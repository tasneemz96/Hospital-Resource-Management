package model;

import java.util.ArrayList;

public class PrivateRoom extends Room {
	
	private String type = "Private";
	public PrivateRoom(String roomNumber, ArrayList<Bed> b, int branchID) {
		

	}
	
	public PrivateRoom(String roomNumber, ArrayList<Bed> b, ArrayList<Integer> pat) {
		

	}

	public PrivateRoom() {
		this.setCapacity(1);
	}
	public String getType() {return type;}
}
