package com.problem_solving.drawing.interfaces;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.problem_solving.drawing.domain.models.PlottingPoint;
import com.problem_solving.drawing.interfaces.validators.CommandValidator;
import com.problem_solving.drawing.interfaces.validators.rule.Command;
import com.problem_solving.drawing.service.FillerPlotter;
import com.problem_solving.drawing.service.Plotter;

public class ConsoleHandler {

    private final Scanner scanner = new Scanner(System.in);

    public void plotDrawingPoints(PlottingPoint[][] matrix, List<PlottingPoint> points) {
        for (var point : points) {
            matrix[point.getY()][point.getX()] = point;
        }
    }

    public void start() {
        var commandValidator = new CommandValidator();
        PlottingPoint[][] drawnTillNow = null;
        String commandLine;
        char command;
        List<String> args;
        var canvasDrawn = false;

        while (true) {
            System.out.print("enter command: ");

            commandLine = scanner.nextLine();
            if (!commandValidator.isCommandLineValid(commandLine)) {
                System.err.println(" > Error: Can't parse empty command");
                continue;
            }
            commandLine = commandLine.trim();

            try {
                command = extractCommand(commandLine);
                if (!commandValidator.isCommandValid(command)) {
                    System.err.println(" > Error: Unknown command ...!");
                    continue;
                }
                if (command == Command.Q) {
                    releaseConsoleResources();
                    System.exit(0);
                }

                args = extractArgs(commandLine);
                commandValidator.isCommandArgsValid(command, args);
            } catch (Exception e) {
                System.err.println(" > Error: " + e.getMessage());
                continue;
            }

            if (canvasDrawn && command == Command.C) {
                System.err.println(" > Error: Canvas can be drawn only once");
                continue;
            }

            if (!canvasDrawn) {
                //Before drawing any shape, you should draw the canvas first
                switch (command) {
                    case Command.C:
                        int width = Integer.parseInt(args.get(0)),
                            height = Integer.parseInt(args.get(1));
                        drawnTillNow = new PlottingPoint[height + 2][width + 2];
                        commandValidator.setCanvasDimensions(width, height);
                        canvasDrawn = true;
                        break;

                    default:
                        System.err.println(" > Error: Canvas should be created first before issuing any new commands");
                        continue;
                }
            }

            List<PlottingPoint> plottedPoints;
            if (command == Command.B) {
                plottedPoints = ((FillerPlotter) Command.VALID_COMMANDS.get(command).getPlotter(args)).getPlottingPoints(args, drawnTillNow);
            } else {
                plottedPoints = ((Plotter) Command.VALID_COMMANDS.get(command).getPlotter(args)).getPlottingPoints(args);
            }

            plotDrawingPoints(drawnTillNow, plottedPoints);
            drawMatrix(drawnTillNow);
        }
    }

    private void releaseConsoleResources() {
        if (scanner != null) {
            scanner.close();
        }
    }

    private void drawMatrix(PlottingPoint[][] matrix) {
        for (var line : matrix) {
            for (var point : line) {
                System.out.print(point != null ? point.getCharacterToBeDrawn() : " ");
            }
            System.out.println();
        }
    }

    private List<String> extractArgs(String commandLine) {
        return Stream.of(commandLine.substring(1).split("\\s"))
                        .filter(arg -> !arg.isEmpty())
                        .collect(Collectors.toList());
    }

    private char extractCommand(String commandLine) {
        return commandLine.charAt(0);
    }

}
