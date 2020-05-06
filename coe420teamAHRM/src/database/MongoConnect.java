package database;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import model.Admin;
import model.Bed;
import model.Doctor;
import model.HospitalBranch;
import model.Nurse;
import model.Patient;
import model.Room;
import model.Watch;

public class MongoConnect {
	private MongoClient mongoClient;
	private MongoCollection<Document> branchesCollection;
	// private DBCollection branchesCollection;
	private MongoCollection<Document> adminsCollection;
	private MongoCollection<Document> patientsCollection;
	private MongoCollection<Document> watchesCollection;
	private MongoCollection<Document> roomsCollection;
	private MongoCollection<Document> doctorsCollection;
	private MongoCollection<Document> nursesCollection;
	private MongoDatabase database;
	private static String dbname = "Chain";
	private static String branch = "Branches";
	private static String admin = "Admins";
	private static String patient = "Patients";
	private static String watch = "Watches";
	private static String room = "Rooms";
	private static String doctor = "Doctors";
	private static String nurse = "Nurses";

	private static String URI = "mongodb+srv://<username>:<password>@cluster0-wndro.mongodb.net/test?retryWrites=true&w=majority&connectTimeoutMS=60000&socketTimeoutMS=60000";

	public MongoConnect() {

		MongoClientURI uri = new MongoClientURI(URI);

		try {
			mongoClient = new MongoClient(uri);

			database = mongoClient.getDatabase(dbname);

			branchesCollection = database.getCollection(branch);
			adminsCollection = database.getCollection(admin);
			patientsCollection = database.getCollection(patient);
			watchesCollection = database.getCollection(watch);
			roomsCollection = database.getCollection(room);
			doctorsCollection = database.getCollection(doctor);
			nursesCollection = database.getCollection(nurse);
			System.out.println("Database and collection connected!");
		} catch (Exception e) {
			System.out.println("Connection failed");
		}

	}
	
	// -------------------------- Admin database methods ----------------------------------------

	public Admin findAdmin(String adminID, String password) {
		Document a = adminsCollection.find(new Document("adminID", adminID).append("password", password)).first();
		if (a != null) {
			Admin admin = new Admin(a.getString("adminID"), a.getString("password"), a.getString("firstname"),
					a.getString("lastname"), a.getString("branchID"), a.getString("type"));

			return admin;
		}
		return null;

	}
	
	// ------------------------ Doctor database methods -------------------------------------------

	public List<Doctor> findDoctors(String branchID) {
		List<Doctor> doctors = new ArrayList<Doctor>();
		FindIterable<Document> doc = doctorsCollection.find(new Document("branchID", branchID));
		int numDoctor = (int) doctorsCollection.countDocuments(new Document("branchID", branchID));

		MongoCursor<Document> c = doc.cursor();
		
		for (int i = 0; i < numDoctor; i++) {
			// DBObject p = cursor.next();
			Document d = c.next();
			Doctor doctor = new Doctor(d.getString("firstname"), 
					d.getString("lastname"), 
					d.getString("specialization"), 
					d.getString("phone"), 
					(ArrayList<String>)d.get("patientIDs"),
					d.getString("doctorID"),
					d.getString("branchID"));

			doctors.add(doctor);
		}

		c.close();

		return doctors;
	}
	
	public Doctor findDoctor(String doctorID) {
		Document d = doctorsCollection.find(new Document("doctorID", doctorID)).first();

		if (d != null) {
			Doctor doctor = new Doctor(d.getString("firstname"), 
					d.getString("lastname"), 
					d.getString("specialization"), 
					d.getString("phone"), 
					(ArrayList<String>)d.get("patientIDs"),
					d.getString("doctorID"),
					d.getString("branchID"));

			return doctor;
		}
		
		return null;
	}
	
	public void addDoctor(Doctor doctor) {
		Document check = new Document("firstname", doctor.getFirstName())
				.append("lastname", doctor.getLastName())
				.append("specialization", doctor.getSpecialization())
				.append("branchID", doctor.getBranchID());
		
		Document duplicate = doctorsCollection.find(check).first();
		
		Document d = new Document("doctorID", doctor.getDoctorID())
				.append("firstname", doctor.getFirstName())
				.append("lastname", doctor.getLastName())
				.append("phone", doctor.getPhone())
				.append("specialization", doctor.getSpecialization())
				.append("patientIDs", doctor.getPatientIDs())
				.append("branchID", doctor.getBranchID());
		
		if(duplicate == null) {
			doctorsCollection.insertOne(d);
		}
	}
	
	// --------------------------- Nurses database methods --------------------------------------------
	
	public List<Nurse> findNurses(String branchID) {
		List<Nurse> nurses = new ArrayList<Nurse>();
		FindIterable<Document> doc = nursesCollection.find(new Document("branchID", branchID));
		int numNurse = (int) nursesCollection.countDocuments(new Document("branchID", branchID));

		MongoCursor<Document> c = doc.cursor();
		
		for (int i = 0; i < numNurse; i++) {
			// DBObject p = cursor.next();
			Document d = c.next();
			
			Nurse nurse = new Nurse(d.getString("firstname"), 
					d.getString("lastname"), 
					d.getString("specialization"), 
					d.getString("phone"), 
					(ArrayList<String>)d.get("patientIDs"),
					d.getString("nurseID"), 
					d.getString("rank"), 
					d.getString("branchID"));

			nurses.add(nurse);
		}

		c.close();

		return nurses;
	}
	
	public Nurse findNurse(String nurseID) {
		Document d = nursesCollection.find(new Document("nurseID", nurseID)).first();

		if (d != null) {
			Nurse nurse = new Nurse(d.getString("firstname"), 
					d.getString("lastname"), 
					d.getString("specialization"), 
					d.getString("phone"), 
					(ArrayList<String>)d.get("patientIDs"),
					d.getString("nurseID"),
					d.getString("rank"),
					d.getString("branchID"));

			return nurse;
		}
		
		return null;
	}
	
	public void addNurse(Nurse nurse) {
		Document check = new Document("firstname", nurse.getFirstName())
				.append("lastname", nurse.getLastName())
				.append("specialization", nurse.getSpecialization())
				.append("rank", nurse.getRanking())
				.append("branchID", nurse.getBranchID());
		
		Document duplicate = nursesCollection.find(check).first();
		
		Document d = new Document("nurseID", nurse.getNurseID())
				.append("firstname", nurse.getFirstName())
				.append("lastname", nurse.getLastName())
				.append("phone", nurse.getPhone())
				.append("specialization", nurse.getSpecialization())
				.append("patientIDs", nurse.getPatientIDs())
				.append("rank", nurse.getRanking())
				.append("branchID", nurse.getBranchID());
		
		if(duplicate == null) {
			nursesCollection.insertOne(d);
		}
	}
	

	// -------------------------------- Patient database methods --------------------------------------
	
	public Patient findPatient(String patientID) {
		try {

			FindIterable<Document> pat = patientsCollection.find(new Document("patientID", patientID));
			Document p = patientsCollection.find(new Document("patientID", patientID)).first();
			if (p != null) {
				Patient patient = new Patient((String) (p.get("patientID")), (String) (p.get("firstname")),
						(String) (p.get("lastname")), (String) (p.get("address")), (String) (p.get("phone")),
						(String) (p.get("diagnosis")), (boolean) (p.get("insurance")), (String) (p.get("branchID")),
						(String) (p.get("roomNum")), (int) (p.get("bedNum")), (String) (p.get("watchID")));

				return patient;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public List<Patient> findPatients(String branchID) {

		List<Patient> patients = new ArrayList<Patient>();
		FindIterable<Document> pats = patientsCollection.find(new Document("branchID", branchID));

		int numPatient = (int) patientsCollection.countDocuments(new Document("branchID", branchID));

		MongoCursor<Document> c = pats.cursor();

		for (int i = 0; i < numPatient; i++) {
			// DBObject p = cursor.next();
			Document p = c.next();
			Patient patient = new Patient((String) (p.get("patientID")), (String) (p.get("firstname")),
					(String) (p.get("lastname")), (String) (p.get("address")), (String) (p.get("phone")),
					(String) (p.get("diagnosis")), (boolean) (p.get("insurance")), (String) (p.get("branchID")),
					(String) (p.get("roomNum")), (int) (p.get("bedNum")), (String) (p.get("watchID")));

			patients.add(patient);
		}

		c.close();

		return patients;
	}

	public void addPatient(Patient patient) {
		Document check = new Document("firstname", patient.getFirstName()).append("lastname", patient.getLastName())
				.append("address", patient.getAddress()).append("branchID", patient.getBranchID());
		/*
		 * DBObject check = new BasicDBObject("firstname", patient.getFirstName())
		 * .append("lastname", patient.getLastName()) .append("address",
		 * patient.getAddress()) .append("branchID", patient.getBranchID());
		 */

		Document check2 = new Document("firstname", patient.getFirstName()).append("lastname", patient.getLastName())
				.append("phone", patient.getPhone()).append("branchID", patient.getBranchID());

		/*
		 * DBObject check2 = new BasicDBObject("firstname", patient.getFirstName())
		 * .append("lastname", patient.getLastName()) .append("phone",
		 * patient.getPhone()) .append("branchID", patient.getBranchID());
		 */

		Document p = new Document("patientID", patient.getPatientID()).append("firstname", patient.getFirstName())
				.append("lastname", patient.getLastName()).append("address", patient.getAddress())
				.append("phone", patient.getPhone()).append("diagnosis", patient.getDiagnosis())
				.append("insurance", patient.isInsurance()).append("branchID", patient.getBranchID())
				.append("roomNum", patient.getRoomNum()).append("bedNum", patient.getBedNum())
				.append("watchID", patient.getWatchID());

		/*
		 * DBObject p = new BasicDBObject("patientID", patient.getPatientID())
		 * .append("firstname", patient.getFirstName()) .append("lastname",
		 * patient.getLastName()) .append("address", patient.getAddress())
		 * .append("phone", patient.getPhone()) .append("diagnosis",
		 * patient.getDiagnosis()) .append("insurance", patient.isInsurance())
		 * .append("branchID", patient.getBranchID()) .append("roomNum",
		 * patient.getRoomNum()) .append("bedNum", patient.getBedNum())
		 * .append("watchID", patient.getWatchID());
		 */

		Document duplicate = patientsCollection.find(check).first();
		Document duplicate2 = patientsCollection.find(check2).first();

		/*
		 * DBObject duplicate = patientsCollection.findOne(check); DBObject duplicate2 =
		 * patientsCollection.findOne(check2);
		 */

		if (duplicate == null && duplicate2 == null) {
			patientsCollection.insertOne(p);
		} else {
			System.out.println("patient exists");
		}

	}

	public void updatePatient(Patient newPatient) {
		/*
		 * DBObject o = new BasicDBObject("patientID", oldPatient.getPatientID())
		 * .append("firstname", oldPatient.getFirstName()) .append("lastname",
		 * oldPatient.getLastName()) .append("address", oldPatient.getAddress())
		 * .append("phone", oldPatient.getPhone()) .append("diagnosis",
		 * oldPatient.getDiagnosis()) .append("insurance", oldPatient.isInsurance())
		 * .append("branchID", oldPatient.getBranchID()) .append("roomNum",
		 * oldPatient.getRoomNum()) .append("bedNum", oldPatient.getBedNum())
		 * .append("watchID", oldPatient.getWatchID());
		 */

		Document o = new Document("patientID", newPatient.getPatientID());

		// DBObject o = new BasicDBObject("patientID", newPatient.getPatientID());

		Document n = new Document("patientID", newPatient.getPatientID()).append("firstname", newPatient.getFirstName())
				.append("lastname", newPatient.getLastName()).append("address", newPatient.getAddress())
				.append("phone", newPatient.getPhone()).append("diagnosis", newPatient.getDiagnosis())
				.append("insurance", newPatient.isInsurance()).append("branchID", newPatient.getBranchID())
				.append("roomNum", newPatient.getRoomNum()).append("bedNum", newPatient.getBedNum())
				.append("watchID", newPatient.getWatchID());

		/*
		 * DBObject n = new BasicDBObject("patientID", newPatient.getPatientID())
		 * .append("firstname", newPatient.getFirstName()) .append("lastname",
		 * newPatient.getLastName()) .append("address", newPatient.getAddress())
		 * .append("phone", newPatient.getPhone()) .append("diagnosis",
		 * newPatient.getDiagnosis()) .append("insurance", newPatient.isInsurance())
		 * .append("branchID", newPatient.getBranchID()) .append("roomNum",
		 * newPatient.getRoomNum()) .append("bedNum", newPatient.getBedNum())
		 * .append("watchID", newPatient.getWatchID());
		 */

		patientsCollection.findOneAndReplace(o, n);
	}
	
	// --------------------------------------- Branch database methods ------------------------------

	public HospitalBranch findBranch(String branchID) {

		Document query = new Document("branchID", branchID);

		// DBObject query = new BasicDBObject("branchID", branchID);

		FindIterable<Document> br = branchesCollection.find(query);

		Document b = br.first();
		// DBObject b = branchesCollection.findOne(query);
		HospitalBranch branch;
		if (b != null) {
			branch = new HospitalBranch((String) (b.getString("branchID")), (String) (b.getString("branchName")),
					(String) (b.getString("branchLocation")));
		} else {
			branch = new HospitalBranch("Failed", "Failed", "Failed");
		}

		return branch;
	}

	public List<HospitalBranch> findBranches() {
		List<HospitalBranch> branches = new ArrayList<HospitalBranch>();
		int numBranches = (int) branchesCollection.countDocuments();
		FindIterable<Document> br = branchesCollection.find();
		MongoCursor<Document> cursor = br.cursor();

		// DBCursor cursor = branchesCollection.find();
		for (int i = 0; i < numBranches; i++) {
			Document b = cursor.next();
			// DBObject b = cursor.next();

			HospitalBranch branch = new HospitalBranch((String) (b.get("branchID")), (String) (b.get("branchName")),
					(String) (b.get("branchLocation")));

			branches.add(branch);
		}

		return branches;
	}

	public void addBranch(HospitalBranch branch) {

		Document b = new Document("branchID", branch.getBranchID()).append("branchName", branch.getBranchName())
				.append("branchLocation", branch.getBranchLocation());

		/*
		 * DBObject b = new BasicDBObject("branchID", branch.getBranchID())
		 * .append("branchName", branch.getBranchName()) .append("branchLocation",
		 * branch.getBranchLocation());
		 */

		branchesCollection.insertOne(b);
	}
	
	// ----------------------------- Watch database methods -----------------------------------

	public List<Watch> findWatches(String branchID) {

		List<Watch> watches = new ArrayList<Watch>();
		Document query = new Document("branchID", branchID);
		// DBObject query = new BasicDBObject("branchID", branchID);
		int numWatches = (int) watchesCollection.countDocuments(query);

		// DBCursor cursor = watchesCollection.find(query);
		if (numWatches != 0) {
			FindIterable<Document> wat = watchesCollection.find(query);
			MongoCursor<Document> cursor = wat.cursor();
			for (int i = 0; i < numWatches; i++) {

				Document w = cursor.next();

				System.out.println(w.getString("watchID") + " " + w.getString("brand") + " " + w.getString("model")
						+ " " + w.getBoolean("available"));

				// DBObject w = cursor.next();
				Watch watch = new Watch((String) (w.get("watchID")), (String) (w.get("brand")),
						(String) (w.get("model")), (boolean) (w.get("available")), (String) (w.get("patientID")),
						(String) (w.get("branchID")));
				watches.add(watch);
			}
		}

		return watches;

	}

	public Watch findWatch(String watchID) {

		Document query = new Document("watchID", watchID);
		// DBObject query = new BasicDBObject("watchID", watchID);
		Document w = watchesCollection.find(query).first();
		// DBObject w = watchesCollection.findOne(query);
		if(w != null) {
			Watch watch = new Watch((String) (w.get("watchID")), (String) (w.get("brand")), (String) (w.get("model")),
					(boolean) (w.get("available")), (String) (w.get("patientID")), (String) (w.get("branchID")));
			return watch;
		}
		return null;
		
	}

	public List<Watch> findAvailableWatches(String branchID) {

		List<Watch> watches = new ArrayList<Watch>();

		Document query = new Document("branchID", branchID).append("available", true);
		/*
		 * DBObject query = new BasicDBObject("branchID", branchID) .append("available",
		 * true);
		 */
		int numWatches = (int) watchesCollection.countDocuments(query);

		// DBCursor cursor = watchesCollection.find(query);
		if (numWatches != 0) {
			FindIterable<Document> wat = watchesCollection.find(query);
			MongoCursor<Document> cursor = wat.cursor();
			for (int i = 0; i < numWatches; i++) {
				Document w = cursor.next();
				// DBObject w = cursor.next();
				Watch watch = new Watch((String) (w.get("watchID")), (String) (w.get("brand")),
						(String) (w.get("model")), (boolean) (w.get("available")), (String) (w.get("patientID")),
						(String) (w.get("branchID")));
				watches.add(watch);
			}
		}

		return watches;

	}

	public void addWatch(Watch watch) {

		Document w = new Document("watchID", watch.getWatchID()).append("brand", watch.getBrand())
				.append("model", watch.getModel()).append("available", watch.isAvailable())
				.append("patientID", watch.getPatientID()).append("branchID", watch.getBranchID());

		/*
		 * DBObject w = new BasicDBObject("watchID", watch.getWatchID())
		 * .append("brand", watch.getBrand()) .append("model", watch.getModel())
		 * .append("available", watch.isAvailable()) .append("patientID",
		 * watch.getPatientID()) .append("branchID", watch.getBranchID());
		 */

		watchesCollection.insertOne(w);
	}

	public void updateWatch(Watch watch) {

		Document o = new Document("watchID", watch.getWatchID());
		// DBObject o = new BasicDBObject("watchID", watch.getWatchID());

		Document n = new Document("watchID", watch.getWatchID()).append("brand", watch.getBrand())
				.append("model", watch.getModel()).append("available", watch.isAvailable())
				.append("patientID", watch.getPatientID()).append("branchID", watch.getBranchID());

		/*
		 * DBObject n = new BasicDBObject("watchID", watch.getWatchID())
		 * .append("brand", watch.getBrand()) .append("model", watch.getModel())
		 * .append("available", watch.isAvailable()) .append("patientID",
		 * watch.getPatientID()) .append("branchID", watch.getBranchID());
		 */

		watchesCollection.findOneAndReplace(o, n);
	}
	
	// ----------------------------- Room database methods -----------------------------------

	public List<Room> findRooms(String branchID) {

		List<Room> rooms = new ArrayList<Room>();
		Document query = new Document("branchID", branchID);
		// DBObject query = new BasicDBObject("branchID", branchID);
		int numRooms = (int) roomsCollection.countDocuments(query);

		if (numRooms != 0) {
			FindIterable<Document> roo = roomsCollection.find(query);
			MongoCursor<Document> cursor = roo.cursor();
			for (int i = 0; i < numRooms; i++) {

				Document r = cursor.next();
				// DBObject w = cursor.next();
				Room room = new Room(r.getString("roomNum"), r.getString("branchID"), r.getString("type"),
						r.getInteger("capacity"));

				System.out.println(r.getString("roomNum") + " " + r.getString("type"));

				ArrayList<Document> be = (ArrayList<Document>) r.get("beds");
				List<Bed> beds = new ArrayList<Bed>();

				for (int j = 0; j < be.size(); j++) {
					Bed bed = new Bed(be.get(j).getInteger("bedNum"), be.get(j).getInteger("status"),
							be.get(j).getString("patientID"));
					beds.add(bed);
				}
				room.setBeds(beds);

				ArrayList<String> patients = (ArrayList<String>) r.get("patients");

				room.setPatientIDs(patients);

				rooms.add(room);
				System.out.println(rooms.get(i).getType());
			}
		}

		return rooms;

	}

	public List<Room> findByRoomType(String branchID, String type) {

		List<Room> rooms = new ArrayList<Room>();
		Document query = new Document("branchID", branchID).append("type", type);
		// DBObject query = new BasicDBObject("branchID", branchID);
		int numRooms = (int) roomsCollection.countDocuments(query);

		if (numRooms != 0) {
			FindIterable<Document> roo = roomsCollection.find(query);
			MongoCursor<Document> cursor = roo.cursor();
			for (int i = 0; i < numRooms; i++) {
				Document r = cursor.next();
				// DBObject w = cursor.next();
				Room room = new Room(r.getString("roomNum"), r.getString("branchID"), r.getString("type"),
						r.getInteger("capacity"));

				ArrayList<Document> be = (ArrayList<Document>) r.get("beds");
				List<Bed> beds = new ArrayList<Bed>();

				for (int j = 0; j < be.size(); j++) {
					Bed bed = new Bed(be.get(j).getInteger("bedNum"), be.get(j).getInteger("status"),
							be.get(j).getString("patientID"));
					beds.add(bed);
				}
				room.setBeds(beds);

				ArrayList<String> patients = (ArrayList<String>) r.get("patients");

				room.setPatientIDs(patients);
				rooms.add(room);
			}
		}

		return rooms;

	}

	public void updateRoom(Room room) {
		Document o = new Document("roomNum", room.getRoomNumber());
		// DBObject o = new BasicDBObject("watchID", watch.getWatchID());

		ArrayList<String> patientIDs = (ArrayList<String>) room.getPatientIDs();
		ArrayList<Bed> beds = (ArrayList<Bed>) room.getBeds();
		ArrayList<Document> b = new ArrayList<Document>();
		for (Bed bed : beds) {
			b.add(new Document("bedNum", bed.getBedNumber()).append("status", bed.getStatus()).append("patientID",
					bed.getPatientID()));
		}
		Document n = new Document("roomNum", room.getRoomNumber()).append("branchID", room.getBranchID())
				.append("type", room.getType()).append("capacity", room.getCapacity()).append("beds", b)
				.append("patients", patientIDs);

		roomsCollection.findOneAndReplace(o, n);
	}

}
