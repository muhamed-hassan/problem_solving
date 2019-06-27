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
        
        List<String> args = Arrays.asList("6", "3", "6", "4"); //X1:6, Y1:3, X2:6, Y2:4
        
        List<PlottingPoint> actualResult = verticalLinePlotter.getPlottingPoints(args);

        //Assert that all plotted points drawn on the same X axis
        assertTrue(actualResult.stream().map(PlottingPoint::getX).allMatch(x -> x == 6));
    }
    
}
