package com.problem_solving.drawing.interfaces;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.problem_solving.drawing.domain.models.PlottingPoint;
import com.problem_solving.drawing.infrastructure.MatrixGrid;
import com.problem_solving.drawing.interfaces.validators.CommandValidator;
import com.problem_solving.drawing.interfaces.validators.rule.Command;

public class ConsoleHandler {

    private final Scanner scanner = new Scanner(System.in);

    public void start() {
        var commandValidator = new CommandValidator();
        String commandLine;
        char command;
        List<String> args;

        while (true) {
            System.out.print("enter command: ");

            commandLine = scanner.nextLine();
            if (!commandValidator.isCommandLineValid(commandLine)) {
                logError("Can't parse empty command");
                continue;
            }
            commandLine = commandLine.trim();

            try {
                command = extractCommand(commandLine);
                if (!commandValidator.isCommandValid(command)) {
                    throw new IllegalArgumentException("Unknown command ...!");
                }
                if (command == Command.Q) {
                    releaseConsoleResources();
                    System.exit(0);
                }

                args = extractArgs(commandLine);
                commandValidator.isCommandArgsValid(command, args);
            } catch (Exception e) {
                logError(e.getMessage());
                continue;
            }

            if (MatrixGrid.isCanvasDrawn() && command == Command.C) {
                logError("Canvas can be drawn only once");
                continue;
            }

            if (!MatrixGrid.isCanvasDrawn()) {
                //Before drawing any shape, you should draw the canvas first
                switch (command) {
                    case Command.C:
                        int width = Integer.parseInt(args.get(0)),
                            height = Integer.parseInt(args.get(1));
                        commandValidator.setCanvasDimensions(width, height);
                        MatrixGrid.initDrawnTillNow(new PlottingPoint[height + 2][width + 2]);
                        break;

                    default:
                        logError("Canvas should be created first before issuing any new commands");
                        continue;
                }
            }

            MatrixGrid.plotDrawnPoints(Command.VALID_COMMANDS.get(command).getPlotter(args).getPlottedPoints(args));
            drawMatrix();
        }
    }

    private void logError(String errMsg) {
        System.out.println(">>> Error: " + errMsg);
    }

    private void drawMatrix() {
        for (var line : MatrixGrid.getDrawnTillNow()) {
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

    private void releaseConsoleResources() {
        if (scanner != null) {
            scanner.close();
        }
    }

}
