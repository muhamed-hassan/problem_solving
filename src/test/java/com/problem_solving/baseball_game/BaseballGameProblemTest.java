package com.problem_solving.baseball_game;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class BaseballGameProblemTest {

    private static BaseballGameProblem baseballGameProblem;

    @BeforeAll
    public static void setUp() {
        baseballGameProblem = new BaseballGameProblem();
    }

    @Test
    public void testCalPoints_WhenOperationsAreValid_ThenReturnSumOfPointsForAllRounds() {
        var operaties = new String[] { "5", "-2", "4", "C", "D", "9", "+", "+" };
        var expectedResult = 27;

        var actualResult= baseballGameProblem.calPoints(operaties);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testCalPoints_WhenOperationsAreEmpty_ThenReturnNegativeOne() {
        String[] operaties = new String[0];
        var expectedResult = -1;

        var actualResult = baseballGameProblem.calPoints(operaties);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testCalPoints_WhenOperationsAreNull_ThenThrowIllegalArgumentException() {
        String[] operaties = null;

        assertThrows(IllegalArgumentException.class,
            () -> baseballGameProblem.calPoints(operaties));
    }

}
