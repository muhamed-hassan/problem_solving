package com.problem_solving.ascending_binary_sorting;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class AscendingBinarySortingProblemTest {

    private static AscendingBinarySortingProblem ascendingBinarySortingProblem;

    @BeforeAll
    public static void setUp() {
        ascendingBinarySortingProblem = new AscendingBinarySortingProblem();
    }

    @Test
    public void testRearrange() {
        var dataSet = List.of(5, 5, 3, 7, 10, 14);

        var sortedDataSet = ascendingBinarySortingProblem.rearrange(dataSet);

        assertEquals(List.of(3, 5, 10, 7, 14), sortedDataSet);
    }

}
