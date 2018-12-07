package com.problem_solving.drawing_program.presentation;

import java.util.Scanner;

import com.problem_solving.drawing_program.models.PlottingPoint;

public class Interface {

    private Scanner scanner = new Scanner(System.in);

    public String readCommand() {
        return scanner.nextLine();
    }

    public void releaseUiResources() {
        if (scanner != null) {
            scanner.close();
        }
    }

    public void displayCommandPromptMsg() {
        System.out.print("enter command: ");
    }

    public void drawMatrix(PlottingPoint[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                PlottingPoint currentPoint = matrix[row][column];
                System.out.print(currentPoint != null ? currentPoint.getCharacterToBeDrawn() : " ");
            }
            System.out.println();
        }
    }

}
