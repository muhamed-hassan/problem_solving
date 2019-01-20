package com.problem_solving.left_rotation;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

//https://www.hackerrank.com/challenges/ctci-array-left-rotation/problem
public class LeftRotationProblemTest {
    
    private LeftRotationProblem leftRotation;
    
    @Before
    public void setUp() {
        leftRotation = new LeftRotationProblem();
    }

    @Test
    public void testRotLeft() {
        
        int[] array = {33, 47, 70, 37, 8, 53, 13, 93, 71, 72, 51, 100, 60, 87, 97};
        int d = 13;
        
        int[] result = leftRotation.rotLeft(array, d);
        
        assertArrayEquals(new int[]{87, 97, 33, 47, 70, 37, 8, 53, 13, 93, 71, 72, 51, 100, 60}, result);
        
    }
    
}
