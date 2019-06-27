package com.problem_solving.drawing.service;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import com.problem_solving.drawing.models.PlottingPoint;

public class HorizontalLinePlotterTest {
    
    private Plotter horizontalLinePlotter;
    
    @Before
    public void setUp() {
        
        horizontalLinePlotter = new HorizontalLinePlotter();
    }

    @Test
    public void testGetPlottingPoints_WhenUsingHorizontalLineCoordinates_ThenReturnListOfPlottedPointsOfHorizontalLine() {
    
        List<String> args = Arrays.asList("1", "2", "6", "2"); //X1:1, Y1:2, X2:6, Y2:2
        
        List<PlottingPoint> actualResult = horizontalLinePlotter.getPlottingPoints(args);

        //Assert that all plotted points drawn on the same Y axis
        assertTrue(actualResult.stream().map(PlottingPoint::getY).allMatch(y -> y == 2));
    }
    
}
