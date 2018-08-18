package ass1;

import java.util.ArrayList;

public class RoomSystem {
	private ArrayList<Room> rooms;
	private ArrayList<Room> availableRooms;
	private ArrayList<Room> bookedRooms;
	public RoomSystem () {
		this.rooms = new ArrayList<Room>();
		this.availableRooms = new ArrayList<Room>();
		this.bookedRooms = new ArrayList<Room>();
	}
	public ArrayList<Room> getRooms() {
		return rooms;
	}
	public int getNumRooms() {
		return rooms.size();
	}
	
	public void addRooms(ArrayList <Room> rooms) {
		for(Room x : rooms) {
			this.rooms.add(x);
		}
	}
	public ArrayList<Room> getAvailableRooms() {
		return availableRooms;
	}
	public void addAvailableRooms(ArrayList <Room> availableRooms) {
		for(Room x : availableRooms ) {
			this.availableRooms.add(x);
		}
	}
	public ArrayList<Room> getBookedRooms() {
		return bookedRooms;
	}
	public void addBookedRooms(ArrayList <Room> bookedRooms) {
		for(Room x : bookedRooms ) {
			this.bookedRooms.add(x);
		}
	}
	
	public void bookRoom(Room room) {
		this.bookedRooms.add(room);
		this.availableRooms.remove(room);
	}
	public void unbookRoom(Room room) {
		this.bookedRooms.remove(room);
		this.availableRooms.add(room);
	}
	
}
