package model;

import java.util.*;

import database.BranchDatabase;  


public class HospitalChain {

	private static HashMap<Integer, HospitalBranch> Hospitals = BranchDatabase.getAllBranches();
   
	public List<HospitalBranch> getBranches(){
		return new ArrayList<HospitalBranch>(Hospitals.values());
	}
	public void addBranch(HospitalBranch Hospital) {
		Hospital.setBranchID(Hospitals.size()+1);
		Hospitals.put(Hospital.getBranchID(), Hospital);
	}
	
	public void removeBranch(HospitalBranch Hospital ) {
		Hospitals.remove(Hospital.getBranchID());
	}

	public void updateBranch(HospitalBranch branch){
		Hospitals.replace(branch.getBranchID(), branch);
	}

	public HospitalBranch findBranch(int branchID){
		return Hospitals.get(branchID);
	}

	public boolean checkDuplicate(String branchName, String branchLocation){
		List<HospitalBranch> branches = this.getBranches();
		for (HospitalBranch branch : branches){
			if(branch.getBranchName().equals(branchName) && branch.getBranchLocation().equals(branchLocation)){
				return true;
			}
		}
		return false;
	}


}

