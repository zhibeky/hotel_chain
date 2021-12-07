package kz.edu.nu.cs.se.project.model;

public class Hotel {
	private int hid;
	private String name;
	private String address;
	private String phone;
	
	public int getHid() {
		return hid;
	}
	public void setHid(int hid) {
		this.hid = hid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Hotel [hid=" + hid + ", name=" + name + ", address=" + address + ", phone=" + phone + "]";
	}
}
