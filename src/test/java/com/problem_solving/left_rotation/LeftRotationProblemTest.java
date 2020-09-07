package com.problem_solving.left_rotation;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

//https://www.hackerrank.com/challenges/ctci-array-left-rotation/problem
public class LeftRotationProblemTest {

    private static LeftRotationProblem leftRotation;

    @BeforeAll
    public static void setup() {
        leftRotation = new LeftRotationProblem();
    }

    @Test
    public void testRotLeft_WhenParametersAreValid_ThenReturnTheRotatedArray() {
        var array = new int[] { 33, 47, 70, 37, 8, 53, 13, 93, 71, 72, 51, 100, 60, 87, 97 };
        var d = 13;
        var expectedResult = new int[] { 87, 97, 33, 47, 70, 37, 8, 53, 13, 93, 71, 72, 51, 100, 60 };

        var actualResult = leftRotation.rotLeft(array, d);

        assertArrayEquals(expectedResult, actualResult);
    }

    @ParameterizedTest
    @MethodSource("provideArgsForTestRotLeftWhenParametersAreInvalid")
    public void testRotLeft_WhenParametersAreInvalid_ThenThrowIllegalArgumentException(int[] a, int d) {
        assertThrows(IllegalArgumentException.class,
            () -> leftRotation.rotLeft(a, d));
    }

    private static Stream<Arguments> provideArgsForTestRotLeftWhenParametersAreInvalid() {
        int[] validArray = { 33, 47, 70, 37, 8, 53, 13, 93, 71, 72, 51, 100, 60, 87, 97 };
        var emptyArray = new int[0];
        int[] nullArray = null;

        var validNumberOfRotations = 13;
        var invalidNumberOfRotations = 0;

        return Stream.of(
            Arguments.of(validArray, invalidNumberOfRotations),
            Arguments.of(emptyArray, validNumberOfRotations),
            Arguments.of(nullArray, validNumberOfRotations),
            Arguments.of(validArray, validArray.length + 1)
        );
    }

}
