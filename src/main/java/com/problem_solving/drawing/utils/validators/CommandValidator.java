package com.problem_solving.drawing.utils.validators;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import com.problem_solving.drawing.models.Rule;
import com.problem_solving.drawing.models.Command;
import com.problem_solving.drawing.models.Point;
import com.problem_solving.drawing.utils.CommandUtils;

public final class CommandValidator {

    private static final String VALID_COMMANDS = "VALID_COMMANDS";

    private int canvasWidth;
    private int canvasHeight;

    public void setCanvasDimensions(int canvasWidth, int canvasHeight) {
        
        this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;
    }

    public int getCanvasHeight() {
        
        return canvasHeight;
    }

    public int getCanvasWidth() {
        
        return canvasWidth;
    }

    public void validateCommand(String commandLine) throws Exception {

        if (commandLine == null || commandLine.isEmpty()) {
            
            throw new IllegalArgumentException("Can't parse empty command");
        }

        commandLine = commandLine.trim();
        char command = CommandUtils.extractCommand(commandLine);
        if (!commandValid(command)) {
            
            throw new IllegalArgumentException("Unknown command ...!");
        }

        if (command == Command.Q) return;

        validateArgsType(commandLine, getValidationRule(CommandUtils.extractCommand(commandLine)));

        List<String> extractedArgs = CommandUtils.extractArgs(commandLine.trim());

        switch (command) {
            case Command.L: {

                int x1 = Integer.parseInt(extractedArgs.get(Point.X1)),
                    y1 = Integer.parseInt(extractedArgs.get(Point.Y1)),
                    x2 = Integer.parseInt(extractedArgs.get(Point.X2)),
                    y2 = Integer.parseInt(extractedArgs.get(Point.Y2));

                Point point1 = new Point(x1, y1),
                      point2 = new Point(x2, y2);

                isInsideCanvasDimensions(point1, point2);
                //Vertical line   -> x1 eq x2
                //Horizontal line -> y1 eq y2
                if (!isLine(point1, point2) 
                        || isPoint(point1, point2)) {
                    
                    throw new IllegalArgumentException("Invalid line coordinates");
                }
            }
            break;

            case Command.R: {

                int x1 = Integer.parseInt(extractedArgs.get(Point.X1)),
                    y1 = Integer.parseInt(extractedArgs.get(Point.Y1)),
                    x2 = Integer.parseInt(extractedArgs.get(Point.X2)),
                    y2 = Integer.parseInt(extractedArgs.get(Point.Y2));

                Point point1 = new Point(x1, y1),
                      point2 = new Point(x2, y2);

                isInsideCanvasDimensions(point1, point2);

                if (!isRectangle(point1, point2) 
                        || isLine(point1, point2) 
                        || isPoint(point1, point2)) {
                    
                    throw new IllegalArgumentException("Invalid rectangle coordinates");
                }
            }
            break;

            case Command.B: {

                int x = Integer.parseInt(extractedArgs.get(0)),
                    y = Integer.parseInt(extractedArgs.get(1));

                isInsideCanvasDimensions(new Point(x, y));
            }
            break;
        }
    }

    private boolean commandValid(char enteredCommand) throws NoSuchFieldException, SecurityException {

        return Stream
                .of(Command.class.getDeclaredField(VALID_COMMANDS))
                .flatMap(field -> {
                    
                    try {
                        
                        return ((Map<Character, Rule>) field.get(field)).keySet().stream();
                    } catch (IllegalArgumentException | IllegalAccessException e) {
                        
                        e.printStackTrace();
                        throw new RuntimeException("Error reading stored commands values via reflections");
                    }})
                .anyMatch(validCommand -> validCommand == enteredCommand);
    }

    private void validateArgsType(String commandLine, Rule rule) {

        List<String> extractedArgs = CommandUtils.extractArgs(commandLine.trim());

        if (extractedArgs.size() != rule.getValidNoOfArgs()) {
            
            throw new IllegalArgumentException("Unexpected number of command line args");
        }

        for (int argPosition = 0; argPosition < extractedArgs.size(); argPosition++) {

            Class<?> expectedDataType = rule.getExpectedDataTypeForArgsAtPositionOf(argPosition);

            String currentArg = extractedArgs.get(argPosition);
            //till now only integers should be validated
            //characters like 'c' used for drawing, doesn't have that much of importance 
            if (expectedDataType == Integer.class) {
                
                int parsedArg = Integer.parseInt(currentArg);
                if (parsedArg <= 0) {
                
                    throw new IllegalArgumentException("All integer arguments should be greater than zero");
                }
            }
        }
    }

    private Rule getValidationRule(char command) throws NoSuchFieldException, SecurityException {

        return Stream
                .of(Command.class.getDeclaredField(VALID_COMMANDS))
                .flatMap(field -> {
                    
                    try {
                        
                        return ((Map<Character, Rule>) field.get(field)).entrySet().stream();
                    } catch (IllegalArgumentException | IllegalAccessException e) {
                        
                        e.printStackTrace();
                        throw new RuntimeException("Error reading stored commands values via reflections");
                    }})
                .filter(entry -> entry.getKey().charValue() == command)
                .map(entry -> entry.getValue())
                .findFirst()
                .get();
    }

    private boolean isLine(Point point1, Point point2) {
        
        return (point1.getX() == point2.getX() && point1.getY() != point2.getY())
                || (point1.getX() != point2.getX() && point1.getY() == point2.getY());
    }

    private boolean isPoint(Point point1, Point point2) {
        
        return (point1.getX() == point2.getX()) && (point1.getY() == point2.getY());
    }

    private boolean isRectangle(Point point1, Point point2) {
        
        return (point1.getX() < point2.getX()) && (point1.getY() < point2.getY());
    }

    private void isInsideCanvasDimensions(Point... points) {

        for (Point point : points) {
            
            if (point.getX() > canvasWidth || point.getY() > canvasHeight) {
                
                throw new IllegalArgumentException("This " + point + " outside canvas dimensions and can't be drawn");
            }
        }
    }

}
