package com.problem_solving.drawing.application;

import static com.problem_solving.drawing.domain.models.Type.CANVAS;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.problem_solving.drawing.domain.models.PlottingPoint;

public class CanvasPlotter extends FourSidedPlotter {

    @Override
    public List<PlottingPoint> getPlottedPoints(List<String> args) {
        var w = Integer.parseInt(args.get(0));
        var h = Integer.parseInt(args.get(1));

        CompletableFuture<List<PlottingPoint>> horizontalSideDrawer = CompletableFuture.supplyAsync(() -> {
            var horizontalPlottedPoints = new ArrayList<PlottingPoint>((w + 2) * 2);
            for (var i = 0; i < w + 2; i++) {
                horizontalPlottedPoints.add(new PlottingPoint(i, 0, CANVAS, PlottingPoint.CANVAS_W));
                horizontalPlottedPoints.add(new PlottingPoint(i, h + 1, CANVAS, PlottingPoint.CANVAS_W));
            }
            return horizontalPlottedPoints;
        });

        CompletableFuture<List<PlottingPoint>> verticalSideDrawer = CompletableFuture.supplyAsync(() -> {
            var verticalPlottedPoints = new ArrayList<PlottingPoint>(h * 2);
            for (var i = 1; i < h + 1; i++) {
                verticalPlottedPoints.add(new PlottingPoint(0, i, CANVAS, PlottingPoint.CANVAS_H));
                verticalPlottedPoints.add(new PlottingPoint(w + 1, i, CANVAS, PlottingPoint.CANVAS_H));
            }
            return verticalPlottedPoints;
        });

        return combineAndGetPlottingPoints(horizontalSideDrawer, verticalSideDrawer);
    }

}
