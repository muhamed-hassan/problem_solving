package com.problem_solving.twod_array;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

//https://www.hackerrank.com/challenges/2d-array/problem
public class TwoDimensionalArrayProblemTest {

    private static TwoDimensionalArrayProblem twoDimensionalArrayProblem;

    @BeforeAll
    public static void setup() {
        twoDimensionalArrayProblem = new TwoDimensionalArrayProblem();
    }

    @Test
    public void testHourglassSum_WhenMatrixIsValid_ThenCalcTheResult() {
        var matrix = new int[][] {
            { -9, -9, -9, 1, 1, 1 },
            { 0, -9, 0, 4, 3, 2 },
            { -9, -9, -9, 1, 2, 3 },
            { 0, 0, 8, 6, 6, 0 },
            { 0, 0, 0, -2, 0, 0 },
            { 0, 0, 1, 2, 4, 0 }
        };
        var expectedResult = 28;

        var actualResult = twoDimensionalArrayProblem.hourglassSum(matrix);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testHourglassSum_WhenPassingNullMatrix_ThenThrowIllegalArgumentException() {
        int[][] matrix = null;

        assertThrows(IllegalArgumentException.class,
            () -> twoDimensionalArrayProblem.hourglassSum(matrix));
    }

    @Test
    public void testHourglassSum_WhenPassingEmptyMatrix_ThenThrowIllegalArgumentException() {
        int[][] matrix = new int[0][];

        assertThrows(IllegalArgumentException.class,
            () -> twoDimensionalArrayProblem.hourglassSum(matrix));
    }

}
