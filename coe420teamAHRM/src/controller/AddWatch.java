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
 * Servlet implementation class AddWatch
 */
@WebServlet("/AddWatch")
public class AddWatch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddWatch() {
        super();
        // TODO Auto-generated constructor stub
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("addwatch.jsp").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		
		String brand = request.getParameter("brand");
		String model = request.getParameter("model");
		
		Watch watch = new Watch();
		watch.setBrand(brand);
		watch.setModel(model);
		
		WatchInventory watches = new WatchInventory();
		
		watches.addWatch(watch);
		
		response.sendRedirect("ViewAllWatches");
	}

}
