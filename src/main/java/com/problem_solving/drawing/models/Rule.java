package com.problem_solving.drawing.models;

import java.util.List;

import com.problem_solving.drawing.service.BasePlotter;

public abstract class Rule {

    private final int validNoOfArgs;
    private final List<ValidationRule> validations;
    protected final List<BasePlotter> plotters;
    
    public Rule(int validNoOfArgs, List<ValidationRule> validations, List<BasePlotter> plotters) {
		this.validNoOfArgs = validNoOfArgs;
		this.validations = validations;
		this.plotters = plotters;
	}

	public int getValidNoOfArgs() {        
        return validNoOfArgs;
    }

    public Class<?> getExpectedDataTypeForArgsAtPositionOf(int position) {        
        return validations.get(position).getExpectedDataType();
    }

    public abstract BasePlotter getPlotter(List<String> args);

    public static class RuleBuilder {

		private int validNoOfArgs;
    	private List<ValidationRule> validations;
    	private List<BasePlotter> plotters;
    	
    	public RuleBuilder validNoOfArgs(int validNoOfArgs) {
    		this.validNoOfArgs = validNoOfArgs;
    		return this;
    	}
    	
    	public RuleBuilder withValidationRules(List<ValidationRule> validations) {
    		if (validations != null 
    				&& validNoOfArgs < validations.size()) {                
                throw new IllegalArgumentException("Validation rules for this command exceeded the predefined number");
            }
    		this.validations = validations;
    		return this;
    	}
    	
    	public RuleBuilder withPlotters(List<BasePlotter> plotters) {
    		this.plotters = plotters;
    		return this;
    	}
    	
    	public Rule build(Class<? extends Rule> targetRule) {    		
    		try {    			
    			return (Rule) targetRule.getConstructor(int.class, List.class, List.class)
    									.newInstance(validNoOfArgs,validations, plotters);    			
    		} catch (Exception exception) {
    			throw new RuntimeException("Unable to build an instance from " + targetRule.getName());
    		}    		
    	}
    }
}
