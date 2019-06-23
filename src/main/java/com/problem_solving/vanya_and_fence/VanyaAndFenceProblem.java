package com.problem_solving.vanya_and_fence;

//http://codeforces.com/contest/677/problem/A
public class VanyaAndFenceProblem {
    
    public int findTheMinimumPossibleValidWidthOfTheRoad(int n, int h, int[] friendsHeights) {
        
        int minimumPossibleValidWidthOfTheRoad = 0;
        
        for(int i = 0; i < n; i++) {
            
            if (friendsHeights[i] <= h) {
                
                minimumPossibleValidWidthOfTheRoad++;
            } else {
                
                minimumPossibleValidWidthOfTheRoad += 2;
            }            
        }
        
        return minimumPossibleValidWidthOfTheRoad;
    }
    
}
