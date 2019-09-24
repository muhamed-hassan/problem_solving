package com.problem_solving.drawing.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

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
            addAll(generateHorizontalAxisPoints(0, w+1, 0));
        	addAll(generateHorizontalAxisPoints(0, w+1, h+1));
        	addAll(generateVerticalAxisPoints(1, h, 0));
        	addAll(generateVerticalAxisPoints(1, h, w+1));
        }};        
        assertTrue(actualResult.containsAll(expectedResult));
    }
    
    private List<PlottingPoint> generateHorizontalAxisPoints(int startFrom, int endAt, int y) {
    	
    	return IntStream.rangeClosed(startFrom, endAt)
    					.parallel()
    					.mapToObj(x -> new PlottingPoint(x, y, Type.Canvas, DrawingCharacter.CANVAS_W))
    					.collect(Collectors.toList());
    }
    
    private List<PlottingPoint> generateVerticalAxisPoints(int startFrom, int endAt, int x) {
    	
    	return IntStream.range(startFrom, endAt)
		    			.parallel()
		    			.mapToObj(y -> new PlottingPoint(x, y, Type.Canvas, DrawingCharacter.CANVAS_H))
		    			.collect(Collectors.toList());
    }
}
