package com.problem_solving.electronics_shop_program;

import com.problem_solving.electronics_shop.ElectronicsShopProblem;
import java.util.stream.Stream;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

//https://www.hackerrank.com/challenges/electronics-shop/problem
public class ElectronicsShopProblemTest {
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    private ElectronicsShopProblem electronicsShopProblem = null;
    
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
    
    @Test
    public void testGetMoneySpent_WhenNumberOfKeyboardsViolatesTheAllowedConstraintRule_ThenThrowException() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("n value violates the allowed value");
        
        int budget = 10;
        int[] keyboards = null,
              usbDrives = {5, 2, 8};
        
        electronicsShopProblem.getMoneySpent(keyboards, usbDrives, budget);
        
    }
    
    @Test
    public void testGetMoneySpent_WhenNumberOfUsbDrivesViolatesTheAllowedConstraintRule_ThenThrowException() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("m value violates the allowed value");
                
        int budget = 10;
        int[] keyboards = {3, 1},
              usbDrives = Stream.iterate(5, usbDrive -> usbDrive + 5).limit(5000).mapToInt(Integer::intValue).toArray();
        
        electronicsShopProblem.getMoneySpent(keyboards, usbDrives, budget);
        
    }
    
    @Test
    public void testGetMoneySpent_WhenTheValueOfBudgetViolatesTheAllowedConstraintRule_ThenThrowException() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("b value violates the allowed value");
        
        int budget = Double.valueOf(Math.pow(10, 7)).intValue();
        int[] keyboards = {3, 1},
              usbDrives = {5, 2, 8};
        
        electronicsShopProblem.getMoneySpent(keyboards, usbDrives, budget);
        
    }
    
}
