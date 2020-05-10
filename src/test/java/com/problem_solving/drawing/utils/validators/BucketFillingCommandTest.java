package com.problem_solving.drawing.utils.validators;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class BucketFillingCommandTest extends BaseCommandValidatorTest {

    //######################################## TEST ARGS LENGTH ###########################################################
    @Test
    public void testValidateCommand_WhenUsingArgsGreaterThanAllowedArgs_ThenThrowException() {
        var commandLine = "B 10 3 o 1";

        IllegalArgumentException thrownException = assertThrows(IllegalArgumentException.class,
                                                                    () -> commandValidator.validateCommand(commandLine));
        assertEquals("Unexpected number of command line args", thrownException.getMessage());
    }

    @Test
    public void testValidateCommand_WhenUsingArgsLessThanAllowedArgs_ThenThrowException() {
        var commandLine = "B 10 3";

        IllegalArgumentException thrownException = assertThrows(IllegalArgumentException.class,
                                                                    () -> commandValidator.validateCommand(commandLine));
        assertEquals("Unexpected number of command line args", thrownException.getMessage());
    }

    //#################################### TEST NON-NUMERIC ARGS AS COORDINATES ###########################################
    @Test
    public void testValidateCommand_WhenUsingNonNumericArgAsPointX_ThenThrowException() {
        var commandLine = "B X 3 o";

        IllegalArgumentException thrownException = assertThrows(IllegalArgumentException.class,
                                                                    () -> commandValidator.validateCommand(commandLine));
        assertEquals("Invalid value for argument number 1 whose value is X", thrownException.getMessage());
    }

    @Test
    public void testValidateCommand_WhenUsingNonNumericArgAsPointY_ThenThrowException() {
        var commandLine = "B 10 X o";

        IllegalArgumentException thrownException = assertThrows(IllegalArgumentException.class,
                                                                    () -> commandValidator.validateCommand(commandLine));
        assertEquals("Invalid value for argument number 2 whose value is X", thrownException.getMessage());
    }

    //#################################### TEST NEGATIVE INTEGERES ARGS AS COORDINATES ####################################
    @Test
    public void testValidateCommand_WhenUsingNegativeIntegerArgAsPointX_ThenThrowException() {
        var commandLine = "B -10 3 o";

        IllegalArgumentException thrownException = assertThrows(IllegalArgumentException.class,
                                                                    () -> commandValidator.validateCommand(commandLine));
        assertEquals("Invalid value for argument number 1 whose value is -10", thrownException.getMessage());
    }

    @Test
    public void testValidateCommand_WhenUsingNegativeIntegerArgAsPointY_ThenThrowException() {
        var commandLine = "B 10 -3 o";

        IllegalArgumentException thrownException = assertThrows(IllegalArgumentException.class,
                                                                    () -> commandValidator.validateCommand(commandLine));
        assertEquals("Invalid value for argument number 2 whose value is -3", thrownException.getMessage());
    }
    
    //########################################### TEST ZERO ARGS AS COORDINATES ###########################################
    @Test
    public void testValidateCommand_WhenUsingZeroArgAsPointX_ThenThrowException() {
        var commandLine = "B 0 3 o";

        IllegalArgumentException thrownException = assertThrows(IllegalArgumentException.class,
                                                                    () -> commandValidator.validateCommand(commandLine));
        assertEquals("Value for argument number 1 whose value is 0 should be greater than zero", thrownException.getMessage());
    }

    @Test
    public void testValidateCommand_WhenUsingZeroArgAsPointY_ThenThrowException() {
        var commandLine = "B 10 0 o";

        IllegalArgumentException thrownException = assertThrows(IllegalArgumentException.class,
                                                                    () -> commandValidator.validateCommand(commandLine));
        assertEquals("Value for argument number 2 whose value is 0 should be greater than zero", thrownException.getMessage());
    }
    
    //##################################### TEST DECIMAL ARGS AS COORDINATES ##############################################
    @Test
    public void testValidateCommand_WhenUsingDecimalArgAsX1_ThenThrowException() {
        var commandLine = "B 10.5 3 o";

        IllegalArgumentException thrownException = assertThrows(IllegalArgumentException.class,
                                                                    () -> commandValidator.validateCommand(commandLine));
        assertEquals("Invalid value for argument number 1 whose value is 10.5", thrownException.getMessage());
    }

    @Test
    public void testValidateCommand_WhenUsingDecimalArgAsY1_ThenThrowException() {
        var commandLine = "B 10 3.5 o";

        IllegalArgumentException thrownException = assertThrows(IllegalArgumentException.class,
                                                                    () -> commandValidator.validateCommand(commandLine));
        assertEquals("Invalid value for argument number 2 whose value is 3.5", thrownException.getMessage());
    }
    
}
