package com.problem_solving.binary_gap;

//https://app.codility.com/programmers/lessons/1-iterations/binary_gap/
public class BinaryGapProblem {
    
    public int solution(int n) {
        
        String binaryValue = Integer.toBinaryString(n);
        int maxConsecutiveZerosBetween2Ones = 0, count = 0;
        boolean startFound = false;

        for (int i = 0; i < binaryValue.length(); i++) {

            if (i < binaryValue.length() - 1) {
                
                if (binaryValue.charAt(i) == '1' && binaryValue.charAt(i + 1) == '0') {
                    
                    startFound = true;
                } else if (binaryValue.charAt(i) == '0' && startFound) {
                    
                    count++;
                    
                    if (binaryValue.charAt(i + 1) == '1') {
                        
                        maxConsecutiveZerosBetween2Ones = Math.max(maxConsecutiveZerosBetween2Ones, count);
                        count = 0;
                        startFound = false;
                    }
                }
            }

        }
        
        return maxConsecutiveZerosBetween2Ones;
    }
    
}
