package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import database.MongoConnect;

public class RoomsList {
	
	private static String branchID;
	private static MongoConnect mongo = new MongoConnect();
	//private static HashMap<Integer, Room> rooms = RoomDatabase.getAllRooms();

	public RoomsList(String branchID) {
		this.branchID = branchID;
		
	}
	
	public List<Room> getRooms() {
		return mongo.findRooms(branchID);
	}

	/*public void setRooms(ArrayList<Room> rooms) {
		this.rooms = rooms;
	}*/

	public void addRoom(Room r) {
		
		//r.setRoomNumber(rooms.size()+1);
		//rooms.put(r.getRoomNumber(), r);
		
		/*for (int i = 0; i < rooms.size(); i++) {
			if (rooms.get(i).getRoomNumber() == r.getRoomNumber()) // Match every room number in the room list with our
																	// argument's room number and find it
			{
				System.out.println("Room already exists!");
				return;
			}
		}*/ // no need 

		// rooms.add(r);

	}

	public void removeRoom(int roomNumber) {
		
		//rooms.remove(roomNumber);
		/*for (int i = 0; i < rooms.size(); i++) {
			if (rooms.get(i).getRoomNumber() == roomNumber) // Match every room number in the room list with our
															// argument's room number and find it
			{
				rooms.remove(i);
			} else {
				{
					System.out.print("Room not found");
				}
			}
		}*/ 
	}
	
	public void updateRoom(Room room) {
		mongo.updateRoom(room);
	}

	public Room findRoom(String roomNumber) {
		/*boolean exists = rooms.containsKey(roomNumber);
		if(exists) {
			return rooms.get(roomNumber);
		}
		else {
			return null;
		}*/
		/*for (int i = 0; i < rooms.size(); i++) {
			if (rooms.get(i).getRoomNumber() == roomNumber) {

				return rooms.get(i);
			} else {
				System.out.println("Room not found" + "\n");
			}

		}*/
		return null;
		
	}

	public List<Room> getAvailableRooms() {
		List<Room> rooms = mongo.findRooms(branchID);
		List<Room> store = new ArrayList<Room>();
		for(Room room : rooms) {
			if(room.isAvailable()) {
				store.add(room);
			}
		}
		return store;
	}

	public List<Room> getAvailablePrivate() {
		List<Room> store = new ArrayList<Room>();
		List<Room> allrooms = mongo.findByRoomType(branchID, "Private");
		for (Room room : allrooms) {
			if (room.isAvailable())// checking capacity to get room type
			{
				store.add(room);
			}

		}

		return store;
	}

	public List<Room> getAvailableSemiPrivate() {
		List<Room> store = new ArrayList<Room>();
		List<Room> allrooms = mongo.findByRoomType(branchID, "Semi-Private");
		for (Room room : allrooms) {
			if (room.isAvailable())// checking capacity to get room type
			{
				store.add(room);
			}

		}

		return store;
	}
	
	public List<Room> getAvailableShared() {
		List<Room> store = new ArrayList<Room>();
		List<Room> allrooms = mongo.findByRoomType(branchID, "Shared");
		for (Room room : allrooms) {
			if (room.isAvailable())// checking capacity to get room type
			{
				store.add(room);
			}

		}

		return store;
	}
	
	public List<Room> getAvailableByType(String roomType){
		List<Room> store = new ArrayList<Room>();
		
		List<Room> allrooms = mongo.findByRoomType(branchID, roomType);
		for (Room room : allrooms) {
			if (room.isAvailable())// checking capacity to get room type
			{
				store.add(room);
			}

		}

		return store;
	}
	
	public HashMap<String, Integer> assignRoom(String roomType, String patientID){
		
		int bedNum = 0;
		String roomNum = "";
		
		System.out.println("room type: " + roomType);
		List<Room> availablerooms = this.getAvailableByType(roomType);
		if(availablerooms.size()!=0) { // if there are available rooms
			Room room = availablerooms.get(0);
			List<Bed> beds = room.getBeds();
			for(int i=0;i<beds.size();i++) {
				Bed bed = beds.get(i);
				
				System.out.println("Bed: " + (i+1)+"\tStatus: "+ bed.getStatus());
				
				if(bed.getStatus()==1) { // bed is available
					
					// assign patient to bed 
					bed.setPatientID(patientID);
					// make bed occupied
					bed.setStatus(2);
					bedNum = bed.getBedNumber();
					
					System.out.println("Bed: " + bed.getBedNumber() + "\tPatientID: " + bed.getPatientID());
					
					// update the bed information in list beds
					beds.remove(i);
					beds.add(i, bed);
					break;
				}
			}
			
			// update beds in room
			room.setBeds(beds);
			roomNum = room.getRoomNumber();
			
			// add patient to room
			room.addPatient(patientID);
			
			System.out.println("Room: " + room.getRoomNumber());

			// update room on database 
			mongo.updateRoom(room);

		}
		
		HashMap<String, Integer> send = new HashMap<String, Integer>();
		send.put(roomNum, bedNum);
		
		// return this to controller
		return send;
	}
	

	/*public HashMap<String, Integer> assignRoom(String roomType, String patientID) {
		
		System.out.println("RoomsList: assignRoom()");
		
		int bedNum = 0;
		String roomNum = "";
		
		if (roomType.contains("Shared")) {
			
			System.out.println("room type: Shared");
			
			// get list of available shared rooms
			List<Room> shared = this.getAvailableShared();
			// get beds in the first available room 
			List<Bed> beds = shared.get(0).getBeds();
			for(int i=0;i<beds.size();i++) {
				Bed bed = beds.get(i);
				
				System.out.println("Bed: " + (i+1)+"\tStatus: "+ bed.getStatus());
				
				if(bed.getStatus()==1) { // bed is available
					
					// assign patient to bed 
					bed.setPatientID(patientID);
					// make bed occupied
					bed.setStatus(2);
					bedNum = bed.getBedNumber();
					
					System.out.println("Bed: " + bed.getBedNumber() + "\tPatientID: " + bed.getPatientID());
					
					// update the bed information in list beds
					beds.remove(i);
					beds.add(i, bed);
					break;
				}
			}
			Room room = shared.get(0);
			// update beds in room
			room.setBeds(beds);
			roomNum = room.getRoomNumber();
			
			// add patient to room
			room.addPatient(patientID);
			
			System.out.println("Room: " + room.getRoomNumber());

			// update room on database 
			mongo.updateRoom(room);
		}

		else if (roomType.equals("Private")) {
			
			System.out.println("room type: Private");
			
			// get list of available private rooms 
			List<Room> priv = this.getAvailablePrivate();
			Room room = priv.get(0);
			List<Bed> beds = room.getBeds();
			Bed bed = beds.get(0);
			bedNum = bed.getBedNumber();
			// set patient to bed
			bed.setPatientID(patientID);
			// make bed occupied
			bed.setStatus(2);
			//update bed in beds
			beds.remove(0);
			beds.add(0, bed);
			
			System.out.println("Room: " + room.getRoomNumber());
			System.out.println("Bed: " + bed.getBedNumber() + "\tPatientID: " + bed.getPatientID());
			
			roomNum = room.getRoomNumber();
			// add patient to room
			room.addPatient(patientID);

			// update room on database
			mongo.updateRoom(room);
		}

		else if (roomType.equals("Semi-Private")) {
			
			System.out.println("room type: Semi-Private");
			
			// get list of semi private rooms 
			List<Room> semi = this.getAvailableSemiPrivate();
			Room room = semi.get(0);
			List<Bed> beds = room.getBeds();
			if(beds.get(0).getStatus()==1) { // if first bed is available 
				Bed bed = beds.get(0);
				bedNum = bed.getBedNumber();
				// set patient to bed 
				bed.setPatientID(patientID);
				// make bed occupied
				bed.setStatus(2);
				// update bed in bed list
				beds.remove(0);
				beds.add(0, bed);
				
				System.out.println("Bed: " + bed.getBedNumber() + "\tPatientID: " + bed.getPatientID());
				
			}
			else {
				// second bed is available
				Bed bed = beds.get(1);
				bedNum = bed.getBedNumber();
				// set patient to bed
				bed.setPatientID(patientID);
				// set status to occupied
				bed.setStatus(2);
				// update bed to beds list
				beds.remove(1);
				beds.add(1, bed);
				
				System.out.println("Bed: " + bed.getBedNumber() + "\tPatientID: " + bed.getPatientID());
				
			}
			roomNum = room.getRoomNumber();
			room.setBeds(beds);
			// add patient to room
			room.addPatient(patientID);
			
			System.out.println("Room: " + room.getRoomNumber());
			
			//update room in room list 
			mongo.updateRoom(room);
		} else {
			System.out.println("No rooms");
		}
		HashMap<String, Integer> send = new HashMap<String, Integer>();
		send.put(roomNum, bedNum);
		
		// return this to controller
		return send;

	}*/

	/*public void printRooms() {
		for (int i = 0; i < rooms.size(); i++) {
			System.out.println(rooms.get(i).getRoomNumber()); // debugging
		}
	}*/

}
