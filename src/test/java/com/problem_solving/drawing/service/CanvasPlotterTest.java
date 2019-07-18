package com.problem_solving.drawing.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import com.problem_solving.drawing.models.PlottingPoint;
import com.problem_solving.drawing.utils.constants.DrawingCharacter;
import com.problem_solving.drawing.utils.constants.Type;

public class CanvasPlotterTest {
    
    private Plotter canvasPlotter;
    
    @Before
    public void setUp() {
        
        canvasPlotter = new CanvasPlotter();
    }

    @Test
    public void testGetPlottingPoints_WhenUsingCanvasCoordinates_ThenReturnListOfPlottedPointsOfCanvas() {
        
        Integer w = 20, h = 4;
        var args = List.of(w.toString(), h.toString());
        
        var actualResult = canvasPlotter.getPlottingPoints(args);
        
        var expectedResult = new ArrayList<PlottingPoint>(){{
            addAll(IntStream.rangeClosed(0, w+1).mapToObj(x -> new PlottingPoint(x, 0, Type.Canvas, DrawingCharacter.CANVAS_W)).collect(Collectors.toList()));
            addAll(IntStream.rangeClosed(0, w+1).mapToObj(x -> new PlottingPoint(x, h+1, Type.Canvas, DrawingCharacter.CANVAS_W)).collect(Collectors.toList()));
            addAll(IntStream.rangeClosed(1, h).mapToObj(y -> new PlottingPoint(0, y, Type.Canvas, DrawingCharacter.CANVAS_H)).collect(Collectors.toList()));
            addAll(IntStream.rangeClosed(1, h).mapToObj(y -> new PlottingPoint(w+1, y, Type.Canvas, DrawingCharacter.CANVAS_H)).collect(Collectors.toList()));
        }};        
        assertTrue(expectedResult.containsAll(actualResult));
    }
    
}
