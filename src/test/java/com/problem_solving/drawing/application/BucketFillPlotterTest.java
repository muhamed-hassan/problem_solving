package com.problem_solving.drawing.application;

import static com.problem_solving.drawing.domain.models.Type.BUCKET_FILLING;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.problem_solving.drawing.domain.models.PlottingPoint;
import com.problem_solving.drawing.helpers.Coordinates;
import com.problem_solving.drawing.infrastructure.MatrixGrid;

class BucketFillPlotterTest {

    private static Plotter bucketFillPlotter;

    private static int w = 20, h = 4;

    private static String fillingPointX = "10", fillingPointY = "3", fillingChar = "o";

    @BeforeAll
    static void initBucketFillPlotter() {
        bucketFillPlotter = new BucketFillPlotter();
    }

    @BeforeEach
    void initMatrix() {
        MatrixGrid.initDrawnTillNow(new PlottingPoint[h + 2][w + 2]);
    }

    @Test
    void testGetPlottedPoints_WhenUsingBucketFillingAndCanvasHasNoOtherShapes_ThenReturnListOfPlottedPointsThatFillsTheEntireCanvas() {
        var expectedPlottedPoints = constructExpectedPlottedPoints(point -> true);

        var actualPlottedPoints = bucketFillPlotter.getPlottedPoints(List.of(fillingPointX, fillingPointY, fillingChar));

        assertTrue(expectedPlottedPoints.containsAll(actualPlottedPoints));
    }

    @ParameterizedTest
    @MethodSource("provideArgsForTestGetPlottedPointsWhenUsingBucketFillingAndCanvasHasAnotherShape")
    void testGetPlottedPoints_WhenUsingBucketFilling_ThenReturnPlottedPointsThatDoNotOverlapWithOtherDrawnShapes(
            Coordinates coordinates,
            Plotter plotter,
            List<PlottingPoint> expectedPlottedPoints) {
        var plottedRectanglePoints = plotter.getPlottedPoints(List.of(coordinates.getX1().toString(),
                                                                                        coordinates.getY1().toString(),
                                                                                        coordinates.getX2().toString(),
                                                                                        coordinates.getY2().toString()));
        MatrixGrid.plotDrawnPoints(plottedRectanglePoints);

        var actualPlottedPoints = bucketFillPlotter.getPlottedPoints(List.of(fillingPointX, fillingPointY, fillingChar));

        assertTrue(expectedPlottedPoints.containsAll(actualPlottedPoints));
    }

    private static Stream<Arguments> provideArgsForTestGetPlottedPointsWhenUsingBucketFillingAndCanvasHasAnotherShape() {
        var horizontalLineCoordinates = new Coordinates(1, 2, 6, 2);
        var expectedHorizontalLinePlottedPoints =
            constructExpectedPlottedPoints(point ->
                !((point.getX() >= horizontalLineCoordinates.getX1().intValue() && point.getX() <= horizontalLineCoordinates.getX2().intValue()) &&
                (point.getY() == horizontalLineCoordinates.getY1().intValue() || point.getY() == horizontalLineCoordinates.getY2().intValue())));

        var verticalLineCoordinates = new Coordinates(6, 3, 6, 4);
        var expectedVerticalLinePlottedPoints =
            constructExpectedPlottedPoints(point ->
                !((point.getX() >= verticalLineCoordinates.getX1().intValue() && point.getX() <= verticalLineCoordinates.getX2().intValue()) &&
                (point.getY() == verticalLineCoordinates.getY1().intValue() || point.getY() == verticalLineCoordinates.getY2().intValue())));

        var rectangleLineCoordinates = new Coordinates(16, 1, 20, 3);
        var expectedRectanglePlottedPoints =
            constructExpectedPlottedPoints(point ->
                !(point.getX() >= rectangleLineCoordinates.getX1().intValue() && point.getX() <= rectangleLineCoordinates.getX2().intValue()
                && point.getY() >= rectangleLineCoordinates.getY1().intValue() && point.getY() <= rectangleLineCoordinates.getY2().intValue()));

        return Stream.of(
            Arguments.of(horizontalLineCoordinates, new HorizontalLinePlotter(), expectedHorizontalLinePlottedPoints),
            Arguments.of(verticalLineCoordinates, new VerticalLinePlotter(), expectedVerticalLinePlottedPoints),
            Arguments.of(rectangleLineCoordinates, new RectanglePlotter(), expectedRectanglePlottedPoints)
        );
    }

    private static List<PlottingPoint> constructExpectedPlottedPoints(Predicate<PlottingPoint> predicate) {
        return IntStream.rangeClosed(1, w)
                            .boxed()
                            .flatMap(x -> IntStream.rangeClosed(1, h)
                                                    .boxed()
                                                    .map(y -> new PlottingPoint(x, y, BUCKET_FILLING, fillingChar.charAt(0))))
                            .filter(predicate)
                            .collect(Collectors.toList());
    }

}
