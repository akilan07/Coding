package com.vmware.areacalc;

import com.vmware.areacalc.circle.CircleArea;
import com.vmware.areacalc.rectangle.RectangleArea;
import com.vmware.areacalc.square.SquareArea;

public class AreaHandler {

	private static final String CIRCLE = "circle";
	private static final String SQUARE = "square";
	private static final String RECTANGLE = "rectangle";
	
	public Area getArea(String shape) {
		if(shape.equalsIgnoreCase(CIRCLE)) {
			return new CircleArea();
		} else if(shape.equalsIgnoreCase(RECTANGLE)){
			return new RectangleArea();
		} else if(shape.equalsIgnoreCase(SQUARE)) {
			return new SquareArea();
		}
		return null;
	}
}
