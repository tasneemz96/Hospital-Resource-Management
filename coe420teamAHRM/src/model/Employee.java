package model;

import java.util.ArrayList;

public abstract class Employee {
	private String fName;
	private String lName;
	private String specialization;
	private String phone;
	private ArrayList<String> patientIDs;
	private String employeeID;
	private String branchID;
	
	public Employee() {}
	
	public Employee(String fName, String lName, String specialization, String phone, ArrayList<String> patientIDs, String E, String branchID) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.specialization = specialization;
		this.phone = phone;
		this.patientIDs = patientIDs;
		this.employeeID = E;
		this.branchID= branchID;
	}

	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public ArrayList<String> getPatientIDs() {
		return patientIDs;
	}
	public void setPatientIDs(ArrayList<String> patientIDs) {
		this.patientIDs = patientIDs;
	}
	public String getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}
	
	public String getBranchID() {
		return branchID;
	}
	public void setBranchID(String branchID) {
		this.branchID = branchID;
	}
	
}
