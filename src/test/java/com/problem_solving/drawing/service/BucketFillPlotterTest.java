package com.problem_solving.drawing.service;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import com.problem_solving.drawing.models.PlottingPoint;
import com.problem_solving.drawing.presentation.Interface;
import com.problem_solving.drawing.utils.constants.Type;

public class BucketFillPlotterTest {
    
    private static FillerPlotter bucketFillPlotter;
    
    private int w = 20, h = 4;
    private String fillingPointX = "10", fillingPointY = "3", fillingChar = "o";
    private PlottingPoint[][] drawnTillNow = null; 
    
    @BeforeClass
    public static void initBucketFillPlotter() {
        
        bucketFillPlotter = new BucketFillPlotter();
    }
    
    @Before
    public void initMatrix() {
        
        drawnTillNow = new PlottingPoint[h + 2][w + 2];
    }
    
    @Test
    public void testGetPlottingPoints_WhenUsingBucketFillingCoordinatesAndAnEmptyCanvas_ThenReturnListOfPlottedPointsThatFillsTheEntireCanvas() {
        
        var plottedPoints = bucketFillPlotter.getPlottingPoints(List.of(fillingPointX, fillingPointY, fillingChar), drawnTillNow);

        var expectedPlottedPoints = constructExpectedPlottedPoints(point -> true);
        assertTrue(expectedPlottedPoints.containsAll(plottedPoints));
    }
        
    @Test
    public void testGetPlottingPoints_WhenUsingBucketFillingCoordinatesAndCanvasContainsHorizontalLine_ThenReturnListOfPlottedPointsThatFillsTheCanvasWithoutDrawingOverTheHorizontalLine() {
        
        var ui = new Interface();        
        Integer x1 = 1, y1 = 2, x2 = 6, y2 = 2;
        var horizontalLinePlotter = new HorizontalLinePlotter();
        var plottedHorizontalLinePoints = horizontalLinePlotter.getPlottingPoints(List.of(x1.toString(), y1.toString(), x2.toString(), y2.toString()));
        ui.plotDrawingPoints(drawnTillNow, plottedHorizontalLinePoints);
        
        var plottedPoints = bucketFillPlotter.getPlottingPoints(List.of(fillingPointX, fillingPointY, fillingChar), drawnTillNow);
        ui.plotDrawingPoints(drawnTillNow, plottedPoints);
        
        var expectedPlottedPoints = constructExpectedPlottedPoints(point -> 
				        													!((point.getX() >= x1.intValue() && point.getX() <= x2.intValue()) &&
				                                                            (point.getY() == y1.intValue() || point.getY() == y2.intValue())));
        assertTrue(expectedPlottedPoints.containsAll(plottedPoints));
    }
    
    @Test
    public void testGetPlottingPoints_WhenUsingBucketFillingCoordinatesAndCanvasContainsVerticalLine_ThenReturnListOfPlottedPointsThatFillsTheCanvasWithoutDrawingOverTheVerticalLine() {
        
        var ui = new Interface();        
        Integer x1 = 6, y1 = 3, x2 = 6, y2 = 4;
        var verticalLinePlotter = new VerticalLinePlotter();
        var plottedVerticalLinePoints = verticalLinePlotter.getPlottingPoints(List.of(x1.toString(), y1.toString(), x2.toString(), y2.toString()));
        ui.plotDrawingPoints(drawnTillNow, plottedVerticalLinePoints);
        
        var plottedPoints = bucketFillPlotter.getPlottingPoints(List.of(fillingPointX, fillingPointY, fillingChar), drawnTillNow);
        ui.plotDrawingPoints(drawnTillNow, plottedPoints);
        
        var expectedPlottedPoints = 
                constructExpectedPlottedPoints(point -> !((point.getX() >= x1.intValue() && point.getX() <= x2.intValue()) &&
                                                            (point.getY() == y1.intValue() || point.getY() == y2.intValue())));
        assertTrue(expectedPlottedPoints.containsAll(plottedPoints));
    }
    
    @Test
    public void testGetPlottingPoints_WhenUsingBucketFillingCoordinatesAndCanvasContainsRectangle_ThenReturnListOfPlottedPointsThatFillsTheCanvasWithoutDrawingOverAndWithinTheRectangleCoordinates() {
        
    	var ui = new Interface();        
        Integer x1 = 16, y1 = 1, x2 = 20, y2 = 3;
        var rectanglePlotter = new RectanglePlotter();
        var plottedVerticalLinePoints = rectanglePlotter.getPlottingPoints(List.of(x1.toString(), y1.toString(), x2.toString(), y2.toString()));
        ui.plotDrawingPoints(drawnTillNow, plottedVerticalLinePoints);
        
        var plottedPoints = bucketFillPlotter.getPlottingPoints(List.of(fillingPointX, fillingPointY, fillingChar), drawnTillNow);        
        ui.plotDrawingPoints(drawnTillNow, plottedPoints);
        
        var expectedPlottedPoints = 
                constructExpectedPlottedPoints(point -> !(point.getX() >= x1.intValue() && point.getX() <=x2.intValue()
                                                            && point.getY() >= y1.intValue() && point.getY() <= y2.intValue()));
        assertTrue(expectedPlottedPoints.containsAll(plottedPoints));
    }
    
    private List<PlottingPoint> constructExpectedPlottedPoints(Predicate<PlottingPoint> predicate) {
        
        return IntStream.rangeClosed(1, w)
                        .boxed()
                        .flatMap(x -> IntStream.rangeClosed(1, h)
                                               .boxed()
                                               .map(y -> new PlottingPoint(x, y, Type.BucketFilling, fillingChar.charAt(0))))
                        .filter(predicate)
                        .collect(Collectors.toList());
    }
    
}
