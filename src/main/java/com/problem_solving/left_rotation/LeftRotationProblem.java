package com.problem_solving.left_rotation;

//https://www.hackerrank.com/challenges/ctci-array-left-rotation/problem
public class LeftRotationProblem {
    
    public int[] rotLeft(int[] a, int d) {
        int arraySize = a.length;
        int[] leftRotatedArray = new int[arraySize];

        int newIndex = -1;
        for(int currentIndex = 0; currentIndex < arraySize; currentIndex++) {
            
            newIndex = ((currentIndex - d) < 0) ? 
                            (((currentIndex - d) + arraySize) % arraySize) : 
                            (currentIndex - d);
            
            leftRotatedArray[newIndex] = a[currentIndex];
        }

        return leftRotatedArray;
    }
    
}