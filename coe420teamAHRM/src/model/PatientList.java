package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import database.PatientDatabase;

public class PatientList {
	
	private static HashMap<Integer, Patient> patients = PatientDatabase.getAllPatients(); 
	
	public List<Patient> getPatients(){
		return new ArrayList<Patient>(patients.values());
	}
	
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
		return patients.get(patientID);
	}
	
	public boolean checkPatientID(int patientID) {
		return patients.containsKey(patientID);
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
