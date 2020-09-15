package com.problem_solving.drawing.application;

import java.util.List;

import com.problem_solving.drawing.domain.models.PlottingPoint;

public abstract class Plotter {

    public abstract List<PlottingPoint> getPlottedPoints(List<String> args);

}
