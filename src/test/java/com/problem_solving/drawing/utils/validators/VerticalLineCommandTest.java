package com.problem_solving.drawing.utils.validators;

import org.junit.Test;

public class VerticalLineCommandTest extends BaseCommandValidatorTest {

    //######################################## TEST ARGS LENGTH ###########################################################
    @Test
    public void testValidateCommand_WhenUsingArgsGreaterThanAllowedArgs_ThenThrowException() throws Exception {

        thrownException.expect(IllegalArgumentException.class);
        thrownException.expectMessage("Unexpected number of command line args");

        var commandLine = "L 6 3 6 4 8";
        commandValidator.validateCommand(commandLine);
    }

    @Test
    public void testValidateCommand_WhenUsingArgsLessThanAllowedArgs_ThenThrowException() throws Exception {

        thrownException.expect(IllegalArgumentException.class);
        thrownException.expectMessage("Unexpected number of command line args");

        var commandLine = "L 6 3 6";
        commandValidator.validateCommand(commandLine);
    }

    //############################# TEST NON-NUMERIC ARGS AS VERTICAL LINE COORDINATES ####################################
    @Test
    public void testValidateCommand_WhenUsingNonNumericArgAsX1_ThenThrowException() throws Exception {

        thrownException.expect(IllegalArgumentException.class);
        thrownException.expectMessage("Invalid value for argument number 1 whose value is X");

        var commandLine = "L X 3 6 4";
        commandValidator.validateCommand(commandLine);
    }

    @Test
    public void testValidateCommand_WhenUsingNonNumericArgAsY1_ThenThrowException() throws Exception {

        thrownException.expect(IllegalArgumentException.class);
        thrownException.expectMessage("Invalid value for argument number 2 whose value is X");

        var commandLine = "L 6 X 6 4";
        commandValidator.validateCommand(commandLine);
    }

    @Test
    public void testValidateCommand_WhenUsingNonNumericArgAsX2_ThenThrowException() throws Exception {

        thrownException.expect(IllegalArgumentException.class);
        thrownException.expectMessage("Invalid value for argument number 3 whose value is X");

        var commandLine = "L 6 3 X 4";
        commandValidator.validateCommand(commandLine);
    }

    @Test
    public void testValidateCommand_WhenUsingNonNumericArgAsY2_ThenThrowException() throws Exception {

        thrownException.expect(IllegalArgumentException.class);
        thrownException.expectMessage("Invalid value for argument number 4 whose value is X");

        var commandLine = "L 6 3 6 X";
        commandValidator.validateCommand(commandLine);
    }

    //############################# TEST NEGATIVE INTEGERES ARGS AS VERTICAL LINE COORDINATES ####################################
    @Test
    public void testValidateCommand_WhenUsingNegativeIntegerArgAsX1_ThenThrowException() throws Exception {

        thrownException.expect(IllegalArgumentException.class);
        thrownException.expectMessage("Invalid value for argument number 1 whose value is -6");

        var commandLine = "L -6 3 6 4";
        commandValidator.validateCommand(commandLine);
    }

    @Test
    public void testValidateCommand_WhenUsingNegativeIntegerArgAsY1_ThenThrowException() throws Exception {

        thrownException.expect(IllegalArgumentException.class);
        thrownException.expectMessage("Invalid value for argument number 2 whose value is -3");

        var commandLine = "L 6 -3 6 4";
        commandValidator.validateCommand(commandLine);
    }

    @Test
    public void testValidateCommand_WhenUsingNegativeIntegerArgAsX2_ThenThrowException() throws Exception {

        thrownException.expect(IllegalArgumentException.class);
        thrownException.expectMessage("Invalid value for argument number 3 whose value is -6");

        var commandLine = "L 6 3 -6 4";
        commandValidator.validateCommand(commandLine);
    }

    @Test
    public void testValidateCommand_WhenUsingNegativeIntegerArgAsY2_ThenThrowException() throws Exception {

        thrownException.expect(IllegalArgumentException.class);
        thrownException.expectMessage("Invalid value for argument number 4 whose value is -4");

        var commandLine = "L 6 3 6 -4";
        commandValidator.validateCommand(commandLine);
    }

    //############################# TEST ZERO ARGS AS VERTICAL LINE COORDINATES ####################################
    @Test
    public void testValidateCommand_WhenUsingZeroArgAsX1_ThenThrowException() throws Exception {

        thrownException.expect(IllegalArgumentException.class);
        thrownException.expectMessage("Value for argument number 1 whose value is 0 should be greater than zero");

        var commandLine = "L 0 3 6 4";
        commandValidator.validateCommand(commandLine);
    }

    @Test
    public void testValidateCommand_WhenUsingZeroArgAsY1_ThenThrowException() throws Exception {

        thrownException.expect(IllegalArgumentException.class);
        thrownException.expectMessage("Value for argument number 2 whose value is 0 should be greater than zero");

        var commandLine = "L 6 0 6 4";
        commandValidator.validateCommand(commandLine);
    }

    @Test
    public void testValidateCommand_WhenUsingZeroArgAsX2_ThenThrowException() throws Exception {

        thrownException.expect(IllegalArgumentException.class);
        thrownException.expectMessage("Value for argument number 3 whose value is 0 should be greater than zero");

        var commandLine = "L 6 3 0 4";
        commandValidator.validateCommand(commandLine);
    }

    @Test
    public void testValidateCommand_WhenUsingZeroArgAsY2_ThenThrowException() throws Exception {

        thrownException.expect(IllegalArgumentException.class);
        thrownException.expectMessage("Value for argument number 4 whose value is 0 should be greater than zero");

        var commandLine = "L 6 3 6 0";
        commandValidator.validateCommand(commandLine);
    }
    
    //############################## TEST ZERO ARGS AS VERTICAL LINE COORDINATES #####################################
    @Test
    public void testValidateCommand_WhenUsingDecimalArgAsX1_ThenThrowException() throws Exception {

        thrownException.expect(IllegalArgumentException.class);
        thrownException.expectMessage("Invalid value for argument number 1 whose value is 1.5");

        var commandLine = "L 1.5 3 6 4";
        commandValidator.validateCommand(commandLine);
    }

    @Test
    public void testValidateCommand_WhenUsingDecimalArgAsY1_ThenThrowException() throws Exception {

        thrownException.expect(IllegalArgumentException.class);
        thrownException.expectMessage("Invalid value for argument number 2 whose value is 2.5");

        var commandLine = "L 6 2.5 6 4";
        commandValidator.validateCommand(commandLine);
    }

    @Test
    public void testValidateCommand_WhenUsingDecimalArgAsX2_ThenThrowException() throws Exception {

        thrownException.expect(IllegalArgumentException.class);
        thrownException.expectMessage("Invalid value for argument number 3 whose value is 6.5");

        var commandLine = "L 6 3 6.5 4";
        commandValidator.validateCommand(commandLine);
    }

    @Test
    public void testValidateCommand_WhenUsingDecimalArgAsY2_ThenThrowException() throws Exception {

        thrownException.expect(IllegalArgumentException.class);
        thrownException.expectMessage("Invalid value for argument number 4 whose value is 4.5");

        var commandLine = "L 6 3 6 4.5";
        commandValidator.validateCommand(commandLine);
    }
    
}
