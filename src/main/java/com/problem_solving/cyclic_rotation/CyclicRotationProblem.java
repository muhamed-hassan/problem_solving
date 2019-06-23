package com.problem_solving.cyclic_rotation;

//https://app.codility.com/programmers/lessons/2-arrays/cyclic_rotation/
public class CyclicRotationProblem {

    public int[] solution(int[] array, int shiftingTimes) {
        
        int[] result = new int[array.length];

        for (int currentIndex = 0; currentIndex < array.length; currentIndex++) {
            
            result[(currentIndex + shiftingTimes) % array.length] = array[currentIndex];
        }

        return result;
    }

}
