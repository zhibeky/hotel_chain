package kz.edu.nu.cs.se.project.controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.Date;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kz.edu.nu.cs.se.project.dao.ReservationDao;
import kz.edu.nu.cs.se.project.model.Reservation;

/**
 * Servlet implementation class ReservationServlet
 */
public class ReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReservationDao reservationDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservationServlet() {
        this.reservationDao = new ReservationDao();
    }
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getServletPath();
		
		switch(action) {
		case "/new":
			showNewForm(request, response);
			break;
		case "/insert":
			try {
				insertReservation(request, response);
			} catch (ServletException | IOException | SQLException | ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "/delete":
			try {
				deleteReservation(request, response);
			} catch(SQLException e) {
				e.printStackTrace();
			}
			break;
		case "/edit":
			try {
				showEditForm(request, response);
			} catch(SQLException e) {
				e.printStackTrace();
			}
			break;
		case "/update":
			try {
				updateReservation(request, response);
			} catch (SQLException | IOException | ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		default:
			try {
				listReservations(request, response);
			} catch (SQLException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
	}
	
	private void listReservations(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		List<Reservation> listReservations = reservationDao.selectAllReservation();
		request.setAttribute("listReservations", listReservations);
		RequestDispatcher rd = request.getRequestDispatcher("reservation_list.jsp");
		rd.forward(request, response);
	}
	
	private void updateReservation(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ParseException {
		int reservationid = Integer.parseInt(request.getParameter("reservationid"));
		int userid = Integer.parseInt(request.getParameter("userid"));
		int hotelid = Integer.parseInt(request.getParameter("hotelid"));
		int roomid = Integer.parseInt(request.getParameter("roomid"));
		Date checkin = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("checkin"));
		Date checkout = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("checkout"));
		int price = Integer.parseInt(request.getParameter("price"));
		
		Reservation newReservation = new Reservation(reservationid, userid, hotelid, roomid, checkin, checkout, price);
		reservationDao.updateReservation(newReservation);
		response.sendRedirect("list");
	}
	
	private void deleteReservation(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
		int reservationid = Integer.parseInt(request.getParameter("reservationid"));
		reservationDao.deleteReservation(reservationid);
		response.sendRedirect("list");
	}
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		int reservationid = Integer.parseInt(request.getParameter("reservationid"));
		Reservation existingReservation = reservationDao.selectReservation(reservationid);
		RequestDispatcher rd = request.getRequestDispatcher("reservation_form.jsp");
		request.setAttribute("reservation", existingReservation);
		rd.forward(request, response);
	}
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("reservation_form.jsp");
		rd.forward(request, response);
	}
	
	private void insertReservation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ParseException {
		int reservationid = Integer.parseInt(request.getParameter("reservationid"));
		int userid = Integer.parseInt(request.getParameter("userid"));
		int hotelid = Integer.parseInt(request.getParameter("hotelid"));
		int roomid = Integer.parseInt(request.getParameter("roomid"));
		Date checkin = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("checkin"));
		Date checkout = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("checkout"));
		int price = Integer.parseInt(request.getParameter("price"));
		
		Reservation newReservation = new Reservation(reservationid, userid, hotelid, roomid, checkin, checkout, price);
		reservationDao.insertReservation(newReservation);
		response.sendRedirect("list");
	}

}
