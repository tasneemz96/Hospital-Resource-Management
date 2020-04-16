package model;

import java.util.ArrayList;

public class SemiPrivateRoom extends Room {
	
	private String type = "Semi-private";
	public SemiPrivateRoom(int roomNumber, ArrayList<Bed> b, int branchID) {
        super(roomNumber, b, branchID);
        this.setType("Semi-private");
        this.setCapacity(2);
    }
	
	public SemiPrivateRoom(int roomNumber, ArrayList<Bed> b, ArrayList<Integer> pat) {
        super(roomNumber, b, pat);
        this.setCapacity(2);
    }
    
    public SemiPrivateRoom()
    {
    	this.setCapacity(2);
    }

    public String getType() {return type;}
}
