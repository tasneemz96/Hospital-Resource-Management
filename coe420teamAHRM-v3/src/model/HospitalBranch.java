package model;
import java.util.HashMap;

public class HospitalBranch {

	
	private String branchName;
	private int  branchID;
	private String BRID;
	private String branchLocation;
	private PatientList patients;
	// TODO employee and admin attributes
	// private EmployeeList employees;
	// private AdminList admins;
	private WatchInventory watchInventory;
	// TO DO: add rooms list 
	
	public HospitalBranch(int  branchID, String branchName,  String branchLocation) {
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
	public int getBranchID() {
		return this.branchID;
	}
	public void setBranchID(int branchID) {
		this.branchID = branchID;
		String BRID = "BR" + Integer.toString(branchID);
		setBRID(BRID);
	}

	public String getBRID(){
		return this.BRID;
	}

	public void setBRID(String BRID){
		this.BRID = BRID;
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
