package model;

import java.util.*;

import database.MongoConnect;  


public class HospitalChain {
	
	private MongoConnect mongo = new MongoConnect();

	// private static HashMap<Integer, HospitalBranch> Hospitals = BranchDatabase.getAllBranches();
   
	public List<HospitalBranch> getBranches(){
		return mongo.findBranches();
	}
	public void addBranch(HospitalBranch Hospital) {
		
		Random r = new Random();
		int id = r.nextInt((9999-1000)+1000);
		String branchID = "BR"+id;
		Hospital.setBranchID(branchID);
		mongo.addBranch(Hospital);
		// Hospitals.put(Hospital.getBranchID(), Hospital);
	}
	
	/*public void removeBranch(HospitalBranch Hospital ) {
		Hospitals.remove(Hospital.getBranchID());
	}
*/
	/*public void updateBranch(HospitalBranch branch){
		Hospitals.replace(branch.getBranchID(), branch);
	}*/

	public HospitalBranch findBranch(String branchID){
		return mongo.findBranch(branchID);
	}

	/*public boolean checkDuplicate(String branchName, String branchLocation){
		List<HospitalBranch> branches = this.getBranches();
		for (HospitalBranch branch : branches){
			if(branch.getBranchName().equals(branchName) && branch.getBranchLocation().equals(branchLocation)){
				return true;
			}
		}
		return false;
	}
*/

}

