package com.problem_solving.drawing.models;

public class Point {

    private final int x; //x = -1 in case of canvas type only
    private final int y; //y = -1 in case of canvas type only
    
    public static final int X1 = 0;
    public static final int X2 = 2;
    public static final int Y1 = 1;
    public static final int Y2 = 3;

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
        final int prime = 31;
        int result = 1;
        result = prime * result + x;
        result = prime * result + y;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = true;
        if (this == obj) {
            result = true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            result = false;
        }
        Point other = (Point) obj;
        if (x != other.x || y != other.y) {
            result = false;
        }
        return result;
    }

    @Override
    public String toString() {        
        return "(" + x + ", " + y + ")";
    }

}
