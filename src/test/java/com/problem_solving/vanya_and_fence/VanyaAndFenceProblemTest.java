package com.problem_solving.vanya_and_fence;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class VanyaAndFenceProblemTest {
    
    private static VanyaAndFenceProblem vafp;
    
    @BeforeAll
    public static void setUp() {
        vafp = new VanyaAndFenceProblem(); 
    }

    @Test
    public void testFindTheMinimumPossibleValidWidthOfTheRoad() {
        int n = 6, h = 5;
        var heights = new int[]{7, 6, 8, 9, 10, 5};
        
        var result = vafp.findTheMinimumPossibleValidWidthOfTheRoad(n, h, heights);
        
        assertEquals(11, result);        
    }
    
}
