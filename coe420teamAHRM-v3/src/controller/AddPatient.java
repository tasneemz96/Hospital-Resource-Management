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
 * Servlet implementation class AddPatient
 */
@WebServlet("/AddPatient")
public class AddPatient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPatient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		int branchID = (int)request.getSession().getAttribute("branchID");
		request.setAttribute("branchID", branchID);
		request.getRequestDispatcher("addpatient.jsp").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int branchID = (int) request.getSession().getAttribute("branchID");
		Patient patient = new Patient();
		patient.setFirstName(request.getParameter("firstname"));
		patient.setLastName(request.getParameter("lastname"));
		patient.setPhone(request.getParameter("areacode")+request.getParameter("phone"));
		patient.setAddress(request.getParameter("address"));
		if(request.getParameter("insurance").contains("yes")) {
			patient.setInsurance(true);
		}
		else {
			patient.setInsurance(false);
		}
		if(request.getParameter("diagnosis").contains("None")) {
			patient.setDiagnosis("Undiagnosed");
		}
		else {
			patient.setDiagnosis(request.getParameter("diagnosis"));
		}
		patient.setRoomNum("Unassigned");
		patient.setBedNum(-1);
		patient.setWatchID(-1);
		patient.setBranchID(branchID);
		PatientList patients = new PatientList(1);
		if(patients.checkDuplicate(patient.getFirstName(), patient.getLastName(), patient.getPhone(), patient.getAddress())) {
			System.out.println("Is duplicate");
		}
		else {
			System.out.println("Not duplicate");
			patients.addPatient(patient);
		}
		response.sendRedirect("ViewAllPatients");
	}

}
