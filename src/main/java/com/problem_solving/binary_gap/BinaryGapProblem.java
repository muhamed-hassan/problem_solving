package com.problem_solving.binary_gap;

//https://app.codility.com/programmers/lessons/1-iterations/binary_gap/
class BinaryGapProblem {

    int solution(int n) {
        var binaryValue = Integer.toBinaryString(n);
        var maxConsecutiveZerosBetween2Ones = 0;
        var count = 0;
        var startFound = false;
        for (var i = 0; i < binaryValue.length(); i++) {
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
