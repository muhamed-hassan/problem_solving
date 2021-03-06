package com.problem_solving.drawing.application;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.problem_solving.drawing.domain.models.PlottingPoint;

class VerticalLinePlotterTest {

    private static Plotter verticalLinePlotter;

    @BeforeAll
    static void setup() {
        verticalLinePlotter = new VerticalLinePlotter();
    }

    @Test
    void testGetPlottingPoints_WhenUsingVerticalLineCoordinates_ThenReturnListOfPlottedPointsOfVerticalLine() {
        Integer x1 = 6, y1 = 3, x2 = 6, y2 = 4;
        var args = List.of(x1.toString(), y1.toString(), x2.toString(), y2.toString());

        var actualResult = verticalLinePlotter.getPlottedPoints(args);

        //Assert that all plotted points drawn on the same X axis
        assertTrue(actualResult.stream().map(PlottingPoint::getX).allMatch(x -> x == x1.intValue() && x == x2.intValue()));
    }

}
