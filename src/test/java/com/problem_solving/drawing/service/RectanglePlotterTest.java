package com.problem_solving.drawing.service;

import java.util.List;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

import com.problem_solving.drawing.models.PlottingPoint;
import com.problem_solving.drawing.utils.constants.DrawingCharacter;
import com.problem_solving.drawing.utils.constants.Type;

public class RectanglePlotterTest extends FourSidedPlotterTest {
    
    private FourSidedPlotter rectanglePlotter;
    
    @Before
    public void setUp() {
        
        rectanglePlotter = new RectanglePlotter();
    }

    @Test
    public void testGetPlottingPoints_WhenUsingRectangleCoordinates_ThenReturnListOfPlottedPointsOfRectangle() {
        
        Integer x1 = 16, y1 = 1, x2 = 20, y2 = 3;
        var args = List.of(x1.toString(), y1.toString(), x2.toString(), y2.toString()); 
        
        var actualResult = rectanglePlotter.getPlottingPoints(args);
        
        var expectedResult = new ArrayList<PlottingPoint>(){{
            addAll(generateHorizontalAxisPoints(x1, x2, y1, Type.Rectangle, DrawingCharacter.X));
        	addAll(generateHorizontalAxisPoints(x1, x2, y2, Type.Rectangle, DrawingCharacter.X));
        	addAll(generateVerticalAxisPoints(y1+1, y2, x1, Type.Rectangle, DrawingCharacter.X));
        	addAll(generateVerticalAxisPoints(y1+1, y2, x2, Type.Rectangle, DrawingCharacter.X));
        }}; 
        assertTrue(actualResult.containsAll(expectedResult)); //Assert that all plotted points represent a rectangle according to the given coordinates
    }
}
