package com.problem_solving.baseball_game;

import java.util.ArrayList;
import java.util.Optional;

//https://leetcode.com/problems/baseball-game/
class BaseballGameProblem {

    Optional<Integer> calPoints(String[] ops) {
        if (ops == null) throw new IllegalArgumentException("operations list can not be null");

        if (ops.length == 0) return Optional.empty();

        var lastElementCursor = -1;
        var result = new ArrayList<Integer>();
        for (var recordedEvent : ops) {
            switch (recordedEvent) {
                case "+":
                    if (result.size() > 1) {
                        result.add(result.get(lastElementCursor - 1) + result.get(lastElementCursor++));
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

        return Optional.of(result.stream()
                                    .reduce(0, (a, b) -> a + b));
    }

}
