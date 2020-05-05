package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Admin;
import model.AdminList;
import model.HospitalBranch;
import model.HospitalChain;
/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("branch.html").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		String uid = request.getParameter("uid");
		String password = request.getParameter("password");
		System.out.println("UID: " + uid + "\tPassword: " + password);
		// boolean auth = false;
		
			AdminList admins = new AdminList(); 
			Admin admin = admins.findAdmin(uid, password);
			if(admin!= null) {
				if(admin.getRank().contains("Top-level")) {
					request.getRequestDispatcher("branch.html").include(request, response);
				}
				else {
					String branchID = admin.getBranchID();
					HospitalChain chain = new HospitalChain();
					HospitalBranch branch = chain.findBranch(branchID);
					request.setAttribute("branch", branch);
					String path = "Branch/"+branchID;
					response.sendRedirect(path);
				}
			}
			else {
				
				response.setContentType("text/html");
				PrintWriter pw=response.getWriter();
				pw.println("<script type=\"text/javascript\">");
				pw.println("alert('Invalid user ID or password. Try again.');");
				pw.println("</script>");
				request.getRequestDispatcher("index.html").include(request, response);
				// response.getWriter().append("Invalid credentials\nRedirecting now...");
				// response.sendRedirect("../coe420teamAHRM");
			}
		
		// response.sendRedirect("Branch");
	}

}
