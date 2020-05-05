package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Doctor;
import model.DoctorList;
import model.Nurse;
import model.NurseList;

/**
 * Servlet implementation class AddNurse
 */
@WebServlet("/AddNurse")
public class AddNurse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNurse() {
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
		request.getRequestDispatcher("addnurse.jsp").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String branchID = (String) request.getSession().getAttribute("branchID");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String specialization = request.getParameter("specialization");
		String rank = request.getParameter("ranking");
		String phone = request.getParameter("phone");
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
			response.setContentType("text/html");
			PrintWriter pw=response.getWriter();
			pw.println("<script type=\"text/javascript\">");
			pw.println("alert('Please make sure the name consists only of alphabets and the phone number consists only of digits');");
			pw.println("</script>");
			request.getRequestDispatcher("adddoctor.jsp").include(request, response);
		}
		else {
			NurseList nurses = new NurseList(branchID);
			
			Nurse nurse = new Nurse();
			nurse.setBranchID(branchID);
			nurse.setFirstName(firstname);
			nurse.setLastName(lastname);
			nurse.setSpecialization(specialization);
			nurse.setRanking(rank);
			nurse.setPhone(phone);
			nurse.setPatientIDs(patientIDs);
			
			nurses.addNurse(nurse);
			response.sendRedirect("ViewAllNurses");
		}

		
	}

}
