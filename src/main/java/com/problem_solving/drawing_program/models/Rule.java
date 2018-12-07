package com.problem_solving.drawing_program.models;

import java.util.ArrayList;
import java.util.List;

import com.problem_solving.drawing_program.service.Plotter;

public abstract class Rule {

    private final int validNoOfArgs;
    private final List<ValidationRule> validations;

    public Rule(int validNoOfArgs) {
        if (validNoOfArgs <= 0) {
            throw new IllegalArgumentException("At least any command should have 1 arg or more");
        }

        this.validNoOfArgs = validNoOfArgs;
        this.validations = new ArrayList<>(0);
    }

    public Rule addValidationRule(ValidationRule validationRule) {
        if (validNoOfArgs < validations.size()) {
            throw new IllegalArgumentException("Validation rules for this command exceeded the predefined number");
        }

        validations.add(validationRule);
        return this;
    }

    public int getValidNoOfArgs() {
        return validNoOfArgs;
    }

    public Class<?> getExpectedDataTypeForArgsAtPositionOf(int position) {
        return validations.get(position).getExpectedDataType();
    }

    public abstract Rule addPlotter(Plotter plotter);

    public abstract Plotter getPlotter(List<String> args);

}
