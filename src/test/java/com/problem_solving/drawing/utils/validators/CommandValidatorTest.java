package com.problem_solving.drawing.utils.validators;

import org.junit.Test;

public class CommandValidatorTest extends BaseCommandValidatorTest {

    @Test
    public void testValidateCommand_WhenUsingNullCommandLine_ThenThrowException() throws Exception {

        thrownException.expect(IllegalArgumentException.class);
        thrownException.expectMessage("Can't parse empty command");

        String commandLine = null;
        commandValidator.validateCommand(commandLine);
    }

    @Test
    public void testValidateCommand_WhenUsingEmptyCommandLine_ThenThrowException() throws Exception {

        thrownException.expect(IllegalArgumentException.class);
        thrownException.expectMessage("Can't parse empty command");

        var commandLine = "";
        commandValidator.validateCommand(commandLine);
    }

    @Test
    public void testValidateCommand_WhenUsingInValidCommandLine_ThenThrowException() throws Exception {

        thrownException.expect(IllegalArgumentException.class);
        thrownException.expectMessage("Unknown command ...!");

        var commandLine = "X 10 5";
        commandValidator.validateCommand(commandLine);
    }
    
}
