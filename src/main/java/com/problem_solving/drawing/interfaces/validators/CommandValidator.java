package com.problem_solving.drawing.interfaces.validators;

import java.util.List;

import com.problem_solving.drawing.domain.models.Point;
import com.problem_solving.drawing.interfaces.validators.rule.Command;
import com.problem_solving.drawing.interfaces.validators.rule.Rule;

public final class CommandValidator {

    private int canvasWidth;
    private int canvasHeight;

    public void setCanvasDimensions(int canvasWidth, int canvasHeight) {
        this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;
    }

    public boolean isCommandLineValid(String commandLine) {
        return commandLine != null && !commandLine.isBlank();
    }

    public boolean isCommandValid(char enteredCommand) {
        return Command.VALID_COMMANDS
                        .entrySet()
                        .stream()
                        .anyMatch(entry -> entry.getKey().charValue() == enteredCommand);
    }

    public void isCommandArgsValid(char enteredCommand, List<String> args) {
        validateNumricArgsType(args, getValidationRule(enteredCommand));

        switch (enteredCommand) {
            case Command.L: {
                int x1 = Integer.parseInt(args.get(Point.X1)),
                    y1 = Integer.parseInt(args.get(Point.Y1)),
                    x2 = Integer.parseInt(args.get(Point.X2)),
                    y2 = Integer.parseInt(args.get(Point.Y2));

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
                int x1 = Integer.parseInt(args.get(Point.X1)),
                    y1 = Integer.parseInt(args.get(Point.Y1)),
                    x2 = Integer.parseInt(args.get(Point.X2)),
                    y2 = Integer.parseInt(args.get(Point.Y2));

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
                int x = Integer.parseInt(args.get(0)),
                    y = Integer.parseInt(args.get(1));

                isInsideCanvasDimensions(new Point(x, y));
            }
            break;
        }
    }

    private void validateNumricArgsType(List<String> args, Rule rule) {
        if (args.size() != rule.getValidNoOfArgs()) {
            throw new IllegalArgumentException("Unexpected number of command line args");
        }

        for (var argPosition = 0; argPosition < args.size(); argPosition++) {
            var expectedDataType = rule.getExpectedDataTypeForArgsAtPositionOf(argPosition);
            var currentArg = args.get(argPosition);
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
        return Command.VALID_COMMANDS
                        .entrySet()
                        .stream()
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
        for (var point : points) {
            if (point.getX() > canvasWidth
                || point.getY() > canvasHeight) {
                throw new IllegalArgumentException("This " + point + " outside canvas dimensions and can't be drawn");
            }
        }
    }

}
