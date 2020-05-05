package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Nurse;
import model.NurseList;

/**
 * Servlet implementation class SearchNurse
 */
@WebServlet("/SearchNurse")
public class SearchNurse extends HttpServlet {
	
	private static Nurse nurse;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchNurse() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("nurse", nurse);
		request.getRequestDispatcher("searchnurse.jsp").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String branchID = (String) request.getSession().getAttribute("branchID");
		String nurseID = request.getParameter("nurseID");
		
		NurseList nurses = new NurseList(branchID);
		nurse = nurses.findNurse(nurseID);
		if(nurse == null) {
			response.setContentType("text/html");
			PrintWriter pw=response.getWriter();
			pw.println("<script type=\"text/javascript\">");
			pw.println("alert('Invalid nurse ID. Try again.');");
			pw.println("</script>");
			request.getRequestDispatcher("nurses.jsp").include(request, response);
		}
		else {
		System.out.println("Nurse is: "+nurse.getFirstName() + " " + nurse.getLastName());
		request.setAttribute("nurse", nurse);
		request.getRequestDispatcher("searchnurse.jsp").include(request, response);
		}
	}

}
