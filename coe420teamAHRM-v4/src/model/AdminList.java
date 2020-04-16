package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import database.AdminDatabase;

public class AdminList {
	
	private static HashMap<Integer, Admin> admins = AdminDatabase.getAllAdmins();
	private static int branchID;
	
	public AdminList(int branchID){
		this.branchID = branchID;
	}
	
	public List<BranchAdmin> getBranchAdmins(){
		ArrayList<Admin> alladmins = new ArrayList<Admin>(admins.values());
		ArrayList<BranchAdmin> branchadmins = new ArrayList<BranchAdmin>();
		for(Admin admin : alladmins) {
			BranchAdmin bradmin = (BranchAdmin)admin;
			if(bradmin.getRank().contains("branch") && bradmin.getBranchID()==this.branchID) {
				branchadmins.add(bradmin);
			}
		}
		
		return branchadmins;
	}
	
	public List<TopLevelAdmin> getTopLevelAdmin(){
		ArrayList<Admin> alladmins = new ArrayList<Admin>(admins.values());
		ArrayList<TopLevelAdmin> topadmins = new ArrayList<TopLevelAdmin>();
		for(Admin admin : alladmins) {
			if(admin.getRank().contains("top")) {
				topadmins.add((TopLevelAdmin)admin);
			}
		}
		return topadmins;
	}
	
	public int getBranchID() {return branchID;}
	public void setBranchID(int branchID) {this.branchID = branchID;}
	
	public boolean checkAdminID(int adminID) {
		
		return admins.containsKey(adminID);
	}
	
	public boolean checkTLAdminID(int adminID) {
		boolean exists = admins.containsKey(adminID);
		if(exists && admins.get(adminID).getRank().contains("top")) {
			return true;
		}
		else
			return false;
	}
	
	public TopLevelAdmin findTLAdmin(int adminID) {
		boolean exists = admins.containsKey(adminID);
		if(exists && admins.get(adminID).getRank().contains("top")) {
			return (TopLevelAdmin) admins.get(adminID);
		}
		return null;
	}
	
}
