package com.problem_solving.drawing.presentation;

import java.util.Scanner;
import java.util.List;

import com.problem_solving.drawing.models.PlottingPoint;

public class Interface {

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
        
        for(PlottingPoint point : points) {
            
            matrix[point.getY()][point.getX()] = point; 
        }
    }
    
    public void drawMatrix(PlottingPoint[][] matrix, List<PlottingPoint> points) {
        
        for(PlottingPoint[] line : matrix) {
            
            for(PlottingPoint point : line) {
            
                System.out.print(point != null ? point.getCharacterToBeDrawn() : " ");
            }
            
            System.out.println();
        }
    }

}
