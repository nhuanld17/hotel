package BUS;

import java.util.ArrayList;

import DAO.RoomDAO;
import DTO.Room;

public class RoomBUS {
	public ArrayList<Room> listRooms() {
		return new RoomDAO().listRooms();
	}
	public void setTrue(Room room) {
		new RoomDAO().setTrue(room);
	}
	public void setFalse(Room room) {
		new RoomDAO().setFalse(room);
	}
}
