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
        
        List<PlottingPoint> plottedPoints = bucketFillPlotter.getPlottingPoints(
                Arrays.asList(fillingPointX, fillingPointY, fillingChar), drawnTillNow);

        List<PlottingPoint> expectedPlottedPoints = constructExpectedPlottedPoints(point -> true);
        assertTrue(expectedPlottedPoints.containsAll(plottedPoints));
    }
        
    @Test
    public void testGetPlottingPoints_WhenUsingBucketFillingCoordinatesAndCanvasContainsHorizontalLine_ThenReturnListOfPlottedPointsThatFillsTheCanvasWithoutDrawingOverTheHorizontalLine() {
        
        Interface ui = new Interface();        
        Integer x1 = 1, y1 = 2, x2 = 6, y2 = 2;
        Plotter horizontalLinePlotter = new HorizontalLinePlotter();
        List<PlottingPoint> plottedHorizontalLinePoints = horizontalLinePlotter.getPlottingPoints(
                        Arrays.asList(x1.toString(), y1.toString(), x2.toString(), y2.toString()));
        ui.plotDrawingPoints(drawnTillNow, plottedHorizontalLinePoints);
        
        List<PlottingPoint> plottedPoints = bucketFillPlotter.getPlottingPoints(
                Arrays.asList(fillingPointX, fillingPointY, fillingChar), drawnTillNow);
        ui.plotDrawingPoints(drawnTillNow, plottedPoints);
        
        List<PlottingPoint> expectedPlottedPoints = 
                constructExpectedPlottedPoints(point -> !((point.getX() >= x1.intValue() && point.getX() <= x2.intValue()) &&
                                                            (point.getY() == y1.intValue() || point.getY() == y2.intValue())));
        assertTrue(expectedPlottedPoints.containsAll(plottedPoints));
    }
    
    @Test
    public void testGetPlottingPoints_WhenUsingBucketFillingCoordinatesAndCanvasContainsVerticalLine_ThenReturnListOfPlottedPointsThatFillsTheCanvasWithoutDrawingOverTheVerticalLine() {
        
        Interface ui = new Interface();        
        Integer x1 = 6, y1 = 3, x2 = 6, y2 = 4;
        Plotter verticalLinePlotter = new VerticalLinePlotter();
        List<PlottingPoint> plottedVerticalLinePoints = verticalLinePlotter.getPlottingPoints(
                        Arrays.asList(x1.toString(), y1.toString(), x2.toString(), y2.toString()));
        ui.plotDrawingPoints(drawnTillNow, plottedVerticalLinePoints);
        
        List<PlottingPoint> plottedPoints = bucketFillPlotter.getPlottingPoints(
                Arrays.asList(fillingPointX, fillingPointY, fillingChar), drawnTillNow);
        ui.plotDrawingPoints(drawnTillNow, plottedPoints);
        
        List<PlottingPoint> expectedPlottedPoints = 
                constructExpectedPlottedPoints(point -> !((point.getX() >= x1.intValue() && point.getX() <= x2.intValue()) &&
                                                            (point.getY() == y1.intValue() || point.getY() == y2.intValue())));
        assertTrue(expectedPlottedPoints.containsAll(plottedPoints));
    }
    
    @Test
    public void testGetPlottingPoints_WhenUsingBucketFillingCoordinatesAndCanvasContainsRectangle_ThenReturnListOfPlottedPointsThatFillsTheCanvasWithoutDrawingOverAndWithinTheRectangleCoordinates() {
        
        Interface ui = new Interface();        
        Integer x1 = 16, y1 = 1, x2 = 20, y2 = 3;
        Plotter rectanglePlotter = new RectanglePlotter();
        List<PlottingPoint> plottedVerticalLinePoints = rectanglePlotter.getPlottingPoints(
                        Arrays.asList(x1.toString(), y1.toString(), x2.toString(), y2.toString()));
        ui.plotDrawingPoints(drawnTillNow, plottedVerticalLinePoints);
        
        List<PlottingPoint> plottedPoints = bucketFillPlotter.getPlottingPoints(
                Arrays.asList(fillingPointX, fillingPointY, fillingChar), drawnTillNow);        
        ui.plotDrawingPoints(drawnTillNow, plottedPoints);
        
        List<PlottingPoint> expectedPlottedPoints = 
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
