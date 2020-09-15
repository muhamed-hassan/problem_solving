package com.problem_solving.drawing.application;

import static com.problem_solving.drawing.domain.models.Type.Rectangle;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.problem_solving.drawing.domain.models.PlottingPoint;
import com.problem_solving.drawing.domain.models.Point;

public class RectanglePlotter extends FourSidedPlotter {

    @Override
    public List<PlottingPoint> getPlottedPoints(List<String> args) {
        int x1 = Integer.parseInt(args.get(Point.X1)),
            y1 = Integer.parseInt(args.get(Point.Y1)),
            x2 = Integer.parseInt(args.get(Point.X2)),
            y2 = Integer.parseInt(args.get(Point.Y2));

        CompletableFuture<List<PlottingPoint>> horizontalSideDrawer = CompletableFuture.supplyAsync(() -> {
            var horizontalPlottedPoints = new LinkedList<PlottingPoint>();
            for (var i = x1; i <= x2; i++) {
                horizontalPlottedPoints.add(new PlottingPoint(i, y1, Rectangle, PlottingPoint.X));
                horizontalPlottedPoints.add(new PlottingPoint(i, y2, Rectangle, PlottingPoint.X));
            }
            return horizontalPlottedPoints;
        });

        CompletableFuture<List<PlottingPoint>> verticalSideDrawer = CompletableFuture.supplyAsync(() -> {
            var verticalPlottedPoints = new LinkedList<PlottingPoint>();
            for (var i = y1 + 1; i < y2; i++) {
                verticalPlottedPoints.add(new PlottingPoint(x1, i, Rectangle, PlottingPoint.X));
                verticalPlottedPoints.add(new PlottingPoint(x2, i, Rectangle, PlottingPoint.X));
            }
            return verticalPlottedPoints;
        });

        return combineAndGetPlottingPoints(horizontalSideDrawer, verticalSideDrawer);
    }

}
