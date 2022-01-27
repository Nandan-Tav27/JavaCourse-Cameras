package com.nandantavargeri;

public class Sensor extends SecurityDevice implements Resettable
{
	//fields:
	int range;
	
	//methods:
	@Override
	public String toString() {
		return super.toString() + "Sensor [range=" + range + "]";
	}
	
	@Override
	public void reset()
	{
		
	}
	
	public void setRange(int range)
	{
		this.range = range;
	}

}
