package com.problem_solving.drawing.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import com.problem_solving.drawing.domain.models.PlottingPoint;

public abstract class FourSidedPlotter extends Plotter {

    public abstract List<PlottingPoint> getPlottingPoints(List<String> args);

    protected List<PlottingPoint> combineAndGetPlottingPoints(CompletableFuture<List<PlottingPoint>> horizontalSideDrawer,
                                                                CompletableFuture<List<PlottingPoint>> verticalSideDrawer) {
        List<PlottingPoint> plottedPoints;
        try {
            plottedPoints = horizontalSideDrawer.thenCombine(verticalSideDrawer, (horizontalSidePlottedPoints, verticalSidePlottedPoints) -> {
                                                                                    var combinedResult = new ArrayList<PlottingPoint>();
                                                                                    combinedResult.addAll(horizontalSidePlottedPoints);
                                                                                    combinedResult.addAll(verticalSidePlottedPoints);
                                                                                    return combinedResult;
                                                                                })
                                                    .get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        return plottedPoints;
    }

}
