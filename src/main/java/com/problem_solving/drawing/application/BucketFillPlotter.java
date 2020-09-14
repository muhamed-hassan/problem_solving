package com.problem_solving.drawing.application;

import static com.problem_solving.drawing.domain.models.Type.BucketFilling;
import static com.problem_solving.drawing.domain.models.Type.Canvas;
import static com.problem_solving.drawing.domain.models.Type.Rectangle;

import java.util.ArrayList;
import java.util.List;

import com.problem_solving.drawing.domain.models.BucketFillPoint;
import com.problem_solving.drawing.domain.models.PlottingPoint;

public class BucketFillPlotter extends FillerPlotter {

    @Override
    public List<PlottingPoint> getPlottingPoints(List<String> args, PlottingPoint[][] matrix) {
        var plottedPoints = new ArrayList<PlottingPoint>();

        var y = Integer.parseInt(args.get(1));
        var fillingCharacter = args.get(2).charAt(0);

        var validPointsForBucketFilling = new ArrayList<ArrayList<BucketFillPoint>>(0);
        var validPointsCursor = 0;

        //collecting valid points for bucket filling
        for (var row = 1; row < matrix.length - 1; row++) {
            validPointsForBucketFilling.add(validPointsCursor, new ArrayList<>(0));

            for (var column = 1; column < matrix[row].length - 1; column++) {
                var nextElement = matrix[row][column + 1];
                var currentElement = matrix[row][column];

                /**
                 * -- nonVacanct if currentElement eq 'X' then continue
                 */
                if (currentElement != null
                    && currentElement.getCharacterToBeDrawn() == PlottingPoint.X)
                    continue;

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
                if (currentElement == null
                    && nextElement != null
                    && nextElement.getCharacterToBeDrawn() == PlottingPoint.X) {

                    if (nextElement.getType().equals(Rectangle)
                        || nextElement.getType().equals(Canvas)) {
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
        for (var line : validPointsForBucketFilling) {
            for (var point : line) {
                plottedPoints.add(new PlottingPoint(point.getX(), point.getY(), BucketFilling, fillingCharacter));
            }
        }

        return plottedPoints;
    }

}
