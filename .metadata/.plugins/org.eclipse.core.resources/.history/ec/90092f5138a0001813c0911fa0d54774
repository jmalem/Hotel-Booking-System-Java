package ass1;

public class Room {
	int roomNumber;
	int capacity;
	
	public Room(int roomNumber, int capacity) {
		this.roomNumber = roomNumber;
		this.capacity = capacity;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	@Override
	public String toString() {
		String str = new String();
		if(this.capacity==1) {
			str = "single";
		} else if (this.capacity ==2) {
			str = "double";
		} else if (this.capacity ==3) {
			str = "triple";
		}
		return "Room Number: "+this.roomNumber+" "+str;
	}
	
}
