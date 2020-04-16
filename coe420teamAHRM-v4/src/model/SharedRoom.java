package model;

import java.util.ArrayList;


public class SharedRoom extends Room{
	
	private String type = "Shared";

	public SharedRoom(int roomNumber, ArrayList<Bed> b, int branchID) {
        super(roomNumber, b, branchID);
        this.setType("Shared");
        this.setCapacity(4);
    }
	
    public SharedRoom(int roomNumber, ArrayList<Bed> b, ArrayList<Integer> pat) {
        super(roomNumber, b, pat);
        this.setCapacity(4);
    }
    
    public SharedRoom()
    {
    	this.setCapacity(4);
    }
    
    public String getType() {
    	return type;}

}