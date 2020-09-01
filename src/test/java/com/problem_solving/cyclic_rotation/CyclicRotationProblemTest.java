package com.problem_solving.cyclic_rotation;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

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

        var shiftedArray = cyclicRotationProblem.solution(array, shiftingTimes);

        assertArrayEquals(new int[] { 9, 7, 6, 3, 8 }, shiftedArray);
    }

}
