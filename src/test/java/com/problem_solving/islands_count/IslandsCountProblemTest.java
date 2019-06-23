package com.problem_solving.islands_count;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class IslandsCountProblemTest {
    
    private IslandsCountProblem islandsCountProblem;    
    
    @Before
    public void setUp() {
        
        islandsCountProblem = new IslandsCountProblem();
    }

    @Test
    public void testSolution_WhenPassingValidMatrix_ThenReturnTheCountOfFoundIslands() {
        
        int[][] matrix = {
                            {1, 0, 1}, 
                            {1, 1, 1}, 
                            {0, 0, 1}, 
                            {1, 1, 1}
                        };
        
        int actualCountOfIslands = islandsCountProblem.solution(matrix);
        
        int expectedCountOfIslands = 3;
        assertEquals(expectedCountOfIslands, actualCountOfIslands);
    }
    
    @Test
    public void testSolution_WhenPassingNullMatrix_ThenReturnNegativeOne() {
        
        int[][] matrix = null;
        
        int actualResult = islandsCountProblem.solution(matrix);
        
        int expectedResult = -1;
        assertEquals(expectedResult, actualResult);
    }
    
}
