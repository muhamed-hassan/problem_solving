package com.problem_solving.drawing.helpers;

public final class Coordinates {

    private final Integer x1;

    private final Integer y1;

    private final Integer x2;

    private final Integer y2;

    public Coordinates(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public Integer getX1() {
        return x1;
    }

    public Integer getY1() {
        return y1;
    }

    public Integer getX2() {
        return x2;
    }

    public Integer getY2() {
        return y2;
    }

}
