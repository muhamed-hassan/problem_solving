package com.problem_solving.frog_jmp;

//https://app.codility.com/programmers/lessons/3-time_complexity/frog_jmp/
public class FrogJumpProblem {

    public int solution(int x, int y, int d) {
        return (int) Math.ceil((y - x) / ((d * 10) / 10.0));
    }

}
