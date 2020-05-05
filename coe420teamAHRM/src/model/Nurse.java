package model;

import java.util.ArrayList;

public class Nurse extends Employee {
	
	public Nurse() {}

	public Nurse(String fName, String lName, String specialization, String phone, ArrayList<String> patientIDs,
			String E, String R, String branchID) {
		super(fName, lName, specialization, phone, patientIDs, E, branchID);
		this.ranking = R;
	}

	private String ranking;

	public String getRanking() {
		return ranking;
	}

	public void setRanking(String ranking) {
		this.ranking = ranking;
	}

	public String getFirstName() {
		return super.getfName();
	}

	public void setFirstName(String fname) {
		super.setfName(fname);
	}

	public String getLastName() {
		return super.getlName();
	}

	public void setLastName(String lname) {
		super.setlName(lname);
	}

	public String getSpecialization() {
		return super.getSpecialization();
	}

	public void setSpecialization(String specialization) {
		super.setSpecialization(specialization);
	}

	public String getPhone() {
		return super.getPhone();
	}

	public void setPhone(String phone) {
		super.setPhone(phone);
	}

	public String getNurseID() {
		return super.getEmployeeID();
	}

	public void setNurseID(String doctorID) {
		super.setEmployeeID(doctorID);
	}

	public ArrayList<String> getPatientIDs() {
		return super.getPatientIDs();
	}

	public void setPatientIDs(ArrayList<String> patientIDs) {
		super.setPatientIDs(patientIDs);
	}

	public String getBranchID() {
		return super.getBranchID();
	}

	public void setBranchID(String branchID) {
		super.setBranchID(branchID);
	}

}
