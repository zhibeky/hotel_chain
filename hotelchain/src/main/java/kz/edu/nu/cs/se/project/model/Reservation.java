package kz.edu.nu.cs.se.project.model;

import java.util.Date;

public class Reservation {
	private int reservationid;
	private int userid;
	private int hotelid;
	private int roomid;
	private Date checkin;
	private Date checkout;
	private int price;
	
	public Reservation(int reservationid, int userid, int hotelid, int roomid, Date checkin, Date checkout, int price) {
		super();
		this.reservationid = reservationid;
		this.userid = userid;
		this.hotelid = hotelid;
		this.roomid = roomid;
		this.checkin = checkin;
		this.checkout = checkout;
		this.price = price;
	}
	
	public Reservation(int userid, int hotelid, int roomid, Date checkin, Date checkout, int price) {
		super();
		this.userid = userid;
		this.hotelid = hotelid;
		this.roomid = roomid;
		this.checkin = checkin;
		this.checkout = checkout;
		this.price = price;
	}

	public int getReservationid() {
		return reservationid;
	}
	public void setReservationid(int reservationid) {
		this.reservationid = reservationid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getHotelid() {
		return hotelid;
	}
	public void setHotelid(int hotelid) {
		this.hotelid = hotelid;
	}
	public int getRoomid() {
		return roomid;
	}
	public void setRoomid(int roomid) {
		this.roomid = roomid;
	}
	public Date getCheckin() {
		return checkin;
	}
	public void setCheckin(Date checkin) {
		this.checkin = checkin;
	}
	public Date getCheckout() {
		return checkout;
	}
	public void setCheckout(Date checkout) {
		this.checkout = checkout;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
