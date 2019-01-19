package com.problem_solving.twod_array;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

//https://www.hackerrank.com/challenges/2d-array/problem
public class TwoDimensionalArrayProblemTest {
    
    private TwoDimensionalArrayProblem twoDimensionalArrayProblem;
    
    @Before
    public void setUp() {
        twoDimensionalArrayProblem = new TwoDimensionalArrayProblem();
    }

    @Test
    public void testHourglassSum() {
      
        int[][] matrix = {
                            {-9, -9, -9, 1, 1, 1},
                            {0, -9, 0, 4, 3, 2},
                            {-9, -9, -9, 1, 2, 3},
                            {0, 0, 8, 6, 6, 0},
                            {0, 0, 0, -2, 0, 0},
                            {0, 0, 1, 2, 4, 0}
                        };
        
        int hourglassSum = twoDimensionalArrayProblem.hourglassSum(matrix);
        
        assertEquals(28, hourglassSum);
        
    }
    
}
