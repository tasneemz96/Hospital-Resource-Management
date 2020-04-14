package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Patient;
import model.PatientList;
import model.Watch;
import model.WatchInventory;

/**
 * Servlet implementation class AssignWatch
 */
@WebServlet("/AssignWatch")
public class AssignWatch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AssignWatch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("assignwatch.jsp").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		
		String patientID = request.getParameter("patientid");
		int ID = -1;
		try {
			ID = Integer.parseInt(patientID.split("P")[1]);
		}
		catch(Exception e) {
			ID=-1;
		}
		String brand = request.getParameter("brand");
		String model = request.getParameter("model");
		
		System.out.println("Patient: " + patientID + "\t ID: " + ID + "\tBrand: " + brand + "\tModel: " + model);
		
		WatchInventory watches = new WatchInventory();
		Watch watch;
		
		PatientList patients = new PatientList();
		Patient patient = patients.findPatient(ID);
		
		boolean pinvalid = false;
		
		if(patient!=null) { // valid patient
			pinvalid = false;
			watch = watches.assignWatch(patientID, brand, model);
			if(watch != null) { // found a watch 
				if(patient.getWatchID()!=-1) { // if patient had a watch previously assigned
					Watch oldWatch = watches.findWatch(patient.getWatchID());
					oldWatch.setPatientID("Unassigned");
					oldWatch.setAvailable(true);
					watches.updateWatch(oldWatch);
				}
				
				patient.setWatchID(watch.getWatchID());
				patients.updatePatient(patient);
			}
		}
		else {
			pinvalid = true;
		}
		
		if(pinvalid) {
			response.sendRedirect("ViewAllPatients"); // temporary fix
		}
		else {
			response.sendRedirect("ViewAllWatches");	
		}
		
	}

}
