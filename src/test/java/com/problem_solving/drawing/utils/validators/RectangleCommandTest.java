package com.problem_solving.drawing.utils.validators;

import org.junit.Test;

public class RectangleCommandTest extends BaseCommandValidatorTest {

    //######################################## TEST ARGS LENGTH ###########################################################
    @Test
    public void testValidateCommand_WhenUsingArgsGreaterThanAllowedArgs_ThenThrowException() throws Exception {

        thrownException.expect(IllegalArgumentException.class);
        thrownException.expectMessage("Unexpected number of command line args");

        String commandLine = "R 16 1 20 3 5";
        commandValidator.validateCommand(commandLine);
    }

    @Test
    public void testValidateCommand_WhenUsingArgsLessThanAllowedArgs_ThenThrowException() throws Exception {

        thrownException.expect(IllegalArgumentException.class);
        thrownException.expectMessage("Unexpected number of command line args");

        String commandLine = "R 16 1 20";
        commandValidator.validateCommand(commandLine);
    }

    //############################### TEST NON-NUMERIC ARGS AS RECTANGLE COORDINATES ######################################
    @Test
    public void testValidateCommand_WhenUsingNonNumericArgAsX1_ThenThrowException() throws Exception {

        thrownException.expect(IllegalArgumentException.class);
        thrownException.expectMessage("Invalid value for argument number 1 whose value is X");

        String commandLine = "R X 1 20 3";
        commandValidator.validateCommand(commandLine);
    }

    @Test
    public void testValidateCommand_WhenUsingNonNumericArgAsY1_ThenThrowException() throws Exception {

        thrownException.expect(IllegalArgumentException.class);
        thrownException.expectMessage("Invalid value for argument number 2 whose value is X");

        String commandLine = "R 16 X 20 3";
        commandValidator.validateCommand(commandLine);
    }

    @Test
    public void testValidateCommand_WhenUsingNonNumericArgAsX2_ThenThrowException() throws Exception {

        thrownException.expect(IllegalArgumentException.class);
        thrownException.expectMessage("Invalid value for argument number 3 whose value is X");

        String commandLine = "R 16 1 X 3";
        commandValidator.validateCommand(commandLine);
    }

    @Test
    public void testValidateCommand_WhenUsingNonNumericArgAsY2_ThenThrowException() throws Exception {

        thrownException.expect(IllegalArgumentException.class);
        thrownException.expectMessage("Invalid value for argument number 4 whose value is X");

        String commandLine = "R 16 1 20 X";
        commandValidator.validateCommand(commandLine);
    }

    //############################ TEST NEGATIVE INTEGERES ARGS AS RECTANGLE COORDINATES ##################################
    @Test
    public void testValidateCommand_WhenUsingNegativeIntegerArgAsX1_ThenThrowException() throws Exception {

        thrownException.expect(IllegalArgumentException.class);
        thrownException.expectMessage("Invalid value for argument number 1 whose value is -16");

        String commandLine = "R -16 1 20 3";
        commandValidator.validateCommand(commandLine);
    }

    @Test
    public void testValidateCommand_WhenUsingNegativeIntegerArgAsY1_ThenThrowException() throws Exception {

        thrownException.expect(IllegalArgumentException.class);
        thrownException.expectMessage("Invalid value for argument number 2 whose value is -1");

        String commandLine = "R 16 -1 20 3";
        commandValidator.validateCommand(commandLine);
    }

    @Test
    public void testValidateCommand_WhenUsingNegativeIntegerArgAsX2_ThenThrowException() throws Exception {

        thrownException.expect(IllegalArgumentException.class);
        thrownException.expectMessage("Invalid value for argument number 3 whose value is -20");

        String commandLine = "R 16 1 -20 3";
        commandValidator.validateCommand(commandLine);
    }

    @Test
    public void testValidateCommand_WhenUsingNegativeIntegerArgAsY2_ThenThrowException() throws Exception {

        thrownException.expect(IllegalArgumentException.class);
        thrownException.expectMessage("Invalid value for argument number 4 whose value is -3");

        String commandLine = "R 16 1 20 -3";
        commandValidator.validateCommand(commandLine);
    }
    
    //################################## TEST ZERO ARGS AS RECTANGLE COORDINATES ##########################################
    @Test
    public void testValidateCommand_WhenUsingZeroArgAsX1_ThenThrowException() throws Exception {

        thrownException.expect(IllegalArgumentException.class);
        thrownException.expectMessage("Value for argument number 1 whose value is 0 should be greater than zero");

        String commandLine = "R 0 1 20 3";
        commandValidator.validateCommand(commandLine);
    }

    @Test
    public void testValidateCommand_WhenUsingZeroArgAsY1_ThenThrowException() throws Exception {

        thrownException.expect(IllegalArgumentException.class);
        thrownException.expectMessage("Value for argument number 2 whose value is 0 should be greater than zero");

        String commandLine = "R 16 0 20 3";
        commandValidator.validateCommand(commandLine);
    }

    @Test
    public void testValidateCommand_WhenUsingZeroArgAsX2_ThenThrowException() throws Exception {

        thrownException.expect(IllegalArgumentException.class);
        thrownException.expectMessage("Value for argument number 3 whose value is 0 should be greater than zero");

        String commandLine = "R 16 1 0 3";
        commandValidator.validateCommand(commandLine);
    }

    @Test
    public void testValidateCommand_WhenUsingZeroArgAsY2_ThenThrowException() throws Exception {

        thrownException.expect(IllegalArgumentException.class);
        thrownException.expectMessage("Value for argument number 4 whose value is 0 should be greater than zero");

        String commandLine = "R 16 1 20 0";
        commandValidator.validateCommand(commandLine);
    }
    
    //############################## TEST ZERO ARGS AS RECTANGLE COORDINATES #####################################
    @Test
    public void testValidateCommand_WhenUsingDecimalArgAsX1_ThenThrowException() throws Exception {

        thrownException.expect(IllegalArgumentException.class);
        thrownException.expectMessage("Invalid value for argument number 1 whose value is 16.5");

        String commandLine = "R 16.5 1 20 3";
        commandValidator.validateCommand(commandLine);
    }

    @Test
    public void testValidateCommand_WhenUsingDecimalArgAsY1_ThenThrowException() throws Exception {

        thrownException.expect(IllegalArgumentException.class);
        thrownException.expectMessage("Invalid value for argument number 2 whose value is 1.5");

        String commandLine = "R 16 1.5 20 3";
        commandValidator.validateCommand(commandLine);
    }

    @Test
    public void testValidateCommand_WhenUsingDecimalArgAsX2_ThenThrowException() throws Exception {

        thrownException.expect(IllegalArgumentException.class);
        thrownException.expectMessage("Invalid value for argument number 3 whose value is 20.5");

        String commandLine = "R 16 1 20.5 3";
        commandValidator.validateCommand(commandLine);
    }

    @Test
    public void testValidateCommand_WhenUsingDecimalArgAsY2_ThenThrowException() throws Exception {

        thrownException.expect(IllegalArgumentException.class);
        thrownException.expectMessage("Invalid value for argument number 4 whose value is 3.5");

        String commandLine = "R 16 1 20 3.5";
        commandValidator.validateCommand(commandLine);
    }
    
}
