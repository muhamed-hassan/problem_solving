package com.problem_solving.drawing.service;

import java.util.List;

import com.problem_solving.drawing.models.PlottingPoint;

public abstract class Plotter {

    public abstract void plot(List<String> args, PlottingPoint[][] matrix);

}
