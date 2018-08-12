package ass1;

import java.util.ArrayList;

public class RoomSystem {
	ArrayList<Room> rooms;
	ArrayList<Room> availableRooms;
	ArrayList<Room> bookedRooms;
	public RoomSystem () {
		this.rooms = new ArrayList<Room>();
		this.availableRooms = new ArrayList<Room>();
		this.bookedRooms = new ArrayList<Room>();
	}
	public ArrayList<Room> getRooms() {
		return rooms;
	}
	public void addRooms(Room rooms) {
		this.rooms.add(rooms);
	}
	public ArrayList<Room> getAvailableRooms() {
		return availableRooms;
	}
	public void addAvailableRooms(Room availableRooms) {
		this.availableRooms.add(availableRooms);
	}
	public ArrayList<Room> getBookedRooms() {
		return bookedRooms;
	}
	public void addBookedRooms(Room bookedRooms) {
		this.bookedRooms.add(bookedRooms);
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
