package com.vmware.areacalc.square;

import com.vmware.areacalc.Area;

public class SquareArea implements Area{

	@Override
	public int area(int... param) {
		return (param[0]*param[0]);
	}

}
