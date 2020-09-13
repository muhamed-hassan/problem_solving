package com.problem_solving.drawing.service;

import static com.problem_solving.drawing.domain.models.Type.Canvas;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.problem_solving.drawing.domain.models.PlottingPoint;

public class CanvasPlotterTest extends FourSidedPlotterTest {

    private static FourSidedPlotter canvasPlotter;

    @BeforeAll
    public static void setup() {
        canvasPlotter = new CanvasPlotter();
    }

    @Test
    public void testGetPlottingPoints_WhenUsingCanvasCoordinates_ThenReturnListOfPlottedPointsOfCanvas() {
        Integer w = 20, h = 4;
        var args = List.of(w.toString(), h.toString());

        var actualResult = canvasPlotter.getPlottingPoints(args);

        var expectedResult = new ArrayList<PlottingPoint>() {{
            addAll(generateHorizontalAxisPoints(0, w + 1, 0, Canvas, PlottingPoint.CANVAS_W));
            addAll(generateHorizontalAxisPoints(0, w + 1, h + 1, Canvas, PlottingPoint.CANVAS_W));
            addAll(generateVerticalAxisPoints(1, h, 0, Canvas, PlottingPoint.CANVAS_H));
            addAll(generateVerticalAxisPoints(1, h, w + 1, Canvas, PlottingPoint.CANVAS_H));
        }};
        assertTrue(actualResult.containsAll(expectedResult));
    }

}
