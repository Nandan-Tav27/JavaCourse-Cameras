package com.nandantavargeri;

public abstract class SecurityDevice {
	//fields:
	private boolean active = true;
	
	//methods:
	@Override
	public String toString() 
	{
		return "SecurityDevice [active=" + active + "]";
	}
	
	public boolean getActive()
    {
        return active;
    }
	
	
	public void setActive(boolean active)
	{
		this.active = active;
	}
}
