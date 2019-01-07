package com.problem_solving.islands_count;

//A problem from Udacity course for [Data Structures & Algorithms in Python]
/*
Count the number of islands in a matrix, 
where island is represented as a sequence of 1s horizontally or vertically
*/
public class IslandsCountProblem {
    
    public int solution(int[][] matrix) {
        
        if ( matrix == null ) return -1;
        
        int islandsCount = 0,
            elementsProduct = 1, 
            matrixWidth = matrix[0].length, 
            matrixHeight = matrix.length;
        boolean elementsProductOccurs = false;
        for(int i = 0; i < matrixHeight; i++) {            
            
            //Horizontal scanning
            for(int j = 0; j < matrixWidth; j++) {
                elementsProduct *= matrix[i][j];
                elementsProductOccurs = true;
            }
                        
            if ( elementsProduct == 1 && elementsProductOccurs ) {
                islandsCount++;
                elementsProductOccurs = false;
            } else {
                elementsProduct = 1;
            }
            
            
            //Vertical scanning
            for(int j = 0; j < matrixHeight && i < matrixWidth; j++) {
                elementsProduct *= matrix[j][i];
                elementsProductOccurs = true;
            }
            
            if ( elementsProduct == 1 && elementsProductOccurs ) {
                islandsCount++;
                elementsProductOccurs = false;
            } else {
                elementsProduct = 1;
            }
            
        }
        
        return islandsCount;
    }
    
}
