package com.problem_solving.drawing.service;

import java.util.List;

import com.problem_solving.drawing.models.PlottingPoint;

public abstract class FillerPlotter extends BasePlotter {

    public abstract List<PlottingPoint> getPlottingPoints(List<String> args, PlottingPoint[][] matrix);
    
}
