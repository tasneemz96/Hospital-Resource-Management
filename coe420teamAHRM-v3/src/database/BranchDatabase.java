package database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// import model.AdminList;
import model.HospitalBranch;
// import model.EmployeeList;
import model.PatientList;
import model.WatchInventory;

public class BranchDatabase {

	private static HashMap<Integer, HospitalBranch> branches = new HashMap<Integer, HospitalBranch>();

	public static HashMap<Integer, HospitalBranch> getAllBranches() {
		HospitalBranch b1 = new HospitalBranch(1, "Mediclinic Welcare Hospital", "Dubai, UAE\r\n" + "Al Garhoud");
		// b1.setBranchID()("B" + Integer.toString(b1.getBranchID()));
		b1.setBranchID(b1.getBranchID());
		// b1.setPatients(-1);
		// b1.setEmployees(-1);
		// b1.setAdmins(-1);
		// b1.setWatchInventory(-1);

		HospitalBranch b2 = new HospitalBranch(2, "Mediclinic Parkview Hospital", "Dubai, UAE\r\n" + "Al Barsha, South 3");
		// b2.setBranchID()("B" + Integer.toString(b2.getBranchID()));
		b2.setBranchID(b2.getBranchID());
		// b2.setPatients(-1);
		// b2.setEmployees(-1);
		// b2.setAdmins(-1);
		// b2.setWatchInventory(-1);

		HospitalBranch b3 = new HospitalBranch(3, "Mediclinic City Hospital", "Dubai, UAE\r\n" + "Dubai Healthcare City");
		// b3.setBranchID()("B" + Integer.toString(b3.getBranchID()));
		b3.setBranchID(b3.getBranchID());
		// b3.setPatients(-1);
		// b3.setEmployees(-1);
		// b3.setAdmins(-1);
		// b3.setWatchInventory(-1);

		HospitalBranch b4 = new HospitalBranch(4, "\r\n" + "Mediclinic City Hospital Comprehensive Cancer Centre",
				"Dubai, UAE\r\n" + "Dubai Healthcare City, Mediclinic City Hospital North Wing\r\n" + "Building 35");
		// b4.setBranchID()("B" + Integer.toString(b4.getBranchID()));
		b4.setBranchID(b4.getBranchID());
		/*
		 * b4.setPatients(-1); b4.setEmployees(-1); b4.setAdmins(-1);
		 * b4.setWatchInventory(-1);
		 */
		HospitalBranch b5 = new HospitalBranch(5, "Mediclinic Al Qusais", "Dubai, UAE\r\n" + "Dubai Residential Oasis Building");
		// b5.setBranchID()("B" + Integer.toString(b5.getBranchID()));
		b5.setBranchID(b5.getBranchID());
		/*
		 * b5.setPatients(-1); b5.setEmployees(-1); b5.setAdmins(-1);
		 * b5.setWatchInventory(-1);
		 */

		HospitalBranch b6 = new HospitalBranch(6, "Mediclinic Al Sufouh", "Dubai, UAE\r\n" + "Knowledge Village, Block 10");
		// b6.setBranchID()("B" + Integer.toString(b6.getBranchID()));
		b6.setBranchID(b6.getBranchID());
		/*
		 * b6.setPatients(-1); b6.setEmployees(-1); b6.setAdmins(-1);
		 * b6.setWatchInventory(-1);
		 */

		HospitalBranch b7 = new HospitalBranch(7, "Mediclinic Arabian Ranches", "Dubai, UAE\r\n" + "Arabian Ranches Community");
		// b7.setBranchID()("B" + Integer.toString(b7.getBranchID()));
		b7.setBranchID(b7.getBranchID());
		/*
		 * b7.setPatients(-1); b7.setEmployees(-1); b7.setAdmins(-1);
		 * b7.setWatchInventory(-1);
		 */

		HospitalBranch b8 = new HospitalBranch(8, "Mediclinic Deira",
				"Dubai, UAE\r\n" + "City Centre Officer Building, Port Saeed\r\n" + "Adjacent to Pullman Hotel");
		// b8.setBranchID()("B" + Integer.toString(b8.getBranchID()));
		b8.setBranchID(b8.getBranchID());
		/*
		 * b8.setPatients(-1); b8.setEmployees(-1); b8.setAdmins(-1);
		 * b8.setWatchInventory(-1);
		 */
		HospitalBranch b9 = new HospitalBranch(9, "Mediclinic Dubai Mall", "Dubai, UAE\r\n" + "Dubai Mall, Fashion Parking, Level 7");
// 		b9.setBranchID()("B" + Integer.toString(b9.getBranchID()));
		b9.setBranchID(b9.getBranchID());

		HospitalBranch b10 = new HospitalBranch(10, "Mediclinic Me'aisem",
				"Dubai, UAE\r\n" + "City Centre Me'aisem, Media Production City\r\n" + "Sheikh Mohammed Bin Zayed Rd,");
//		b10.setBranchID()("B" + Integer.toString(b10.getBranchID()));
		b10.setBranchID(b10.getBranchID());

		branches.put(1, b1);
		branches.put(2, b2);
		branches.put(3, b3);
		branches.put(4, b4);
		branches.put(5, b5);
		branches.put(6, b6);
		branches.put(7, b7);
		branches.put(8, b8);
		branches.put(9, b9);
		branches.put(10, b10);

		return branches;
	}

}