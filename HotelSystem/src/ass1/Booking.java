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
	/**
	 * Get the name of the booker
	 * @return String
	 */
	public String getName() {
		return this.name;
	}
	/**
	 * Set the name in the booking
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * Get collection of rooms for the current booking
	 * @return ArrayList<Room>
	 */
	public ArrayList<Room> getRooms() {
		return rooms;
	}
	/**
	 * Set rooms for the booking
	 * @param rooms
	 */
	public void setRooms(ArrayList<Room> rooms) {
		this.rooms = rooms;
	}
	/**
	 * Return the booking start date
	 * @return LocalDate
	 */
	public LocalDate getStart() {
		return this.start;
	}
	/**
	 * Return booking end date
	 * @return LocalDate
	 */
	public LocalDate getEnd() {
		return this.end;
	}
	/**
	 * Return the hotel name in which the booking belongs to
	 * @return String
	 */
	public String getHotel() {
		return this.hotel;
	}
	/**
	 * Set hotel name for a booking
	 * @param name
	 */
	public void setHotel(String name) {
		this.hotel=name;
	}
	/**
	 * Get the number of nights the booking is made for
	 * @return Integer
	 */
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
