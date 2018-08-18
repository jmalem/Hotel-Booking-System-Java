package ass1;

import java.time.*;
import java.util.ArrayList;

public class Booking {
	private String name;
	private ArrayList<Room> rooms;
	private LocalDate start;
	private LocalDate end;
	private String hotel;
	private int lengthOfStay;
	/**
	 * This constructor creates a booking for a certain user, contains the rooms wanted, and dates of booking
	 * @param name The name of the booker
	 * @param roomsWanted The rooms that are going to be booked
	 * @param start The booking start date
	 * @param lengthOfStay The length of stay
	 * @param hotelName The name of hotel
	 */
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
	/**
	 * 
	 * @return This method return a string which contains a booking detail
	 */
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
