package com.problem_solving.cyclic_rotation;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

//https://app.codility.com/programmers/lessons/2-arrays/cyclic_rotation/
public class CyclicRotationProblemTest {

    private static CyclicRotationProblem cyclicRotationProblem;

    @BeforeAll
    public static void setup() {
        cyclicRotationProblem = new CyclicRotationProblem();
    }

    @Test
    public void testSolution_WhenPassingAnArrayAndShiftingTimes_ThenReturnShiftedArrayAccordingToShiftTimes() {
        var array = new int[] { 3, 8, 9, 7, 6 };
        var shiftingTimes = 3;
        var expectedResult = new int[] { 9, 7, 6, 3, 8 };

        var actualResult = cyclicRotationProblem.solution(array, shiftingTimes);

        assertArrayEquals(expectedResult, actualResult);
    }

    @ParameterizedTest
    @MethodSource("provideArgsForTestSolution")
    public void testSolution_WhenPassingInvalidParameters_ThenThrowIllegalArgumentException(int[] array, int shiftingTimes) {
        assertThrows(IllegalArgumentException.class,
            () -> cyclicRotationProblem.solution(array, shiftingTimes));
    }

    private static Stream<Arguments> provideArgsForTestSolution() {
        var validArray = new int[] { 3, 8, 9, 7, 6 };
        var emptyArray = new int[0];
        int[] nullArray = null;
        var validShiftingTimes = 3;
        var invalidShiftingTimes = 0;

        return Stream.of(
            Arguments.of(emptyArray, validShiftingTimes),
            Arguments.of(nullArray, validShiftingTimes),
            Arguments.of(validArray, invalidShiftingTimes)
        );
    }

}
