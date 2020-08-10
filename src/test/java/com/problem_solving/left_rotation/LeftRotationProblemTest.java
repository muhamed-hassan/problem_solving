package com.problem_solving.left_rotation;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

//https://www.hackerrank.com/challenges/ctci-array-left-rotation/problem
public class LeftRotationProblemTest {

    private static LeftRotationProblem leftRotation;

    @BeforeAll
    public static void setUp() {
        leftRotation = new LeftRotationProblem();
    }

    @Test
    public void testRotLeft() {
        var array = new int[] { 33, 47, 70, 37, 8, 53, 13, 93, 71, 72, 51, 100, 60, 87, 97 };
        var d = 13;

        var result = leftRotation.rotLeft(array, d);

        assertArrayEquals(new int[] { 87, 97, 33, 47, 70, 37, 8, 53, 13, 93, 71, 72, 51, 100, 60 }, result);
    }

}
