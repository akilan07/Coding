package com.vmware.areacalc.circle;

import com.vmware.areacalc.Area;

public class CircleArea implements Area{

	@Override
	public int area(int... param) {
		
		return (22*param[0]*param[0])/7;
	}

}
