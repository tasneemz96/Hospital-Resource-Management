package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AdminList;
import model.TopLevelAdmin;

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
		boolean auth = false;
		int ID = -1;
		if(uid.charAt(0)=='T') {
			try {
				ID = Integer.parseInt(uid.split("T")[1]);
				System.out.println("extracted ID = " + ID);
			}
			catch(Exception e) {
				ID = -1;
			}
			
			AdminList admins = new AdminList(0); // will only retrieve top level admins
			TopLevelAdmin tladmin = admins.findTLAdmin(ID);
			if(tladmin != null) { // valid top level ID 
				if(tladmin.getPassword().equals(password)) {
					auth = true;
				}
				
			}
		}
		if(auth) {
			
			request.getRequestDispatcher("branch.html").include(request, response);
		}
		else {
			response.getWriter().append("Invalid credentials");
		}
		// response.sendRedirect("Branch");
	}

}
