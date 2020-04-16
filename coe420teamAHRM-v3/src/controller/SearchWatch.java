package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Watch;
import model.WatchInventory;

/**
 * Servlet implementation class SearchWatch
 */
@WebServlet("/SearchWatch")
public class SearchWatch extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static Watch watch;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchWatch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		// request.getRequestDispatcher("searchwatch.jsp").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		int branchID = (int)request.getSession().getAttribute("branchID");
		String watchID = request.getParameter("watchid");
		int ID=-1; 
		try {
			ID = Integer.parseInt(watchID);
		}
		catch (Exception e) {
			ID=-1;
		}
		
		WatchInventory watches = new WatchInventory(branchID);
		watch = watches.findWatch(ID);
		if(watch!= null) {
			System.out.println(ID + "\tWatch is: "+watch.getWatchID() + " " + watch.getBrand()+" "+watch.getModel());
			request.setAttribute("watch", watch);
			request.getSession().setAttribute("branchID", branchID);
			request.getRequestDispatcher("searchwatch.jsp").include(request, response);
		}
		else {
			response.sendRedirect("ViewAllWatches");
		}
	}

}
