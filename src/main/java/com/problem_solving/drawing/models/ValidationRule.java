package com.problem_solving.drawing.models;

public class ValidationRule {

    private final int argPosition;
    private final Class<?> expectedDataType;

    public ValidationRule(int argPosition, Class<?> expectedDataType) {
        
        if (argPosition < 0) {            
            throw new IllegalArgumentException("Command line argument position should start from zero");
        }

        this.argPosition = argPosition;
        this.expectedDataType = expectedDataType;
    }

    public int getArgPosition() {        
        return argPosition;
    }

    public Class<?> getExpectedDataType() {        
        return expectedDataType;
    }

}
