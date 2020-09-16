package com.problem_solving.drawing.domain.models;

import java.util.Objects;

public class Point {

    public static final int X1 = 0;
    public static final int X2 = 2;
    public static final int Y1 = 1;
    public static final int Y2 = 3;

    private final int x; //x = -1 in case of canvas type only
    private final int y; //y = -1 in case of canvas type only

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Point other = (Point) obj;
        return x != other.x || y != other.y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

}
