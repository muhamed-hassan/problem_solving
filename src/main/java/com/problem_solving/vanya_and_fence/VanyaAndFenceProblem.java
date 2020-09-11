package com.problem_solving.vanya_and_fence;

//http://codeforces.com/contest/677/problem/A
public class VanyaAndFenceProblem {

    public int findTheMinimumPossibleValidWidthOfTheRoad(int numberOfFriends, int heightOfFence, int[] friendsHeights) {
        if (numberOfFriends < 1) throw new IllegalArgumentException("number of friends should be a positive number");

        if (heightOfFence < 1) throw new IllegalArgumentException("height of fence should be a positive number");

        if (friendsHeights == null || friendsHeights.length == 0) throw new IllegalArgumentException("friends heights array can not be null or empty");

        int minimumPossibleValidWidthOfTheRoad = 0;

        for (var i = 0; i < numberOfFriends; i++) {
            if (friendsHeights[i] <= heightOfFence) {
                minimumPossibleValidWidthOfTheRoad++;
            } else {
                minimumPossibleValidWidthOfTheRoad += 2;
            }
        }

        return minimumPossibleValidWidthOfTheRoad;
    }

}
