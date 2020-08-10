package com.problem_solving.drawing.service;

import java.util.ArrayList;
import java.util.List;

import com.problem_solving.drawing.models.PlottingPoint;
import com.problem_solving.drawing.models.Point;
import com.problem_solving.drawing.utils.constants.DrawingCharacter;
import com.problem_solving.drawing.utils.constants.Type;

public class HorizontalLinePlotter extends LinePlotter {

    @Override
    public List<PlottingPoint> getPlottingPoints(List<String> args) {
        var plottedPoints = new ArrayList<PlottingPoint>();

        int y = Integer.parseInt(args.get(Point.Y1)), // y1, or y2 there is no difference
            x1 = Integer.parseInt(args.get(Point.X1)),
            x2 = Integer.parseInt(args.get(Point.X2)),
            startingPoint, endingPoint;
        if (x1 < x2) {
            startingPoint = x1;
            endingPoint = x2;
        } else {
            startingPoint = x2;
            endingPoint = x1;
        }

        for (var i = startingPoint; i <= endingPoint; i++) {
            plottedPoints.add(new PlottingPoint(i, y, Type.Line, DrawingCharacter.X));
        }

        return plottedPoints;
    }

}
