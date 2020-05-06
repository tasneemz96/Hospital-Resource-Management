package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import database.MongoConnect;
// import database.WatchDatabase;

public class WatchInventory {
	
	private MongoConnect mongo = new MongoConnect();
	
	private static String branchID;
	
	public WatchInventory(String branchID) {
		WatchInventory.branchID = branchID;
	}
	
	public List<Watch> getWatches(){
		
		ArrayList<Watch> branchWatches = (ArrayList) mongo.findWatches(branchID);
		return branchWatches;
		
	}

	public List<Watch> getAvailableWatches(){
		List<Watch> availableWatches = mongo.findAvailableWatches(branchID);
		return availableWatches;
	}
	
	public void addWatch(Watch watch) {
		Random r = new Random();
		int id = r.nextInt((9999-1000)+1) + 1000;
		String watchID = "W"+id;
		watch.setWatchID(watchID);
		mongo.addWatch(watch);
	}
	
	/*public void removeWatch(Watch watch) {
		//watches.remove(watch.getWatchID());
	}*/
	
	public void updateWatch(Watch watch) {
		mongo.updateWatch(watch);
	}
	
	public Watch findWatch(String watchID) {
		return mongo.findWatch(watchID);
		
	}
		
	public Watch assignWatch(String patientID, String brand, String model) {
		List<Watch> watches = this.getAvailableWatches();
		
		if(watches.size()==0) {
			return null;
		}
		
		if(brand.toLowerCase().contains("any")) {
			Watch watch = watches.get(0);
			watch.setPatientID(patientID);
			watch.setAvailable(false);
			mongo.updateWatch(watch);
			return watch;
		}
		else {
			for(Watch watch : watches) {
				if(model.isEmpty()) {
					if(watch.getBrand().equals(brand)) {
						watch.setPatientID(patientID);
						watch.setAvailable(false);
						mongo.updateWatch(watch);
						return watch;
					}
				}
				else {
					if(watch.getBrand().equals(brand)&& watch.getModel().equals(model)) {
						watch.setPatientID(patientID);
						watch.setAvailable(false);
						mongo.updateWatch(watch);
						return watch;
					}
				}
			}
		}
		
		return null;
	}
	
}
