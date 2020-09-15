package com.problem_solving.drawing.infrastructure;

import java.util.List;

import com.problem_solving.drawing.domain.models.PlottingPoint;

public final class MatrixGrid {

    private static PlottingPoint[][] drawnTillNow;

    private static boolean canvasDrawn;

    private MatrixGrid() {}

    public static void initDrawnTillNow(PlottingPoint[][] canvasPoints) {
        if (!canvasDrawn) {
            drawnTillNow = canvasPoints;
            canvasDrawn = true;
        }
    }

    public static void plotDrawnPoints(List<PlottingPoint> points) {
        for (var point : points) {
            drawnTillNow[point.getY()][point.getX()] = point;
        }
    }

    public static PlottingPoint[][] getDrawnTillNow() {
        return drawnTillNow;
    }

    public static boolean isCanvasDrawn() {
        return canvasDrawn;
    }

}
