package com.problem_solving.drawing;

import com.problem_solving.drawing.interfaces.ConsoleHandler;

public final class Launcher {

    public static void main(String[] args) {
        var consoleHandler = new ConsoleHandler();
        consoleHandler.start();
    }

}
