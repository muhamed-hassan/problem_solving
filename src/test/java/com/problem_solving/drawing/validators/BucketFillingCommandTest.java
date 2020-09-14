package com.problem_solving.drawing.validators;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class BucketFillingCommandTest extends BaseCommandValidatorTest {

    @ParameterizedTest
    @MethodSource("provideArgsForTestIsCommandArgsValid")
    public void testIsCommandArgsValid_WhenUsingInvalidCommandArgs_ThenThrowIllegalArgumentException(char command, List<String> args) {
        super.testIsCommandArgsValid_WhenUsingInvalidCommandArgs_ThenThrowIllegalArgumentException(command, args);
    }

    private static Stream<Arguments> provideArgsForTestIsCommandArgsValid() {
        char bucketFillingCommand = 'B';
        return Stream.of(
            Arguments.of(bucketFillingCommand, List.of("10", "3", "o", "1")),
            Arguments.of(bucketFillingCommand, List.of("10", "3")),
            Arguments.of(bucketFillingCommand,  List.of("X", "3", "o")),
            Arguments.of(bucketFillingCommand,  List.of("10", "X", "o")),
            Arguments.of(bucketFillingCommand,  List.of("-10", "3", "o")),
            Arguments.of(bucketFillingCommand,  List.of("10", "-3", "o")),
            Arguments.of(bucketFillingCommand, List.of("0", "3", "o")),
            Arguments.of(bucketFillingCommand, List.of("10", "0", "o")),
            Arguments.of(bucketFillingCommand, List.of("10.5", "3", "o")),
            Arguments.of(bucketFillingCommand, List.of("10", "3.5", "o"))
        );
    }

}
