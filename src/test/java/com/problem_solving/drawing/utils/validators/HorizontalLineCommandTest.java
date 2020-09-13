package com.problem_solving.drawing.utils.validators;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class HorizontalLineCommandTest extends BaseCommandValidatorTest {

    private static Stream<Arguments> provideArgsForTestValidateCommand() {
        return Stream.of(
            Arguments.of("L 1 2 6 2 1", "Unexpected number of command line args"),
            Arguments.of("L 1 2 6", "Unexpected number of command line args"),
            Arguments.of("L X 2 6 2", "Invalid value for argument number 1 whose value is X"),
            Arguments.of("L 1 X 6 2", "Invalid value for argument number 2 whose value is X"),
            Arguments.of("L 1 2 X 2", "Invalid value for argument number 3 whose value is X"),
            Arguments.of("L 1 2 6 X", "Invalid value for argument number 4 whose value is X"),
            Arguments.of("L -1 2 6 2", "Invalid value for argument number 1 whose value is -1"),
            Arguments.of("L 1 -2 6 2", "Invalid value for argument number 2 whose value is -2"),
            Arguments.of("L 1 2 -6 2", "Invalid value for argument number 3 whose value is -6"),
            Arguments.of("L 1 2 6 -2", "Invalid value for argument number 4 whose value is -2"),
            Arguments.of("L 0 2 6 2", "Value for argument number 1 whose value is 0 should be greater than zero"),
            Arguments.of("L 1 0 6 2", "Value for argument number 2 whose value is 0 should be greater than zero"),
            Arguments.of("L 1 2 0 2", "Value for argument number 3 whose value is 0 should be greater than zero"),
            Arguments.of("L 1 2 6 0", "Value for argument number 4 whose value is 0 should be greater than zero"),
            Arguments.of("L 1.5 2 6 2", "Invalid value for argument number 1 whose value is 1.5"),
            Arguments.of("L 1 2.5 6 2", "Invalid value for argument number 2 whose value is 2.5"),
            Arguments.of("L 1 2 6.5 2", "Invalid value for argument number 3 whose value is 6.5"),
            Arguments.of("L 1 2 6 2.5", "Invalid value for argument number 4 whose value is 2.5")
        );
    }

//    @ParameterizedTest
//    @MethodSource("provideArgsForTestValidateCommand")
//    public void testValidateCommand_WhenUsingInvalidCommand_ThenThrowIllegalArgumentException(String commandLine, String expectedErrorMsg) {
//        super.testValidateCommand_WhenUsingInvalidCommand_ThenThrowIllegalArgumentException(commandLine, expectedErrorMsg);
//    }

}
