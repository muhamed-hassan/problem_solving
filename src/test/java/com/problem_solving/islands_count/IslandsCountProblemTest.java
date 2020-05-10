package com.problem_solving.islands_count;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class IslandsCountProblemTest {
    
    private static IslandsCountProblem islandsCountProblem;
    
    @BeforeAll
    public static void setUp() {
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
        var actualCountOfIslands = islandsCountProblem.solution(null);
        
        var expectedCountOfIslands = -1;
        assertEquals(expectedCountOfIslands, actualCountOfIslands);
    }
    
}
