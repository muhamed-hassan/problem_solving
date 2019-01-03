package com.problem_solving.drawing.service;

import java.util.List;

import com.problem_solving.drawing.utils.constants.DrawingCharacter;
import com.problem_solving.drawing.utils.constants.Type;
import com.problem_solving.drawing.models.PlottingPoint;

public class VerticalLinePlotter extends LinePlotter {

    @Override
    public void plot(List<String> args, PlottingPoint[][] matrix) {

        int x = Integer.parseInt(args.get(0)); // or 2 -> represents x1, or x2

        int y1 = Integer.parseInt(args.get(1)),
            y2 = Integer.parseInt(args.get(3));

        int startingPoint, endingPoint;
        if (y1 < y2) {
            startingPoint = y1;
            endingPoint = y2;
        } else {
            startingPoint = y2;
            endingPoint = y1;
        }

        for (int i = startingPoint; i <= endingPoint; i++) {
            matrix[i][x] = new PlottingPoint(i, x, Type.Line, DrawingCharacter.X);
        }

    }

}
