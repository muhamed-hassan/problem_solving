package com.problem_solving.drawing.validators;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class VerticalLineCommandTest extends BaseCommandValidatorTest {

    @ParameterizedTest
    @MethodSource("provideArgsForTestIsCommandArgsValid")
    public void testIsCommandArgsValid_WhenUsingInvalidCommandArgs_ThenThrowIllegalArgumentException(char command, List<String> args) {
        super.testIsCommandArgsValid_WhenUsingInvalidCommandArgs_ThenThrowIllegalArgumentException(command, args);
    }

    private static Stream<Arguments> provideArgsForTestIsCommandArgsValid() {
        char verticalLineCommand = 'L';
        return Stream.of(
            Arguments.of(verticalLineCommand, List.of("6", "3", "6", "4", "8")), 
            Arguments.of(verticalLineCommand, List.of("6", "3", "6")),
            Arguments.of(verticalLineCommand,  List.of("X", "3", "6", "4")),
            Arguments.of(verticalLineCommand,  List.of("6", "X", "6", "4")),
            Arguments.of(verticalLineCommand,  List.of("6", "3", "X", "4")),
            Arguments.of(verticalLineCommand,  List.of("6", "3", "6", "X")),
            Arguments.of(verticalLineCommand, List.of("-6", "3", "6", "4")),
            Arguments.of(verticalLineCommand, List.of("6", "-3", "6", "4")),
            Arguments.of(verticalLineCommand, List.of("6", "3", "-6", "4")),
            Arguments.of(verticalLineCommand, List.of("6", "3", "6", "-4")),
            Arguments.of(verticalLineCommand, List.of("0", "3", "6", "4")),
            Arguments.of(verticalLineCommand,  List.of("6", "0", "6", "4")),
            Arguments.of(verticalLineCommand,  List.of("6", "3", "0", "4")),
            Arguments.of(verticalLineCommand,  List.of("6", "3", "6", "0")),
            Arguments.of(verticalLineCommand,  List.of("1.5", "3", "6", "4")),
            Arguments.of(verticalLineCommand, List.of("6", "2.5", "6", "4")),
            Arguments.of(verticalLineCommand, List.of("6", "3", "6.5", "4")),
            Arguments.of(verticalLineCommand, List.of("6", "3", "6", "4.5"))
        );
    }

    @Test
    public void testIsCommandValid_WhenUsingValidCommand_ThenReturnTrue() {

        boolean isValid = super.testIsCommandValid_WhenUsingValidCommand_ThenReturnTrue('L');

        assertTrue(isValid);
    }

}
