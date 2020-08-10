package com.problem_solving.frog_jmp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

//https://app.codility.com/programmers/lessons/3-time_complexity/frog_jmp/
public class FrogJumpProblemTest {

    private static FrogJumpProblem frogJumpProblem;

    @BeforeAll
    public static void setUp() {
        frogJumpProblem = new FrogJumpProblem();
    }

    @Test
    public void testSolution_WhenPassing10And85And30_ThenReturn3() {
        int x = 10,
            y = 85,
            d = 30;

        var minimalNumberOfJumps = frogJumpProblem.solution(x, y, d);

        assertEquals(3, minimalNumberOfJumps);
    }

}
