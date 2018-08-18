package ass1;

import java.time.LocalDate;
import java.util.ArrayList;

public class Room {
	int roomNumber;
	int capacity;
	String hotel;
	Booking booking;
	public Room(int roomNumber, int capacity, String hotel) {
		this.roomNumber = roomNumber;
		this.capacity = capacity;
		this.hotel = hotel;
		this.booking = null;
	}
	
	public void setBooking(Booking b) {
		this.booking = b;
	}
	
	public Booking getBooking() {
		return this.booking;
	}
	
	public String getHotel() {
		return hotel;
	}

	public void setHotel(String hotel) {
		this.hotel = hotel;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public int getCapacity() {
		return capacity;
	}
	
}
