package com.problem_solving.drawing.domain.models;

import java.util.Objects;

public class PlottingPoint extends Point {

    public static final char X = 'X';
    public static final char CANVAS_W = '-';
    public static final char CANVAS_H = '|';

    private final Type type;
    private final char characterToBeDrawn;

    public PlottingPoint(int x, int y, Type type, char characterToBeDrawn) {
        super(x, y);
        this.type = type;
        this.characterToBeDrawn = characterToBeDrawn;
    }

    public Type getType() {
        return type;
    }

    public char getCharacterToBeDrawn() {
        return characterToBeDrawn;
    }

    @Override
    public boolean equals(Object other) {
        PlottingPoint that = (PlottingPoint) other;
        return super.equals(other)
            && Objects.equals(type, that.type)
            && Objects.equals(characterToBeDrawn, that.characterToBeDrawn);
    }

}
