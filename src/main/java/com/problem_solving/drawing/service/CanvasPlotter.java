package com.problem_solving.drawing.service;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.problem_solving.drawing.models.PlottingPoint;
import com.problem_solving.drawing.utils.constants.DrawingCharacter;
import com.problem_solving.drawing.utils.constants.Type;

public class CanvasPlotter extends FourSidedPlotter {

    @Override
    public List<PlottingPoint> getPlottingPoints(List<String> args) {
        int w = Integer.parseInt(args.get(0)),
            h = Integer.parseInt(args.get(1));

        CompletableFuture<List<PlottingPoint>> horizontalSideDrawer = CompletableFuture.supplyAsync(() -> {
            var horizontalPlottedPoints = new LinkedList<PlottingPoint>();
            for (var i = 0; i < w + 2; i++) {
                horizontalPlottedPoints.add(new PlottingPoint(i, 0, Type.Canvas, DrawingCharacter.CANVAS_W));
                horizontalPlottedPoints.add(new PlottingPoint(i, h + 1, Type.Canvas, DrawingCharacter.CANVAS_W));
            }
            return horizontalPlottedPoints;
        });

        CompletableFuture<List<PlottingPoint>> verticalSideDrawer = CompletableFuture.supplyAsync(() -> {
            var verticalPlottedPoints = new LinkedList<PlottingPoint>();
            for (var i = 1; i < h + 1; i++) {
                verticalPlottedPoints.add(new PlottingPoint(0, i, Type.Canvas, DrawingCharacter.CANVAS_H));
                verticalPlottedPoints.add(new PlottingPoint(w + 1, i, Type.Canvas, DrawingCharacter.CANVAS_H));
            }
            return verticalPlottedPoints;
        });

        return combineAndGetPlottingPoints(horizontalSideDrawer, verticalSideDrawer);
    }

}
