package ass1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public class BookingSystem {
	private ArrayList<Booking> bookings;
	public BookingSystem() {
		this.bookings = new ArrayList<Booking>();
	}
	
	public Booking bookRoom(ArrayList<Room> rooms, String user, LocalDate start, int lengthOfStay) {
		
		Booking b = new Booking(user, rooms, start, lengthOfStay);
		this.bookings.add(b);
		
		for(Room r : rooms) {
			r.setBooking(b);
		}
		return b;
	}
	public ArrayList<Booking> getBookings() {
		return this.bookings;
	}
	
	public void removeBooking(String name) {
		Iterator<Booking> iter = bookings.iterator();
		if(bookings.size()==0) {
			/*
			if(bookings.get(0).getName().equals(name)) {
				bookings.remove(0);
			}*/
		}
		// Still gives a concurrent modification exception
		while (iter.hasNext()) {
		    Booking b = iter.next();

		    if (b.getName().equals(name)) {
		        
		    	iter.remove();
		    }
		}
		/*// causes concurrent modification exception
		for(Booking b : bookings) {
			if(b.getName().equals(name)) this.bookings.remove(b);
		}*/
	}
}
