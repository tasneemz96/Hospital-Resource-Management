package model;

public class Patient {
	
	private String patientID;
	private String firstName;
	private String lastName;
	private String address;
	private String phone;
	private String diagnosis;
	private boolean insurance;
	
	
	
	private String roomNum;
	private int bedNum;
	private String watchID;
	
	private String branchID;
	
	// TODO: attributes for assigned employees 
	
	public String getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;
	}

	public int getBedNum() {
		return bedNum;
	}

	public void setBedNum(int bedNum) {
		this.bedNum = bedNum;
	}

	public String getWatchID() {
		return watchID;
	}

	public void setWatchID(String watchID) {
		this.watchID = watchID;
	}
	
	public Patient() {
		// nothing
	}

	public Patient(String patientID, String firstName, String lastName, String address, String phone, String diagnosis,
			boolean insurance, String branchID, String roomNum, int bedNum, String watchID) {
		super();
		
		this.patientID = patientID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phone = phone;
		this.diagnosis = diagnosis;
		this.insurance = insurance;
		this.branchID = branchID;
		this.roomNum= roomNum;
		this.bedNum=bedNum;
		this.watchID= watchID;
	}

	public String getPatientID() {
		return patientID;
	}
	
	public void setPatientID(String patientID) {
		this.patientID = patientID;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getDiagnosis() {
		return diagnosis;
	}
	
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	
	public boolean isInsurance() {
		return insurance;
	}
	
	public void setInsurance(boolean insurance) {
		this.insurance = insurance;
	}
	
	public String getBranchID() {
		return branchID;
	}
	
	public void setBranchID(String branchID) {
		this.branchID = branchID;
	} 
	
	

}
