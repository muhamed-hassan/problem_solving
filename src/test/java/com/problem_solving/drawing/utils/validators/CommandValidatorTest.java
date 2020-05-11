package com.problem_solving.drawing.utils.validators;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class CommandValidatorTest extends BaseCommandValidatorTest {

    @ParameterizedTest
    @MethodSource("provideArgsForTestValidateCommand")
    public void testValidateCommand_WhenUsingInvalidCommand_ThenThrowIllegalArgumentException(String commandLine, String expectedErrorMsg) {
        super.testValidateCommand_WhenUsingInvalidCommand_ThenThrowIllegalArgumentException(commandLine, expectedErrorMsg);
    }

    private static Stream<Arguments> provideArgsForTestValidateCommand() {
        return Stream.of(
            Arguments.of(null, "Can't parse empty command"),
            Arguments.of("", "Can't parse empty command"),
            Arguments.of("X 10 5", "Unknown command ...!")
        );
    }
    
}
