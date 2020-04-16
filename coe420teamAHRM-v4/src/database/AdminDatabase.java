package database;

import java.util.HashMap;

import model.Admin;
import model.BranchAdmin;
import model.TopLevelAdmin;

public class AdminDatabase {
	
	private static HashMap<Integer, Admin> admins = new HashMap<Integer, Admin>();
	
	public static HashMap<Integer, Admin> getAllAdmins() {
		TopLevelAdmin t1 = new TopLevelAdmin(1, "Kayleigh", "Coulson", "admin");
		TopLevelAdmin t2 = new TopLevelAdmin(2, "Dave", "Barrow", "admin");
		BranchAdmin b1 = new BranchAdmin(3, "Kailan", "Sampson", "admin", 2);
		admins.put(1, t1);
		admins.put(2,  t2);
		admins.put(3, b1);
		
		return admins;
	}

}
