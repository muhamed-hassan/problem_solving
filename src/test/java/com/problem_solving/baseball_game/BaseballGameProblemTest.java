package com.problem_solving.baseball_game;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class BaseballGameProblemTest {

    private static BaseballGameProblem baseballGameProblem;

    @BeforeAll
    public static void setUp() {
        baseballGameProblem = new BaseballGameProblem();
    }

    @Test
    public void testRearrange() {
        var operaties = new String[] { "5", "-2", "4", "C", "D", "9", "+", "+" };

        var actualResult= baseballGameProblem.calPoints(operaties);

        assertEquals(27, actualResult);
    }

}
