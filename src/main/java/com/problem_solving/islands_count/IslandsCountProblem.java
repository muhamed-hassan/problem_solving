package com.problem_solving.islands_count;

//A problem from Udacity course for [Data Structures & Algorithms in Python]
/*
Count the number of islands in a matrix, 
where island is represented as a sequence of 1s horizontally or vertically
*/
class IslandsCountProblem {

    int solution(int[][] matrix) {
        if (matrix == null || matrix.length == 0) throw new IllegalArgumentException("matrix can not be null or empty");

        var islandsCount = 0;
        var elementsProduct = 1;
        var matrixWidth = matrix[0].length;
        var matrixHeight = matrix.length;
        var elementsProductOccurs = false;
        for (var i = 0; i < matrixHeight; i++) {
            //Horizontal scanning
            for (var j = 0; j < matrixWidth; j++) {
                elementsProduct *= matrix[i][j];
                elementsProductOccurs = true;
            }

            if (elementsProduct == 1 && elementsProductOccurs) {
                islandsCount++;
                elementsProductOccurs = false;
            } else {
                elementsProduct = 1;
            }

            //Vertical scanning
            for (var j = 0; j < matrixHeight && i < matrixWidth; j++) {
                elementsProduct *= matrix[j][i];
                elementsProductOccurs = true;
            }

            if (elementsProduct == 1 && elementsProductOccurs) {
                islandsCount++;
                elementsProductOccurs = false;
            } else {
                elementsProduct = 1;
            }
        }

        return islandsCount;
    }

}
