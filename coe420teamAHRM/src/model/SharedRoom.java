package model;

import java.util.ArrayList;


public class SharedRoom extends Room{
	
	private String type = "Shared";

	public SharedRoom(String roomNumber,String branchID, String type, int capacity) {
        
    }
	
    public SharedRoom()
    {
    	this.setCapacity(4);
    }
    
    public String getType() {
    	return type;}

}