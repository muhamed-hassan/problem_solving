package com.problem_solving.daily_temprature;

//https://leetcode.com/problems/daily-temperatures/
class DailyTemperatureProblem {

    int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null || temperatures.length == 0) throw new IllegalArgumentException("temperatures list can not be null or empty");

        var result = new int[temperatures.length];
        var waitingPeriod = 0;
        var resultCursor = 0;
        for (var i = 0; i < temperatures.length; i++) {
            for (var j = i + 1; j < temperatures.length; j++) {
                waitingPeriod++;
                if (temperatures[j] > temperatures[i]) {
                    result[resultCursor] = waitingPeriod;
                    break;
                }
            }
            resultCursor++;
            waitingPeriod = 0;
        }

        return result;
    }

}
