package com.problem_solving.drawing.utils.validators;

import org.junit.Test;

public class HorizontalLineCommandTest extends BaseCommandValidatorTest {

    //######################################## TEST ARGS LENGTH ###########################################################
    @Test
    public void testValidateCommand_WhenUsingArgsGreaterThanAllowedArgs_ThenThrowException() throws Exception {

        thrownException.expect(IllegalArgumentException.class);
        thrownException.expectMessage("Unexpected number of command line args");

        var commandLine = "L 1 2 6 2 1";
        commandValidator.validateCommand(commandLine);
    }

    @Test
    public void testValidateCommand_WhenUsingArgsLessThanAllowedArgs_ThenThrowException() throws Exception {

        thrownException.expect(IllegalArgumentException.class);
        thrownException.expectMessage("Unexpected number of command line args");

        var commandLine = "L 1 2 6";
        commandValidator.validateCommand(commandLine);
    }

    //############################ TEST NON-NUMERIC ARGS AS HORIZONTAL LINE COORDINATES ###################################
    @Test
    public void testValidateCommand_WhenUsingNonNumericArgAsX1_ThenThrowException() throws Exception {

        thrownException.expect(IllegalArgumentException.class);
        thrownException.expectMessage("Invalid value for argument number 1 whose value is X");

        var commandLine = "L X 2 6 2";
        commandValidator.validateCommand(commandLine);
    }

    @Test
    public void testValidateCommand_WhenUsingNonNumericArgAsY1_ThenThrowException() throws Exception {

        thrownException.expect(IllegalArgumentException.class);
        thrownException.expectMessage("Invalid value for argument number 2 whose value is X");

        var commandLine = "L 1 X 6 2";
        commandValidator.validateCommand(commandLine);
    }

    @Test
    public void testValidateCommand_WhenUsingNonNumericArgAsX2_ThenThrowException() throws Exception {

        thrownException.expect(IllegalArgumentException.class);
        thrownException.expectMessage("Invalid value for argument number 3 whose value is X");

        var commandLine = "L 1 2 X 2";
        commandValidator.validateCommand(commandLine);
    }

    @Test
    public void testValidateCommand_WhenUsingNonNumericArgAsY2_ThenThrowException() throws Exception {

        thrownException.expect(IllegalArgumentException.class);
        thrownException.expectMessage("Invalid value for argument number 4 whose value is X");

        var commandLine = "L 1 2 6 X";
        commandValidator.validateCommand(commandLine);
    }

    //############################# TEST NEGATIVE INTEGERES ARGS AS HORIZONTAL LINE COORDINATES ####################################
    @Test
    public void testValidateCommand_WhenUsingNegativeIntegerArgAsX1_ThenThrowException() throws Exception {

        thrownException.expect(IllegalArgumentException.class);
        thrownException.expectMessage("Invalid value for argument number 1 whose value is -1");

        var commandLine = "L -1 2 6 2";
        commandValidator.validateCommand(commandLine);
    }

    @Test
    public void testValidateCommand_WhenUsingNegativeIntegerArgAsY1_ThenThrowException() throws Exception {

        thrownException.expect(IllegalArgumentException.class);
        thrownException.expectMessage("Invalid value for argument number 2 whose value is -2");

        var commandLine = "L 1 -2 6 2";
        commandValidator.validateCommand(commandLine);
    }

    @Test
    public void testValidateCommand_WhenUsingNegativeIntegerArgAsX2_ThenThrowException() throws Exception {

        thrownException.expect(IllegalArgumentException.class);
        thrownException.expectMessage("Invalid value for argument number 3 whose value is -6");

        var commandLine = "L 1 2 -6 2";
        commandValidator.validateCommand(commandLine);
    }

    @Test
    public void testValidateCommand_WhenUsingNegativeIntegerArgAsY2_ThenThrowException() throws Exception {

        thrownException.expect(IllegalArgumentException.class);
        thrownException.expectMessage("Invalid value for argument number 4 whose value is -2");

        var commandLine = "L 1 2 6 -2";
        commandValidator.validateCommand(commandLine);
    }
    
    //############################# TEST ZERO ARGS AS HORIZONTAL LINE COORDINATES ####################################
    @Test
    public void testValidateCommand_WhenUsingZeroArgAsX1_ThenThrowException() throws Exception {

        thrownException.expect(IllegalArgumentException.class);
        thrownException.expectMessage("Value for argument number 1 whose value is 0 should be greater than zero");

        var commandLine = "L 0 2 6 2";
        commandValidator.validateCommand(commandLine);
    }

    @Test
    public void testValidateCommand_WhenUsingZeroArgAsY1_ThenThrowException() throws Exception {

        thrownException.expect(IllegalArgumentException.class);
        thrownException.expectMessage("Value for argument number 2 whose value is 0 should be greater than zero");

        var commandLine = "L 1 0 6 2";
        commandValidator.validateCommand(commandLine);
    }

    @Test
    public void testValidateCommand_WhenUsingZeroArgAsX2_ThenThrowException() throws Exception {

        thrownException.expect(IllegalArgumentException.class);
        thrownException.expectMessage("Value for argument number 3 whose value is 0 should be greater than zero");

        var commandLine = "L 1 2 0 2";
        commandValidator.validateCommand(commandLine);
    }

    @Test
    public void testValidateCommand_WhenUsingZeroArgAsY2_ThenThrowException() throws Exception {

        thrownException.expect(IllegalArgumentException.class);
        thrownException.expectMessage("Value for argument number 4 whose value is 0 should be greater than zero");

        var commandLine = "L 1 2 6 0";
        commandValidator.validateCommand(commandLine);
    }
    
    //############################# TEST ZERO ARGS AS HORIZONTAL LINE COORDINATES ####################################
    @Test
    public void testValidateCommand_WhenUsingDecimalArgAsX1_ThenThrowException() throws Exception {

        thrownException.expect(IllegalArgumentException.class);
        thrownException.expectMessage("Invalid value for argument number 1 whose value is 1.5");

        var commandLine = "L 1.5 2 6 2";
        commandValidator.validateCommand(commandLine);
    }

    @Test
    public void testValidateCommand_WhenUsingDecimalArgAsY1_ThenThrowException() throws Exception {

        thrownException.expect(IllegalArgumentException.class);
        thrownException.expectMessage("Invalid value for argument number 2 whose value is 2.5");

        var commandLine = "L 1 2.5 6 2";
        commandValidator.validateCommand(commandLine);
    }

    @Test
    public void testValidateCommand_WhenUsingDecimalArgAsX2_ThenThrowException() throws Exception {

        thrownException.expect(IllegalArgumentException.class);
        thrownException.expectMessage("Invalid value for argument number 3 whose value is 6.5");

        var commandLine = "L 1 2 6.5 2";
        commandValidator.validateCommand(commandLine);
    }

    @Test
    public void testValidateCommand_WhenUsingDecimalArgAsY2_ThenThrowException() throws Exception {

        thrownException.expect(IllegalArgumentException.class);
        thrownException.expectMessage("Invalid value for argument number 4 whose value is 2.5");

        var commandLine = "L 1 2 6 2.5";
        commandValidator.validateCommand(commandLine);
    }
    
}
