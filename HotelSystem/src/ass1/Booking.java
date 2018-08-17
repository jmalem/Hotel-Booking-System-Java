package ass1;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Booking {
	String name;
	ArrayList<Room> rooms;
	LocalDate start;
	LocalDate end;
	String hotel;
	int lengthOfStay;
	public Booking (String name, ArrayList<Room> roomsWanted, LocalDate start,int lengthOfStay, String hotelName) {
		this.name = name;
		this.rooms = new ArrayList<Room>(roomsWanted);
		this.start = start;
		this.end = start.plusDays(lengthOfStay);
		this.hotel = hotelName;
		this.lengthOfStay = lengthOfStay;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Room> getRooms() {
		return rooms;
	}
	public void setRooms(ArrayList<Room> rooms) {
		this.rooms = rooms;
	}
	
	public LocalDate getStart() {
		return this.start;
	}
	
	public LocalDate getEnd() {
		return this.end;
	}
	public String getHotel() {
		return this.hotel;
	}
	
	public void setHotel(String name) {
		this.hotel=name;
	}
	
	public int getNight() {
		return this.lengthOfStay;
	}
	public StringBuilder showBook() {
		StringBuilder booked = new StringBuilder();
		booked.append(name);
		booked.append(" ");
		booked.append(this.hotel);
		for(Room r : rooms) {
			booked.append(" ");
			booked.append(r.getRoomNumber());
		}
		return booked;
	}
	
	
}
