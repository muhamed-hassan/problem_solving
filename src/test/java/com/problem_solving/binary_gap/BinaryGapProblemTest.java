package com.problem_solving.binary_gap;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

//https://app.codility.com/programmers/lessons/1-iterations/binary_gap/
public class BinaryGapProblemTest {

    private static BinaryGapProblem binaryGapProblem;

    @BeforeAll
    public static void setup() {
        binaryGapProblem = new BinaryGapProblem();
    }

    @Test
    public void testSolution_WhenAllBitsAreOnes_ThenReturn0() {
        var n = 2147483647;
        var expectedValue = 0;

        var maxConsecutiveZerosBetween2Ones = binaryGapProblem.solution(n);

        assertEquals(expectedValue, maxConsecutiveZerosBetween2Ones);
    }

    @Test
    public void testSolution_WhenTheBinaryValueIsLarge_ThenReturn28() {
        var n = 1610612737;
        var expectedValue = 28;

        var maxConsecutiveZerosBetween2Ones = binaryGapProblem.solution(n);

        assertEquals(expectedValue, maxConsecutiveZerosBetween2Ones);
    }

    @Test
    public void testSolution_WhenZeroBitsAtTheEnd_ThenReturn2() {
        var n = 328;
        var expectedValue = 2;

        var maxConsecutiveZerosBetween2Ones = binaryGapProblem.solution(n);

        assertEquals(expectedValue, maxConsecutiveZerosBetween2Ones);
    }

}
