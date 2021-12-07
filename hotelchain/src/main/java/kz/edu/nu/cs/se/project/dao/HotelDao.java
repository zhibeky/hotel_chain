package kz.edu.nu.cs.se.project.dao;

import java.sql.*;
import kz.edu.nu.cs.se.project.model.Hotel;

public class HotelDao {

	public Hotel getHotel(int hid) {
		Hotel h = new Hotel();
		h.setHid(1);
		h.setName("Rixos");
		h.setAddress("Kunayeva 7, Nur-Sultan");
		String phone[]={"87172245050"};
		h.setPhone("87172245050");
		
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost/hotel_chain", "postgres", "password");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from hotel where hid = " + hid);
			if (rs.next()) {
				h.setHid(rs.getInt("hid"));
				h.setName(rs.getString("hname"));
				h.setAddress(rs.getString("address"));
				h.setPhone(rs.getString("phone"));
			}
		} catch(Exception e) {
			System.out.println(e);
		}
		
		return h;
	}
}
