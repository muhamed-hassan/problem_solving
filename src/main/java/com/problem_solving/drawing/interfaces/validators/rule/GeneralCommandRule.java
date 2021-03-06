package com.problem_solving.drawing.interfaces.validators.rule;

import java.util.List;

import com.problem_solving.drawing.application.Plotter;

public class GeneralCommandRule extends Rule {

    public GeneralCommandRule(RuleBuilder generalCommandRuleBuilder) {
        super(generalCommandRuleBuilder);
    }

    @Override
    public Plotter getPlotter(List<String> args) {
        return plotters.get(0);
    }

    public static class GeneralCommandRuleBuilder extends RuleBuilder {

        @Override
        protected GeneralCommandRuleBuilder self() {
            return this;
        }

        @Override
        protected GeneralCommandRule build() {
            return new GeneralCommandRule(this);
        }

    }

}
