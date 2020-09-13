package com.problem_solving.drawing;

import java.util.List;

import com.problem_solving.drawing.interfaces.validators.rule.Command;
import com.problem_solving.drawing.domain.models.PlottingPoint;
import com.problem_solving.drawing.interfaces.ConsoleHandler;
import com.problem_solving.drawing.service.FillerPlotter;
import com.problem_solving.drawing.service.Plotter;
import com.problem_solving.drawing.interfaces.validators.CommandValidator;

public final class Launcher {

    public static void main(String[] argse) {
        var consoleHandler = new ConsoleHandler();
        var commandValidator = new CommandValidator();
        PlottingPoint[][] drawnTillNow = null;
        String commandLine;
        char command;
        List<String> args;
        var canvasDrawn = false;

        while (true) {
            consoleHandler.displayCommandPromptMsg();
            commandLine = consoleHandler.readCommand();

            try {
                commandValidator.validateCommand(commandLine);
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }

            command = consoleHandler.extractCommand(commandLine);
            args = consoleHandler.extractArgs(commandLine);

            if (command == Command.Q)
                System.exit(0);

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

            consoleHandler.plotDrawingPoints(drawnTillNow, plottedPoints);
            consoleHandler.drawMatrix(drawnTillNow);
        }
    }

}
