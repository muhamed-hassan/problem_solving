package com.problem_solving.drawing.service;

import static com.problem_solving.drawing.domain.models.Type.Rectangle;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.problem_solving.drawing.domain.models.PlottingPoint;

public class RectanglePlotterTest extends FourSidedPlotterTest {

    private static FourSidedPlotter rectanglePlotter;

    @BeforeAll
    public static void setup() {
        rectanglePlotter = new RectanglePlotter();
    }

    @Test
    public void testGetPlottingPoints_WhenUsingRectangleCoordinates_ThenReturnListOfPlottedPointsOfRectangle() {
        Integer x1 = 16, y1 = 1, x2 = 20, y2 = 3;
        var args = List.of(x1.toString(), y1.toString(), x2.toString(), y2.toString());

        var actualResult = rectanglePlotter.getPlottingPoints(args);

        var expectedResult = new ArrayList<PlottingPoint>() {{
            addAll(generateHorizontalAxisPoints(x1, x2, y1, Rectangle, PlottingPoint.X));
            addAll(generateHorizontalAxisPoints(x1, x2, y2, Rectangle, PlottingPoint.X));
            addAll(generateVerticalAxisPoints(y1 + 1, y2, x1, Rectangle, PlottingPoint.X));
            addAll(generateVerticalAxisPoints(y1 + 1, y2, x2, Rectangle, PlottingPoint.X));
        }};
        //Assert that all plotted points represent a rectangle according to the given coordinates
        assertTrue(actualResult.containsAll(expectedResult));
    }

}
