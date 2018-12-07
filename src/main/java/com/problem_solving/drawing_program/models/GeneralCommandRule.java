package com.problem_solving.drawing_program.models;

import java.util.List;

import com.problem_solving.drawing_program.service.Plotter;

public class GeneralCommandRule extends Rule {

    private Plotter plotter;

    public GeneralCommandRule(int validNoOfArgs) {
        super(validNoOfArgs);
    }

    @Override
    public Rule addPlotter(Plotter plotter) {
        this.plotter = plotter;
        return this;
    }

    @Override
    public Plotter getPlotter(List<String> args) {
        return plotter;
    }

}
