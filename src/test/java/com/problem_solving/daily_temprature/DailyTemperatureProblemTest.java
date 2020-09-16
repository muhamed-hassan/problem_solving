package com.problem_solving.daily_temprature;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class DailyTemperatureProblemTest {

    private static DailyTemperatureProblem dailyTemperatureProblem;

    @BeforeAll
    static void setup() {
        dailyTemperatureProblem = new DailyTemperatureProblem();
    }

    @Test
    void testDailyTemperatures() {
        var temperatures = new int[] { 55, 38, 53, 81, 61, 93, 97, 32, 43, 78 };
        var expectedResult = new int[] { 3, 1, 1, 2, 1, 1, 0, 1, 1, 0 };

        var actualResult = dailyTemperatureProblem.dailyTemperatures(temperatures);

        assertArrayEquals(expectedResult, actualResult);
    }

    @ParameterizedTest
    @MethodSource("provideArgsForTestDailyTemperatures")
    void testDailyTemperatures_WhenPassingInvalidParameter_ThenThrowIllegalArgumentException(int[] temperatures) {
        assertThrows(IllegalArgumentException.class,
            () -> dailyTemperatureProblem.dailyTemperatures(temperatures));
    }

    private static Stream<Arguments> provideArgsForTestDailyTemperatures() {
        var emptyArray = new int[0];
        int[] nullArray = null;

        return Stream.of(
            Arguments.of(emptyArray),
            Arguments.of(nullArray)
        );
    }

}
