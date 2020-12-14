package com.problem_solving.drawing.validators;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class RectangleCommandTest extends BaseCommandValidatorTest {

    @ParameterizedTest
    @MethodSource("provideArgsForTestIsCommandArgsValid")
    void testIsCommandArgsValid_WhenUsingInvalidCommandArgs_ThenThrowIllegalArgumentException(char command, List<String> args) {
        super.testIsCommandArgsValid_WhenUsingInvalidCommandArgs_ThenThrowIllegalArgumentException(command, args);
    }

    private static Stream<Arguments> provideArgsForTestIsCommandArgsValid() {
        var rectangleCommand = 'R';
        return Stream.of(
            Arguments.of(rectangleCommand, List.of("16", "1", "20", "3", "5")), 
            Arguments.of(rectangleCommand, List.of("16", "1", "20")),
            Arguments.of(rectangleCommand,  List.of("X", "1", "20", "3")),
            Arguments.of(rectangleCommand,  List.of("16", "X", "20", "3")),
            Arguments.of(rectangleCommand,  List.of("16", "1", "X", "3")),
            Arguments.of(rectangleCommand,  List.of("16", "1", "20", "X")),
            Arguments.of(rectangleCommand, List.of("-16", "1", "20", "3")),
            Arguments.of(rectangleCommand, List.of("16", "-1", "20", "3")),
            Arguments.of(rectangleCommand, List.of("16", "1", "-20", "3")),
            Arguments.of(rectangleCommand, List.of("16", "1", "20", "-3")),
            Arguments.of(rectangleCommand, List.of("0", "1", "20", "3")),
            Arguments.of(rectangleCommand,  List.of("16", "0", "20", "3")),
            Arguments.of(rectangleCommand,  List.of("16", "1", "0", "3")),
            Arguments.of(rectangleCommand,  List.of("16", "1", "20", "0")),
            Arguments.of(rectangleCommand,  List.of("16.5", "1", "20", "3")),
            Arguments.of(rectangleCommand, List.of("16", "1.5", "20", "3")),
            Arguments.of(rectangleCommand, List.of("16", "1", "20.5", "3")),
            Arguments.of(rectangleCommand, List.of("16", "1", "20", "3.5"))
        );
    }

    @Test
    void testIsCommandValid_WhenUsingValidCommand_ThenReturnTrue() {

        var isValid = super.testIsCommandValid_WhenUsingValidCommand_ThenReturnTrue('R');

        assertTrue(isValid);
    }

}
