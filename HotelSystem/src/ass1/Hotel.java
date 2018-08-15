package ass1;

import java.util.ArrayList;

public class Hotel {
	private String name;	
	private int numRooms;
	private RoomSystem roomSys;
	private BookingSystem bookSys;
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

	public int numRooms() {
		return this.numRooms;
	}
	
	public ArrayList<String> getUsers() {
		return users;
	}

	public void addUsers(String user) {
		this.users.add(user);
	}
	public void addRoom(ArrayList<Room> newRooms) {
		
		this.roomSys.addAvailableRooms(newRooms);
		this.roomSys.addRooms(newRooms);
		this.numRooms += this.roomSys.getNumRooms();
		
	}
	public ArrayList<Room> getRoom() {
		return this.roomSys.getRooms();
	}
}
