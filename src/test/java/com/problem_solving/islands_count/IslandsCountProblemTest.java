package com.problem_solving.islands_count;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class IslandsCountProblemTest {

    private static IslandsCountProblem islandsCountProblem;

    @BeforeAll
    static void setup() {
        islandsCountProblem = new IslandsCountProblem();
    }

    @Test
    void testSolution_WhenPassingValidMatrix_ThenReturnTheCountOfFoundIslands() {
        var matrix = new int[][] {
            { 1, 0, 1 },
            { 1, 1, 1 },
            { 0, 0, 1 },
            { 1, 1, 1 }
        };
        var expectedCountOfIslands = 3;

        var actualCountOfIslands = islandsCountProblem.solution(matrix);

        assertEquals(expectedCountOfIslands, actualCountOfIslands);
    }

    @Test
    void testSolution_WhenPassingNullMatrix_ThenThrowIllegalArgumentException() {
        int[][] matrix = null;

        assertThrows(IllegalArgumentException.class,
            () -> islandsCountProblem.solution(matrix));
    }

    @Test
    void testSolution_WhenPassingEmptyMatrix_ThenThrowIllegalArgumentException() {
        int[][] matrix = new int[0][];

        assertThrows(IllegalArgumentException.class,
            () -> islandsCountProblem.solution(matrix));
    }

}
