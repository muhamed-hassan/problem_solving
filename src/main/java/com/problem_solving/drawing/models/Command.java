package com.problem_solving.drawing.models;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.problem_solving.drawing.service.BucketFillPlotter;
import com.problem_solving.drawing.service.CanvasPlotter;
import com.problem_solving.drawing.service.HorizontalLinePlotter;
import com.problem_solving.drawing.service.RectanglePlotter;
import com.problem_solving.drawing.service.VerticalLinePlotter;

public final class Command {

    private Command() { }

    public static final char C = 'C';
    public static final char L = 'L';
    public static final char R = 'R';
    public static final char B = 'B';
    public static final char Q = 'Q';

    public static final Map<Character, Rule> VALID_COMMANDS = new HashMap<>(0);

    static {
            	
    	VALID_COMMANDS.put(C, new GeneralCommandRule
    								.GeneralCommandRuleBuilder()
						            	.validNoOfArgs(2)
						            	.withValidationRules(Arrays.asList(
						            			new ValidationRule(0, Integer.class),
						            			new ValidationRule(1, Integer.class)))
						            	.withPlotters(Arrays.asList(new CanvasPlotter()))
						            	.build());       

        VALID_COMMANDS.put(L, new LineCommandRule
        							.LineCommandRuleBuilder()
						            	.validNoOfArgs(4)
						            	.withValidationRules(Arrays.asList(
						            			new ValidationRule(0, Integer.class),
						            			new ValidationRule(1, Integer.class),
						            			new ValidationRule(2, Integer.class),
						            			new ValidationRule(3, Integer.class) ))
						            	.withPlotters(Arrays.asList(new VerticalLinePlotter(), 
						            			new HorizontalLinePlotter()))
						            	.build());

        VALID_COMMANDS.put(R, new GeneralCommandRule
        							.GeneralCommandRuleBuilder()
						            	.validNoOfArgs(4)
						            	.withValidationRules(Arrays.asList(
						            			new ValidationRule(0, Integer.class),
						            			new ValidationRule(1, Integer.class),
						            			new ValidationRule(2, Integer.class),
						            			new ValidationRule(3, Integer.class) ))
						            	.withPlotters(Arrays.asList(new RectanglePlotter()))
						            	.build());

        VALID_COMMANDS.put(B, new GeneralCommandRule
        							.GeneralCommandRuleBuilder()
						            	.validNoOfArgs(3)
						            	.withValidationRules(Arrays.asList(
						            			new ValidationRule(0, Integer.class),
						            			new ValidationRule(1, Integer.class),
						            			new ValidationRule(2, Character.class) ))
						            	.withPlotters(Arrays.asList(new BucketFillPlotter()))
						            	.build());

        VALID_COMMANDS.put(Q, new GeneralCommandRule
        							.GeneralCommandRuleBuilder()
						            	.validNoOfArgs(1)
						            	.withValidationRules(Arrays.asList(new ValidationRule(0, Character.class)))    	
						            	.build());
    }
}
