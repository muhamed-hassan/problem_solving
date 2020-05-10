package com.problem_solving.drawing.utils.validators;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class VerticalLineCommandTest extends BaseCommandValidatorTest {

    //######################################## TEST ARGS LENGTH ###########################################################
    @Test
    public void testValidateCommand_WhenUsingArgsGreaterThanAllowedArgs_ThenThrowException() {
        var commandLine = "L 6 3 6 4 8";

        IllegalArgumentException thrownException = assertThrows(IllegalArgumentException.class,
                                                                    () -> commandValidator.validateCommand(commandLine));
        assertEquals("Unexpected number of command line args", thrownException.getMessage());
    }

    @Test
    public void testValidateCommand_WhenUsingArgsLessThanAllowedArgs_ThenThrowException() {
        var commandLine = "L 6 3 6";

        IllegalArgumentException thrownException = assertThrows(IllegalArgumentException.class,
                                                                    () -> commandValidator.validateCommand(commandLine));
        assertEquals("Unexpected number of command line args", thrownException.getMessage());
    }

    //############################# TEST NON-NUMERIC ARGS AS VERTICAL LINE COORDINATES ####################################
    @Test
    public void testValidateCommand_WhenUsingNonNumericArgAsX1_ThenThrowException() {
        var commandLine = "L X 3 6 4";

        IllegalArgumentException thrownException = assertThrows(IllegalArgumentException.class,
                                                                    () -> commandValidator.validateCommand(commandLine));
        assertEquals("Invalid value for argument number 1 whose value is X", thrownException.getMessage());
    }

    @Test
    public void testValidateCommand_WhenUsingNonNumericArgAsY1_ThenThrowException() {
        var commandLine = "L 6 X 6 4";

        IllegalArgumentException thrownException = assertThrows(IllegalArgumentException.class,
                                                                    () -> commandValidator.validateCommand(commandLine));
        assertEquals("Invalid value for argument number 2 whose value is X", thrownException.getMessage());
    }

    @Test
    public void testValidateCommand_WhenUsingNonNumericArgAsX2_ThenThrowException() {
        var commandLine = "L 6 3 X 4";

        IllegalArgumentException thrownException = assertThrows(IllegalArgumentException.class,
                                                                    () -> commandValidator.validateCommand(commandLine));
        assertEquals("Invalid value for argument number 3 whose value is X", thrownException.getMessage());
    }

    @Test
    public void testValidateCommand_WhenUsingNonNumericArgAsY2_ThenThrowException() {
        var commandLine = "L 6 3 6 X";

        IllegalArgumentException thrownException = assertThrows(IllegalArgumentException.class,
                                                                    () -> commandValidator.validateCommand(commandLine));
        assertEquals("Invalid value for argument number 4 whose value is X", thrownException.getMessage());
    }

    //############################# TEST NEGATIVE INTEGERES ARGS AS VERTICAL LINE COORDINATES ####################################
    @Test
    public void testValidateCommand_WhenUsingNegativeIntegerArgAsX1_ThenThrowException() {
        var commandLine = "L -6 3 6 4";

        IllegalArgumentException thrownException = assertThrows(IllegalArgumentException.class,
                                                                    () -> commandValidator.validateCommand(commandLine));
        assertEquals("Invalid value for argument number 1 whose value is -6", thrownException.getMessage());
    }

    @Test
    public void testValidateCommand_WhenUsingNegativeIntegerArgAsY1_ThenThrowException() {
        var commandLine = "L 6 -3 6 4";

        IllegalArgumentException thrownException = assertThrows(IllegalArgumentException.class,
                                                                    () -> commandValidator.validateCommand(commandLine));
        assertEquals("Invalid value for argument number 2 whose value is -3", thrownException.getMessage());
    }

    @Test
    public void testValidateCommand_WhenUsingNegativeIntegerArgAsX2_ThenThrowException() {
        var commandLine = "L 6 3 -6 4";

        IllegalArgumentException thrownException = assertThrows(IllegalArgumentException.class,
                                                                    () -> commandValidator.validateCommand(commandLine));
        assertEquals("Invalid value for argument number 3 whose value is -6", thrownException.getMessage());
    }

    @Test
    public void testValidateCommand_WhenUsingNegativeIntegerArgAsY2_ThenThrowException() {
        var commandLine = "L 6 3 6 -4";

        IllegalArgumentException thrownException = assertThrows(IllegalArgumentException.class,
                                                                    () -> commandValidator.validateCommand(commandLine));
        assertEquals("Invalid value for argument number 4 whose value is -4", thrownException.getMessage());
    }

    //############################# TEST ZERO ARGS AS VERTICAL LINE COORDINATES ####################################
    @Test
    public void testValidateCommand_WhenUsingZeroArgAsX1_ThenThrowException() {
        var commandLine = "L 0 3 6 4";

        IllegalArgumentException thrownException = assertThrows(IllegalArgumentException.class,
                                                                    () -> commandValidator.validateCommand(commandLine));
        assertEquals("Value for argument number 1 whose value is 0 should be greater than zero", thrownException.getMessage());
    }

    @Test
    public void testValidateCommand_WhenUsingZeroArgAsY1_ThenThrowException() {
        var commandLine = "L 6 0 6 4";

        IllegalArgumentException thrownException = assertThrows(IllegalArgumentException.class,
                                                                    () -> commandValidator.validateCommand(commandLine));
        assertEquals("Value for argument number 2 whose value is 0 should be greater than zero", thrownException.getMessage());
    }

    @Test
    public void testValidateCommand_WhenUsingZeroArgAsX2_ThenThrowException() {
        var commandLine = "L 6 3 0 4";

        IllegalArgumentException thrownException = assertThrows(IllegalArgumentException.class,
                                                                    () -> commandValidator.validateCommand(commandLine));
        assertEquals("Value for argument number 3 whose value is 0 should be greater than zero", thrownException.getMessage());
    }

    @Test
    public void testValidateCommand_WhenUsingZeroArgAsY2_ThenThrowException() {
        var commandLine = "L 6 3 6 0";

        IllegalArgumentException thrownException = assertThrows(IllegalArgumentException.class,
                                                                    () -> commandValidator.validateCommand(commandLine));
        assertEquals("Value for argument number 4 whose value is 0 should be greater than zero", thrownException.getMessage());
    }
    
    //############################## TEST ZERO ARGS AS VERTICAL LINE COORDINATES #####################################
    @Test
    public void testValidateCommand_WhenUsingDecimalArgAsX1_ThenThrowException() {
        var commandLine = "L 1.5 3 6 4";

        IllegalArgumentException thrownException = assertThrows(IllegalArgumentException.class,
                                                                    () -> commandValidator.validateCommand(commandLine));
        assertEquals("Invalid value for argument number 1 whose value is 1.5", thrownException.getMessage());
    }

    @Test
    public void testValidateCommand_WhenUsingDecimalArgAsY1_ThenThrowException() {
        var commandLine = "L 6 2.5 6 4";

        IllegalArgumentException thrownException = assertThrows(IllegalArgumentException.class,
                                                                    () -> commandValidator.validateCommand(commandLine));
        assertEquals("Invalid value for argument number 2 whose value is 2.5", thrownException.getMessage());
    }

    @Test
    public void testValidateCommand_WhenUsingDecimalArgAsX2_ThenThrowException() {
        var commandLine = "L 6 3 6.5 4";

        IllegalArgumentException thrownException = assertThrows(IllegalArgumentException.class,
                                                                    () -> commandValidator.validateCommand(commandLine));
        assertEquals("Invalid value for argument number 3 whose value is 6.5", thrownException.getMessage());
    }

    @Test
    public void testValidateCommand_WhenUsingDecimalArgAsY2_ThenThrowException() {
        var commandLine = "L 6 3 6 4.5";

        IllegalArgumentException thrownException = assertThrows(IllegalArgumentException.class,
                                                                    () -> commandValidator.validateCommand(commandLine));
        assertEquals("Invalid value for argument number 4 whose value is 4.5", thrownException.getMessage());
    }
    
}
