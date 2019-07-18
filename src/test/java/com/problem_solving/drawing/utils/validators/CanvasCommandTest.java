package com.problem_solving.drawing.utils.validators;

import org.junit.Test;

public class CanvasCommandTest extends BaseCommandValidatorTest {

    //######################################## TEST ARGS LENGTH ###########################################################
    @Test
    public void testValidateCommand_WhenUsingArgsGreaterThanAllowedArgs_ThenThrowException() throws Exception {

        thrownException.expect(IllegalArgumentException.class);
        thrownException.expectMessage("Unexpected number of command line args");

        var commandLine = "C 20 4 3";
        commandValidator.validateCommand(commandLine);
    }

    @Test
    public void testValidateCommand_WhenUsingArgsLessThanAllowedArgs_ThenThrowException() throws Exception {

        thrownException.expect(IllegalArgumentException.class);
        thrownException.expectMessage("Unexpected number of command line args");

        var commandLine = "C 20";
        commandValidator.validateCommand(commandLine);
    }
    
    //################################# TEST NON-NUMERIC ARGS AS CANVAS DIMENSIONS ########################################
    @Test
    public void testValidateCommand_WhenUsingNonNumericArgAsCanvasWidth_ThenThrowException() throws Exception {

        thrownException.expect(IllegalArgumentException.class);
        thrownException.expectMessage("Invalid value for argument number 1 whose value is X");

        var commandLine = "C X 4";
        commandValidator.validateCommand(commandLine);
    }

    @Test
    public void testValidateCommand_WhenUsingNonNumericArgAsCanvasHeight_ThenThrowException() throws Exception {

        thrownException.expect(IllegalArgumentException.class);
        thrownException.expectMessage("Invalid value for argument number 2 whose value is X");

        var commandLine = "C 20 X";
        commandValidator.validateCommand(commandLine);
    }

    //################################# TEST NEGATIVE INTEGERES ARGS AS CANVAS DIMENSIONS #################################
    @Test
    public void testValidateCommand_WhenUsingNegativeIntegerArgAsCanvasWidth_ThenThrowException() throws Exception {

        thrownException.expect(IllegalArgumentException.class);
        thrownException.expectMessage("Invalid value for argument number 1 whose value is -20");

        var commandLine = "C -20 4";
        commandValidator.validateCommand(commandLine);
    }

    @Test
    public void testValidateCommand_WhenUsingNegativeIntegerArgAsCanvasHeight_ThenThrowException() throws Exception {

        thrownException.expect(IllegalArgumentException.class);
        thrownException.expectMessage("Invalid value for argument number 2 whose value is -4");

        var commandLine = "C 20 -4";
        commandValidator.validateCommand(commandLine);
    }
        
    //######################################## TEST ZERO ARGS AS CANVAS DIMENSIONS ########################################
    @Test
    public void testValidateCommand_WhenUsingZeroArgAsCanvasWidth_ThenThrowException() throws Exception {

        thrownException.expect(IllegalArgumentException.class);
        thrownException.expectMessage("Value for argument number 1 whose value is 0 should be greater than zero");

        var commandLine = "C 0 4";
        commandValidator.validateCommand(commandLine);
    }

    @Test
    public void testValidateCommand_WhenUsingZeroArgAsCanvasHeight_ThenThrowException() throws Exception {

        thrownException.expect(IllegalArgumentException.class);
        thrownException.expectMessage("Value for argument number 2 whose value is 0 should be greater than zero");

        var commandLine = "C 20 0";
        commandValidator.validateCommand(commandLine);
    }
    
    //################################## TEST DECIMAL ARGS AS CANVAS DIMENSIONS ###########################################
    @Test
    public void testValidateCommand_WhenUsingDecimalArgAsX1_ThenThrowException() throws Exception {

        thrownException.expect(IllegalArgumentException.class);
        thrownException.expectMessage("Invalid value for argument number 1 whose value is 20.5");

        var commandLine = "C 20.5 4";
        commandValidator.validateCommand(commandLine);
    }

    @Test
    public void testValidateCommand_WhenUsingDecimalArgAsY1_ThenThrowException() throws Exception {

        thrownException.expect(IllegalArgumentException.class);
        thrownException.expectMessage("Invalid value for argument number 2 whose value is 4.5");

        var commandLine = "C 20 4.5";
        commandValidator.validateCommand(commandLine);
    }
    
}
