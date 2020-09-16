package com.problem_solving.drawing.application;

import static com.problem_solving.drawing.domain.models.Type.LINE;

import java.util.ArrayList;
import java.util.List;

import com.problem_solving.drawing.domain.models.PlottingPoint;
import com.problem_solving.drawing.domain.models.Point;

public class HorizontalLinePlotter extends LinePlotter {

    @Override
    public List<PlottingPoint> getPlottedPoints(List<String> args) {
        var y = Integer.parseInt(args.get(Point.Y1)); // y1, or y2 there is no difference
        var x1 = Integer.parseInt(args.get(Point.X1));
        var x2 = Integer.parseInt(args.get(Point.X2));
        int startingPoint;
        int endingPoint;
        if (x1 < x2) {
            startingPoint = x1;
            endingPoint = x2;
        } else {
            startingPoint = x2;
            endingPoint = x1;
        }

        var plottedPoints = new ArrayList<PlottingPoint>(endingPoint - startingPoint + 1);
        for (var i = startingPoint; i <= endingPoint; i++) {
            plottedPoints.add(new PlottingPoint(i, y, LINE, PlottingPoint.X));
        }

        return plottedPoints;
    }

}
