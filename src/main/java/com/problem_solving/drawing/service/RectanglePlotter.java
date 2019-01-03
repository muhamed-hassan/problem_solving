package com.problem_solving.drawing.service;

import java.util.List;

import com.problem_solving.drawing.utils.constants.DrawingCharacter;
import com.problem_solving.drawing.utils.constants.Type;
import com.problem_solving.drawing.models.PlottingPoint;

public class RectanglePlotter extends Plotter {

    @Override
    public void plot(List<String> args, PlottingPoint[][] matrix) {

        int x1 = Integer.parseInt(args.get(0));
        int y1 = Integer.parseInt(args.get(1));

        int x2 = Integer.parseInt(args.get(2));
        int y2 = Integer.parseInt(args.get(3));

        for (int i = x1; i <= x2; i++) {
            matrix[y1][i] = new PlottingPoint(y1, i, Type.Rectangle, DrawingCharacter.X);
            matrix[y2][i] = new PlottingPoint(y2, i, Type.Rectangle, DrawingCharacter.X);
        }

        for (int i = y1 + 1; i < y2; i++) {
            matrix[i][x1] = new PlottingPoint(i, x1, Type.Rectangle, DrawingCharacter.X);
            matrix[i][x2] = new PlottingPoint(i, x2, Type.Rectangle, DrawingCharacter.X);
        }

    }

}
