package com.problem_solving.drawing.models;

import com.problem_solving.drawing.utils.constants.Type;

public class PlottingPoint extends Point {

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
