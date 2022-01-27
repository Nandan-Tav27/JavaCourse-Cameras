package com.nandantavargeri;

import java.util.Objects;

public class Position
{
    int pan;
    int tilt;
    int zoom;
    
    @Override
    public String toString()
    {
    	return "Pan: " + pan + ". Tilt: " + tilt + ". Zoom: " + zoom + ".";
    }

	@Override
	public int hashCode() {
		return Objects.hash(pan, tilt, zoom);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Position other = (Position) obj;
		return pan == other.pan && tilt == other.tilt && zoom == other.zoom;
	}
    
}

