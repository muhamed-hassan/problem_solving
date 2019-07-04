package com.problem_solving.drawing;

import java.util.List;

import com.problem_solving.drawing.models.Command;
import com.problem_solving.drawing.models.PlottingPoint;
import com.problem_solving.drawing.presentation.Interface;
import com.problem_solving.drawing.service.FillerPlotter;
import com.problem_solving.drawing.service.Plotter;
import com.problem_solving.drawing.utils.CommandUtils;
import com.problem_solving.drawing.utils.validators.CommandValidator;

public final class Launcher {

    public static void main(String[] argse) {

        Interface ui = new Interface();
        CommandValidator commandValidator = new CommandValidator();

        PlottingPoint[][] drawnTillNow = null; 
        String commandLine;
        char command;
        List<String> args;
        boolean canvasDrawn = false;

        while (true) {

            ui.displayCommandPromptMsg();
            commandLine = ui.readCommand();

            try {
                
                commandValidator.validateCommand(commandLine);                                
            } catch (Exception e) {
                
                e.printStackTrace();
                continue;
            }

            command = CommandUtils.extractCommand(commandLine);
            args = CommandUtils.extractArgs(commandLine);

            if (command == Command.Q) System.exit(0);
            
            
            if ( canvasDrawn && command == Command.C) {
                System.err.println(" > Error: Canvas can be drawn only once");
                continue;
            }

            if (!canvasDrawn) {
                
                //Before drawing any shape, you should draw the canvas first
                switch (command) {
                    case Command.C:
                        int width = Integer.parseInt(args.get(0));
                        int height = Integer.parseInt(args.get(1));
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
            if ( command == Command.B ) {
                
                plottedPoints = ((FillerPlotter) Command.VALID_COMMANDS.get(command).getPlotter(args)).getPlottingPoints(args, drawnTillNow); 
            } else {
                
                plottedPoints = ((Plotter) Command.VALID_COMMANDS.get(command).getPlotter(args)).getPlottingPoints(args); 
            }
            
            ui.plotDrawingPoints(drawnTillNow, plottedPoints);
            ui.drawMatrix(drawnTillNow, plottedPoints);
        }
    }

}
