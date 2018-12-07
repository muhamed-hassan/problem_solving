package com.problem_solving.drawing_program.service;

import java.util.List;

import com.problem_solving.drawing_program.models.PlottingPoint;

public abstract class Plotter {

    public abstract void plot(List<String> args, PlottingPoint[][] matrix);

}
