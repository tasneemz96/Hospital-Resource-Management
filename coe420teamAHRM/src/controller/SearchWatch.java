package controller;

import java.io.IOException;
import java.io.PrintWriter;

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
		String branchID = (String)request.getSession().getAttribute("branchID");
		String watchID = request.getParameter("watchid");
		
		WatchInventory watches = new WatchInventory(branchID);
		watch = watches.findWatch(watchID);
		if(watch!= null) {
			System.out.println("\tWatch is: "+watch.getWatchID() + " " + watch.getBrand()+" "+watch.getModel());
			request.setAttribute("watch", watch);
			request.getSession().setAttribute("branchID", branchID);
			request.getRequestDispatcher("searchwatch.jsp").include(request, response);
		}
		else {
			response.setContentType("text/html");
			PrintWriter pw=response.getWriter();
			pw.println("<script type=\"text/javascript\">");
			pw.println("alert('Invalid watch ID. Try again.');");
			pw.println("</script>");
			request.getRequestDispatcher("watches.jsp").include(request, response);
		}
	}

}
