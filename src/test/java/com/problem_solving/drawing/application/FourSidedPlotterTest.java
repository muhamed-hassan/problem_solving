package com.problem_solving.drawing.application;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.problem_solving.drawing.domain.models.PlottingPoint;
import com.problem_solving.drawing.domain.models.Type;

public class FourSidedPlotterTest {

    protected List<PlottingPoint> generateHorizontalAxisPoints(int startFrom, int endAt, int y, Type type, char characterToBeDrawn) {
        return IntStream.rangeClosed(startFrom, endAt)
                        .parallel()
                        .mapToObj(x -> new PlottingPoint(x, y, type, characterToBeDrawn))
                        .collect(Collectors.toList());
    }

    protected List<PlottingPoint> generateVerticalAxisPoints(int startFrom, int endAt, int x, Type type, char characterToBeDrawn) {
        return IntStream.range(startFrom, endAt)
                        .parallel()
                        .mapToObj(y -> new PlottingPoint(x, y, type, characterToBeDrawn))
                        .collect(Collectors.toList());
    }

}
