package com.problem_solving.baseball_game;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class BaseballGameProblemTest {

    private static BaseballGameProblem baseballGameProblem;

    @BeforeAll
    static void setup() {
        baseballGameProblem = new BaseballGameProblem();
    }

    @Test
    void testCalPoints_WhenOperationsAreValid_ThenReturnSumOfPointsForAllRounds() {
        var operations = new String[] { "5", "-2", "4", "C", "D", "9", "+", "+" };
        var expectedResult = 27;

        var actualResult= baseballGameProblem.calPoints(operations);

        assertEquals(expectedResult, actualResult.get());
    }

    @Test
    void testCalPoints_WhenOperationsAreEmpty_ThenReturnNegativeOne() {
        var operations = new String[0];
        var expectedResult = Optional.empty();

        var actualResult = baseballGameProblem.calPoints(operations);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testCalPoints_WhenOperationsAreNull_ThenThrowIllegalArgumentException() {
        String[] operations = null;

        assertThrows(IllegalArgumentException.class,
            () -> baseballGameProblem.calPoints(operations));
    }

}
