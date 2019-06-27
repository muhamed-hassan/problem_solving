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
    
        Integer x1 = 1, y1 = 2, x2 = 6, y2 = 2;
        List<String> args = Arrays.asList(x1.toString(), y1.toString(), x2.toString(), y2.toString()); 
        
        List<PlottingPoint> actualResult = horizontalLinePlotter.getPlottingPoints(args);

        //Assert that all plotted points drawn on the same Y axis
        assertTrue(actualResult.stream().map(PlottingPoint::getY).allMatch(y -> y == y1.intValue() && y == y2.intValue()));
    }
    
}
