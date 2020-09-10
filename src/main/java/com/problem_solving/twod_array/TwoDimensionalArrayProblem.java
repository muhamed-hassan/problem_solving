package com.problem_solving.twod_array;

import java.util.Comparator;
import java.util.PriorityQueue;

//https://www.hackerrank.com/challenges/2d-array/problem
public class TwoDimensionalArrayProblem {

    public int hourglassSum(int[][] matrix) {
        if (matrix == null || matrix.length == 0) throw new IllegalArgumentException("matrix can not be null or empty");

        var hourglassSums = new PriorityQueue<Integer>(Comparator.reverseOrder());

        int hourglassSum, a, b, c, d, e, f, g;
        for (var i = 0; i < 4; i++) {
            for (var j = 0; j < 4; j++) {
                a = matrix[i][j];
                b = matrix[i][j + 1];
                c = matrix[i][j + 2];
                d = matrix[i + 1][j + 1];
                e = matrix[i + 2][j];
                f = matrix[i + 2][j + 1];
                g = matrix[i + 2][j + 2];
                hourglassSum = a + b + c + d + e + f + g;
                hourglassSums.add(hourglassSum);
            }
        }

        return hourglassSums.element();
    }

}
