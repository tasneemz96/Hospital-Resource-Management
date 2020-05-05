package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import database.MongoConnect;

public class DoctorList {
	
	String branchID;
	ArrayList<Doctor> doctorList = new ArrayList<>();
	MongoConnect mongo = new MongoConnect();

	public DoctorList(String branchID) {
		super();
		this.branchID = branchID;
	}
	

	public List<Doctor> getDoctorList() {
		return mongo.findDoctors(branchID);
	}

	public void setDoctorList(ArrayList<Doctor> doctorList) {
		this.doctorList = doctorList;
	}
	
	
	
	public Doctor findDoctor(String ID)
	{
		return mongo.findDoctor(ID);
		
		
	}
	
	public void addDoctor(Doctor nu)
	{
		Random r = new Random();
		int id = r.nextInt((9999-1000)+1) + 1000;
		String doctorID = "D"+id;
		nu.setDoctorID(doctorID);
		mongo.addDoctor(nu);
	}
	
}
