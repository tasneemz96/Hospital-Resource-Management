package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Doctor;
import model.DoctorList;

/**
 * Servlet implementation class AddDoctor
 */
@WebServlet("/AddDoctor")
public class AddDoctor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDoctor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String branchID = (String)request.getSession().getAttribute("branchID");
		request.setAttribute("branchID", branchID);
		request.getRequestDispatcher("adddoctor.jsp").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String branchID = (String) request.getSession().getAttribute("branchID");
		String firstname = request.getParameter("firstname").trim();
		String lastname = request.getParameter("lastname").trim();
		String specialization = request.getParameter("specialization");
		String phone = request.getParameter("phone").trim();
		ArrayList<String> patientIDs = new ArrayList<String>();
		
		if(firstname.isEmpty()|| lastname.isEmpty() || phone.isEmpty()) {
			System.out.println(firstname + " " + lastname + " " + phone);
			response.setContentType("text/html");
			PrintWriter pw=response.getWriter();
			pw.println("<script type=\"text/javascript\">");
			pw.println("alert('Please fill out the empty fields');");
			pw.println("</script>");
			request.getRequestDispatcher("adddoctor.jsp").include(request, response);
		}
		else if(firstname.matches(".*\\d.*") || lastname.matches(".*\\d.*") || !phone.matches("[0-9]+")) {
			System.out.println(firstname + " " + lastname + " " + phone);
			response.setContentType("text/html");
			PrintWriter pw=response.getWriter();
			pw.println("<script type=\"text/javascript\">");
			pw.println("alert('Please make sure the name consists only of alphabets and the phone number consists only of digits');");
			pw.println("</script>");
			request.getRequestDispatcher("adddoctor.jsp").include(request, response);
		}
		
		else {
			DoctorList doctors = new DoctorList(branchID);
			
			Doctor doctor = new Doctor();
			doctor.setBranchID(branchID);
			doctor.setFirstName(firstname);
			doctor.setLastName(lastname);
			doctor.setSpecialization(specialization);
			doctor.setPhone(phone);
			doctor.setPatientIDs(patientIDs);
			
			doctors.addDoctor(doctor);
			response.sendRedirect("ViewAllDoctors");
		}
		
		
	}

}
