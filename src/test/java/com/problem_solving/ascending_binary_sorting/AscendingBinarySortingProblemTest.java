package com.problem_solving.ascending_binary_sorting;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class AscendingBinarySortingProblemTest {

    private static AscendingBinarySortingProblem ascendingBinarySortingProblem;

    @BeforeAll
    static void setup() {
        ascendingBinarySortingProblem = new AscendingBinarySortingProblem();
    }

    @Test
    void testRearrange_WhenDataSetIsValid_ThenRearrangeIt() {
        var dataSet = List.of(5, 5, 3, 7, 10, 14);
        var expectedResult = List.of(3, 5, 10, 7, 14);

        var actualResult = ascendingBinarySortingProblem.rearrange(dataSet);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testRearrange_WhenDataSetEmpty_ThenReturnAnEmptyDataSet() {
        List<Integer> dataSet = List.of();
        var expectedResult = List.of();

        var actualResult = ascendingBinarySortingProblem.rearrange(dataSet);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testRearrange_WhenDataSetIsNull_ThenThrowIllegalArgumentException() {
        List<Integer> dataSet = null;

        assertThrows(IllegalArgumentException.class,
            () -> ascendingBinarySortingProblem.rearrange(dataSet));
    }

}
