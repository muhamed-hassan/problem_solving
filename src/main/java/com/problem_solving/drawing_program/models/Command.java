package com.problem_solving.drawing_program.models;

import java.util.HashMap;
import java.util.Map;

import com.problem_solving.drawing_program.service.BucketFillPlotter;
import com.problem_solving.drawing_program.service.CanvasPlotter;
import com.problem_solving.drawing_program.service.HorizontalLinePlotter;
import com.problem_solving.drawing_program.service.RectanglePlotter;
import com.problem_solving.drawing_program.service.VerticalLinePlotter;

public final class Command {

    private Command() { }

    public static final char C = 'C';
    public static final char L = 'L';
    public static final char R = 'R';
    public static final char B = 'B';
    public static final char Q = 'Q';

    public static final Map<Character, Rule> VALID_COMMANDS = new HashMap<>(0);

    static {
        VALID_COMMANDS.put(C, new GeneralCommandRule(2)
                .addValidationRule(new ValidationRule(0, Integer.class))
                .addValidationRule(new ValidationRule(1, Integer.class))
                .addPlotter(new CanvasPlotter()));

        VALID_COMMANDS.put(L, new LineCommandRule(4)
                .addValidationRule(new ValidationRule(0, Integer.class))
                .addValidationRule(new ValidationRule(1, Integer.class))
                .addValidationRule(new ValidationRule(2, Integer.class))
                .addValidationRule(new ValidationRule(3, Integer.class))
                .addPlotter(new VerticalLinePlotter())
                .addPlotter(new HorizontalLinePlotter()));

        VALID_COMMANDS.put(R, new GeneralCommandRule(4)
                .addValidationRule(new ValidationRule(0, Integer.class))
                .addValidationRule(new ValidationRule(1, Integer.class))
                .addValidationRule(new ValidationRule(2, Integer.class))
                .addValidationRule(new ValidationRule(3, Integer.class))
                .addPlotter(new RectanglePlotter()));

        VALID_COMMANDS.put(B, new GeneralCommandRule(3)
                .addValidationRule(new ValidationRule(0, Integer.class))
                .addValidationRule(new ValidationRule(1, Integer.class))
                .addValidationRule(new ValidationRule(2, Character.class))
                .addPlotter(new BucketFillPlotter()));

        VALID_COMMANDS.put(Q, new GeneralCommandRule(1)
                .addValidationRule(new ValidationRule(0, Character.class)));
    }

}
