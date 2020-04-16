package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import database.PatientDatabase;

public class PatientList {
	
	private static int branchID;
	private static HashMap<Integer, Patient> patients = PatientDatabase.getAllPatients(); 
	
	public PatientList(int branchID) {
		this.branchID = branchID;
	}
	
	public List<Patient> getPatients(){
		
		ArrayList<Patient> branchPatients = new ArrayList<Patient>();
		ArrayList<Patient> all = new ArrayList<Patient>(patients.values());
		
		for(Patient patient : all) {
			if(patient.getBranchID()==this.branchID) {
				branchPatients.add(patient);
			}
		}
		
		return branchPatients;
	}
	
	public int getBranchID() {return branchID;}
	public void setBranchID(int branchID) { this.branchID= branchID; }
	public void addPatient(Patient patient) {
		patient.setID(patients.size()+1);
		patients.put(patient.getID(), patient);
	}
	
	public void removePatient(Patient patient) {
		patients.remove(patient.getPatientID());
	}
	
	public void updatePatient(Patient patient) {
		patients.replace(patient.getID(), patient);
	}
	
	public Patient findPatient(int patientID) {
		boolean exists = patients.containsKey(patientID);
		if(exists && patients.get(patientID).getBranchID()==this.branchID) {
			return patients.get(patientID);
		}
		else {
		return null;
		}
	}
	
	public boolean checkPatientID(int patientID) {
		boolean exists = patients.containsKey(patientID);
		if(exists && (patients.get(patientID).getBranchID()==this.branchID)) {
			return patients.containsKey(patientID);
		}
		else {
			return false;
		}
		
	}
	
	public boolean checkDuplicate(String firstname, String lastname, String phone, String address) {
		List<Patient>allpatients = this.getPatients();
		for(Patient patient : allpatients) {
			if(patient.getFirstName().equals(firstname) && patient.getLastName().equals(lastname) && patient.getPhone().equals(phone) && patient.getAddress().equals(address)) {
				return true;
			}
		}
		return false;
	}
	
}
