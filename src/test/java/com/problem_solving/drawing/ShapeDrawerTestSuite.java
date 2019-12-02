package com.problem_solving.drawing;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.problem_solving.drawing.service.BucketFillPlotterTest;
import com.problem_solving.drawing.service.CanvasPlotterTest;
import com.problem_solving.drawing.service.HorizontalLinePlotterTest;
import com.problem_solving.drawing.service.RectanglePlotterTest;
import com.problem_solving.drawing.service.VerticalLinePlotterTest;
import com.problem_solving.drawing.utils.validators.BucketFillingCommandTest;
import com.problem_solving.drawing.utils.validators.CanvasCommandTest;
import com.problem_solving.drawing.utils.validators.CommandValidatorTest;
import com.problem_solving.drawing.utils.validators.HorizontalLineCommandTest;
import com.problem_solving.drawing.utils.validators.RectangleCommandTest;
import com.problem_solving.drawing.utils.validators.VerticalLineCommandTest;

@RunWith(Suite.class)
@SuiteClasses({BucketFillPlotterTest.class, CanvasPlotterTest.class,
				HorizontalLinePlotterTest.class, RectanglePlotterTest.class, 
				VerticalLinePlotterTest.class, BucketFillingCommandTest.class,
				CanvasCommandTest.class, CommandValidatorTest.class,
				HorizontalLineCommandTest.class, RectangleCommandTest.class,
				VerticalLineCommandTest.class})
public class ShapeDrawerTestSuite {

}
