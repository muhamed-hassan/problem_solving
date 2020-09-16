package com.problem_solving.frog_jmp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

//https://app.codility.com/programmers/lessons/3-time_complexity/frog_jmp/
class FrogJumpProblemTest {

    private static FrogJumpProblem frogJumpProblem;

    @BeforeAll
    static void setup() {
        frogJumpProblem = new FrogJumpProblem();
    }

    @Test
    void testSolution_WhenPassing10And85And30_ThenReturn3() {
        var x = 10;
        var y = 85;
        var d = 30;
        var expectedResult = 3;

        var actualResult = frogJumpProblem.solution(x, y, d);

        assertEquals(expectedResult, actualResult);
    }

}
