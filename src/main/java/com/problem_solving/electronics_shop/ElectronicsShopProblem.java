package com.problem_solving.electronics_shop;

import java.util.ArrayList;
import java.util.List;

//https://www.hackerrank.com/challenges/electronics-shop/problem
public class ElectronicsShopProblem {

    public int getMoneySpent(int[] keyboards, int[] drives, int b) {
        
        List<Integer> priceSummtionOfitemsToBeBought = new ArrayList<>();
        for (int keyboardIndex = 0; keyboardIndex < keyboards.length; keyboardIndex++) {

            for (int driveIndex = 0; driveIndex < drives.length; driveIndex++) {
                
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
