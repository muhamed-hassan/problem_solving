package com.problem_solving.drawing.application;

import static com.problem_solving.drawing.domain.models.Type.CANVAS;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.problem_solving.drawing.domain.models.PlottingPoint;

class CanvasPlotterTest extends FourSidedPlotterTest {

    private static FourSidedPlotter canvasPlotter;

    @BeforeAll
    static void setup() {
        canvasPlotter = new CanvasPlotter();
    }

    @Test
    void testGetPlottingPoints_WhenUsingCanvasCoordinates_ThenReturnListOfPlottedPointsOfCanvas() {
        Integer w = 20, h = 4;
        var args = List.of(w.toString(), h.toString());
        var expectedResult = new ArrayList<PlottingPoint>() {{
            addAll(generateHorizontalAxisPoints(0, w + 1, 0, CANVAS, PlottingPoint.CANVAS_W));
            addAll(generateHorizontalAxisPoints(0, w + 1, h + 1, CANVAS, PlottingPoint.CANVAS_W));
            addAll(generateVerticalAxisPoints(1, h, 0, CANVAS, PlottingPoint.CANVAS_H));
            addAll(generateVerticalAxisPoints(1, h, w + 1, CANVAS, PlottingPoint.CANVAS_H));
        }};

        var actualResult = canvasPlotter.getPlottedPoints(args);

        assertTrue(actualResult.containsAll(expectedResult));
    }

}
