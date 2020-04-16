package model;

import java.util.ArrayList;

public abstract class Room {
	private int branchID;
	private int roomNumber;
	private String type;
	private ArrayList<Bed> beds = new ArrayList<Bed>();
	// private int capacity = 0; // ??
	private int capacity;
	private ArrayList<Integer> patientIDs = new ArrayList<Integer>();

	public Room(int r, ArrayList<Bed> b, ArrayList<Integer> pat, int branchID) {
		this.roomNumber = r;
		this.beds = b;
		this.patientIDs = pat;
		this.branchID = branchID;
	}
	public String getType() {return type;}
	
	public void setType(String type) {this.type = type;}
	
	public Room(int r, ArrayList<Bed> b, int branchID) {
		this.roomNumber = r;
		this.beds = b;
		this.branchID = branchID;
	}
	
	public Room(int r, ArrayList<Bed> b, ArrayList<Integer> pat) {
		this.roomNumber = r;
		this.beds = b;
		this.patientIDs = pat;
	}
	
	public int getBranchID() {
		return branchID;
	}
	
	public void setBranchID(int branchID) {
		this.branchID = branchID;
	}

	public Room(int roomNumber) {
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

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public ArrayList<Bed> getBeds() {
		return beds;
	}

	public void setBeds(ArrayList<Bed> beds) {
		this.beds = beds;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public ArrayList<Integer> getPatientIDs() {
		return patientIDs;
	}

	public void setPatientIDs(ArrayList<Integer> patientIDs) {
		this.patientIDs = patientIDs;
	}

	public Room() {
		// useless it's abstract, auto-made by java
	}

	public void addPatient(int patientID) {
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
