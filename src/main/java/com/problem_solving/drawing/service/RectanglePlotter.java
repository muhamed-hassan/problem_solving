package com.problem_solving.drawing.service;

import java.util.List;
import java.util.ArrayList;

import com.problem_solving.drawing.utils.constants.DrawingCharacter;
import com.problem_solving.drawing.utils.constants.Type;
import com.problem_solving.drawing.models.PlottingPoint;
import com.problem_solving.drawing.models.Point;

public class RectanglePlotter extends Plotter {

    @Override
    public List<PlottingPoint> getPlottingPoints(List<String> args) {

        var plottedPoints = new ArrayList<PlottingPoint>();
        
        int x1 = Integer.parseInt(args.get(Point.X1)),
            y1 = Integer.parseInt(args.get(Point.Y1)),

            x2 = Integer.parseInt(args.get(Point.X2)),
            y2 = Integer.parseInt(args.get(Point.Y2));

        // drawing horizontal sides
        for (var i = x1; i <= x2; i++) {
            
            plottedPoints.add(new PlottingPoint(i, y1, Type.Rectangle, DrawingCharacter.X));
            plottedPoints.add(new PlottingPoint(i, y2, Type.Rectangle, DrawingCharacter.X));
        }

        // drawing vertical sides
        for (var i = y1 + 1; i < y2; i++) {
         
            plottedPoints.add(new PlottingPoint(x1, i, Type.Rectangle, DrawingCharacter.X));
            plottedPoints.add(new PlottingPoint(x2, i, Type.Rectangle, DrawingCharacter.X));
        }
        
        return plottedPoints;
    }

}
