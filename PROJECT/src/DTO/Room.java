package DTO;

public class Room {
	private int roomNumber;
	private boolean isOrdered;
	
	public Room(int roomNumber, boolean isOrdered) {
		this.roomNumber = roomNumber;
		this.isOrdered = isOrdered;
	}

	public Room(boolean isOrdered) {
		this.isOrdered = isOrdered;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public boolean isOrdered() {
		return isOrdered;
	}

	public void setOrdered(boolean isOrdered) {
		this.isOrdered = isOrdered;
	}
	
    public Object[] toObject() {
        return new Object[]{""+roomNumber,""+isOrdered};
    }
}
