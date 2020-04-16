package database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import model.Patient;

public class PatientDatabase {
	
	private static HashMap<Integer, Patient> patients = new HashMap<Integer, Patient>();
	
	public static HashMap<Integer, Patient> getAllPatients(){
		
		Patient p11 = new Patient(1, "Jane", "Doe", "Bur Dubai", "+971501234567", "Undiagnosed", true, 1);
		Patient p12 = new Patient(2, "John", "Smith", "Barsha", "+971507654321", "Appendicitis", true, 1);
		Patient p13 = new Patient(3, "Mary", "Moe", "Karama", "+971501010101", "Gall stones", false, 1);
		
		Patient p21 = new Patient(4,"Maciej", "Hulme", "Al Qusais", "+971501234567", "Cancer", true, 2);
		Patient p22 = new Patient(5, "Felicity", "Galloway", "Al Nahda", "+971507654321", "Appendicitis", true, 2);
		Patient p23 = new Patient(6, "Ivy-Rose", "Oakley", "Dubai Marina", "+971501010101", "Gall stones", false, 2);
		
		Patient p51 = new Patient(7,"Arham", "Sweeney", "Jumeirah Lake Towers", "+971501234567", "Cancer", true, 5);
		Patient p52 = new Patient(8, "Greta", "Hudson", "Abu Hail", "+971507654321", "Appendicitis", true, 5);
		Patient p53 = new Patient(9, "Inara", "Mcloughlin", "Deira", "+971501010101", "Gall stones", false, 5);
		
		patients.put(1, p11);
		patients.put(2, p12);
		patients.put(3, p13);

		patients.put(4, p21);
		patients.put(5, p22);
		patients.put(6, p23);
		
		patients.put(7, p51);
		patients.put(8, p52);
		patients.put(9, p53);
		
		return patients;
	}
	
	/*public static HashMap<Integer, Patient> getPatientsFromBranch(int branchID){
		
		HashMap<Integer, HashMap<Integer, Patient>> all = getAllPatients();
		if(branchID ==1) {
			return all.get(1);
		}
		else if(branchID==2) {
			return all.get(2);
		}
		else if(branchID==5) {
			return all.get(5);
		}
		else {
			return null;
		}
	}*/
	
	public static void addPatient(Patient patient) {
		
		patients.put(patient.getID(), patient);
		
	}

}
