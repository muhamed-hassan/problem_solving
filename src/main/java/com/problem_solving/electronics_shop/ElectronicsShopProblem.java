package com.problem_solving.electronics_shop;

import java.util.ArrayList;
import java.util.LinkedList;

//https://www.hackerrank.com/challenges/electronics-shop/problem
public class ElectronicsShopProblem {

    public int getMoneySpent(int[] keyboards, int[] usbDrives, int budget) {
        if (keyboards == null || keyboards.length == 0) throw new IllegalArgumentException("keyboards can not be null or empty");

        if (usbDrives == null || usbDrives.length == 0) throw new IllegalArgumentException("usb drives can not be null or empty");

        if (budget < 1) throw new IllegalArgumentException("budget should be greater than zero");

        var totalPriceOfItemsToBeBought = new LinkedList<Integer>();
        for (var keyboardIndex = 0; keyboardIndex < keyboards.length; keyboardIndex++) {
            for (var driveIndex = 0; driveIndex < usbDrives.length; driveIndex++) {
                totalPriceOfItemsToBeBought.add(keyboards[keyboardIndex] + usbDrives[driveIndex]);
            }
        }

        return totalPriceOfItemsToBeBought
                .stream()
                .filter(totalPrice -> totalPrice <= budget)
                .max((x, y) -> x - y)
                .orElse(-1);
    }

}
