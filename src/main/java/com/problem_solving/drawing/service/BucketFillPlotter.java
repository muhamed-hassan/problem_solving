package com.problem_solving.drawing.service;

import java.util.ArrayList;
import java.util.List;

import com.problem_solving.drawing.utils.constants.DrawingCharacter;
import com.problem_solving.drawing.utils.constants.Type;
import com.problem_solving.drawing.models.BucketFillPoint;
import com.problem_solving.drawing.models.PlottingPoint;

public class BucketFillPlotter extends Plotter {

    @Override
    public void plot(List<String> args, PlottingPoint[][] matrix) {

        int x = Integer.parseInt(args.get(0)),
            y = Integer.parseInt(args.get(1));
        char fillingCharacter = args.get(2).charAt(0);

        List<List<BucketFillPoint>> validPointsForBucketFilling = new ArrayList<>(0);
        int validPointsCursor = 0;

        //collecting valid points for bucket filling
        for (int row = 1; row < matrix.length - 1; row++) {

            validPointsForBucketFilling.add(validPointsCursor, new ArrayList<>(0));

            for (int column = 1; column < matrix[row].length - 1; column++) {
                PlottingPoint nextElement = matrix[row][column + 1];
                PlottingPoint currentElement = matrix[row][column];

                /**
                 * -- nonVacanct if currentElement eq 'X' then continue
                 */
                if (currentElement != null && currentElement.getCharacterToBeDrawn() == DrawingCharacter.X) {
                    continue;
                }

                /**
                 * collect points
                 */
                validPointsForBucketFilling.get(validPointsCursor).add(new BucketFillPoint(column, row));

                /**
                 * -- blocked: case1 if currentElement eq null and 
                 *                      nextElement eq 'X' and 
                 *                      nextElement.type eq Rectangle 
                 *                   -> then stop collecting points and move to the next row
                 *
                 * -- blocked: case2 if currentElement eq null and 
                 *                      nextElement eq 'X' and 
                 *                      nextElement.type ne Rectangle 
                 *                    -> then delete previous drawn characters then jump above the nextElement
                 */
                if (currentElement == null && nextElement != null && nextElement.getCharacterToBeDrawn() == DrawingCharacter.X) {

                    if (nextElement.getType().equals(Type.Rectangle) || nextElement.getType().equals(Type.Canvas)) {
                        /**
                         * -- blocked: case1 if nextElement.type eq Rectangle or
                         *                      hit the canvas border 
                         *                   -> then stop collecting points and move to the next row
                         */
                        break;
                    } else {
                        /**
                         * -- blocked: case2 if nextElement.type ne Rectangle
                         *                   -> then delete previous drawn characters then jump above the nextElement
                         */
                        validPointsForBucketFilling.get(validPointsCursor).clear();
                        column++;
                        continue;
                    }
                }
            }

            /**
             * -- blocked: case3 if row > 0 and
             *                      validPointsForBucketFilling.get(row-1) not empty and
             *                      validPointsForBucketFilling.get(row) empty and y > row 
             *                   -> then reset validPointsForBucketFilling
             */
            if (row > 0
                    && validPointsForBucketFilling.get(validPointsCursor++).isEmpty()
                    && y > row) {
                validPointsCursor = 0;
                validPointsForBucketFilling.clear();
            }
        }

        //plot valid points for drawing on the matrix
        validPointsForBucketFilling
                .stream()
                .flatMap(points -> points.stream())
                .forEach(point -> matrix[point.getY()][point.getX()] = new PlottingPoint(point.getX(), point.getY(), Type.BucketFilling, fillingCharacter));

    }

}
