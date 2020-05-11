package com.problem_solving.drawing.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

import com.problem_solving.drawing.models.PlottingPoint;

public abstract class FourSidedPlotter extends Plotter {

	public abstract List<PlottingPoint> getPlottingPoints(List<String> args);

	protected List<PlottingPoint> combineAndGetPlottingPoints(CompletableFuture<List<PlottingPoint>> horizontalSideDrawer, 
																CompletableFuture<List<PlottingPoint>> verticalSideDrawer) {
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
