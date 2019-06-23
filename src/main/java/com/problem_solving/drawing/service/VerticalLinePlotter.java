package com.problem_solving.drawing.service;

import java.util.List;
import java.util.ArrayList;

import com.problem_solving.drawing.utils.constants.DrawingCharacter;
import com.problem_solving.drawing.utils.constants.Type;
import com.problem_solving.drawing.models.PlottingPoint;
import com.problem_solving.drawing.models.Point;

public class VerticalLinePlotter extends LinePlotter {

    @Override
    public List<PlottingPoint> getPlottingPoints(List<String> args) {

        List<PlottingPoint> plottedPoints = new ArrayList<>();
                
        int x = Integer.parseInt(args.get(Point.X1)); // or 2 -> represents x1, or x2

        int y1 = Integer.parseInt(args.get(Point.Y1)),
            y2 = Integer.parseInt(args.get(Point.Y2));

        int startingPoint, endingPoint;
        if (y1 < y2) {
            
            startingPoint = y1;
            endingPoint = y2;
        } else {
            
            startingPoint = y2;
            endingPoint = y1;
        }

        for (int i = startingPoint; i <= endingPoint; i++) {
            
            plottedPoints.add(new PlottingPoint(i, x, Type.Line, DrawingCharacter.X));
        }
        
        return plottedPoints;
    }

}
