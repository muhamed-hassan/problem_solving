package com.problem_solving.drawing.service;

import java.util.List;

import com.problem_solving.drawing.utils.constants.DrawingCharacter;
import com.problem_solving.drawing.utils.constants.Type;
import com.problem_solving.drawing.models.PlottingPoint;

public class HorizontalLinePlotter extends LinePlotter {

    @Override
    public void plot(List<String> args, PlottingPoint[][] matrix) {

        int y = Integer.parseInt(args.get(1)); // or 3 -> represents y1, or y2

        int x1 = Integer.parseInt(args.get(0)),
            x2 = Integer.parseInt(args.get(2));

        int startingPoint, endingPoint;
        if (x1 < x2) {
            startingPoint = x1;
            endingPoint = x2;
        } else {
            startingPoint = x2;
            endingPoint = x1;
        }

        for (int i = startingPoint; i <= endingPoint; i++) {
            matrix[y][i] = new PlottingPoint(y, i, Type.Line, DrawingCharacter.X);
        }

    }

}
