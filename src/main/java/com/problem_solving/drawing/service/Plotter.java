package com.problem_solving.drawing.service;

import java.util.List;

import com.problem_solving.drawing.domain.models.PlottingPoint;

public abstract class Plotter extends BasePlotter {

    public abstract List<PlottingPoint> getPlottingPoints(List<String> args);

}
