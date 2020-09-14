package com.problem_solving.drawing.validators;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class RectangleCommandTest extends BaseCommandValidatorTest {

    @ParameterizedTest
    @MethodSource("provideArgsForTestIsCommandArgsValid")
    public void testIsCommandArgsValid_WhenUsingInvalidCommandArgs_ThenThrowIllegalArgumentException(char command, List<String> args) {
        super.testIsCommandArgsValid_WhenUsingInvalidCommandArgs_ThenThrowIllegalArgumentException(command, args);
    }

    private static Stream<Arguments> provideArgsForTestIsCommandArgsValid() {
        return Stream.of(
            Arguments.of("R 16 1 20 3 5", "Unexpected number of command line args"),
            Arguments.of("R 16 1 20", "Unexpected number of command line args"),
            Arguments.of("R X 1 20 3", "Invalid value for argument number 1 whose value is X"),
            Arguments.of("R 16 X 20 3", "Invalid value for argument number 2 whose value is X"),
            Arguments.of("R 16 1 X 3", "Invalid value for argument number 3 whose value is X"),
            Arguments.of("R 16 1 20 X", "Invalid value for argument number 4 whose value is X"),
            Arguments.of("R -16 1 20 3", "Invalid value for argument number 1 whose value is -16"),
            Arguments.of("R 16 -1 20 3", "Invalid value for argument number 2 whose value is -1"),
            Arguments.of("R 16 1 -20 3", "Invalid value for argument number 3 whose value is -20"),
            Arguments.of("R 16 1 20 -3", "Invalid value for argument number 4 whose value is -3"),
            Arguments.of("R 0 1 20 3", "Value for argument number 1 whose value is 0 should be greater than zero"),
            Arguments.of("R 16 0 20 3", "Value for argument number 2 whose value is 0 should be greater than zero"),
            Arguments.of("R 16 1 0 3", "Value for argument number 3 whose value is 0 should be greater than zero"),
            Arguments.of("R 16 1 20 0", "Value for argument number 4 whose value is 0 should be greater than zero"),
            Arguments.of("R 16.5 1 20 3", "Invalid value for argument number 1 whose value is 16.5"),
            Arguments.of("R 16 1.5 20 3", "Invalid value for argument number 2 whose value is 1.5"),
            Arguments.of("R 16 1 20.5 3", "Invalid value for argument number 3 whose value is 20.5"),
            Arguments.of("R 16 1 20 3.5", "Invalid value for argument number 4 whose value is 3.5")
        );
    }

}
