package com.problem_solving.drawing.service;

import java.util.List;
import java.util.ArrayList;

import com.problem_solving.drawing.utils.constants.DrawingCharacter;
import com.problem_solving.drawing.utils.constants.Type;
import com.problem_solving.drawing.models.PlottingPoint;

public class CanvasPlotter extends Plotter {

    @Override
    public List<PlottingPoint> getPlottingPoints(List<String> args) {

        List<PlottingPoint> plottedPoints = new ArrayList<>();
        
        int w = Integer.parseInt(args.get(0)),
            h = Integer.parseInt(args.get(1));

        // fill width
        for (int i = 0; i < w + 2; i++) {
            
            plottedPoints.add(new PlottingPoint(i, 0, Type.Canvas, DrawingCharacter.CANVAS_W));
            plottedPoints.add(new PlottingPoint(i, h + 1, Type.Canvas, DrawingCharacter.CANVAS_W));
        }

        // fill height
        for (int i = 1; i < h + 1; i++) {
            
            plottedPoints.add(new PlottingPoint(0, i, Type.Canvas, DrawingCharacter.CANVAS_H));
            plottedPoints.add(new PlottingPoint(w + 1, i, Type.Canvas, DrawingCharacter.CANVAS_H));
        }
        
        return plottedPoints;
    }

}
