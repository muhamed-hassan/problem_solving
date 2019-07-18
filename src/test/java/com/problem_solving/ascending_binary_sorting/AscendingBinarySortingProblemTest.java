package com.problem_solving.ascending_binary_sorting;

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
        
        var dataSet = List.of(5, 5, 3, 7, 10, 14);
        
        var sortedDataSet = ascendingBinarySortingProblem.rearrange(dataSet);
        
        assertEquals(List.of(3, 5, 10, 7, 14), sortedDataSet);        
    }
    
}
