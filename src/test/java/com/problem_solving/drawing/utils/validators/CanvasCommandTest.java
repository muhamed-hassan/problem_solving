package com.problem_solving.drawing.utils.validators;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class CanvasCommandTest extends BaseCommandValidatorTest {

    //######################################## TEST ARGS LENGTH ###########################################################
    @Test
    public void testValidateCommand_WhenUsingArgsGreaterThanAllowedArgs_ThenThrowException() {
        var commandLine = "C 20 4 3";

        IllegalArgumentException thrownException = assertThrows(IllegalArgumentException.class,
                                                                    () -> commandValidator.validateCommand(commandLine));
        assertEquals("Unexpected number of command line args", thrownException.getMessage());
    }

    @Test
    public void testValidateCommand_WhenUsingArgsLessThanAllowedArgs_ThenThrowException() {
        var commandLine = "C 20";

        IllegalArgumentException thrownException = assertThrows(IllegalArgumentException.class,
                                                                    () -> commandValidator.validateCommand(commandLine));
        assertEquals("Unexpected number of command line args", thrownException.getMessage());
    }
    
    //################################# TEST NON-NUMERIC ARGS AS CANVAS DIMENSIONS ########################################
    @Test
    public void testValidateCommand_WhenUsingNonNumericArgAsCanvasWidth_ThenThrowException() {
        var commandLine = "C X 4";

        IllegalArgumentException thrownException = assertThrows(IllegalArgumentException.class,
                                                                    () -> commandValidator.validateCommand(commandLine));
        assertEquals("Invalid value for argument number 1 whose value is X", thrownException.getMessage());
    }

    @Test
    public void testValidateCommand_WhenUsingNonNumericArgAsCanvasHeight_ThenThrowException() {
        var commandLine = "C 20 X";

        IllegalArgumentException thrownException = assertThrows(IllegalArgumentException.class,
                                                                    () -> commandValidator.validateCommand(commandLine));
        assertEquals("Invalid value for argument number 2 whose value is X", thrownException.getMessage());
    }

    //################################# TEST NEGATIVE INTEGERES ARGS AS CANVAS DIMENSIONS #################################
    @Test
    public void testValidateCommand_WhenUsingNegativeIntegerArgAsCanvasWidth_ThenThrowException() {
        var commandLine = "C -20 4";

        IllegalArgumentException thrownException = assertThrows(IllegalArgumentException.class,
                                                                    () -> commandValidator.validateCommand(commandLine));
        assertEquals("Invalid value for argument number 1 whose value is -20", thrownException.getMessage());
    }

    @Test
    public void testValidateCommand_WhenUsingNegativeIntegerArgAsCanvasHeight_ThenThrowException() {
        var commandLine = "C 20 -4";

        IllegalArgumentException thrownException = assertThrows(IllegalArgumentException.class,
                                                                    () -> commandValidator.validateCommand(commandLine));
        assertEquals("Invalid value for argument number 2 whose value is -4", thrownException.getMessage());
    }
        
    //######################################## TEST ZERO ARGS AS CANVAS DIMENSIONS ########################################
    @Test
    public void testValidateCommand_WhenUsingZeroArgAsCanvasWidth_ThenThrowException() {
        var commandLine = "C 0 4";

        IllegalArgumentException thrownException = assertThrows(IllegalArgumentException.class,
                                                                    () -> commandValidator.validateCommand(commandLine));
        assertEquals("Value for argument number 1 whose value is 0 should be greater than zero", thrownException.getMessage());
    }

    @Test
    public void testValidateCommand_WhenUsingZeroArgAsCanvasHeight_ThenThrowException() {
        var commandLine = "C 20 0";

        IllegalArgumentException thrownException = assertThrows(IllegalArgumentException.class,
                                                                    () -> commandValidator.validateCommand(commandLine));
        assertEquals("Value for argument number 2 whose value is 0 should be greater than zero", thrownException.getMessage());
    }
    
    //################################## TEST DECIMAL ARGS AS CANVAS DIMENSIONS ###########################################
    @Test
    public void testValidateCommand_WhenUsingDecimalArgAsX1_ThenThrowException() {
        var commandLine = "C 20.5 4";

        IllegalArgumentException thrownException = assertThrows(IllegalArgumentException.class,
                                                                    () -> commandValidator.validateCommand(commandLine));
        assertEquals("Invalid value for argument number 1 whose value is 20.5", thrownException.getMessage());
    }

    @Test
    public void testValidateCommand_WhenUsingDecimalArgAsY1_ThenThrowException() {
        var commandLine = "C 20 4.5";

        IllegalArgumentException thrownException = assertThrows(IllegalArgumentException.class,
                                                                    () -> commandValidator.validateCommand(commandLine));
        assertEquals("Invalid value for argument number 2 whose value is 4.5", thrownException.getMessage());
    }
    
}
