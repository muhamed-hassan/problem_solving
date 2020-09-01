package com.problem_solving.second_element_with_max_frequency;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class SecondElementWithMaxFrequencyProblemTest {

    private static SecondElementWithMaxFrequencyProblem secondElementWithMaxFrequencyProblem;

    @BeforeAll
    public static void setup() {
        secondElementWithMaxFrequencyProblem = new SecondElementWithMaxFrequencyProblem();
    }

    @Test
    public void testSolve_WhenPassingCollectionOfIntegers_ThenReturnElementWith2ndBiggestFrequency() {
        var numbers = List.of(1, 2, 1, 3, 4, 3, 3, 4, 9, 11, 4, 4, 4);

        var actualResult = secondElementWithMaxFrequencyProblem.solve(numbers);

        assertEquals(3, actualResult);
    }

}
