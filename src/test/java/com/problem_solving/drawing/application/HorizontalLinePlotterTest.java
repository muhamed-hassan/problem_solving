package com.problem_solving.drawing.application;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.problem_solving.drawing.domain.models.PlottingPoint;

public class HorizontalLinePlotterTest {

    private static Plotter horizontalLinePlotter;

    @BeforeAll
    public static void setup() {
        horizontalLinePlotter = new HorizontalLinePlotter();
    }

    @Test
    public void testGetPlottingPoints_WhenUsingHorizontalLineCoordinates_ThenReturnListOfPlottedPointsOfHorizontalLine() {
        Integer x1 = 1, y1 = 2, x2 = 6, y2 = 2;
        var args = List.of(x1.toString(), y1.toString(), x2.toString(), y2.toString());

        var actualResult = horizontalLinePlotter.getPlottedPoints(args);

        //Assert that all plotted points drawn on the same Y axis
        assertTrue(actualResult.stream().map(PlottingPoint::getY).allMatch(y -> y == y1.intValue() && y == y2.intValue()));
    }

}
