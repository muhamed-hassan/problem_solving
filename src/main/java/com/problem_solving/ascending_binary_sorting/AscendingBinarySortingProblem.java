package com.problem_solving.ascending_binary_sorting;

import java.util.List;
import java.util.stream.Collectors;

/*
Consider an array of decimal integers. We want to rearrange the array according to the following rules:

Sort the integers in ascending order by the number of 1's in their binary representations.
Elements having the same number of 1's in their binary representations are ordered by increasing decimal value.
 
For example, consider the array [7, 8, 6, 5]10 = [0111, 1000, 0110, 0101]2.  
First group the items by number of binary digits equal to 1: [[1000], [0101, 0110], [0111]]2.  
The elements with two 1's now must be ordered:  [0110, 0101]2 = [6, 5]10.  
We sort those two elements in ascending order by value making our final array [1000, 0101, 0110, 0111]2 = [8, 5, 6, 7]10.

#Function Description 
Complete the function rearrange in the editor below. The function must return an array of decimal integers sorted per the rules above.

rearrange has the following parameter(s):

    elements[elements[0],...elements[n-1]]:  an array of integers to sort
*/
public class AscendingBinarySortingProblem {
        
    public List<Integer> rearrange(List<Integer> elements) {
    	return elements.stream()
                        .distinct()
                        .map(intValue -> Integer.toBinaryString(intValue))
                        .sorted((a, b) -> {
                                    int comparisonResult;
                                    long countOfOnesOfFirst = a.chars().mapToObj(intChar -> (char)intChar).filter(literalChar -> literalChar == '1').count();
                                    long countOfOnesOfSecond = b.chars().mapToObj(intChar -> (char)intChar).filter(literalChar -> literalChar == '1').count();

                                    if ( countOfOnesOfFirst == countOfOnesOfSecond ) {
                                         int intValueOfFirst = Integer.parseInt(a, 2);
                                         int intValueOfSecond = Integer.parseInt(b, 2);
                                         comparisonResult = intValueOfFirst - intValueOfSecond;
                                    } else {
                                        comparisonResult = (int) (countOfOnesOfFirst - countOfOnesOfSecond);
                                    }
                                    return comparisonResult;})
                        .map(binaryValue -> Integer.parseInt(binaryValue, 2))
                        .collect(Collectors.toList());
    }
    
}
