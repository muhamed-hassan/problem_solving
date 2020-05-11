package com.problem_solving.baseball_game;

import java.util.ArrayList;

//https://leetcode.com/problems/baseball-game/
public class BaseballGameProblem {

    public int calPoints(String[] ops) {
        int lastElementCursor = -1;
        var result = new ArrayList<Integer>(ops.length);
        
        for(var recordedEvent : ops) {
            switch(recordedEvent) {
                case "+":
                    if (result.size() > 1) {
                        result.add(result.get(lastElementCursor-1) + result.get(lastElementCursor++));
                    }
                    break;
                    
                case "C":
                    if (!result.isEmpty()) {
                        result.remove(lastElementCursor--);
                    }
                    break;
                    
                case "D":
                    if (!result.isEmpty()) {
                        result.add(result.get(lastElementCursor++) * 2);
                    }
                    break;
                    
                default:
                    result.add(Integer.parseInt(recordedEvent));
                    lastElementCursor++;
            }
        }
        
        return result.stream()
                        .reduce(0, (a, b) -> a + b);
    }
    
}
