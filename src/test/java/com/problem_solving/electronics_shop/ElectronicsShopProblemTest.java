package com.problem_solving.electronics_shop;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

//https://www.hackerrank.com/challenges/electronics-shop/problem
public class ElectronicsShopProblemTest {
    
    private ElectronicsShopProblem electronicsShopProblem;
    
    @Before
    public void setup() {
        
        electronicsShopProblem = new ElectronicsShopProblem();
    }
    
    @Test
    public void testGetMoneySpent_WhenBudgetIsSufficient_ThenCalcTheMaxAmountOfBudgetTheCustomerCouldAffordFromBudget() {
        
        int budget = 10;
        int[] keyboards = {3, 1},
              usbDrives = {5, 2, 8};
        
        int moneyToSpent = electronicsShopProblem.getMoneySpent(keyboards, usbDrives, budget);
        
        assertTrue(moneyToSpent <= budget);
        assertEquals(9, moneyToSpent);                
    }
        
    @Test
    public void testGetMoneySpent_WhenBudgetIsNotSufficient_ThenReturnNegativeOne() {
        
        int budget = 5;
        int[] keyboards = {4},
              usbDrives = {5};
        
        int moneyToSpent = electronicsShopProblem.getMoneySpent(keyboards, usbDrives, budget);
        
        assertEquals(-1, moneyToSpent);        
    }
    
}
