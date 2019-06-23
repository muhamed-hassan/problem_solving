package com.problem_solving.ascending_binary_sorting;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AscendingBinarySortingProblemTest {
    
    private AscendingBinarySortingProblem ascendingBinarySortingProblem;
    
    @Before
    public void setUp() {
        
        ascendingBinarySortingProblem = new AscendingBinarySortingProblem();
    }

    @Test
    public void testRearrange() {
        
        List<Integer> dataSet = Arrays.asList(5, 5, 3, 7, 10, 14);
        
        List<Integer> sortedDataSet = ascendingBinarySortingProblem.rearrange(dataSet);
        
        assertEquals(Arrays.asList(3, 5, 10, 7, 14), sortedDataSet);        
    }
    
}
