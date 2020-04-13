package database;

import java.util.HashMap;

import model.Watch;

public class WatchDatabase {
private static HashMap<Integer, Watch> watches = new HashMap<Integer, Watch>();
	
	public static HashMap<Integer, Watch> getAllWatches(){
		Watch w1 = new Watch(1, "Samsung", "Gear S2");
		Watch w2 = new Watch(2, "Apple", "Series 3");
		Watch w3 = new Watch(3, "Fitbit", "Versa 2");
		
		watches.put(1, w1);
		watches.put(2, w2);
		watches.put(3, w3);
		
		return watches;
	}

}
