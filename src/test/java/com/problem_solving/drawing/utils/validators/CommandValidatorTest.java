package com.problem_solving.drawing.utils.validators;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class CommandValidatorTest extends BaseCommandValidatorTest {

    @Test
    public void testValidateCommand_WhenUsingNullCommandLine_ThenThrowException() {
        String commandLine = null;

        IllegalArgumentException thrownException = assertThrows(IllegalArgumentException.class,
                                                                    () -> commandValidator.validateCommand(commandLine));
        assertEquals("Can't parse empty command", thrownException.getMessage());
    }

    @Test
    public void testValidateCommand_WhenUsingEmptyCommandLine_ThenThrowException() {
        var commandLine = "";

        IllegalArgumentException thrownException = assertThrows(IllegalArgumentException.class,
                                                                    () -> commandValidator.validateCommand(commandLine));
        assertEquals("Can't parse empty command", thrownException.getMessage());
    }

    @Test
    public void testValidateCommand_WhenUsingInValidCommandLine_ThenThrowException() {
        var commandLine = "X 10 5";

        IllegalArgumentException thrownException = assertThrows(IllegalArgumentException.class,
                                                                    () -> commandValidator.validateCommand(commandLine));
        assertEquals("Unknown command ...!", thrownException.getMessage());
    }
    
}
