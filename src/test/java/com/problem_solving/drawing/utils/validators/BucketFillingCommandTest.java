package com.problem_solving.drawing.utils.validators;

import org.junit.Test;

public class BucketFillingCommandTest extends BaseCommandValidatorTest {

    //######################################## TEST ARGS LENGTH ###########################################################
    @Test
    public void testValidateCommand_WhenUsingArgsGreaterThanAllowedArgs_ThenThrowException() throws Exception {

        thrownException.expect(IllegalArgumentException.class);
        thrownException.expectMessage("Unexpected number of command line args");

        var commandLine = "B 10 3 o 1";
        commandValidator.validateCommand(commandLine);
    }

    @Test
    public void testValidateCommand_WhenUsingArgsLessThanAllowedArgs_ThenThrowException() throws Exception {

        thrownException.expect(IllegalArgumentException.class);
        thrownException.expectMessage("Unexpected number of command line args");

        var commandLine = "B 10 3";
        commandValidator.validateCommand(commandLine);
    }

    //#################################### TEST NON-NUMERIC ARGS AS COORDINATES ###########################################
    @Test
    public void testValidateCommand_WhenUsingNonNumericArgAsPointX_ThenThrowException() throws Exception {

        thrownException.expect(IllegalArgumentException.class);
        thrownException.expectMessage("Invalid value for argument number 1 whose value is X");

        var commandLine = "B X 3 o";
        commandValidator.validateCommand(commandLine);
    }

    @Test
    public void testValidateCommand_WhenUsingNonNumericArgAsPointY_ThenThrowException() throws Exception {

        thrownException.expect(IllegalArgumentException.class);
        thrownException.expectMessage("Invalid value for argument number 2 whose value is X");

        var commandLine = "B 10 X o";
        commandValidator.validateCommand(commandLine);
    }

    //#################################### TEST NEGATIVE INTEGERES ARGS AS COORDINATES ####################################
    @Test
    public void testValidateCommand_WhenUsingNegativeIntegerArgAsPointX_ThenThrowException() throws Exception {

        thrownException.expect(IllegalArgumentException.class);
        thrownException.expectMessage("Invalid value for argument number 1 whose value is -10");

        var commandLine = "B -10 3 o";
        commandValidator.validateCommand(commandLine);
    }

    @Test
    public void testValidateCommand_WhenUsingNegativeIntegerArgAsPointY_ThenThrowException() throws Exception {

        thrownException.expect(IllegalArgumentException.class);
        thrownException.expectMessage("Invalid value for argument number 2 whose value is -3");

        var commandLine = "B 10 -3 o";
        commandValidator.validateCommand(commandLine);
    }
    
    //########################################### TEST ZERO ARGS AS COORDINATES ###########################################
    @Test
    public void testValidateCommand_WhenUsingZeroArgAsPointX_ThenThrowException() throws Exception {

        thrownException.expect(IllegalArgumentException.class);
        thrownException.expectMessage("Value for argument number 1 whose value is 0 should be greater than zero");

        var commandLine = "B 0 3 o";
        commandValidator.validateCommand(commandLine);
    }

    @Test
    public void testValidateCommand_WhenUsingZeroArgAsPointY_ThenThrowException() throws Exception {

        thrownException.expect(IllegalArgumentException.class);
        thrownException.expectMessage("Value for argument number 2 whose value is 0 should be greater than zero");

        var commandLine = "B 10 0 o";
        commandValidator.validateCommand(commandLine);
    }
    
    //##################################### TEST DECIMAL ARGS AS COORDINATES ##############################################
    @Test
    public void testValidateCommand_WhenUsingDecimalArgAsX1_ThenThrowException() throws Exception {

        thrownException.expect(IllegalArgumentException.class);
        thrownException.expectMessage("Invalid value for argument number 1 whose value is 10.5");

        var commandLine = "B 10.5 3 o";
        commandValidator.validateCommand(commandLine);
    }

    @Test
    public void testValidateCommand_WhenUsingDecimalArgAsY1_ThenThrowException() throws Exception {

        thrownException.expect(IllegalArgumentException.class);
        thrownException.expectMessage("Invalid value for argument number 2 whose value is 3.5");

        var commandLine = "B 10 3.5 o";
        commandValidator.validateCommand(commandLine);
    }
    
}
