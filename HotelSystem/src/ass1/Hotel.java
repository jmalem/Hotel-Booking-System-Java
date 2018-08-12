package ass1;

import java.util.ArrayList;

public class Hotel {
	private int numRooms;
	RoomSystem roomSys;
	//BookingSystem bookSys;
	private ArrayList<String> users;
	
	public Hotel(ArrayList<Room> rooms) {
		this.numRooms = numRooms;
		this.roomSys = new RoomSystem();
		this.users = new ArrayList<String>();
	}

	public int getCapacity() {
		return numRooms;
	}

	public void setCapacity(int num) {
		this.numRooms = num;
	}

	public ArrayList<String> getUsers() {
		return users;
	}

	public void addUsers(String user) {
		this.users.add(user);
	}
	
}
