package com.problem_solving.drawing.utils.validators;

import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class BaseCommandValidatorTest {

    @Rule
    public ExpectedException thrownException = ExpectedException.none();
    
    protected CommandValidator commandValidator;
    
    @Before
    public void setUp() {
        
        commandValidator = new CommandValidator();
    }

}
