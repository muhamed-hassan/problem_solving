package com.problem_solving.drawing.utils.validators;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class RectangleCommandTest extends BaseCommandValidatorTest {

    //######################################## TEST ARGS LENGTH ###########################################################
    @Test
    public void testValidateCommand_WhenUsingArgsGreaterThanAllowedArgs_ThenThrowException() {
        var commandLine = "R 16 1 20 3 5";

        IllegalArgumentException thrownException = assertThrows(IllegalArgumentException.class,
                                                                    () -> commandValidator.validateCommand(commandLine));
        assertEquals("Unexpected number of command line args", thrownException.getMessage());
    }

    @Test
    public void testValidateCommand_WhenUsingArgsLessThanAllowedArgs_ThenThrowException() {
        var commandLine = "R 16 1 20";

        IllegalArgumentException thrownException = assertThrows(IllegalArgumentException.class,
                                                                    () -> commandValidator.validateCommand(commandLine));
        assertEquals("Unexpected number of command line args", thrownException.getMessage());
    }

    //############################### TEST NON-NUMERIC ARGS AS RECTANGLE COORDINATES ######################################
    @Test
    public void testValidateCommand_WhenUsingNonNumericArgAsX1_ThenThrowException() {
        var commandLine = "R X 1 20 3";

        IllegalArgumentException thrownException = assertThrows(IllegalArgumentException.class,
                                                                    () -> commandValidator.validateCommand(commandLine));
        assertEquals("Invalid value for argument number 1 whose value is X", thrownException.getMessage());
    }

    @Test
    public void testValidateCommand_WhenUsingNonNumericArgAsY1_ThenThrowException() {
        var commandLine = "R 16 X 20 3";

        IllegalArgumentException thrownException = assertThrows(IllegalArgumentException.class,
                                                                    () -> commandValidator.validateCommand(commandLine));
        assertEquals("Invalid value for argument number 2 whose value is X", thrownException.getMessage());
    }

    @Test
    public void testValidateCommand_WhenUsingNonNumericArgAsX2_ThenThrowException() {
        var commandLine = "R 16 1 X 3";

        IllegalArgumentException thrownException = assertThrows(IllegalArgumentException.class,
                                                                    () -> commandValidator.validateCommand(commandLine));
        assertEquals("Invalid value for argument number 3 whose value is X", thrownException.getMessage());
    }

    @Test
    public void testValidateCommand_WhenUsingNonNumericArgAsY2_ThenThrowException() {
        var commandLine = "R 16 1 20 X";

        IllegalArgumentException thrownException = assertThrows(IllegalArgumentException.class,
                                                                    () -> commandValidator.validateCommand(commandLine));
        assertEquals("Invalid value for argument number 4 whose value is X", thrownException.getMessage());
    }

    //############################ TEST NEGATIVE INTEGERES ARGS AS RECTANGLE COORDINATES ##################################
    @Test
    public void testValidateCommand_WhenUsingNegativeIntegerArgAsX1_ThenThrowException() {
        var commandLine = "R -16 1 20 3";

        IllegalArgumentException thrownException = assertThrows(IllegalArgumentException.class,
                                                                    () -> commandValidator.validateCommand(commandLine));
        assertEquals("Invalid value for argument number 1 whose value is -16", thrownException.getMessage());
    }

    @Test
    public void testValidateCommand_WhenUsingNegativeIntegerArgAsY1_ThenThrowException() {
        var commandLine = "R 16 -1 20 3";

        IllegalArgumentException thrownException = assertThrows(IllegalArgumentException.class,
                                                                    () -> commandValidator.validateCommand(commandLine));
        assertEquals("Invalid value for argument number 2 whose value is -1", thrownException.getMessage());
    }

    @Test
    public void testValidateCommand_WhenUsingNegativeIntegerArgAsX2_ThenThrowException() {
        var commandLine = "R 16 1 -20 3";

        IllegalArgumentException thrownException = assertThrows(IllegalArgumentException.class,
                                                                    () -> commandValidator.validateCommand(commandLine));
        assertEquals("Invalid value for argument number 3 whose value is -20", thrownException.getMessage());
    }

    @Test
    public void testValidateCommand_WhenUsingNegativeIntegerArgAsY2_ThenThrowException() {
        var commandLine = "R 16 1 20 -3";

        IllegalArgumentException thrownException = assertThrows(IllegalArgumentException.class,
                                                                    () -> commandValidator.validateCommand(commandLine));
        assertEquals("Invalid value for argument number 4 whose value is -3", thrownException.getMessage());
    }
    
    //################################## TEST ZERO ARGS AS RECTANGLE COORDINATES ##########################################
    @Test
    public void testValidateCommand_WhenUsingZeroArgAsX1_ThenThrowException() {
        var commandLine = "R 0 1 20 3";

        IllegalArgumentException thrownException = assertThrows(IllegalArgumentException.class,
                                                                    () -> commandValidator.validateCommand(commandLine));
        assertEquals("Value for argument number 1 whose value is 0 should be greater than zero", thrownException.getMessage());
    }

    @Test
    public void testValidateCommand_WhenUsingZeroArgAsY1_ThenThrowException() {
        var commandLine = "R 16 0 20 3";

        IllegalArgumentException thrownException = assertThrows(IllegalArgumentException.class,
                                                                    () -> commandValidator.validateCommand(commandLine));
        assertEquals("Value for argument number 2 whose value is 0 should be greater than zero", thrownException.getMessage());
    }

    @Test
    public void testValidateCommand_WhenUsingZeroArgAsX2_ThenThrowException() {
        var commandLine = "R 16 1 0 3";

        IllegalArgumentException thrownException = assertThrows(IllegalArgumentException.class,
                                                                    () -> commandValidator.validateCommand(commandLine));
        assertEquals("Value for argument number 3 whose value is 0 should be greater than zero", thrownException.getMessage());
    }

    @Test
    public void testValidateCommand_WhenUsingZeroArgAsY2_ThenThrowException() {
        var commandLine = "R 16 1 20 0";

        IllegalArgumentException thrownException = assertThrows(IllegalArgumentException.class,
                                                                    () -> commandValidator.validateCommand(commandLine));
        assertEquals("Value for argument number 4 whose value is 0 should be greater than zero", thrownException.getMessage());
    }
    
    //############################## TEST ZERO ARGS AS RECTANGLE COORDINATES #####################################
    @Test
    public void testValidateCommand_WhenUsingDecimalArgAsX1_ThenThrowException() {
        var commandLine = "R 16.5 1 20 3";

        IllegalArgumentException thrownException = assertThrows(IllegalArgumentException.class,
                                                                    () -> commandValidator.validateCommand(commandLine));
        assertEquals("Invalid value for argument number 1 whose value is 16.5", thrownException.getMessage());
    }

    @Test
    public void testValidateCommand_WhenUsingDecimalArgAsY1_ThenThrowException() {
        var commandLine = "R 16 1.5 20 3";

        IllegalArgumentException thrownException = assertThrows(IllegalArgumentException.class,
                                                                    () -> commandValidator.validateCommand(commandLine));
        assertEquals("Invalid value for argument number 2 whose value is 1.5", thrownException.getMessage());
    }

    @Test
    public void testValidateCommand_WhenUsingDecimalArgAsX2_ThenThrowException() {
        var commandLine = "R 16 1 20.5 3";

        IllegalArgumentException thrownException = assertThrows(IllegalArgumentException.class,
                                                                    () -> commandValidator.validateCommand(commandLine));
        assertEquals("Invalid value for argument number 3 whose value is 20.5", thrownException.getMessage());
    }

    @Test
    public void testValidateCommand_WhenUsingDecimalArgAsY2_ThenThrowException() {
        var commandLine = "R 16 1 20 3.5";

        IllegalArgumentException thrownException = assertThrows(IllegalArgumentException.class,
                                                                    () -> commandValidator.validateCommand(commandLine));
        assertEquals("Invalid value for argument number 4 whose value is 3.5", thrownException.getMessage());
    }
    
}
