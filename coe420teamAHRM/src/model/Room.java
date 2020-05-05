package model;

import java.util.ArrayList;
import java.util.List;

public class Room {
	private String branchID;
	private String roomNumber;
	private String type;
	private List<Bed> beds = new ArrayList<Bed>();
	// private int capacity = 0; // ??
	private int capacity;
	private List<String> patientIDs = new ArrayList<String>();

	public String getType() {return type;}
	
	public void setType(String type) {this.type = type;}
	
	public Room(String r, String branchID, String type, int capacity) {
		this.roomNumber = r;
		this.branchID = branchID;
		this.type = type;
		this.capacity = capacity;
	}
	
	public String getBranchID() {
		return branchID;
	}
	
	public void setBranchID(String branchID) {
		this.branchID = branchID;
	}

	public Room(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public boolean isAvailable() {
		Boolean y = false;

		for (int i = 0; i < this.beds.size(); i++) {
			if (this.beds.get(i).getStatus() == 1) {
				y = true;
				break; // Stop checking, we only want one bed to be ready
			}
		}
		return y;

	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public List<Bed> getBeds() {
		return beds;
	}

	public void setBeds(List<Bed> beds) {
		this.beds = beds;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public List<String> getPatientIDs() {
		return patientIDs;
	}

	public void setPatientIDs(List<String> patientIDs) {
		this.patientIDs = patientIDs;
	}

	public Room() {
		// useless it's abstract, auto-made by java
	}

	public void addPatient(String patientID) {
		if (this.patientIDs.contains(patientID) || this.patientIDs.size() == this.capacity) {
			System.out.println("Already exists/full");
			return;
		} else {
			this.patientIDs.add(patientID);
		}
	}

	public void removePatient(int patientID) {
		if (!this.patientIDs.contains(patientID)) {
			System.out.println("Patient does not exist");
			return;
		} else {
			this.patientIDs.remove(this.patientIDs.indexOf(patientID));
		}
	}

	public void printRoomPatients() {
		for (int i = 0; i < this.patientIDs.size(); i++) {
			System.out.println(this.patientIDs.get(i)); // Debugging function, please ignore
		}
	}

}
