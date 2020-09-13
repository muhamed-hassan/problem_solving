package com.problem_solving.drawing.domain.models;

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
    public boolean equals(Object obj) {
        PlottingPoint other = (PlottingPoint) obj;
        return super.equals(obj)
            && type.equals(other.getType())
            && characterToBeDrawn == other.characterToBeDrawn;
    }

}
