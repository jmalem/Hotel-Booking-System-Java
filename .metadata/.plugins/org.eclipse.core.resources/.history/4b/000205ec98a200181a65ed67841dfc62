package ass1;

import java.time.LocalDate;
import java.util.ArrayList;

public class Hotel {
	private String name;
	private ArrayList<Room> rooms;
	private ArrayList<Booking> bookings;
	/**
	 * Creates a hotel with name name and containing the room collection rooms
	 * @param name
	 * @param rooms
	 */
	public Hotel(String name, ArrayList<Room> rooms) {
		this.name = name;
		this.bookings = new ArrayList<Booking>();
		this.rooms=rooms;
	}
	
	public String getHotelName() {
		return this.name;
	}

	public void addRoom(ArrayList<Room> newRooms){
		for(Room r : newRooms) {
			this.rooms.add(r);
		}
	}
	public ArrayList<Room> getRoom() {
		return this.rooms;
	}
	/**
	 * This method creates a booking and inserts it in ascending order in this.bookings
	 * also set the booked rooms' booking to the latest booking
	 * @param rooms Rooms to be booked
	 * @param user Customer name
	 * @param start Booking start date
	 * @param lengthOfStay Length of Stay
	 */
	public void makeBooking(ArrayList<Room> rooms, String user, LocalDate start, int lengthOfStay) {
		Booking b = new Booking(user, rooms, start, lengthOfStay, this.name);
		if(this.bookings.size()==0) {
			this.bookings.add(b);
		} else {
			
			for(int i=0; i<this.bookings.size();i++) {
				//System.out.println(i);
				Booking curr = bookings.get(i);
				LocalDate currStart = curr.getStart();
				if(i==0 && (b.getStart().isBefore(currStart))) {
					this.bookings.add(0,b);
					break;
				} else if(i==this.bookings.size()-1 && (b.getStart().isAfter(currStart) ||b.getStart().isEqual(currStart))) {
					this.bookings.add(b);
					break;
				} else {
					if(b.getStart().isAfter(curr.getStart()) && i!=this.bookings.size()-1) {
						this.bookings.add(i+1, b);
						break;
					}	
				}
			
			}
		}
		System.out.println(b.showBook());
		for(Room n :rooms) {
			n.setBooking(b);
		}
	}
	
	
	public ArrayList<Booking> getBookings(){
		return this.bookings;
	}
	
	/**
	 * Cancels booking for a customer
	 * Removes all instances of booking with customer name
	 * and removes all booking in rooms that is associated with this customer
	 * replaces all those bookings with the latest previous bookings for that room number
	 * @param name Customer
	 * @param typeOfBooking No output when typeOfBooking is "Change"
	 */
	public void cancelBooking(String name, String typeOfBooking) {
		
		ArrayList<Integer> indexes = new ArrayList<Integer> ();
		Booking tmp =null;
		for(Booking b : bookings) {
			if(b.getName().equals(name)) {
				indexes.add(bookings.indexOf(b));
				tmp=b;
			}
		}
		// dont forget to set the booking in each room to null
		// booked contains the room number of booked rooms
		
		ArrayList<Integer> booked = new ArrayList<Integer>();
		for(Room r :tmp.getRooms()) {
			booked.add(r.getRoomNumber());
		}
		// if the room in hotel is one of the booked rooms, set the booking to null
		for(Room r : this.rooms) {
			int num =r.getRoomNumber();
			//System.out.println("HERE");
			if(booked.contains(num)) {
				r.setBooking(null);
				
				// replaces the booking  with the latest booking if there is
				for (int i = bookings.size()-1; i>=0; i--) {
					Booking c=bookings.get(i);
					for(Room x:c.getRooms()) {
						// if the prev booking room number = this room number		
						if(x.getRoomNumber()==r.getRoomNumber()) {
							r.setBooking(c);
							
						}
					}
				}
			}
		}
		
		for(int index : indexes) {
			bookings.remove(index);
		}
		if(typeOfBooking.equals("Booking")) {
			System.out.println("Cancel "+name);	
		}
	}
	
}
 