package database;

import java.util.HashMap;

import model.Watch;

public class WatchDatabase {
	private static HashMap<Integer, Watch> watches = new HashMap<Integer, Watch>();
	private static HashMap<Integer, HashMap<Integer, Watch>> allwatches = new HashMap<Integer, HashMap<Integer, Watch>>();
	private static HashMap<Integer, Watch> watchesb1 = new HashMap<Integer, Watch>();
	private static HashMap<Integer, Watch> watchesb2 = new HashMap<Integer, Watch>();
	private static HashMap<Integer, Watch> watchesb5 = new HashMap<Integer, Watch>();

	public static HashMap<Integer, Watch> getAllWatches() {
		/*Watch w1 = new Watch(1, "Samsung", "Gear S2");
		Watch w2 = new Watch(2, "Apple", "Series 3");
		Watch w3 = new Watch(3, "Fitbit", "Versa 2");

		watches.put(1, w1);
		watches.put(2, w2);
		watches.put(3, w3);
*/
		
		Watch w11 = new Watch(1, "Samsung", "Gear S2", 1);
		Watch w12 = new Watch(2, "Apple", "Series 3", 1);
		Watch w13 = new Watch(3, "Fitbit", "Versa 2", 1);
		
		Watch w21 = new Watch(4, "Samsung", "Gear S2", 2);
		Watch w22 = new Watch(5, "Xiaomi", "Amazfit", 2);
		Watch w23 = new Watch(6, "Fitbit", "Versa 2", 2);
		
		Watch w51 = new Watch(7, "Xiaomi", "Amazfit", 5);
		Watch w52 = new Watch(8, "Apple", "Series 3", 5);
		Watch w53 = new Watch(9, "Fitbit", "Versa 2", 5);

		watches.put(1, w11);
		watches.put(2, w12);
		watches.put(3, w13);

		watches.put(4, w21);
		watches.put(5, w22);
		watches.put(6, w23);
		
		watches.put(7, w51);
		watches.put(8, w52);
		watches.put(9, w53);
		

		return watches;
	}
	
	/*public static HashMap<Integer, Watch> getWatchesFromBranch(int branchID){
		
		HashMap<Integer, HashMap<Integer, Watch>> all = getAllWatches();

		if(branchID==1) {
			return all.get(1);
		}
		else if(branchID==2) {
			return all.get(2);
		}
		else if(branchID==5) {
			return all.get(5);
		}
		else {
			return null;
		}
		
	}*/
	
	public static void addWatch(Watch watch) {
		watches.put(watch.getWatchID(), watch);
	}

}
