package model;

import java.util.ArrayList;

public class SemiPrivateRoom extends Room {
	
	private String type = "Semi-private";
	public SemiPrivateRoom(String roomNumber, ArrayList<Bed> b, int branchID) {
        
    }
	
	public SemiPrivateRoom(String roomNumber, ArrayList<Bed> b, ArrayList<Integer> pat) {
       
    }
    
    public SemiPrivateRoom()
    {
    	this.setCapacity(2);
    }

    public String getType() {return type;}
}
