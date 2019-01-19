package com.problem_solving.twod_array;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

//https://www.hackerrank.com/challenges/2d-array/problem
public class TwoDimensionalArrayProblem {
    
    public int hourglassSum(int[][] arr) {
        
        Queue<Integer> hourglassSums = new PriorityQueue<>(Comparator.reverseOrder());

        int hourglassSum, a, b, c, d, e, f, g;
        for(int i = 0; i < 4; i++) {
            
            hourglassSum = 0;
            for(int j = 0; j < 4; j++) {
                
                a = arr[i][j];
                b = arr[i][j+1];
                c = arr[i][j+2];
                d = arr[i+1][j+1];
                e = arr[i+2][j];
                f = arr[i+2][j+1];
                g = arr[i+2][j+2];

                hourglassSum = a + b + c + d + e + f + g;

                hourglassSums.add(hourglassSum);           
            }
        }

        return hourglassSums.element();
    }
    
}
