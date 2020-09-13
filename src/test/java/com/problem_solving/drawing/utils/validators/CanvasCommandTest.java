package com.problem_solving.drawing.utils.validators;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class CanvasCommandTest extends BaseCommandValidatorTest {

    private static Stream<Arguments> provideArgsForTestValidateCommand() {
        return Stream.of(
            Arguments.of("C 20 4 3", "Unexpected number of command line args"),
            Arguments.of("C 20", "Unexpected number of command line args"),
            Arguments.of("C X 4", "Invalid value for argument number 1 whose value is X"),
            Arguments.of("C 20 X", "Invalid value for argument number 2 whose value is X"),
            Arguments.of("C -20 4", "Invalid value for argument number 1 whose value is -20"),
            Arguments.of("C 20 -4", "Invalid value for argument number 2 whose value is -4"),
            Arguments.of("C 0 4", "Value for argument number 1 whose value is 0 should be greater than zero"),
            Arguments.of("C 20 0", "Value for argument number 2 whose value is 0 should be greater than zero"),
            Arguments.of("C 20.5 4", "Invalid value for argument number 1 whose value is 20.5"),
            Arguments.of("C 20 4.5", "Invalid value for argument number 2 whose value is 4.5")
        );
    }

//    @ParameterizedTest
//    @MethodSource("provideArgsForTestValidateCommand")
//    public void testValidateCommand_WhenUsingInvalidCommand_ThenThrowIllegalArgumentException(String commandLine, String expectedErrorMsg) {
//        super.testValidateCommand_WhenUsingInvalidCommand_ThenThrowIllegalArgumentException(commandLine, expectedErrorMsg);
//    }

}
