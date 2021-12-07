package kz.edu.nu.cs.se.project.model;

import java.io.Serializable;

public class Registration implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String username;
	private String password;
	private String ident_type;
	private String ident_number;
	private String address;
	private String home_phone;
	private String mobile_phone;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getIdent_type() {
		return ident_type;
	}
	public void setIdent_type(String ident_type) {
		this.ident_type = ident_type;
	}
	public String getIdent_number() {
		return ident_number;
	}
	public void setIdent_number(String ident_number) {
		this.ident_number = ident_number;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getHome_phone() {
		return home_phone;
	}
	public void setHome_phone(String home_phone) {
		this.home_phone = home_phone;
	}
	public String getMobile_phone() {
		return mobile_phone;
	}
	public void setMobile_phone(String mobile_phone) {
		this.mobile_phone = mobile_phone;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
