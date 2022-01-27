package com.nandantavargeri;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Camera extends SecurityDevice implements Resettable
{
	//fields:
    private String serialNumber;
    private Position position = new Position();
    private CameraType cameraType = CameraType.PTZ;
    
    enum CameraType{PTZ, EPTZ, STATIONARY};
    
    static List<Camera> readCameras()
    {
    	List<Camera> cameras = new ArrayList<Camera>();
    	List<String> lines;
    	try {
    		
			lines = Files.readAllLines(Paths.get("cameras.txt"));
			for (String line : lines)
			{
				Camera c = parseCamera(line);
				cameras.add(c);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return cameras;
    }
    
    static Camera parseCamera(String s)
    {
	
		String[] data = s.split(" ");
		
		Camera camera = new Camera(data[1]);
		camera.setActive(Boolean.getBoolean(data[0]));
		Position p = new Position();
		p.pan = Integer.parseInt(data[2]);
		p.tilt = Integer.parseInt(data[3]);
		p.zoom = Integer.parseInt(data[4]);
		camera.setPosition(p);
		camera.setCameraType(data[5]);
		return camera;
	
	
    }
    
    

	Camera(String serialNumber)
    {
    	setSerialNumber(serialNumber);
    }
    
    //methods:
    
    //serialNumbergetter and setter
    
    String getSerialNumber()
    {
    	return serialNumber;
    }
    
    void setSerialNumber(String serialNumber)
    {
    	this.serialNumber = serialNumber;
    }
    
    //cameraType getter and setter
    
    CameraType getCameraType()
    {
    	return cameraType;
    }
    
    String getCameraTypeString()
    {
    	return cameraType.toString();
    }
    
    void setCameraType(CameraType cameraType)
    {
    	this.cameraType = cameraType;
    }
    
    void setCameraType(String cameraType)
    {
    	this.cameraType = CameraType.valueOf(cameraType);
    }
    
    @Override
    public String toString() 
    {
		return super.toString() + "Camera [serialNumber=" + serialNumber + ", position=" + position + 
				", cameraType=" + cameraType + "]";
	}
    
    
    
    @Override
	public int hashCode() {
		return Objects.hash(serialNumber);
	}
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Camera other = (Camera) obj;
		return Objects.equals(serialNumber, other.serialNumber);
	}



	
    
    Position getPosition()
    {
        return position;
    }
    
    void setPosition(Position position)
    {
        this.position = position;
    }
    
    void setPosition(int x, int y, int z)
    {
        position.pan = x;
        position.tilt = y;
        position.zoom = z;
    }
    
    void setPosition()
    {
    	reset();
    }
    
    @Override
    public void reset()
    {
    	position.pan = 0;
    	position.tilt = 0;
        position.zoom = 0;
        setActive(true);
    }
}

