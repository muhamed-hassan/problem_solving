package com.problem_solving.electronics_shop;

import java.util.ArrayList;
import java.util.List;

//https://www.hackerrank.com/challenges/electronics-shop/problem
public class ElectronicsShopProblem {

    public int getMoneySpent(int[] keyboards, int[] drives, int b) {
        
        if( keyboards == null || keyboards.length < 1 || keyboards.length > 1000 ) throw new IllegalArgumentException("n value violates the allowed value");
        
        if( drives == null || drives.length < 1 || drives.length > 1000 ) throw new IllegalArgumentException("m value violates the allowed value");
        
        if( b < 1 || b > Math.pow(10, 6) ) throw new IllegalArgumentException("b value violates the allowed value");
        

        List<Integer> priceSummtionOfitemsToBeBought = new ArrayList<>();
        for (int keyboardIndex = 0; keyboardIndex < keyboards.length; keyboardIndex++) {

            for (int driveIndex = 0; driveIndex < drives.length; driveIndex++) {
                
                priceSummtionOfitemsToBeBought.add(keyboards[keyboardIndex] + drives[driveIndex]);
            }

        }

        int affordableTotalPrice = priceSummtionOfitemsToBeBought
                                        .stream()
                                        .filter(totalPrice -> totalPrice <= b)
                                        .max((x, y) -> x - y)
                                        .orElse(-1);

        return affordableTotalPrice;
    }

}
