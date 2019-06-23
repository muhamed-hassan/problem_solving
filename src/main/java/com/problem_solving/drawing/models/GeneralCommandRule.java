package com.problem_solving.drawing.models;

import java.util.List;

import com.problem_solving.drawing.service.BasePlotter;

public class GeneralCommandRule extends Rule {

    private BasePlotter plotter;

    public GeneralCommandRule(int validNoOfArgs) {
        
        super(validNoOfArgs);
    }

    @Override
    public Rule addPlotter(BasePlotter plotter) {
        
        this.plotter = plotter;
        return this;
    }

    @Override
    public BasePlotter getPlotter(List<String> args) {
        
        return plotter;
    }

}
