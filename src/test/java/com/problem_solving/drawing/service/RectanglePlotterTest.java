package com.problem_solving.drawing.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.ArrayList;

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
        
        Integer x1 = 16, y1 = 1, x2 = 20, y2 = 3;
        List<String> args = Arrays.asList(x1.toString(), y1.toString(), x2.toString(), y2.toString()); 
        
        List<PlottingPoint> actualResult = rectanglePlotter.getPlottingPoints(args);
        
        List<PlottingPoint> expectedResult = new ArrayList<PlottingPoint>(){{
            addAll(IntStream.rangeClosed(x1, x2).mapToObj(x -> new PlottingPoint(x, y1, Type.Rectangle, DrawingCharacter.X)).collect(Collectors.toList()));
            addAll(IntStream.rangeClosed(x1, x2).mapToObj(x -> new PlottingPoint(x, y2, Type.Rectangle, DrawingCharacter.X)).collect(Collectors.toList()));
            addAll(IntStream.range(y1+1, y2).mapToObj(y -> new PlottingPoint(x1, y, Type.Rectangle, DrawingCharacter.X)).collect(Collectors.toList()));
            addAll(IntStream.range(y1+1, y2).mapToObj(y -> new PlottingPoint(x2, y, Type.Rectangle, DrawingCharacter.X)).collect(Collectors.toList()));
        }}; 
        assertTrue(expectedResult.containsAll(actualResult)); //Assert that all plotted points represent a rectangle according to the given coordinates
    }
    
}
