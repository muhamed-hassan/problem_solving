package com.problem_solving.electronics_shop;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

//https://www.hackerrank.com/challenges/electronics-shop/problem
public class ElectronicsShopProblemTest {

    private static ElectronicsShopProblem electronicsShopProblem;

    @BeforeAll
    public static void setup() {
        electronicsShopProblem = new ElectronicsShopProblem();
    }

    @Test
    public void testGetMoneySpent_WhenBudgetIsSufficient_ThenCalcTheMaxAmountOfBudgetTheCustomerCouldAffordFromBudget() {
        var budget = 10;
        int[] keyboards = { 3, 1 },
            usbDrives = { 5, 2, 8 };

        var moneyToSpent = electronicsShopProblem.getMoneySpent(keyboards, usbDrives, budget);

        assertTrue(moneyToSpent <= budget);
        assertEquals(9, moneyToSpent);
    }

    @Test
    public void testGetMoneySpent_WhenBudgetIsNotSufficient_ThenReturnNegativeOne() {
        var budget = 5;
        int[] keyboards = { 4 },
            usbDrives = { 5 };

        var moneyToSpent = electronicsShopProblem.getMoneySpent(keyboards, usbDrives, budget);

        assertEquals(-1, moneyToSpent);
    }

}
