package ass1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Hotel {
	private String name;	
	private int numRooms;
	private ArrayList<Room> rooms;
	private ArrayList<Booking> bookings;
	
	public Hotel(String name, ArrayList<Room> rooms) {
		this.numRooms = rooms.size();
		this.name = name;
		//this.users = new ArrayList<String>();
		this.rooms.addAll(rooms);
	}
	
	public String getHotelName() {
		return this.name;
	}

	public int numRooms() {
		return this.numRooms;
	}
	
	public void addRoom(ArrayList<Room> newRooms){
		this.rooms.addAll(newRooms);
		this.numRooms = this.rooms.size();
		
	}
	public ArrayList<Room> getRoom() {
		return this.rooms;
	}

	public void makeBooking(ArrayList<Room> rooms, String user, LocalDate start, int lengthOfStay) {
		Booking b = new Booking(user, rooms, start, lengthOfStay);
		this.bookings.add(b);
		
		for(Room n :rooms) {
			n.setBooking(b);
		}
	}
	public ArrayList<Booking> getBookings(){
		return this.bookings;
	}
	
	public void cancelBooking(String name) {
		
		ArrayList<Integer> indexes = new ArrayList<Integer> ();
		
		for(Booking b : bookings) {
			if(b.getName().equals(name)) {
				indexes.add(bookings.indexOf(b));
			}
		}
		
		for(int index : indexes) {
			bookings.remove(index);
		}
	}
	
	public void displayRoom() {
		for(Room r : this.rooms) {
			System.out.println(r.toString());
		}
	}
}
 