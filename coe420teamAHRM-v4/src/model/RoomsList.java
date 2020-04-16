package model;

import java.util.ArrayList;
import java.util.HashMap;
import database.RoomDatabase;

public class RoomsList {
	
	private static int branchID;

	private static HashMap<Integer, Room> rooms = RoomDatabase.getAllRooms();

	public RoomsList(int branchID) {
		this.branchID = branchID;
	}
	
	public ArrayList<Room> getRooms() {
		ArrayList<Room> allrooms = new ArrayList<Room>(rooms.values());
		ArrayList<Room> branchrooms = new ArrayList<Room>();
		for(Room room : allrooms) {
			if(room.getBranchID() == branchID) {
				branchrooms.add(room);
			}
		}
		return branchrooms;
	}

	/*public void setRooms(ArrayList<Room> rooms) {
		this.rooms = rooms;
	}*/

	public void addRoom(Room r) {
		
		r.setRoomNumber(rooms.size()+1);
		rooms.put(r.getRoomNumber(), r);
		
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
		
		rooms.remove(roomNumber);
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
	

	public Room findRoom(int roomNumber) {
		boolean exists = rooms.containsKey(roomNumber);
		if(exists) {
			return rooms.get(roomNumber);
		}
		else {
			return null;
		}
		/*for (int i = 0; i < rooms.size(); i++) {
			if (rooms.get(i).getRoomNumber() == roomNumber) {

				return rooms.get(i);
			} else {
				System.out.println("Room not found" + "\n");
			}

		}
		return null; */ 
	}

	public ArrayList<Room> getAvailableRooms() {
		ArrayList<Room> store = new ArrayList<Room>();
		ArrayList<Room> allrooms = getRooms();
		for (int i = 0; i < allrooms.size(); i++) {
			if (allrooms.get(i).isAvailable()) {
				store.add(allrooms.get(i));
			}
		}
		return store;
	}

	public ArrayList<Room> getAvailablePrivate() {
		ArrayList<Room> store = new ArrayList<Room>();
		ArrayList<Room> allrooms = getRooms();
		for (int i = 0; i < allrooms.size(); i++) {
			if (allrooms.get(i).getCapacity() == 1 && allrooms.get(i).isAvailable())// checking capacity to get room type
			{
				store.add(allrooms.get(i));
			}

		}

		return store;
	}

	public ArrayList<Room> getAvailableSemiPrivate() {
		ArrayList<Room> store = new ArrayList<Room>();
		ArrayList<Room> allrooms = getRooms();
		for (int i = 0; i < allrooms.size(); i++) {
			if (allrooms.get(i).getCapacity() == 2 && allrooms.get(i).isAvailable())// checking capacity to get room type
			{
				store.add(allrooms.get(i));
			}

		}
		return store;
	}

	public ArrayList<Room> getAvailableShared() {
		ArrayList<Room> store = new ArrayList<Room>();
		ArrayList<Room> allrooms = getRooms();
		for (int i = 0; i < allrooms.size(); i++) {
			if (allrooms.get(i).getCapacity() == 4 && allrooms.get(i).isAvailable()) // checking capacity to get room type
			{
				store.add(allrooms.get(i));
			}

		}
		return store;
	}

	public void assignRoom(String roomType, int patientID) {
		if (roomType == "Shared") {
			ArrayList<Room> shared = this.getAvailableShared();
			shared.get(0).addPatient(patientID);

		}

		else if (roomType == "Private") {
			ArrayList<Room> priv = this.getAvailablePrivate();
			priv.get(0).addPatient(patientID);

		}

		else if (roomType == "Semi") {
			ArrayList<Room> semi = this.getAvailableSemiPrivate();
			semi.get(0).addPatient(patientID);
		} else {
			System.out.println("No rooms");
		}

	}

	public void printRooms() {
		for (int i = 0; i < rooms.size(); i++) {
			System.out.println(rooms.get(i).getRoomNumber()); // debugging
		}
	}

}
