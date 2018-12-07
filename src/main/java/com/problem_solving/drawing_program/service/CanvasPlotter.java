package com.problem_solving.drawing_program.service;

import java.util.List;

import com.problem_solving.drawing_program.utils.constants.DrawingCharacter;
import com.problem_solving.drawing_program.utils.constants.Type;
import com.problem_solving.drawing_program.models.PlottingPoint;

public class CanvasPlotter extends Plotter {

    @Override
    public void plot(List<String> args, PlottingPoint[][] matrix) {

        int w = Integer.parseInt(args.get(0)),
                h = Integer.parseInt(args.get(1));

        // fill width
        for (int i = 0; i < w + 2; i++) {
            matrix[0][i] = new PlottingPoint(-1, -1, Type.Canvas, DrawingCharacter.CANVAS_W);
            matrix[h + 1][i] = new PlottingPoint(-1, -1, Type.Canvas, DrawingCharacter.CANVAS_W);
        }

        // fill height
        for (int i = 1; i < h + 1; i++) {
            matrix[i][0] = new PlottingPoint(-1, -1, Type.Canvas, DrawingCharacter.CANVAS_H);
            matrix[i][w + 1] = new PlottingPoint(-1, -1, Type.Canvas, DrawingCharacter.CANVAS_H);
        }

    }

}
