package com.problem_solving.drawing.models;

public class ValidationRule {

    private final Class<?> expectedDataType;

    public ValidationRule(int argPosition, Class<?> expectedDataType) {
        if (argPosition < 0) {            
            throw new IllegalArgumentException("Command line argument position should start from zero");
        }
        this.expectedDataType = expectedDataType;
    }

    public Class<?> getExpectedDataType() {
        return expectedDataType;
    }

}
