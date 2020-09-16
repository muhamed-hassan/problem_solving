package com.problem_solving.drawing.validators;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.problem_solving.drawing.interfaces.validators.CommandValidator;

class BaseCommandValidatorTest {

    private CommandValidator commandValidator;

    @BeforeEach
    void setup() {
        commandValidator = new CommandValidator();
    }

    @ParameterizedTest
    @MethodSource("provideArgsForTestIsCommandLineValid")
    void testIsCommandLineValid_WhenUsingInvalidCommandLine_ThenReturnFalse(String commandLine) {

        boolean isValid = commandValidator.isCommandLineValid(commandLine);

        assertFalse(isValid);
    }

    private static Stream<Arguments> provideArgsForTestIsCommandLineValid() {
        return Stream.of(
            Arguments.of(""),
            Arguments.of("   ")
        );
    }

    @Test
    void testIsCommandLineValid_WhenUsingValidCommandLine_ThenReturnTrue() {
        var commandLine = "C 10 5";

        boolean isValid = commandValidator.isCommandLineValid(commandLine);

        assertTrue(isValid);
    }

    boolean testIsCommandValid_WhenUsingValidCommand_ThenReturnTrue(char command) {
        return commandValidator.isCommandValid(command);
    }

    @Test
    void testIsCommandValid_WhenUsingInvalidCommand_ThenReturnFalse() {

        boolean isValid = commandValidator.isCommandValid('X');

        assertFalse(isValid);
    }

    void testIsCommandArgsValid_WhenUsingInvalidCommandArgs_ThenThrowIllegalArgumentException(char command, List<String> args) {
        assertThrows(IllegalArgumentException.class,
            () -> commandValidator.isCommandArgsValid(command, args));
    }

}
