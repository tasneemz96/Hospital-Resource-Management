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
		String branchID = (String)request.getSession().getAttribute("branchID");
		request.setAttribute("branchID", branchID);
		request.getRequestDispatcher("addpatient.jsp").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String branchID = (String) request.getSession().getAttribute("branchID");
		String firstname = request.getParameter("firstname").trim();
		String lastname = request.getParameter("lastname").trim();
		String phone = request.getParameter("areacode")+request.getParameter("phone").trim();
		String address = request.getParameter("address").trim();
		String insurance = request.getParameter("insurance");
		String diagnosis = request.getParameter("diagnosis");
		
		if(firstname.isEmpty()|| lastname.isEmpty() || request.getParameter("phone").trim().isEmpty() || address.isEmpty()) {
			System.out.println(firstname + " " + lastname + " " + phone);
			response.setContentType("text/html");
			PrintWriter pw=response.getWriter();
			pw.println("<script type=\"text/javascript\">");
			pw.println("alert('Please fill out the empty fields');");
			pw.println("</script>");
			request.getRequestDispatcher("addpatient.jsp").include(request, response);
		}
		else if(firstname.matches(".*\\d.*") || lastname.matches(".*\\d.*") || !phone.matches("[0-9]+")) {
			System.out.println(firstname + " " + lastname + " " + phone);
			response.setContentType("text/html");
			PrintWriter pw=response.getWriter();
			pw.println("<script type=\"text/javascript\">");
			pw.println("alert('Please make sure the name consists only of alphabets and the phone number consists only of digits');");
			pw.println("</script>");
			request.getRequestDispatcher("addpatient.jsp").include(request, response);
		}
		else {
			Patient patient = new Patient();
			patient.setFirstName(firstname);
			patient.setLastName(lastname);
			patient.setPhone(phone);
			patient.setAddress(address);
			if(insurance.contains("yes")) {
				patient.setInsurance(true);
			}
			else {
				patient.setInsurance(false);
			}
			if(diagnosis.contains("None")) {
				patient.setDiagnosis("Undiagnosed");
			}
			else {
				patient.setDiagnosis(diagnosis);
			}
			patient.setRoomNum("Unassigned");
			patient.setBedNum(0);
			patient.setWatchID("Unassigned");
			patient.setBranchID(branchID);
			PatientList patients = new PatientList(branchID);
			
			patients.addPatient(patient);
			
			response.sendRedirect("ViewAllPatients");
		}
		
		
	}

}
