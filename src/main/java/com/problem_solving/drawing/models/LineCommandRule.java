package com.problem_solving.drawing.models;

import java.util.List;
import java.util.function.Predicate;

import com.problem_solving.drawing.service.BasePlotter;
import com.problem_solving.drawing.service.HorizontalLinePlotter;
import com.problem_solving.drawing.service.VerticalLinePlotter;

public class LineCommandRule extends Rule {

    public LineCommandRule(int validNoOfArgs, List<ValidationRule> validations, List<BasePlotter> plotters) {
		super(validNoOfArgs, validations, plotters);
	}

    @Override
    public BasePlotter getPlotter(List<String> args) {
        
        BasePlotter plotter = null;
        if (args.get(Point.X1).equals(args.get(Point.X2))) {             
            plotter = findPlotter(currentPlotter -> currentPlotter instanceof VerticalLinePlotter);            
        } else if (args.get(Point.Y1).equals(args.get(Point.Y2))) {            
            plotter = findPlotter(currentPlotter -> currentPlotter instanceof HorizontalLinePlotter);            
        }

        return plotter;
    }

    private BasePlotter findPlotter(Predicate<BasePlotter> plotterPredicate) {
        
        return plotters
                    .stream()
                    .filter(plotterPredicate)
                    .findFirst()
                    .get();
    }

}
