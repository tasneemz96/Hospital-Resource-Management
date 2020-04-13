package database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import model.Patient;

public class PatientDatabase {
	
	private static HashMap<Integer, Patient> patients = new HashMap<Integer, Patient>();
	
	public static HashMap<Integer, Patient> getAllPatients(){
		Patient p1 = new Patient(1, "Jane", "Doe", "Bur Dubai", "+971501234567", "Undiagnosed", true, 1);
		p1.setPatientID("P" + Integer.toString(p1.getID()));
		p1.setRoomNum("Unassigned");
		p1.setBedNum(-1);
		p1.setWatchID(-1);
		Patient p2 = new Patient(2, "John", "Smith", "Barsha", "+971507654321", "Appendicitis", true, 1);
		p2.setPatientID("P" + Integer.toString(p2.getID()));
		p2.setRoomNum("Unassigned");
		p2.setBedNum(-1);
		p2.setWatchID(-1);
		Patient p3 = new Patient(3, "Mary", "Moe", "Karama", "+971501010101", "Gall stones", false, 1);
		p3.setPatientID("P"+Integer.toString(p3.getID()));
		p3.setRoomNum("Unassigned");
		p3.setBedNum(-1);
		p3.setWatchID(-1);
		patients.put(1, p1);
		patients.put(2, p2);
		patients.put(3, p3);
		
		return patients;
	}

}
