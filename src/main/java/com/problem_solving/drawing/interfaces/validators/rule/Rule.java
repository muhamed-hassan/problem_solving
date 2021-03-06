package com.problem_solving.drawing.interfaces.validators.rule;

import java.util.List;
import java.util.Objects;

import com.problem_solving.drawing.application.Plotter;

public abstract class Rule {

    protected final List<Plotter> plotters;
    private final int validNoOfArgs;
    private final List<ValidationRule> validations;

    public Rule(RuleBuilder ruleBuilder) {
        this.validNoOfArgs = ruleBuilder.validNoOfArgs;
        this.validations = ruleBuilder.validations;
        this.plotters = ruleBuilder.plotters;
    }

    public int getValidNoOfArgs() {
        return validNoOfArgs;
    }

    public Class<?> getExpectedDataTypeForArgsAtPositionOf(int position) {
        return validations.get(position).getExpectedDataType();
    }

    public abstract Plotter getPlotter(List<String> args);

    protected abstract static class RuleBuilder {

        private int validNoOfArgs; // mandatory
        private List<ValidationRule> validations; // mandatory
        private List<Plotter> plotters; // optional

        public RuleBuilder validNoOfArgs(int validNoOfArgs) {
            this.validNoOfArgs = validNoOfArgs;
            return self();
        }

        public RuleBuilder withValidationRules(List<ValidationRule> validations) {
            Objects.requireNonNull(validations, "A list of validation rules should be supplied");
            if (validNoOfArgs < validations.size()) {
                throw new IllegalArgumentException("Validation rules for this command exceeded the predefined number");
            }
            this.validations = validations;
            return self();
        }

        public RuleBuilder withPlotters(List<Plotter> plotters) {
            this.plotters = plotters;
            return self();
        }

        protected abstract RuleBuilder self();

        protected abstract Rule build();
    }

}
