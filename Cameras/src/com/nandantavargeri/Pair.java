package com.nandantavargeri;

public class Pair <T, U>{ // Here T represents whatever type we are working with
	//fields:
	private T x;
	private U y;
	
	//methods:
	@Override
	public String toString() {
		return "Pair [x=" + x + ", y=" + y + "]";
	}
	
	T getX()
	{
		return x;
	}
	

	void setX(T x)
	{
		this.x = x;
	}
	
	U getY()
	{
		return y;
	}
	
	void setY(U y)
	{
		this.y = y;
	}
}
