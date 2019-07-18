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
        
        var matrix = new int[][]{
                            {1, 0, 1}, 
                            {1, 1, 1}, 
                            {0, 0, 1}, 
                            {1, 1, 1}
                        };
        
        var actualCountOfIslands = islandsCountProblem.solution(matrix);
        
        var expectedCountOfIslands = 3;
        assertEquals(expectedCountOfIslands, actualCountOfIslands);
    }
    
    @Test
    public void testSolution_WhenPassingNullMatrix_ThenReturnNegativeOne() {
        
        var actualResult = islandsCountProblem.solution(null);
        
        var expectedResult = -1;
        assertEquals(expectedResult, actualResult);
    }
    
}
