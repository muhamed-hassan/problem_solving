package com.problem_solving.cyclic_rotation;

//https://app.codility.com/programmers/lessons/2-arrays/cyclic_rotation/
public class CyclicRotationProblem {

    public int[] solution(int[] array, int shiftingTimes) {
        if (array == null || array.length == 0) throw new IllegalArgumentException("array can not be null or empty");

        if (shiftingTimes < 1) throw new IllegalArgumentException("shifting times should be 1 at least");

        var result = new int[array.length];
        for (var currentIndex = 0; currentIndex < array.length; currentIndex++) {
            result[(currentIndex + shiftingTimes) % array.length] = array[currentIndex];
        }
        return result;
    }

}
