package com.problem_solving.drawing.service;

import java.util.List;
import java.util.ArrayList;

import com.problem_solving.drawing.utils.constants.DrawingCharacter;
import com.problem_solving.drawing.utils.constants.Type;
import com.problem_solving.drawing.models.PlottingPoint;
import com.problem_solving.drawing.models.Point;

public class HorizontalLinePlotter extends LinePlotter {

    @Override
    public List<PlottingPoint> getPlottingPoints(List<String> args) {

        List<PlottingPoint> plottedPoints = new ArrayList<>();
        
        int y = Integer.parseInt(args.get(Point.Y1)); // y1, or y2 there is no difference

        int x1 = Integer.parseInt(args.get(Point.X1)),
            x2 = Integer.parseInt(args.get(Point.X2));

        int startingPoint, endingPoint;
        if (x1 < x2) {
            
            startingPoint = x1;
            endingPoint = x2;
        } else {
            
            startingPoint = x2;
            endingPoint = x1;
        }

        for (int i = startingPoint; i <= endingPoint; i++) {
            
            plottedPoints.add(new PlottingPoint(i, y, Type.Line, DrawingCharacter.X));
        }
        
        return plottedPoints;
    }

}
