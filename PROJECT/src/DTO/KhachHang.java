package DTO;

import java.sql.Date;

public class KhachHang {
	private int id;
	private String name;
	private int age;
	private Date dateOrder;
	private int roomNumber;
	
	public KhachHang(int id, String name, int age, Date dateOrder, int roomNumber) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.dateOrder = dateOrder;
		this.roomNumber = roomNumber;
	}

	public KhachHang(String name, int age, Date dateOrder, int roomNumber) {
		this.name = name;
		this.age = age;
		this.dateOrder = dateOrder;
		this.roomNumber = roomNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getDateOrder() {
		return dateOrder;
	}

	public void setDateOrder(Date dateOrder) {
		this.dateOrder = dateOrder;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	
    public Object[] toObject() {
        return new Object[]{""+id, name, ""+age, dateOrder,""+roomNumber};
    }
}
