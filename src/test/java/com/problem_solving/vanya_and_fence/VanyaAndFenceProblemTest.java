/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.problem_solving.vanya_and_fence;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author muhamed
 */
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
