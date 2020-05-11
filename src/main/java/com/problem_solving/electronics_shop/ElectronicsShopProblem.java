package com.problem_solving.electronics_shop;

import java.util.ArrayList;

//https://www.hackerrank.com/challenges/electronics-shop/problem
public class ElectronicsShopProblem {

    public int getMoneySpent(int[] keyboards, int[] drives, int b) {
        var priceSummtionOfitemsToBeBought = new ArrayList<Integer>();
        for (var keyboardIndex = 0; keyboardIndex < keyboards.length; keyboardIndex++) {
            for (var driveIndex = 0; driveIndex < drives.length; driveIndex++) {
                priceSummtionOfitemsToBeBought.add(keyboards[keyboardIndex] + drives[driveIndex]);
            }
        }

        return priceSummtionOfitemsToBeBought
                                        .stream()
                                        .filter(totalPrice -> totalPrice <= b)
                                        .max((x, y) -> x - y)
                                        .orElse(-1);
    }

}
