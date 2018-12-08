package com.problem_solving.drawing_program.presentation;

import java.util.Scanner;
import java.util.stream.Stream;

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
        Stream.of(matrix)
              .forEach(row -> {
                  Stream.of(row)
                        .map(element -> element != null ? element.getCharacterToBeDrawn() : " ")
                        .forEach(System.out::print);
                  
                  System.out.println();
              });
    }

}
