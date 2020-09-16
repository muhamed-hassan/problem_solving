package com.problem_solving.drawing.application;

import static com.problem_solving.drawing.domain.models.Type.RECTANGLE;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.problem_solving.drawing.domain.models.PlottingPoint;
import com.problem_solving.drawing.domain.models.Point;

public class RectanglePlotter extends FourSidedPlotter {

    @Override
    public List<PlottingPoint> getPlottedPoints(List<String> args) {
        var x1 = Integer.parseInt(args.get(Point.X1));
        var y1 = Integer.parseInt(args.get(Point.Y1));
        var x2 = Integer.parseInt(args.get(Point.X2));
        var y2 = Integer.parseInt(args.get(Point.Y2));

        CompletableFuture<List<PlottingPoint>> horizontalSideDrawer = CompletableFuture.supplyAsync(() -> {
            var horizontalPlottedPoints = new ArrayList<PlottingPoint>((x2 - x1 + 1) * 2);
            for (var i = x1; i <= x2; i++) {
                horizontalPlottedPoints.add(new PlottingPoint(i, y1, RECTANGLE, PlottingPoint.X));
                horizontalPlottedPoints.add(new PlottingPoint(i, y2, RECTANGLE, PlottingPoint.X));
            }
            return horizontalPlottedPoints;
        });

        CompletableFuture<List<PlottingPoint>> verticalSideDrawer = CompletableFuture.supplyAsync(() -> {
            var verticalPlottedPoints = new ArrayList<PlottingPoint>((y2 - y1 + 1) * 2);
            for (var i = y1 + 1; i < y2; i++) {
                verticalPlottedPoints.add(new PlottingPoint(x1, i, RECTANGLE, PlottingPoint.X));
                verticalPlottedPoints.add(new PlottingPoint(x2, i, RECTANGLE, PlottingPoint.X));
            }
            return verticalPlottedPoints;
        });

        return combineAndGetPlottingPoints(horizontalSideDrawer, verticalSideDrawer);
    }

}
