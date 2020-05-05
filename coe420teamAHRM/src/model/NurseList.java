package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import database.MongoConnect;

public class NurseList {
	private ArrayList<Nurse> nurseList = new ArrayList<>();
	private MongoConnect mongo = new MongoConnect();
	private static String branchID;
	
	public NurseList(String branchID) {
		this.branchID = branchID;
	}
	
	public List<Nurse> getNurseList() {
		return mongo.findNurses(branchID);
	}

	public void setNurseList(ArrayList<Nurse> nurseList) {
		this.nurseList = nurseList;
	}
	
	public Nurse findNurse(String ID)
	{
		return mongo.findNurse(ID);
	}
	
	public void addNurse(Nurse nu)
	{
		Random r = new Random();
		int id = r.nextInt((9999-1000)+1) + 1000;
		String nurseID = "N"+id;
		nu.setNurseID(nurseID);
		mongo.addNurse(nu);
	}

	
}
