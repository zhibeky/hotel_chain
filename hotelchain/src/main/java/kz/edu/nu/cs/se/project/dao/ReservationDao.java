package kz.edu.nu.cs.se.project.dao;

import java.util.List;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kz.edu.nu.cs.se.project.model.Reservation;

public class ReservationDao {
	private String jdbcUrl = "jdbc:postgresql://localhost/hotel_chain";
	private String jdbcUsername = "postgres";
	private String jdbcPassword = "password";
	
	private static final String INSERT_RESERVATION_SQL = "insert into reservation (reservationid, userid, hotelid, roomid, checkin, checkout, price) values (?, ?, ?, ?, ?, ?, ?)";
	
	private static final String SELECT_RESERVATION_BY_ID = "select * from reservation where reservationid=?";
	private static final String SELECT_ALL_RESERVATIONS = "select * from reservation";
	private static final String DELETE_RESERVATION_SQL = "delete from reservation where reservationid=?";
	private static final String UPDATE_RESERVATION_SQL = "update reservation set userid=?, hotelid=?, roomid=?, checkin=?, checkout=?, price=? where reservationid=?";

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword);
		} catch(SQLException e) {
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	//create or insert reservation
	public void insertReservation(Reservation reservation) throws SQLException {
		try(Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_RESERVATION_SQL)) {
			preparedStatement.setInt(1, reservation.getReservationid());
			preparedStatement.setInt(2, reservation.getUserid());
			preparedStatement.setInt(3, reservation.getHotelid());
			preparedStatement.setInt(4, reservation.getRoomid());
			preparedStatement.setDate(5, (Date) reservation.getCheckin());
			preparedStatement.setDate(6, (Date) reservation.getCheckout());
			preparedStatement.setInt(7, reservation.getPrice());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// update reservation
	public boolean updateReservation(Reservation reservation) throws SQLException {
		boolean rowUpdated;
		try(Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_RESERVATION_SQL)) {
			preparedStatement.setInt(1, reservation.getReservationid());
			preparedStatement.setInt(2, reservation.getUserid());
			preparedStatement.setInt(3, reservation.getHotelid());
			preparedStatement.setInt(4, reservation.getRoomid());
			preparedStatement.setDate(5, (Date) reservation.getCheckin());
			preparedStatement.setDate(6, (Date) reservation.getCheckout());
			preparedStatement.setInt(7, reservation.getPrice());
			
			rowUpdated = preparedStatement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
	
	//select reservation by id
	public Reservation selectReservation(int id) {
		Reservation reservation = null;
		try(Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_RESERVATION_BY_ID)) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				int userid = rs.getInt("userid");
				int hotelid = rs.getInt("hotelid");
				int roomid = rs.getInt("roomid");
				Date checkin = rs.getDate("checkin");
				Date checkout = rs.getDate("checkout");
				int price = rs.getInt("price");
				reservation = new Reservation(id, userid, hotelid, roomid, checkin, checkout, price);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return reservation;
	}
	
	//select reservation
	public List<Reservation> selectAllReservation() {
		List<Reservation> reservations = new ArrayList();
		try(Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_RESERVATIONS)) {
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				int reservationid = rs.getInt("reservationid");
				int userid = rs.getInt("userid");
				int hotelid = rs.getInt("hotelid");
				int roomid = rs.getInt("roomid");
				Date checkin = rs.getDate("checkin");
				Date checkout = rs.getDate("checkout");
				int price = rs.getInt("price");
				reservations.add(new Reservation(reservationid, userid, hotelid, roomid, checkin, checkout, price));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return reservations;
	}
	
	//delete reservation
	public boolean deleteReservation(int id) throws SQLException {
		boolean rowDeleted;
		try(Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(DELETE_RESERVATION_SQL)) {
			preparedStatement.setInt(1, id);			
			rowDeleted = preparedStatement.executeUpdate() > 0;
		}
		return rowDeleted;
	}
}
