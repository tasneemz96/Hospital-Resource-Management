package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Patient;
import model.PatientList;

/**
 * Servlet implementation class SearchPatient
 */
@WebServlet("/SearchPatient")
public class SearchPatient extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Patient patient;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchPatient() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
    	request.setAttribute("patient", patient);
		request.getRequestDispatcher("searchpatient.jsp").include(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String patientID = request.getParameter("patientID");
		int ID=-1;
		try {
			ID = Integer.parseInt(patientID.split("P")[1]);	
		}
		catch (Exception e){
			ID=-1;
		}
		
		PatientList patients = new PatientList();
		patient = patients.findPatient(ID);
		if(patient == null) {
			response.sendRedirect("ViewAllPatients");
		}
		else {
		System.out.println(ID + "\tPatient is: "+patient.getFirstName() + " " + patient.getLastName());
		request.setAttribute("patient", patient);
		request.getRequestDispatcher("searchpatient.jsp").include(request, response);
		}
	}

}
