package com.problem_solving.vanya_and_fence;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class VanyaAndFenceProblemTest {
    
    private VanyaAndFenceProblem vafp;
    
    @Before
    public void setUp() {

        vafp = new VanyaAndFenceProblem(); 
    }

    @Test
    public void testFindTheMinimumPossibleValidWidthOfTheRoad() {
        
        int n = 6, h = 5;
        int[] heights = {7, 6, 8, 9, 10, 5};
        
        int result = vafp.findTheMinimumPossibleValidWidthOfTheRoad(n, h, heights);
        
        assertEquals(11, result);        
    }
    
}
