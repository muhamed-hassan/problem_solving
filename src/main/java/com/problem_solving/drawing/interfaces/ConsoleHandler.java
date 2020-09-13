package com.problem_solving.drawing.interfaces;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.problem_solving.drawing.domain.models.PlottingPoint;

public class ConsoleHandler {

    private final Scanner scanner = new Scanner(System.in);

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

    public void plotDrawingPoints(PlottingPoint[][] matrix, List<PlottingPoint> points) {
        for (var point : points) {
            matrix[point.getY()][point.getX()] = point;
        }
    }

    public void drawMatrix(PlottingPoint[][] matrix) {
        for (var line : matrix) {
            for (var point : line) {
                System.out.print(point != null ? point.getCharacterToBeDrawn() : " ");
            }
            System.out.println();
        }
    }

    public List<String> extractArgs(String commandLine) {
        return Stream.of(commandLine.substring(1).split("\\s"))
                        .filter(arg -> !arg.isEmpty())
                        .collect(Collectors.toList());
    }

    public char extractCommand(String commandLine) {
        return commandLine.charAt(0);
    }

}
