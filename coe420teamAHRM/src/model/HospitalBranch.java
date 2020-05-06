package model;

public class HospitalBranch {

	
	private String branchName;
	private String  branchID;
	private String branchLocation;
	private PatientList patients;
	// TODO employee and admin attributes
	// private EmployeeList employees;
	// private AdminList admins;
	private WatchInventory watchInventory;
	// TO DO: add rooms list 
	
	public HospitalBranch(String  branchID, String branchName,  String branchLocation) {
		super();
		this.branchID = branchID;
		this.branchName = branchName;
		this.branchLocation= branchLocation;
		
	}

	public HospitalBranch(){}
	
	public String getBranchName() {
		return this.branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getBranchID() {
		return this.branchID;
	}
	public void setBranchID(String branchID) {
		this.branchID = branchID;

	}

	public String getBranchLocation() {
		return this.branchLocation;
	}
	public void setBranchLocation(String branchLocation) {
		this.branchLocation = branchLocation;
	}
	public PatientList getPatients() {
		return patients;
	}
	public void setPatients(PatientList patients) {
		this.patients = patients;
	}
	
	//TODO getters and setters for employees and admins 
	/*
	public EmployeeList getEmployees() {
		return this.employees;
	}
	public void setEmployees(EmployeeList employees) {
		this.employees = employees;
	}
	public AdminList getAdmins() {
		return this.admins;
	}
	public void setAdmins(AdminList admins) {
		this.admins = admins;
	}*/
	
	public WatchInventory getWatchInventory() {
		return this.watchInventory;
	}
	public void setWatchInventory(WatchInventory watchInventory) {
		this.watchInventory = watchInventory;
	}
	
}
