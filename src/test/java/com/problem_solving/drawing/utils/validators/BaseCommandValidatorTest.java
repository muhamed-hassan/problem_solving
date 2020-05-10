package com.problem_solving.drawing.utils.validators;

import org.junit.jupiter.api.BeforeEach;

public class BaseCommandValidatorTest {

    protected CommandValidator commandValidator;

    @BeforeEach
    public void setUp() {
        commandValidator = new CommandValidator();
    }

}
