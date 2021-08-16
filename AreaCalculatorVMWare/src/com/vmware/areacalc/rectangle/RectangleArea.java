package com.vmware.areacalc.rectangle;

import com.vmware.areacalc.Area;

public class RectangleArea implements Area {

	@Override
	public int area(int... param) {
		
		return (param[0]*param[1]);
	}

}
