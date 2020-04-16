package database;

import java.util.ArrayList;
import java.util.HashMap;

import model.Bed;
import model.PrivateRoom;
import model.Room;
import model.SemiPrivateRoom;
import model.SharedRoom;

public class RoomDatabase{
	
	private static HashMap<Integer, Room> rooms = new HashMap<Integer, Room>();
	
	public static HashMap<Integer,Room> getAllRooms(){
		
		Bed bed1 = new Bed(1, 1, -1); // -1 means unassigned;
		Bed bed2 = new Bed(2, 1, -1);
		Bed bed3 = new Bed(3, 1, -1);
		Bed bed4 = new Bed(4, 1, -1);
		
		ArrayList<Bed> bedshared = new ArrayList<Bed>();
		bedshared.add(bed1);
		bedshared.add(bed2);
		bedshared.add(bed3);
		bedshared.add(bed4);
		
		ArrayList<Bed> bedsemi = new ArrayList<Bed>();
		bedsemi.add(bed1);
		bedsemi.add(bed2);
		
		ArrayList<Bed>bedpri = new ArrayList<Bed>();
		bedpri.add(bed1);
		
		SharedRoom r1 = new SharedRoom(1, bedshared, 1);
		SharedRoom r2 = new SharedRoom(2, bedshared, 1);
		SemiPrivateRoom r3 = new SemiPrivateRoom(3, bedsemi, 1);
		PrivateRoom r4 = new PrivateRoom(4, bedpri, 1);
		
		rooms.put(1, r1);
		rooms.put(2, r2);
		rooms.put(3, r3);
		rooms.put(4, r4);
		
		return rooms;
	}
}