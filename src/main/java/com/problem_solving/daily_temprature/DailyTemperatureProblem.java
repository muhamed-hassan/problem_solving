package com.problem_solving.daily_temprature;

//https://leetcode.com/problems/daily-temperatures/
public class DailyTemperatureProblem {

    public int[] dailyTemperatures(int[] T) {
        if (T == null || T.length == 0) throw new IllegalArgumentException("temperatures list can not be null or empty");

        var result = new int[T.length];
        int waitingPeriod = 0,
            resultCursor = 0;

        for (var i = 0; i < T.length; i++) {
            for (var j = i + 1; j < T.length; j++) {
                waitingPeriod++;
                if (T[j] > T[i]) {
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
