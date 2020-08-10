package com.problem_solving.drawing.service;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.problem_solving.drawing.models.PlottingPoint;
import com.problem_solving.drawing.models.Point;
import com.problem_solving.drawing.utils.constants.DrawingCharacter;
import com.problem_solving.drawing.utils.constants.Type;

public class RectanglePlotter extends FourSidedPlotter {

    @Override
    public List<PlottingPoint> getPlottingPoints(List<String> args) {
        int x1 = Integer.parseInt(args.get(Point.X1)),
            y1 = Integer.parseInt(args.get(Point.Y1)),
            x2 = Integer.parseInt(args.get(Point.X2)),
            y2 = Integer.parseInt(args.get(Point.Y2));

        CompletableFuture<List<PlottingPoint>> horizontalSideDrawer = CompletableFuture.supplyAsync(() -> {
            var horizontalPlottedPoints = new LinkedList<PlottingPoint>();
            for (var i = x1; i <= x2; i++) {
                horizontalPlottedPoints.add(new PlottingPoint(i, y1, Type.Rectangle, DrawingCharacter.X));
                horizontalPlottedPoints.add(new PlottingPoint(i, y2, Type.Rectangle, DrawingCharacter.X));
            }
            return horizontalPlottedPoints;
        });

        CompletableFuture<List<PlottingPoint>> verticalSideDrawer = CompletableFuture.supplyAsync(() -> {
            var verticalPlottedPoints = new LinkedList<PlottingPoint>();
            for (var i = y1 + 1; i < y2; i++) {
                verticalPlottedPoints.add(new PlottingPoint(x1, i, Type.Rectangle, DrawingCharacter.X));
                verticalPlottedPoints.add(new PlottingPoint(x2, i, Type.Rectangle, DrawingCharacter.X));
            }
            return verticalPlottedPoints;
        });

        return combineAndGetPlottingPoints(horizontalSideDrawer, verticalSideDrawer);
    }

}
