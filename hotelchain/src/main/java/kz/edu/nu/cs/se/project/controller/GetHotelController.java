package kz.edu.nu.cs.se.project.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kz.edu.nu.cs.se.project.dao.HotelDao;
import kz.edu.nu.cs.se.project.model.Hotel;

/**
 * Servlet implementation class GetHotelController
 */
public class GetHotelController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetHotelController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int hid = Integer.parseInt(request.getParameter("hid"));
		HotelDao dao = new HotelDao();
		Hotel h1 = dao.getHotel(hid);
		
		request.setAttribute("hotel", h1);
		
		RequestDispatcher rd = request.getRequestDispatcher("showHotel.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
