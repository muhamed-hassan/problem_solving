package com.problem_solving.drawing.service;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import com.problem_solving.drawing.models.PlottingPoint;

public class VerticalLinePlotterTest {
    
    private Plotter verticalLinePlotter;
    
    @Before
    public void setUp() {
        
        verticalLinePlotter = new VerticalLinePlotter();
    }

    @Test
    public void testGetPlottingPoints_WhenUsingVerticalLineCoordinates_ThenReturnListOfPlottedPointsOfVerticalLine() {
        
        Integer x1 = 6, y1 = 3, x2 = 6, y2 = 4;
        List<String> args = Arrays.asList(x1.toString(), y1.toString(), x2.toString(), y2.toString()); 
        
        List<PlottingPoint> actualResult = verticalLinePlotter.getPlottingPoints(args);

        //Assert that all plotted points drawn on the same X axis
        assertTrue(actualResult.stream().map(PlottingPoint::getX).allMatch(x -> x == x1.intValue() && x == x2.intValue()));
    }
    
}
