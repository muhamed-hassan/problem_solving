package com.problem_solving.binary_gap;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

//https://app.codility.com/programmers/lessons/1-iterations/binary_gap/
public class BinaryGapTest {
    
    private static BinaryGapProblem binaryGapProblem;
    
    @BeforeAll
    public static void setUp() {
        binaryGapProblem = new BinaryGapProblem();
    }

    @Test
    public void testSolution_WhenAllBitsAreOnes() {
        int n = 2147483647;
        
        int maxConsecutiveZerosBetween2Ones = binaryGapProblem.solution(n);
        
        assertEquals(0, maxConsecutiveZerosBetween2Ones);        
    }
    
    @Test
    public void testSolution_WhenTheBinaryValueIsLarge() {
        int n = 1610612737;
        
        int maxConsecutiveZerosBetween2Ones = binaryGapProblem.solution(n);
        
        assertEquals(28, maxConsecutiveZerosBetween2Ones);        
    }
    
    @Test
    public void testSolution_WhenZeroBitsAtTheEnd() {
        int n = 328;
        
        int maxConsecutiveZerosBetween2Ones = binaryGapProblem.solution(n);
        
        assertEquals(2, maxConsecutiveZerosBetween2Ones);        
    }
    
}
