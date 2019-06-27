package com.problem_solving.drawing.service;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import com.problem_solving.drawing.models.PlottingPoint;
import com.problem_solving.drawing.utils.constants.DrawingCharacter;
import com.problem_solving.drawing.utils.constants.Type;

public class RectanglePlotterTest {
    
    private Plotter rectanglePlotter;
    
    @Before
    public void setUp() {
        
        rectanglePlotter = new RectanglePlotter();
    }

    @Test
    public void testGetPlottingPoints_WhenUsingRectangleCoordinates_ThenReturnListOfPlottedPointsOfRectangle() {
        
        List<String> args = Arrays.asList("16", "1", "20", "3"); //X1:16, Y1:1, X2:20, Y2:3
        
        List<PlottingPoint> actualResult = rectanglePlotter.getPlottingPoints(args);
        
        List<PlottingPoint> expectedResult = Arrays.asList(
                                                    new PlottingPoint(16, 1, Type.Rectangle, DrawingCharacter.X),
                                                    new PlottingPoint(17, 1, Type.Rectangle, DrawingCharacter.X),
                                                    new PlottingPoint(18, 1, Type.Rectangle, DrawingCharacter.X),
                                                    new PlottingPoint(19, 1, Type.Rectangle, DrawingCharacter.X),
                                                    new PlottingPoint(20, 1, Type.Rectangle, DrawingCharacter.X),
                                                    new PlottingPoint(16, 3, Type.Rectangle, DrawingCharacter.X),
                                                    new PlottingPoint(17, 3, Type.Rectangle, DrawingCharacter.X),
                                                    new PlottingPoint(18, 3, Type.Rectangle, DrawingCharacter.X),
                                                    new PlottingPoint(19, 3, Type.Rectangle, DrawingCharacter.X),
                                                    new PlottingPoint(20, 3, Type.Rectangle, DrawingCharacter.X),
                                                    new PlottingPoint(16, 2, Type.Rectangle, DrawingCharacter.X),
                                                    new PlottingPoint(20, 2, Type.Rectangle, DrawingCharacter.X)
                                            );                
        assertTrue(expectedResult.containsAll(actualResult)); //Assert that all plotted points represent a rectangle according to the given coordinates
    }
    
}
