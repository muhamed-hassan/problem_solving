package com.problem_solving.odd_occurrences_in_array;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

//https://app.codility.com/programmers/lessons/2-arrays/odd_occurrences_in_array/
public class OddOccurrencesInArrayProblemTest {
    
    private static OddOccurrencesInArrayProblem oddOccurrencesInArrayProblem;
    
    @BeforeAll
    public static void setUp() {
        oddOccurrencesInArrayProblem = new OddOccurrencesInArrayProblem();
    }

    @Test
    public void testSolution_WhenPassingCollectionOfIntegers_ThenReturnUnpairedNumber() {
        var array = new int[]{9, 3, 9, 3, 9, 7, 9};
        
        var unpairedNumber = oddOccurrencesInArrayProblem.solution(array);
        
        assertEquals(7, unpairedNumber);
    }
    
}
