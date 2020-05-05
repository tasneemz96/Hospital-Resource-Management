package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Doctor;
import model.DoctorList;
import model.PatientList;

/**
 * Servlet implementation class SearchDoctor
 */
@WebServlet("/SearchDoctor")
public class SearchDoctor extends HttpServlet {
	
	private static Doctor doctor;
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchDoctor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("doctor", doctor);
		request.getRequestDispatcher("searchdoctor.jsp").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String branchID = (String) request.getSession().getAttribute("branchID");
		String doctorID = request.getParameter("doctorID");
		
		DoctorList doctors = new DoctorList(branchID);
		doctor = doctors.findDoctor(doctorID);
		if(doctor == null) {
			response.setContentType("text/html");
			PrintWriter pw=response.getWriter();
			pw.println("<script type=\"text/javascript\">");
			pw.println("alert('Invalid doctor ID. Try again.');");
			pw.println("</script>");
			request.getRequestDispatcher("doctors.jsp").include(request, response);
		}
		else {
		System.out.println("tPatient is: "+doctor.getFirstName() + " " + doctor.getLastName());
		request.setAttribute("doctor", doctor);
		request.getRequestDispatcher("searchdoctor.jsp").include(request, response);
		}
	}

}
