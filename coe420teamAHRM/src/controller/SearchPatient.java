package controller;

import java.io.IOException;
import java.io.PrintWriter;

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
		String branchID = (String) request.getSession().getAttribute("branchID");
		String patientID = request.getParameter("patientID");
		
		PatientList patients = new PatientList(branchID);
		patient = patients.findPatient(patientID);
		if(patient == null) {
			response.setContentType("text/html");
			PrintWriter pw=response.getWriter();
			pw.println("<script type=\"text/javascript\">");
			pw.println("alert('Invalid patient ID. Try again.');");
			pw.println("</script>");
			request.getRequestDispatcher("patients.jsp").include(request, response);
		}
		else {
		System.out.println("tPatient is: "+patient.getFirstName() + " " + patient.getLastName());
		request.setAttribute("patient", patient);
		request.getRequestDispatcher("searchpatient.jsp").include(request, response);
		}
	}

}
