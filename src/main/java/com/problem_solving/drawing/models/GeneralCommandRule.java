package com.problem_solving.drawing.models;

import java.util.List;

import com.problem_solving.drawing.service.BasePlotter;

public class GeneralCommandRule extends Rule {

    public GeneralCommandRule(RuleBuilder generalCommandRuleBuilder) {
        super(generalCommandRuleBuilder);
    }

    @Override
    public BasePlotter getPlotter(List<String> args) {
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
