package com.problem_solving.drawing.validators;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;

import com.problem_solving.drawing.interfaces.validators.CommandValidator;

public class BaseCommandValidatorTest {

    protected CommandValidator commandValidator;

    @BeforeEach
    public void setup() {
        commandValidator = new CommandValidator();
    }

    public boolean testIsCommandLineValid_WhenUsingValidCommandLine_ThenReturnTrue(String commandLine) {
        return commandValidator.isCommandLineValid(commandLine);
    }

    public boolean testIsCommandLineValid_WhenUsingInvalidCommandLine_ThenReturnFalse(String commandLine) {
        return commandValidator.isCommandLineValid(commandLine);
    }

    public boolean testIsCommandValid_WhenUsingValidCommand_ThenReturnTrue(char command) {
        return commandValidator.isCommandValid(command);
    }

    public boolean testIsCommandValid_WhenUsingInvalidCommand_ThenReturnFalse(char command) {
        return commandValidator.isCommandValid(command);
    }

    public void testIsCommandArgsValid_WhenUsingInvalidCommandArgs_ThenThrowIllegalArgumentException(char command, List<String> args) {
        assertThrows(IllegalArgumentException.class,
            () -> commandValidator.isCommandArgsValid(command, args));
    }

}
