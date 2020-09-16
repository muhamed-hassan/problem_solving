package com.problem_solving.electronics_shop;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

//https://www.hackerrank.com/challenges/electronics-shop/problem
class ElectronicsShopProblemTest {

    private static ElectronicsShopProblem electronicsShopProblem;

    @BeforeAll
    static void setup() {
        electronicsShopProblem = new ElectronicsShopProblem();
    }

    @Test
    void testGetMoneySpent_WhenBudgetIsSufficient_ThenCalcTheMaxAmountOfBudgetTheCustomerCouldAffordFromBudget() {
        var budget = 10;
        int[] keyboards = { 3, 1 },
            usbDrives = { 5, 2, 8 };
        var expectedMoneyToSpent = 9;

        var actualMoneyToSpent = electronicsShopProblem.getMoneySpent(keyboards, usbDrives, budget);

        assertTrue(actualMoneyToSpent <= budget);
        assertEquals(expectedMoneyToSpent, actualMoneyToSpent);
    }

    @Test
    void testGetMoneySpent_WhenBudgetIsNotSufficient_ThenReturnNegativeOne() {
        var budget = 5;
        int[] keyboards = { 4 },
            usbDrives = { 5 };
        var expectedMoneyToSpent = -1;

        var actualMoneyToSpent = electronicsShopProblem.getMoneySpent(keyboards, usbDrives, budget);

        assertEquals(expectedMoneyToSpent, actualMoneyToSpent);
    }

    @ParameterizedTest
    @MethodSource("provideArgsForTestGetMoneySpent")
    void testGetMoneySpent_WhenPassingInvalidParameters_ThenThrowIllegalArgumentException(int[] keyboards, int[] usbDrives, int budget) {
        assertThrows(IllegalArgumentException.class,
            () -> electronicsShopProblem.getMoneySpent(keyboards, usbDrives, budget));
    }

    private static Stream<Arguments> provideArgsForTestGetMoneySpent() {
        int[] validKeyboards = { 3, 1 };
        var emptyKeyboards = new int[0];
        int[] nullKeyboards = null;

        int[] validUsbDrives = { 5, 2, 8 };
        var emptyUsbDrives = new int[0];
        int[] nullUsbDrives = null;

        var validBudget = 10;
        var invalidBudget = 0;

        return Stream.of(
            Arguments.of(emptyKeyboards, validUsbDrives, validBudget),
            Arguments.of(nullKeyboards, validUsbDrives, validBudget),
            Arguments.of(validKeyboards, emptyUsbDrives, validBudget),
            Arguments.of(validKeyboards, nullUsbDrives, validBudget),
            Arguments.of(validKeyboards, validUsbDrives, invalidBudget)
        );
    }

}
