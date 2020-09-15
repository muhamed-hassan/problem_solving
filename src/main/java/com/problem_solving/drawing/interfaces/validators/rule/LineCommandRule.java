package com.problem_solving.drawing.interfaces.validators.rule;

import java.util.List;
import java.util.function.Predicate;

import com.problem_solving.drawing.domain.models.Point;
import com.problem_solving.drawing.application.Plotter;
import com.problem_solving.drawing.application.HorizontalLinePlotter;
import com.problem_solving.drawing.application.VerticalLinePlotter;

public class LineCommandRule extends Rule {

    public LineCommandRule(RuleBuilder lineCommandRuleBuilder) {
        super(lineCommandRuleBuilder);
    }

    @Override
    public Plotter getPlotter(List<String> args) {
        Plotter plotter = null;
        if (args.get(Point.X1).equals(args.get(Point.X2))) {
            plotter = findPlotter(currentPlotter -> currentPlotter instanceof VerticalLinePlotter);
        } else if (args.get(Point.Y1).equals(args.get(Point.Y2))) {
            plotter = findPlotter(currentPlotter -> currentPlotter instanceof HorizontalLinePlotter);
        }
        return plotter;
    }

    private Plotter findPlotter(Predicate<Plotter> plotterPredicate) {
        return plotters.stream()
                        .filter(plotterPredicate)
                        .findFirst()
                        .get();
    }

    public static class LineCommandRuleBuilder extends RuleBuilder {

        @Override
        protected LineCommandRuleBuilder self() {
            return this;
        }

        @Override
        protected LineCommandRule build() {
            return new LineCommandRule(this);
        }

    }

}
