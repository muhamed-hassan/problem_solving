package com.problem_solving.binary_gap;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

//https://app.codility.com/programmers/lessons/1-iterations/binary_gap/
class BinaryGapProblemTest {

    private static BinaryGapProblem binaryGapProblem;

    @BeforeAll
    static void setup() {
        binaryGapProblem = new BinaryGapProblem();
    }

    @Test
    void testSolution_WhenAllBitsAreOnes_ThenReturn0() {
        var n = 2147483647;
        var expectedResult = 0;

        var actualResult = binaryGapProblem.solution(n);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testSolution_WhenTheBinaryValueIsLarge_ThenReturn28() {
        var n = 1610612737;
        var expectedResult = 28;

        var actualResult = binaryGapProblem.solution(n);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testSolution_WhenZeroBitsAtTheEnd_ThenReturn2() {
        var n = 328;
        var expectedResult = 2;

        var actualResult = binaryGapProblem.solution(n);

        assertEquals(expectedResult, actualResult);
    }

}
