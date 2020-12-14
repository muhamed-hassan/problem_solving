package com.problem_solving.drawing.validators;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CanvasCommandTest extends BaseCommandValidatorTest {

    @ParameterizedTest
    @MethodSource("provideArgsForTestIsCommandArgsValid")
    void testIsCommandArgsValid_WhenUsingInvalidCommandArgs_ThenThrowIllegalArgumentException(char command, List<String> args) {
        super.testIsCommandArgsValid_WhenUsingInvalidCommandArgs_ThenThrowIllegalArgumentException(command, args);
    }

    private static Stream<Arguments> provideArgsForTestIsCommandArgsValid() {
        var canvasCommand = 'C';
        return Stream.of(
            Arguments.of(canvasCommand, List.of("20", "4", "3")),
            Arguments.of(canvasCommand, List.of("20")),
            Arguments.of(canvasCommand,  List.of("X", "4")),
            Arguments.of(canvasCommand,  List.of("20", "X")),
            Arguments.of(canvasCommand,  List.of("-20", "4")),
            Arguments.of(canvasCommand,  List.of("20", "-4")),
            Arguments.of(canvasCommand, List.of("0", "4")),
            Arguments.of(canvasCommand, List.of("20", "0")),
            Arguments.of(canvasCommand, List.of("20.5", "4")),
            Arguments.of(canvasCommand, List.of("20", "4.5"))
        );
    }

    @Test
    void testIsCommandValid_WhenUsingValidCommand_ThenReturnTrue() {

        var isValid = super.testIsCommandValid_WhenUsingValidCommand_ThenReturnTrue('C');

        assertTrue(isValid);
    }

}
