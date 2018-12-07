package com.problem_solving.drawing_program;

import com.problem_solving.drawing_program.models.PlottingPoint;

public final class ApplicationState {

    private final PlottingPoint[][] matrix;

    public ApplicationState(int rows, int columns) {
        
        this.matrix = new PlottingPoint[rows + 2][columns + 2];
    }

    public PlottingPoint[][] getMatrix() {
        
        return matrix;
    }

}
