package com.problem_solving.odd_occurrences_in_array;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

//https://app.codility.com/programmers/lessons/2-arrays/odd_occurrences_in_array/
public class OddOccurrencesInArrayProblem {

    public int solution(int[] A) {
        if (A == null || A.length == 0) throw new IllegalArgumentException("array can not be null or empty");

        return Arrays.stream(A)
                        .boxed()
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                        .entrySet()
                        .stream()
                        .filter(entry -> entry.getValue() == 1)
                        .map(entry -> entry.getKey())
                        .findFirst()
                        .get();
    }

}
