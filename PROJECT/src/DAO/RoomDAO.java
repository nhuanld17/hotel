package DAO;

import java.sql.ResultSet;
import java.util.ArrayList;

import javax.print.attribute.PrintRequestAttribute;

import DTO.Room;

public class RoomDAO {
	public ArrayList<Room> listRooms() {
		try {
			ArrayList<Room> result = new ArrayList<Room>();
			ResultSet resultSet = new DBConn().queryDB("SELECT * FROM room");
			while (resultSet.next()) {
				result.add(new Room(resultSet.getInt("roomNumber"),resultSet.getBoolean("status")));
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<Room>();
	}
	public void setTrue(Room room) {
		try {
			new DBConn().updateDB("UPDATE room SET status = '1' WHERE roomNumber = '"+room.getRoomNumber()+"'");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void setFalse(Room room) {
		try {
			new DBConn().updateDB("UPDATE room SET status = '0' WHERE roomNumber = '"+room.getRoomNumber()+"'");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
