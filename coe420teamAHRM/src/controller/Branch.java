package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.HospitalBranch;
import model.HospitalChain;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Branch/*")
public class Branch extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static HospitalBranch branch;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Branch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		String branchID = request.getPathInfo();
		System.out.println(branchID);
		if(!branchID.contains("back")) {
			String bID = branchID.split("/")[1];
			HospitalChain branches = new HospitalChain();
			branch = branches.findBranch(bID);
			System.out.println(branch.getBranchName());
			request.setAttribute("branch", branch);	
			RequestDispatcher req = request.getRequestDispatcher("../resources.jsp");
			req.include(request, response);
		}
		else {
			// System.out.println(branch.getBranchName());
			branchID = (String)request.getSession().getAttribute("branchID");
			HospitalChain branches = new HospitalChain();
			branch = branches.findBranch(branchID);
			request.setAttribute("branch", branch);	
			RequestDispatcher req = request.getRequestDispatcher("../resources.jsp");
			req.include(request, response);
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// request.uid, request.password -> validate user 
		
		
	}

}
