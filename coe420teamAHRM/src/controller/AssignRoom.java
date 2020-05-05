package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Bed;
import model.Patient;
import model.PatientList;
import model.Room;
import model.RoomsList;

/**
 * Servlet implementation class AssignRoom
 */
@WebServlet("/AssignRoom")
public class AssignRoom extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AssignRoom() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("assignroom.jsp").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String branchID = (String) request.getSession().getAttribute("branchID");
		String patientID = (String)request.getParameter("patientid");
		String type = (String)request.getParameter("roomtype");
		
		RoomsList  rooms = new RoomsList(branchID);
		PatientList patients = new PatientList(branchID);
		Patient patient = patients.findPatient(patientID);
		
		boolean pinvalid = false;
		if(patient!=null) {
			pinvalid = false;
			HashMap<String, Integer> roomBed = new HashMap<String,Integer>();
			roomBed = rooms.assignRoom(type, patientID);
			String roomNum = (String) roomBed.keySet().toArray()[0];
			int bedNum = roomBed.get(roomNum);
			if(bedNum != 0) {
				if(!(patient.getRoomNum().contains("Unassigned"))) {
					// patient was previously assigned a room 
					Room oldRoom = rooms.findRoom(patient.getRoomNum());
					List<Bed> beds = oldRoom.getBeds();
					// TODO remove patient from room function
					Bed oldBed = oldRoom.getBeds().get(patient.getBedNum()-1);
					oldBed.setPatientID("");
					oldBed.setStatus(1);
					beds.add((patient.getBedNum()-1), oldBed);
					oldRoom.setBeds(beds);
					rooms.updateRoom(oldRoom);
				}
				patient.setRoomNum(roomNum);
				patient.setBedNum(bedNum);
				patients.updatePatient(patient);
			}
			else {
				// no room
			}
			
		}
		else {
			// patient not found 
			pinvalid = true;
		}
		
		if(pinvalid) {
			response.sendRedirect("ViewAllPatients"); // temporary fix
		}
		else {
			response.sendRedirect("ViewAllRooms");	
		}
		
	}

}
