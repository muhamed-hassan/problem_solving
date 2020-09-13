package com.problem_solving.drawing.interfaces.validators;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.problem_solving.drawing.domain.models.Point;
import com.problem_solving.drawing.interfaces.validators.rule.Command;
import com.problem_solving.drawing.interfaces.validators.rule.Rule;

public final class CommandValidator {

    private static final String VALID_COMMANDS = "VALID_COMMANDS";

    private int canvasWidth;
    private int canvasHeight;

    public void setCanvasDimensions(int canvasWidth, int canvasHeight) {
        this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;
    }

    public void validateCommand(String commandLine) {
        if (commandLine == null || commandLine.isEmpty()) {
            throw new IllegalArgumentException("Can't parse empty command");
        }

        commandLine = commandLine.trim();
        var command = extractCommand(commandLine);
        if (!commandValid(command)) {
            throw new IllegalArgumentException("Unknown command ...!");
        }

        if (command == Command.Q)
            return;

        validateNumricArgsType(commandLine, getValidationRule(extractCommand(commandLine)));

        var extractedArgs = extractArgs(commandLine.trim());

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

    private boolean commandValid(char enteredCommand) {
        boolean valid = false;
        try {
            valid = Stream
                .of(Command.class.getDeclaredField(VALID_COMMANDS))
                .flatMap(field -> {
                    try {
                        return ((Map<Character, Rule>) field.get(field)).keySet().stream();
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException("Error occured during command validation: " + e.getMessage());
                    }
                })
                .anyMatch(validCommand -> validCommand == enteredCommand);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException("Error occured during command validation: " + e.getMessage());
        }
        return valid;
    }

    private void validateNumricArgsType(String commandLine, Rule rule) {
        var extractedArgs = extractArgs(commandLine.trim());

        if (extractedArgs.size() != rule.getValidNoOfArgs()) {
            throw new IllegalArgumentException("Unexpected number of command line args");
        }

        for (var argPosition = 0; argPosition < extractedArgs.size(); argPosition++) {
            var expectedDataType = rule.getExpectedDataTypeForArgsAtPositionOf(argPosition);
            var currentArg = extractedArgs.get(argPosition);
            //till now only integers should be validated
            //characters like 'c' used for drawing, doesn't have that much of importance 
            if (expectedDataType == Integer.class) {
                if (!currentArg.matches("[0-9]+")) {
                    throw new IllegalArgumentException("Invalid value for argument number " + (argPosition + 1) + " whose value is " + currentArg);
                }

                var parsedArg = Integer.parseInt(currentArg);
                if (parsedArg == 0) {
                    throw new IllegalArgumentException(
                        "Value for argument number " + (argPosition + 1) + " whose value is " + currentArg + " should be greater than zero");
                }
            }
        }
    }

    private Rule getValidationRule(char command) {
        Rule rule = null;
        try {
            rule = Stream
                .of(Command.class.getDeclaredField(VALID_COMMANDS))
                .flatMap(field -> {
                    try {
                        return ((Map<Character, Rule>) field.get(field)).entrySet().stream();
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException("Error occured during validation rule retrieval: " + e.getMessage());
                    }
                })
                .filter(entry -> entry.getKey().charValue() == command)
                .map(entry -> entry.getValue())
                .findFirst()
                .get();
        } catch (NoSuchFieldException e) {
            throw new RuntimeException("Error occured during validation rule retrieval: " + e.getMessage());
        }
        return rule;
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
        for (var point : points) {
            if (point.getX() > canvasWidth
                || point.getY() > canvasHeight) {
                throw new IllegalArgumentException("This " + point + " outside canvas dimensions and can't be drawn");
            }
        }
    }

    public List<String> extractArgs(String commandLine) {
        return Stream.of(commandLine.substring(1).split("\\s"))
            .filter(arg -> !arg.isEmpty())
            .collect(Collectors.toList());
    }

    public char extractCommand(String commandLine) {
        return commandLine.charAt(0);
    }


}
