package com.problem_solving.drawing.application;

import static com.problem_solving.drawing.domain.models.Type.Line;

import java.util.ArrayList;
import java.util.List;

import com.problem_solving.drawing.domain.models.PlottingPoint;
import com.problem_solving.drawing.domain.models.Point;

public class VerticalLinePlotter extends LinePlotter {

    @Override
    public List<PlottingPoint> getPlottingPoints(List<String> args) {
        var plottedPoints = new ArrayList<PlottingPoint>();

        int x = Integer.parseInt(args.get(Point.X1)), // x1, or x2 there is no difference
            y1 = Integer.parseInt(args.get(Point.Y1)),
            y2 = Integer.parseInt(args.get(Point.Y2)),
            startingPoint, endingPoint;
        if (y1 < y2) {
            startingPoint = y1;
            endingPoint = y2;
        } else {
            startingPoint = y2;
            endingPoint = y1;
        }

        for (var i = startingPoint; i <= endingPoint; i++) {
            plottedPoints.add(new PlottingPoint(x, i, Line, PlottingPoint.X));
        }

        return plottedPoints;
    }

}
