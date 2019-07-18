package com.problem_solving.daily_temprature;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class DailyTempratureProblemTest {
    
    private DailyTempratureProblem dailyTempratureProblem;
    
    @Before
    public void setUp() {
        
        dailyTempratureProblem = new DailyTempratureProblem();
    }

    @Test
    public void testRearrange() {
        
        var T = new int[]{55,38,53,81,61,93,97,32,43,78};
        
        var result = dailyTempratureProblem.dailyTemperatures(T);
        
        assertArrayEquals(new int[]{3,1,1,2,1,1,0,1,1,0}, result);
    }
    
}
