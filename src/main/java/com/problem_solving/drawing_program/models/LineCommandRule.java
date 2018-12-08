package com.problem_solving.drawing_program.models;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import com.problem_solving.drawing_program.service.HorizontalLinePlotter;
import com.problem_solving.drawing_program.service.Plotter;
import com.problem_solving.drawing_program.service.VerticalLinePlotter;

public class LineCommandRule extends Rule {

    private List<Plotter> plotters;

    public LineCommandRule(int validNoOfArgs) {
        super(validNoOfArgs);
        plotters = new ArrayList<>(0);
    }

    @Override
    public Rule addPlotter(Plotter plotter) {
        plotters.add(plotter);
        return this;
    }

    @Override
    public Plotter getPlotter(List<String> args) {

        Plotter plotter = null;
        if (args.get(0).equals(args.get(2))) {
            plotter = findPlotter(currentPlotter -> currentPlotter instanceof VerticalLinePlotter);
            
        } else if (args.get(1).equals(args.get(3))) {
            plotter = findPlotter(currentPlotter -> currentPlotter instanceof HorizontalLinePlotter);
            
        }

        return plotter;
    }

    private Plotter findPlotter(Predicate<Plotter> plotterPredicate) {
        return plotters
                    .stream()
                    .filter(plotterPredicate)
                    .findFirst()
                    .get();
    }

}
