package com.problem_solving.twod_array;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    public void testHourglassSum() {
        var matrix = new int[][] {
            { -9, -9, -9, 1, 1, 1 },
            { 0, -9, 0, 4, 3, 2 },
            { -9, -9, -9, 1, 2, 3 },
            { 0, 0, 8, 6, 6, 0 },
            { 0, 0, 0, -2, 0, 0 },
            { 0, 0, 1, 2, 4, 0 }
        };

        var hourglassSum = twoDimensionalArrayProblem.hourglassSum(matrix);

        assertEquals(28, hourglassSum);
    }

}
