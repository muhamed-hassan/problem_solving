package com.problem_solving.second_element_with_max_frequency;

import static java.util.stream.Collectors.groupingBy;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SecondElementWithMaxFrequencyProblem {

    public int solve(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) throw new IllegalArgumentException("numbers list can not be null or empty");

        return numbers.stream()
                        .collect(groupingBy(Function.identity(), Collectors.counting()))
                        .entrySet()
                        .stream()
                        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                        .skip(1)
                        .findFirst()
                        .get()
                        .getValue()
                        .intValue();
    }

}
