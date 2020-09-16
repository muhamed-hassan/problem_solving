package com.problem_solving.left_rotation;

//https://www.hackerrank.com/challenges/ctci-array-left-rotation/problem
class LeftRotationProblem {

    int[] rotLeft(int[] a, int d) {
        if (a == null || a.length == 0) throw new IllegalArgumentException("array can not be null or empty");

        if (d < 1 || d > a.length) throw new IllegalArgumentException("number of rotations is invalid, (it should be >= 1 and <= length of the array)");

        var leftRotatedArray = new int[a.length];
        int newIndex;
        for (var currentIndex = 0; currentIndex < a.length; currentIndex++) {
            newIndex = ((currentIndex - d) < 0) ?
                        (((currentIndex - d) + a.length) % a.length) :
                        (currentIndex - d);
            leftRotatedArray[newIndex] = a[currentIndex];
        }

        return leftRotatedArray;
    }

}
