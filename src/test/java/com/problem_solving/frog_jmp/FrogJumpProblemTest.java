package com.problem_solving.frog_jmp;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

//https://app.codility.com/programmers/lessons/3-time_complexity/frog_jmp/
public class FrogJumpProblemTest {
    
    private FrogJumpProblem frogJumpProblem;
    
    @Before
    public void setUp() {
        
        frogJumpProblem = new FrogJumpProblem();
    }

    @Test
    public void testSolution_WhenPassing10And85And30_ThenReturn3() {
        
        int x = 10,
            y = 85,
            d = 30;
        
        int minimalNumberOfJumps = frogJumpProblem.solution(x, y, d);
                
        assertEquals(3, minimalNumberOfJumps);
    }
    
}
