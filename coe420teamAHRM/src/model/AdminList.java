package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import database.MongoConnect;

public class AdminList {
	
	// private static HashMap<Integer, Admin> admins = AdminDatabase.getAllAdmins();
	private static String branchID;
	private MongoConnect mongo = new MongoConnect();
	
	public AdminList(){
		// this.branchID = branchID;
	}
	
	public String getBranchID() {return branchID;}
	public void setBranchID(String branchID) {this.branchID = branchID;}
	
	public Admin findAdmin(String adminID, String password) {
		Admin admin = mongo.findAdmin(adminID, password);
		
		return admin;
	}
	
}
