package model;

import java.util.ArrayList;

public class PrivateRoom extends Room {
	
	private String type = "Private";
	public PrivateRoom(int roomNumber, ArrayList<Bed> b, int branchID) {
		super(roomNumber, b, branchID);
		this.setType("Semi-private");
		this.setCapacity(1);

	}
	
	public PrivateRoom(int roomNumber, ArrayList<Bed> b, ArrayList<Integer> pat) {
		super(roomNumber, b, pat);
		this.setCapacity(1);

	}

	public PrivateRoom() {
		this.setCapacity(1);
	}
	public String getType() {return type;}
}
