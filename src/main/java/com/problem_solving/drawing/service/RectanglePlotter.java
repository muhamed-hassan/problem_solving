package com.problem_solving.drawing.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.ArrayList;

import com.problem_solving.drawing.utils.constants.DrawingCharacter;
import com.problem_solving.drawing.utils.constants.Type;
import com.problem_solving.drawing.models.PlottingPoint;
import com.problem_solving.drawing.models.Point;

public class RectanglePlotter extends Plotter {

    @Override
    public List<PlottingPoint> getPlottingPoints(List<String> args) {
        
        int x1 = Integer.parseInt(args.get(Point.X1)),
            y1 = Integer.parseInt(args.get(Point.Y1)),

            x2 = Integer.parseInt(args.get(Point.X2)),
            y2 = Integer.parseInt(args.get(Point.Y2));
        
        CompletableFuture<List<PlottingPoint>> horizontalSideDrawer = CompletableFuture.supplyAsync(() -> {
			
        	var horizontalPlottedPoints = new ArrayList<PlottingPoint>();
        	
        	for (var i = x1; i <= x2; i++) {
                
        		horizontalPlottedPoints.add(new PlottingPoint(i, y1, Type.Rectangle, DrawingCharacter.X));
        		horizontalPlottedPoints.add(new PlottingPoint(i, y2, Type.Rectangle, DrawingCharacter.X));
            }
        	
        	return horizontalPlottedPoints;
		});
		
    	CompletableFuture<List<PlottingPoint>> verticalSideDrawer = CompletableFuture.supplyAsync(() -> {
			
    		var verticalPlottedPoints = new ArrayList<PlottingPoint>();
    		
    		for (var i = y1 + 1; i < y2; i++) {
    	         
    			verticalPlottedPoints.add(new PlottingPoint(x1, i, Type.Rectangle, DrawingCharacter.X));
    			verticalPlottedPoints.add(new PlottingPoint(x2, i, Type.Rectangle, DrawingCharacter.X));
            }
    		
    		return verticalPlottedPoints;
		});
		
    	List<CompletableFuture<List<PlottingPoint>>> futures = List.of(horizontalSideDrawer, verticalSideDrawer);
    	CompletableFuture<Void> combinedFutures = CompletableFuture.allOf(futures.toArray(new CompletableFuture[futures.size()]));
            	
    	List<PlottingPoint> plottedPoints = null;
		try {
			
			plottedPoints = combinedFutures.thenApply(voidType -> futures.stream()
																			.map(CompletableFuture::join)
																			.flatMap(List::stream)
																			.collect(Collectors.toList()))
											.get();

		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} 
    	    	
        return plottedPoints; 
    }
}
