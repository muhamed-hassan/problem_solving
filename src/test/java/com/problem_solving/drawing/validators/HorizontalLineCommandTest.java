package com.problem_solving.drawing.validators;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class HorizontalLineCommandTest extends BaseCommandValidatorTest {

    @ParameterizedTest
    @MethodSource("provideArgsForTestIsCommandArgsValid")
    void testIsCommandArgsValid_WhenUsingInvalidCommandArgs_ThenThrowIllegalArgumentException(char command, List<String> args) {
        super.testIsCommandArgsValid_WhenUsingInvalidCommandArgs_ThenThrowIllegalArgumentException(command, args);
    }

    private static Stream<Arguments> provideArgsForTestIsCommandArgsValid() {
        char horizontalLineCommand = 'L';
        return Stream.of(
            Arguments.of(horizontalLineCommand, List.of("1", "2", "6", "2", "1")),
            Arguments.of(horizontalLineCommand, List.of("1", "2", "6")),
            Arguments.of(horizontalLineCommand,  List.of("X", "2", "6", "2")),
            Arguments.of(horizontalLineCommand,  List.of("1", "X", "6", "2")),
            Arguments.of(horizontalLineCommand,  List.of("1", "2", "X", "2")),
            Arguments.of(horizontalLineCommand,  List.of("1", "2", "6", "X")),
            Arguments.of(horizontalLineCommand, List.of("-1", "2", "6", "2")),
            Arguments.of(horizontalLineCommand, List.of("1", "-2", "6", "2")),
            Arguments.of(horizontalLineCommand, List.of("1", "2", "-6", "2")),
            Arguments.of(horizontalLineCommand, List.of("1", "2", "6", "-2")),
            Arguments.of(horizontalLineCommand, List.of("0", "2", "6", "2")),
            Arguments.of(horizontalLineCommand,  List.of("1", "0", "6", "2")),
            Arguments.of(horizontalLineCommand,  List.of("1", "2", "0", "2")),
            Arguments.of(horizontalLineCommand,  List.of("1", "2", "6", "0")),
            Arguments.of(horizontalLineCommand,  List.of("1.5", "2", "6", "0")),
            Arguments.of(horizontalLineCommand, List.of("1", "2.5", "6", "2")),
            Arguments.of(horizontalLineCommand, List.of("1", "2", "6.5", "2")),
            Arguments.of(horizontalLineCommand, List.of("1", "2", "6", "2.5"))
        );
    }

    @Test
    void testIsCommandValid_WhenUsingValidCommand_ThenReturnTrue() {

        boolean isValid = super.testIsCommandValid_WhenUsingValidCommand_ThenReturnTrue('L');

        assertTrue(isValid);
    }

}
