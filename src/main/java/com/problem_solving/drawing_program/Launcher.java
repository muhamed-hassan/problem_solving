package com.problem_solving.drawing_program;

import java.util.List;

import com.problem_solving.drawing_program.models.Command;
import com.problem_solving.drawing_program.presentation.Interface;
import com.problem_solving.drawing_program.utils.CommandUtils;
import com.problem_solving.drawing_program.utils.validators.CommandValidator;

public final class Launcher {

    public static void main(String[] argse) {

        Interface ui = new Interface();
        CommandValidator commandValidator = new CommandValidator();

        ApplicationState applicationState = null;
        String commandLine;
        char command;
        List<String> args;

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

            if (command == Command.Q) {
                System.exit(0);
            }

            if (!commandValidator.isCanvasDrawn()) {
                
                switch (command) {
                    case Command.C:
                        int width = Integer.parseInt(args.get(0));
                        int height = Integer.parseInt(args.get(1));
                        applicationState = new ApplicationState(height, width);
                        commandValidator.setCanvasDimensions(width, height);
                        commandValidator.canvasDrawn();
                        break;
                        
                    default:
                        System.err.println(" > Error: Canvas should be created first before issuing any new commands");
                        continue;
                }
            }

            Command.VALID_COMMANDS.get(command).getPlotter(args).plot(args, applicationState.getMatrix());

            ui.drawMatrix(applicationState.getMatrix());
        }
    }

}
