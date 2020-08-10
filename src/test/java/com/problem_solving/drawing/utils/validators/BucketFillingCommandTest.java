package com.problem_solving.drawing.utils.validators;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class BucketFillingCommandTest extends BaseCommandValidatorTest {

    private static Stream<Arguments> provideArgsForTestValidateCommand() {
        return Stream.of(
            Arguments.of("B 10 3 o 1", "Unexpected number of command line args"),
            Arguments.of("B 10 3", "Unexpected number of command line args"),
            Arguments.of("B X 3 o", "Invalid value for argument number 1 whose value is X"),
            Arguments.of("B 10 X o", "Invalid value for argument number 2 whose value is X"),
            Arguments.of("B -10 3 o", "Invalid value for argument number 1 whose value is -10"),
            Arguments.of("B 10 -3 o", "Invalid value for argument number 2 whose value is -3"),
            Arguments.of("B 0 3 o", "Value for argument number 1 whose value is 0 should be greater than zero"),
            Arguments.of("B 10 0 o", "Value for argument number 2 whose value is 0 should be greater than zero"),
            Arguments.of("B 10.5 3 o", "Invalid value for argument number 1 whose value is 10.5"),
            Arguments.of("B 10 3.5 o", "Invalid value for argument number 2 whose value is 3.5")
        );
    }

    @ParameterizedTest
    @MethodSource("provideArgsForTestValidateCommand")
    public void testValidateCommand_WhenUsingInvalidCommand_ThenThrowIllegalArgumentException(String commandLine, String expectedErrorMsg) {
        super.testValidateCommand_WhenUsingInvalidCommand_ThenThrowIllegalArgumentException(commandLine, expectedErrorMsg);
    }

}
