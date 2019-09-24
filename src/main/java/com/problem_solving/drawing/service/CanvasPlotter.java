package com.problem_solving.drawing.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.ArrayList;

import com.problem_solving.drawing.utils.constants.DrawingCharacter;
import com.problem_solving.drawing.utils.constants.Type;
import com.problem_solving.drawing.models.PlottingPoint;

public class CanvasPlotter extends Plotter {

    @Override
    public List<PlottingPoint> getPlottingPoints(List<String> args) {

        int w = Integer.parseInt(args.get(0)),
            h = Integer.parseInt(args.get(1));
        
        CompletableFuture<List<PlottingPoint>> horizontalSideDrawer = CompletableFuture.supplyAsync(() -> {
			
        	var horizontalPlottedPoints = new ArrayList<PlottingPoint>();
        	
        	for (var i = 0; i < w + 2; i++) {
                
        		horizontalPlottedPoints.add(new PlottingPoint(i, 0, Type.Canvas, DrawingCharacter.CANVAS_W));
        		horizontalPlottedPoints.add(new PlottingPoint(i, h + 1, Type.Canvas, DrawingCharacter.CANVAS_W));
            }
        	
        	return horizontalPlottedPoints;
		});
		
    	CompletableFuture<List<PlottingPoint>> verticalSideDrawer = CompletableFuture.supplyAsync(() -> {
			
    		var verticalPlottedPoints = new ArrayList<PlottingPoint>();
    		
    		for (var i = 1; i < h + 1; i++) {
    	         
    			verticalPlottedPoints.add(new PlottingPoint(0, i, Type.Canvas, DrawingCharacter.CANVAS_H));
    			verticalPlottedPoints.add(new PlottingPoint(w + 1, i, Type.Canvas, DrawingCharacter.CANVAS_H));
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
