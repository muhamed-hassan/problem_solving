package com.problem_solving.odd_occurrences_in_array;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

//https://app.codility.com/programmers/lessons/2-arrays/odd_occurrences_in_array/
public class OddOccurrencesInArrayProblemTest {

    private static OddOccurrencesInArrayProblem oddOccurrencesInArrayProblem;

    @BeforeAll
    public static void setup() {
        oddOccurrencesInArrayProblem = new OddOccurrencesInArrayProblem();
    }

    @Test
    public void testSolution_WhenPassingCollectionOfIntegers_ThenReturnUnpairedNumber() {
        var array = new int[] { 9, 3, 9, 3, 9, 7, 9 };
        var expectedResult = 7;

        var actualResult = oddOccurrencesInArrayProblem.solution(array);

        assertEquals(expectedResult, actualResult);
    }

    @ParameterizedTest
    @MethodSource("provideArgsForTestSolutionWhenParametersAreInvalid")
    public void testSolution_WhenParametersAreInvalid_ThenThrowIllegalArgumentException(int[] array) {
        assertThrows(IllegalArgumentException.class,
            () -> oddOccurrencesInArrayProblem.solution(array));
    }

    private static Stream<Arguments> provideArgsForTestSolutionWhenParametersAreInvalid() {
        var emptyArray = new int[0];
        int[] nullArray = null;

        return Stream.of(
            Arguments.of(emptyArray),
            Arguments.of(nullArray)
        );
    }

}
