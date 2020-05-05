package model;

public class Watch {
	
	private String watchID;
	private String brand;
	private String model;
	private boolean available;
	private String patientID;
	
	private String branchID;
	
	
	
	public String getBranchID() {
		return branchID;
	}

	public void setBranchID(String branchID) {
		this.branchID = branchID;
	}
		
	public Watch(String watchID, String brand, String model, boolean available, String patientID, String branchID) {
		super();
		this.watchID = watchID;
		this.brand = brand;
		this.model = model;
		this.patientID = patientID;
		this.available = available;
		this.branchID = branchID;
	}
	
	public Watch() {
		this.patientID="Unassigned";
		this.available=true;
	}

	public String getWatchID() {
		return watchID;
	}
	public void setWatchID(String watchID) {
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
