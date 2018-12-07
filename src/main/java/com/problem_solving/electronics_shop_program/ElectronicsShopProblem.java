package com.problem_solving.electronics_shop_program;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ElectronicsShopProblem {

    /*
     * Complete the getMoneySpent function below.
     */
    static int getMoneySpent(int[] keyboards, int[] drives, int b) {

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

    public static void main(String[] args) throws IOException {
        
        Scanner scanner = new Scanner(System.in);

        String[] bnm = scanner.nextLine().split(" ");

        int b = Integer.parseInt(bnm[0]),
            n = Integer.parseInt(bnm[1]),
            m = Integer.parseInt(bnm[2]);

        int[] keyboards = new int[n];

        
        String[] keyboardsItems = scanner.nextLine().split(" ");

        for (int keyboardsItr = 0; keyboardsItr < n; keyboardsItr++) {
            int keyboardsItem = Integer.parseInt(keyboardsItems[keyboardsItr]);
            keyboards[keyboardsItr] = keyboardsItem;
        }

        int[] drives = new int[m];
        

        String[] drivesItems = scanner.nextLine().split(" ");

        for (int drivesItr = 0; drivesItr < m; drivesItr++) {
            int drivesItem = Integer.parseInt(drivesItems[drivesItr]);
            drives[drivesItr] = drivesItem;
        }

        /*
         * The maximum amount of money she can spend on a keyboard and USB drive, or -1 if she can't purchase both items
         */
        int moneySpent = getMoneySpent(keyboards, drives, b);
        System.out.println("Money to spend: " + moneySpent);

        scanner.close();
    }

}
