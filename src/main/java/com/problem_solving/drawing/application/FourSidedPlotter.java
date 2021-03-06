package com.problem_solving.drawing.application;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import com.problem_solving.drawing.domain.models.PlottingPoint;

abstract class FourSidedPlotter extends Plotter {

    List<PlottingPoint> combineAndGetPlottingPoints(CompletableFuture<List<PlottingPoint>> horizontalSideDrawer,
                                                                CompletableFuture<List<PlottingPoint>> verticalSideDrawer) {
        List<PlottingPoint> plottedPoints;
        try {
            plottedPoints = horizontalSideDrawer
                .thenCombine(verticalSideDrawer, (horizontalSidePlottedPoints, verticalSidePlottedPoints) -> {
                    var combinedResult = new ArrayList<PlottingPoint>(horizontalSidePlottedPoints.size() +
                                                                                    verticalSidePlottedPoints.size()){{
                        addAll(horizontalSidePlottedPoints);
                        addAll(verticalSidePlottedPoints);
                    }};
                    return combinedResult;
                })
                .get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        return plottedPoints;
    }

}
