package com.problem_solving.drawing.utils.validators;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class HorizontalLineCommandTest extends BaseCommandValidatorTest {

    //######################################## TEST ARGS LENGTH ###########################################################
    @Test
    public void testValidateCommand_WhenUsingArgsGreaterThanAllowedArgs_ThenThrowException() {
        var commandLine = "L 1 2 6 2 1";

        IllegalArgumentException thrownException = assertThrows(IllegalArgumentException.class,
                                                                    () -> commandValidator.validateCommand(commandLine));
        assertEquals("Unexpected number of command line args", thrownException.getMessage());
    }

    @Test
    public void testValidateCommand_WhenUsingArgsLessThanAllowedArgs_ThenThrowException() {
        var commandLine = "L 1 2 6";

        IllegalArgumentException thrownException = assertThrows(IllegalArgumentException.class,
                                                                    () -> commandValidator.validateCommand(commandLine));
        assertEquals("Unexpected number of command line args", thrownException.getMessage());
    }

    //############################ TEST NON-NUMERIC ARGS AS HORIZONTAL LINE COORDINATES ###################################
    @Test
    public void testValidateCommand_WhenUsingNonNumericArgAsX1_ThenThrowException() {
        var commandLine = "L X 2 6 2";

        IllegalArgumentException thrownException = assertThrows(IllegalArgumentException.class,
                                                                    () -> commandValidator.validateCommand(commandLine));
        assertEquals("Invalid value for argument number 1 whose value is X", thrownException.getMessage());
    }

    @Test
    public void testValidateCommand_WhenUsingNonNumericArgAsY1_ThenThrowException() {
        var commandLine = "L 1 X 6 2";

        IllegalArgumentException thrownException = assertThrows(IllegalArgumentException.class,
                                                                    () -> commandValidator.validateCommand(commandLine));
        assertEquals("Invalid value for argument number 2 whose value is X", thrownException.getMessage());
    }

    @Test
    public void testValidateCommand_WhenUsingNonNumericArgAsX2_ThenThrowException() {
        var commandLine = "L 1 2 X 2";

        IllegalArgumentException thrownException = assertThrows(IllegalArgumentException.class,
                                                                    () -> commandValidator.validateCommand(commandLine));
        assertEquals("Invalid value for argument number 3 whose value is X", thrownException.getMessage());
    }

    @Test
    public void testValidateCommand_WhenUsingNonNumericArgAsY2_ThenThrowException() {
        var commandLine = "L 1 2 6 X";

        IllegalArgumentException thrownException = assertThrows(IllegalArgumentException.class,
                                                                    () -> commandValidator.validateCommand(commandLine));
        assertEquals("Invalid value for argument number 4 whose value is X", thrownException.getMessage());
    }

    //############################# TEST NEGATIVE INTEGERES ARGS AS HORIZONTAL LINE COORDINATES ####################################
    @Test
    public void testValidateCommand_WhenUsingNegativeIntegerArgAsX1_ThenThrowException() {
        var commandLine = "L -1 2 6 2";

        IllegalArgumentException thrownException = assertThrows(IllegalArgumentException.class,
                                                                    () -> commandValidator.validateCommand(commandLine));
        assertEquals("Invalid value for argument number 1 whose value is -1", thrownException.getMessage());
    }

    @Test
    public void testValidateCommand_WhenUsingNegativeIntegerArgAsY1_ThenThrowException() {
        var commandLine = "L 1 -2 6 2";

        IllegalArgumentException thrownException = assertThrows(IllegalArgumentException.class,
                                                                    () -> commandValidator.validateCommand(commandLine));
        assertEquals("Invalid value for argument number 2 whose value is -2", thrownException.getMessage());
    }

    @Test
    public void testValidateCommand_WhenUsingNegativeIntegerArgAsX2_ThenThrowException() {
        var commandLine = "L 1 2 -6 2";

        IllegalArgumentException thrownException = assertThrows(IllegalArgumentException.class,
                                                                    () -> commandValidator.validateCommand(commandLine));
        assertEquals("Invalid value for argument number 3 whose value is -6", thrownException.getMessage());
    }

    @Test
    public void testValidateCommand_WhenUsingNegativeIntegerArgAsY2_ThenThrowException() {
        var commandLine = "L 1 2 6 -2";

        IllegalArgumentException thrownException = assertThrows(IllegalArgumentException.class,
                                                                    () -> commandValidator.validateCommand(commandLine));
        assertEquals("Invalid value for argument number 4 whose value is -2", thrownException.getMessage());
    }
    
    //############################# TEST ZERO ARGS AS HORIZONTAL LINE COORDINATES ####################################
    @Test
    public void testValidateCommand_WhenUsingZeroArgAsX1_ThenThrowException() {
        var commandLine = "L 0 2 6 2";

        IllegalArgumentException thrownException = assertThrows(IllegalArgumentException.class,
                                                                    () -> commandValidator.validateCommand(commandLine));
        assertEquals("Value for argument number 1 whose value is 0 should be greater than zero", thrownException.getMessage());
    }

    @Test
    public void testValidateCommand_WhenUsingZeroArgAsY1_ThenThrowException() {
        var commandLine = "L 1 0 6 2";

        IllegalArgumentException thrownException = assertThrows(IllegalArgumentException.class,
                                                                    () -> commandValidator.validateCommand(commandLine));
        assertEquals("Value for argument number 2 whose value is 0 should be greater than zero", thrownException.getMessage());
    }

    @Test
    public void testValidateCommand_WhenUsingZeroArgAsX2_ThenThrowException() {
        var commandLine = "L 1 2 0 2";

        IllegalArgumentException thrownException = assertThrows(IllegalArgumentException.class,
                                                                    () -> commandValidator.validateCommand(commandLine));
        assertEquals("Value for argument number 3 whose value is 0 should be greater than zero", thrownException.getMessage());
    }

    @Test
    public void testValidateCommand_WhenUsingZeroArgAsY2_ThenThrowException() {
        var commandLine = "L 1 2 6 0";

        IllegalArgumentException thrownException = assertThrows(IllegalArgumentException.class,
                                                                    () -> commandValidator.validateCommand(commandLine));
        assertEquals("Value for argument number 4 whose value is 0 should be greater than zero", thrownException.getMessage());
    }
    
    //############################# TEST ZERO ARGS AS HORIZONTAL LINE COORDINATES ####################################
    @Test
    public void testValidateCommand_WhenUsingDecimalArgAsX1_ThenThrowException() {
        var commandLine = "L 1.5 2 6 2";

        IllegalArgumentException thrownException = assertThrows(IllegalArgumentException.class,
                                                                    () -> commandValidator.validateCommand(commandLine));
        assertEquals("Invalid value for argument number 1 whose value is 1.5", thrownException.getMessage());
    }

    @Test
    public void testValidateCommand_WhenUsingDecimalArgAsY1_ThenThrowException() {
        var commandLine = "L 1 2.5 6 2";

        IllegalArgumentException thrownException = assertThrows(IllegalArgumentException.class,
                                                                    () -> commandValidator.validateCommand(commandLine));
        assertEquals("Invalid value for argument number 2 whose value is 2.5", thrownException.getMessage());
    }

    @Test
    public void testValidateCommand_WhenUsingDecimalArgAsX2_ThenThrowException() {
        var commandLine = "L 1 2 6.5 2";

        IllegalArgumentException thrownException = assertThrows(IllegalArgumentException.class,
                                                                    () -> commandValidator.validateCommand(commandLine));
        assertEquals("Invalid value for argument number 3 whose value is 6.5", thrownException.getMessage());
    }

    @Test
    public void testValidateCommand_WhenUsingDecimalArgAsY2_ThenThrowException() {
        var commandLine = "L 1 2 6 2.5";

        IllegalArgumentException thrownException = assertThrows(IllegalArgumentException.class,
                                                                    () -> commandValidator.validateCommand(commandLine));
        assertEquals("Invalid value for argument number 4 whose value is 2.5", thrownException.getMessage());
    }
    
}
