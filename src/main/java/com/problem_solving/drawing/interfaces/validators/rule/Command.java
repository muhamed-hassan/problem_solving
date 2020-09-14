package com.problem_solving.drawing.interfaces.validators.rule;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.problem_solving.drawing.application.BucketFillPlotter;
import com.problem_solving.drawing.application.CanvasPlotter;
import com.problem_solving.drawing.application.HorizontalLinePlotter;
import com.problem_solving.drawing.application.RectanglePlotter;
import com.problem_solving.drawing.application.VerticalLinePlotter;

public final class Command {

    public static final char C = 'C';
    public static final char L = 'L';
    public static final char R = 'R';
    public static final char B = 'B';
    public static final char Q = 'Q';

    public static final Map<Character, Rule> VALID_COMMANDS = new HashMap<>(5, 1.0f);

    static {
        VALID_COMMANDS.put(C, new GeneralCommandRule
            .GeneralCommandRuleBuilder()
            .validNoOfArgs(2)
            .withValidationRules(List.of(
                new ValidationRule(0, Integer.class),
                new ValidationRule(1, Integer.class)))
            .withPlotters(List.of(new CanvasPlotter()))
            .build());

        VALID_COMMANDS.put(L, new LineCommandRule
            .LineCommandRuleBuilder()
            .validNoOfArgs(4)
            .withValidationRules(List.of(
                new ValidationRule(0, Integer.class),
                new ValidationRule(1, Integer.class),
                new ValidationRule(2, Integer.class),
                new ValidationRule(3, Integer.class)))
            .withPlotters(List.of(new VerticalLinePlotter(),
                                    new HorizontalLinePlotter()))
            .build());

        VALID_COMMANDS.put(R, new GeneralCommandRule
            .GeneralCommandRuleBuilder()
            .validNoOfArgs(4)
            .withValidationRules(List.of(
                new ValidationRule(0, Integer.class),
                new ValidationRule(1, Integer.class),
                new ValidationRule(2, Integer.class),
                new ValidationRule(3, Integer.class)))
            .withPlotters(List.of(new RectanglePlotter()))
            .build());

        VALID_COMMANDS.put(B, new GeneralCommandRule
            .GeneralCommandRuleBuilder()
            .validNoOfArgs(3)
            .withValidationRules(List.of(
                new ValidationRule(0, Integer.class),
                new ValidationRule(1, Integer.class),
                new ValidationRule(2, Character.class)))
            .withPlotters(List.of(new BucketFillPlotter()))
            .build());

        VALID_COMMANDS.put(Q, new GeneralCommandRule
            .GeneralCommandRuleBuilder()
            .validNoOfArgs(1)
            .withValidationRules(List.of(new ValidationRule(0, Character.class)))
            .build());
    }

    private Command() {}

}
