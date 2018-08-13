package ass1;

import java.util.ArrayList;

public class Hotel {
	private String name;	
	private int numRooms;
	RoomSystem roomSys;
	//BookingSystem bookSys;
	private ArrayList<String> users;
	
	public Hotel(String name, ArrayList<Room> rooms) {
		this.numRooms = rooms.size();
		this.name = name;
		this.roomSys = new RoomSystem();
		
		this.users = new ArrayList<String>();
	}
	public String getHotelName() {
		return this.name;
	}

	public int getCapacity() {
		return numRooms;
	}
	
	public ArrayList<String> getUsers() {
		return users;
	}

	public void addUsers(String user) {
		this.users.add(user);
	}
	
	
}
