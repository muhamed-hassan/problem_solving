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

        List<PlottingPoint> plottedPoints = new ArrayList<>();
        
        int x1 = Integer.parseInt(args.get(Point.X1));
        int y1 = Integer.parseInt(args.get(Point.Y1));

        int x2 = Integer.parseInt(args.get(Point.X2));
        int y2 = Integer.parseInt(args.get(Point.Y2));

        for (int i = x1; i <= x2; i++) {
            
            plottedPoints.add(new PlottingPoint(y1, i, Type.Rectangle, DrawingCharacter.X));
            plottedPoints.add(new PlottingPoint(y2, i, Type.Rectangle, DrawingCharacter.X));
        }

        for (int i = y1 + 1; i < y2; i++) {
         
            plottedPoints.add(new PlottingPoint(i, x1, Type.Rectangle, DrawingCharacter.X));
            plottedPoints.add(new PlottingPoint(i, x2, Type.Rectangle, DrawingCharacter.X));
        }
        
        return plottedPoints;
    }

}
