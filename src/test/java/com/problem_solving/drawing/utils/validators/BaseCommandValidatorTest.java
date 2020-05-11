package com.problem_solving.drawing.utils.validators;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;

public class BaseCommandValidatorTest {

    protected CommandValidator commandValidator;

    @BeforeEach
    public void setUp() {
        commandValidator = new CommandValidator();
    }

    public void testValidateCommand_WhenUsingInvalidCommand_ThenThrowIllegalArgumentException(String commandLine, String expectedErrorMsg) {
        IllegalArgumentException thrownException = assertThrows(IllegalArgumentException.class,
                                                                    () -> commandValidator.validateCommand(commandLine));
        assertEquals(expectedErrorMsg, thrownException.getMessage());
    }

}
