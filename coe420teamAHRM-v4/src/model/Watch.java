package model;

public class Watch {
	
	private int watchID;
	private String brand;
	private String model;
	private boolean available;
	private String patientID;
	
	private int branchID;
	
	
	
	public int getBranchID() {
		return branchID;
	}

	public void setBranchID(int branchID) {
		this.branchID = branchID;
	}

	public Watch(int watchID, String brand, String model) {
		super();
		this.watchID = watchID;
		this.brand = brand;
		this.model = model;
		this.available = true;
		this.patientID = "Unassigned";
	}
		
	public Watch(int watchID, String brand, String model, String patientID) {
		super();
		this.watchID = watchID;
		this.brand = brand;
		this.model = model;
		this.patientID = patientID;
		this.available = false;
	}
	
	public Watch(int watchID, String brand, String model, int branchID) {
		this.watchID = watchID;
		this.brand = brand;
		this.model = model;
		this.branchID = branchID;
		this.available = true;
		this.patientID = "Unassigned";
	}
	
	public Watch() {
		this.patientID="Unassigned";
		this.available=true;
	}

	public int getWatchID() {
		return watchID;
	}
	public void setWatchID(int watchID) {
		this.watchID = watchID;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	public String getPatientID() {
		return patientID;
	}
	public void setPatientID(String patientID) {
		this.patientID = patientID;
	}
	
	//TODO: attribute for biometrics
	
}
