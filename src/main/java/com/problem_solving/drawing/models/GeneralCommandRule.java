package com.problem_solving.drawing.models;

import java.util.List;

import com.problem_solving.drawing.service.BasePlotter;

public class GeneralCommandRule extends Rule {

	public GeneralCommandRule(int validNoOfArgs, List<ValidationRule> validations, List<BasePlotter> plotters) {
		super(validNoOfArgs, validations, plotters);
	}

    @Override
    public BasePlotter getPlotter(List<String> args) {        
        return plotters.get(0);
    }
    
}
