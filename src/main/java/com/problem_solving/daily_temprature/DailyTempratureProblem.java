package com.problem_solving.daily_temprature;

//https://leetcode.com/problems/daily-temperatures/
public class DailyTempratureProblem {
    
    public int[] dailyTemperatures(int[] T) {
        
        int[] result = new int[T.length];
        int waitingPeriod = 0, 
            resultCursor = 0;
        
        for(int i = 0; i < T.length; i++) {
            
            for(int j = i+1; j < T.length; j++) {
                
                waitingPeriod++;
                
                if ( T[j] > T[i] ) {
                    
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