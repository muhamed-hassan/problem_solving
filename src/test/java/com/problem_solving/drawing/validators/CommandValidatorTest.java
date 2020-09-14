package com.problem_solving.drawing.validators;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class CommandValidatorTest extends BaseCommandValidatorTest {

//    @ParameterizedTest
//    @MethodSource("provideArgsForTestIsCommandArgsValid")
//    public void testIsCommandArgsValid_WhenUsingInvalidCommandArgs_ThenThrowIllegalArgumentException(char command, List<String> args) {
//        super.testIsCommandArgsValid_WhenUsingInvalidCommandArgs_ThenThrowIllegalArgumentException(command, args);
//    }
//
//    private static Stream<Arguments> provideArgsForTestIsCommandArgsValid() {
//        return Stream.of(
//            Arguments.of(null, "Can't parse empty command"),
//            Arguments.of("", "Can't parse empty command"),
//            Arguments.of("X 10 5", "Unknown command ...!")
//        );
//    }

}
