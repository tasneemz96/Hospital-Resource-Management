package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import database.MongoConnect;

public class PatientList {
	
	private static String branchID;
	// private static HashMap<Integer, Patient> patients = PatientDatabase.getAllPatients(); 
	private MongoConnect mongo = new MongoConnect();
	
	public PatientList(String branchID) {
		this.branchID = branchID;
	}
	
	public List<Patient> getPatients(){
		
		ArrayList<Patient> branchPatients = (ArrayList)mongo.findPatients(branchID);
		/*ArrayList<Patient> all = new ArrayList<Patient>(patients.values());
		
		for(Patient patient : all) {
			if(patient.getBranchID()==this.branchID) {
				branchPatients.add(patient);
			}
		}*/
		
		return branchPatients;
	}
	
	public String getBranchID() {return branchID;}
	public void setBranchID(String branchID) { this.branchID= branchID; }
	
	public void addPatient(Patient patient) {
		
		Random rand = new Random();
		int id = rand.nextInt((9999-1000) + 1) + 1000;
		String patientID = "P"+id;
		patient.setPatientID(patientID);
		mongo.addPatient(patient);
		
		// patient.setID(patients.size()+1);
		// patients.put(patient.getID(), patient);
	}
	
	/*public void removePatient(Patient patient) {
		patients.remove(patient.getPatientID());
	}*/
	
	public void updatePatient(Patient patient) {
		mongo.updatePatient(patient);
	}
	
	public Patient findPatient(String patientID) {
		Patient patient = mongo.findPatient(patientID);
		return patient;
	}
	
	/*public boolean checkPatientID(int patientID) {
		boolean exists = patients.containsKey(patientID);
		if(exists && (patients.get(patientID).getBranchID()==this.branchID)) {
			return patients.containsKey(patientID);
		}
		else {
			return false;
		}
		
	}*/
	
	/*public boolean checkDuplicate(String firstname, String lastname, String phone, String address) {
		List<Patient>allpatients = this.getPatients();
		for(Patient patient : allpatients) {
			if(patient.getFirstName().equals(firstname) && patient.getLastName().equals(lastname) && patient.getPhone().equals(phone) && patient.getAddress().equals(address)) {
				return true;
			}
		}
		return false;
	}
	*/
}
