package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import database.WatchDatabase;

public class WatchInventory {
	
	private static HashMap<Integer, Watch> watches = WatchDatabase.getAllWatches(); 
	
	public List<Watch> getWatches(){
		return new ArrayList<Watch>(watches.values());
	}
	
	public List<Watch> getAvailableWatches(){
		List<Watch> watches = this.getWatches();
		List<Watch> availableWatches = new ArrayList<Watch>();
		for(Watch watch : watches) {
			if(watch.isAvailable()) {
				availableWatches.add(watch);
			}
		}
		return availableWatches;
	}
	
	public void addWatch(Watch watch) {
		watch.setWatchID(watches.size()+1);
		watches.put(watch.getWatchID(), watch);
	}
	
	public void removeWatch(Watch watch) {
		watches.remove(watch.getWatchID());
	}
	
	public void updateWatch(Watch watch) {
		this.watches.replace(watch.getWatchID(), watch);
	}
	
	public Watch findWatch(int watchID) {
		return watches.get(watchID);
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
			this.watches.replace(watch.getWatchID(), watch);
			return watch;
		}
		else {
			for(Watch watch : watches) {
				if(model.isEmpty()) {
					if(watch.getBrand().equals(brand)) {
						watch.setPatientID(patientID);
						watch.setAvailable(false);
						this.watches.replace(watch.getWatchID(), watch);
						return watch;
					}
				}
				else {
					if(watch.getBrand().equals(brand)&& watch.getModel().equals(model)) {
						watch.setPatientID(patientID);
						watch.setAvailable(false);
						this.watches.replace(watch.getWatchID(), watch);
						return watch;
					}
				}
			}
		}
		
		return null;
	}
	
}
