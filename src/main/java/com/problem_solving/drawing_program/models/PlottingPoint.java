package com.problem_solving.drawing_program.models;

import com.problem_solving.drawing_program.utils.constants.Type;

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
        boolean result = super.equals(obj);

        PlottingPoint other = (PlottingPoint) obj;
        if (!type.equals(other.getType())) {
            result = false;
        }
        if (characterToBeDrawn != other.characterToBeDrawn) {
            result = false;
        }

        return result;
    }

}
