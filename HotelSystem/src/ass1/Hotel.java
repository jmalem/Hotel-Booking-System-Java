package ass1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
		this.bookSys = new BookingSystem();
		this.users = new ArrayList<String>();
		this.roomSys.addRooms(rooms);
	}
	
	/*
	public BookingSystem getBookSys() {
		return this.bookSys;
	}
	
	public RoomSystem getRoomSys() {
		return this.roomSys;
	}*/
	
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
	public void addRoom(ArrayList<Room> newRooms){
		this.roomSys.addRooms(newRooms);
		this.numRooms = this.roomSys.getNumRooms();
		
	}
	public ArrayList<Room> getRoom() {
		return this.roomSys.getRooms();
	}
	/*
	public ArrayList<Room> getAvailableRoom() {
		return this.roomSys.getAvailableRooms();
	}*/


	public void makeBooking(ArrayList<Room> rooms, String user, LocalDate start, int lengthOfStay) {
		this.bookSys.bookRoom(rooms, user, start, lengthOfStay);
		for(Room n :rooms) {
			this.roomSys.bookRoom(n);
		}
	}
	public ArrayList<Booking> getBookings(){
		return this.bookSys.getBookings();
	}
	
	public void cancelBooking(String name) {
		this.bookSys.removeBooking(name);
	}
	
	public void displayRoom() {
		for(Room r : this.roomSys.getRooms()) {
			System.out.println(r.toString());
		}
	}
}
 