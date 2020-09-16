package com.problem_solving.second_element_with_max_frequency;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SecondElementWithMaxFrequencyProblemTest {

    private static SecondElementWithMaxFrequencyProblem secondElementWithMaxFrequencyProblem;

    @BeforeAll
    static void setup() {
        secondElementWithMaxFrequencyProblem = new SecondElementWithMaxFrequencyProblem();
    }

    @Test
    void testSolve_WhenPassingCollectionOfIntegers_ThenReturnElementWith2ndBiggestFrequency() {
        var numbers = List.of(1, 2, 1, 3, 4, 3, 3, 4, 9, 11, 4, 4, 4);
        var expectedResult = 3;

        var actualResult = secondElementWithMaxFrequencyProblem.solve(numbers);

        assertEquals(expectedResult, actualResult);
    }

    @ParameterizedTest
    @MethodSource("provideArgsForTestSolveWhenParameterIsInvalid")
    void testSolve_WhenParameterIsInvalid_ThenThrowIllegalArgumentException(List<Integer> numbers) {
        assertThrows(IllegalArgumentException.class,
            () -> secondElementWithMaxFrequencyProblem.solve(numbers));
    }

    private static Stream<Arguments> provideArgsForTestSolveWhenParameterIsInvalid() {
        var emptyList = List.of();
        List<Integer> nullList = null;

        return Stream.of(
            Arguments.of(emptyList),
            Arguments.of(nullList)
        );
    }

}
