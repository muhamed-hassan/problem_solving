package com.problem_solving.drawing.utils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class CommandUtils {

    private CommandUtils() {}

    public static List<String> extractArgs(String commandLine) {
        return Stream
            .of(commandLine.substring(1).split("\\s"))
            .filter(arg -> !arg.isEmpty())
            .collect(Collectors.toList());
    }

    public static char extractCommand(String commandLine) {
        return commandLine.charAt(0);
    }

}
