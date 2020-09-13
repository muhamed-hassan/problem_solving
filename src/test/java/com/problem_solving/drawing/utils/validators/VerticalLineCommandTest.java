package com.problem_solving.drawing.utils.validators;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class VerticalLineCommandTest extends BaseCommandValidatorTest {

    private static Stream<Arguments> provideArgsForTestValidateCommand() {
        return Stream.of(
            Arguments.of("L 6 3 6 4 8", "Unexpected number of command line args"),
            Arguments.of("L 6 3 6", "Unexpected number of command line args"),
            Arguments.of("L X 3 6 4", "Invalid value for argument number 1 whose value is X"),
            Arguments.of("L 6 X 6 4", "Invalid value for argument number 2 whose value is X"),
            Arguments.of("L 6 3 X 4", "Invalid value for argument number 3 whose value is X"),
            Arguments.of("L 6 3 6 X", "Invalid value for argument number 4 whose value is X"),
            Arguments.of("L -6 3 6 4", "Invalid value for argument number 1 whose value is -6"),
            Arguments.of("L 6 -3 6 4", "Invalid value for argument number 2 whose value is -3"),
            Arguments.of("L 6 3 -6 4", "Invalid value for argument number 3 whose value is -6"),
            Arguments.of("L 6 3 6 -4", "Invalid value for argument number 4 whose value is -4"),
            Arguments.of("L 0 3 6 4", "Value for argument number 1 whose value is 0 should be greater than zero"),
            Arguments.of("L 6 0 6 4", "Value for argument number 2 whose value is 0 should be greater than zero"),
            Arguments.of("L 6 3 0 4", "Value for argument number 3 whose value is 0 should be greater than zero"),
            Arguments.of("L 6 3 6 0", "Value for argument number 4 whose value is 0 should be greater than zero"),
            Arguments.of("L 1.5 3 6 4", "Invalid value for argument number 1 whose value is 1.5"),
            Arguments.of("L 6 2.5 6 4", "Invalid value for argument number 2 whose value is 2.5"),
            Arguments.of("L 6 3 6.5 4", "Invalid value for argument number 3 whose value is 6.5"),
            Arguments.of("L 6 3 6 4.5", "Invalid value for argument number 4 whose value is 4.5")
        );
    }

//    @ParameterizedTest
//    @MethodSource("provideArgsForTestValidateCommand")
//    public void testValidateCommand_WhenUsingInvalidCommand_ThenThrowIllegalArgumentException(String commandLine, String expectedErrorMsg) {
//        super.testValidateCommand_WhenUsingInvalidCommand_ThenThrowIllegalArgumentException(commandLine, expectedErrorMsg);
//    }

}
