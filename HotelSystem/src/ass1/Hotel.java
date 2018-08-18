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
		this.bookings = new ArrayList<Booking>();
		this.rooms=rooms;
	}
	
	public String getHotelName() {
		return this.name;
	}

	public int numRooms() {
		return this.numRooms;
	}
	
	public void addRoom(ArrayList<Room> newRooms){
		for(Room r : newRooms) {
			this.rooms.add(r);
		}
		this.numRooms = this.rooms.size();
		
	}
	public ArrayList<Room> getRoom() {
		return this.rooms;
	}

	public void makeBooking(ArrayList<Room> rooms, String user, LocalDate start, int lengthOfStay) {
		Booking b = new Booking(user, rooms, start, lengthOfStay, this.name);
		//System.out.println(user+" bookmana "+this.bookings.size());
		if(this.bookings.size()==0) {
			this.bookings.add(b);
		} else {
			
			for(int i=0; i<this.bookings.size();i++) {
				//System.out.println(i);
				Booking curr = bookings.get(i);
				LocalDate currStart = curr.getStart();
				LocalDate currEnd = curr.getEnd();
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
	/*
	public void changeBooking(ArrayList<Room> rooms, String user, LocalDate start, int lengthOfStay) {
		Booking b = new Booking(user, rooms, start, lengthOfStay);
		this.bookings.add(b);
		
		for(Room n :rooms) {
			n.setBooking(b);
		}
	}*/
	
	public ArrayList<Booking> getBookings(){
		return this.bookings;
	}
	
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
	public void displayRoom() {
		for(Room r : this.rooms) {
			System.out.println(r.toString());
		}
	}
	public StringBuilder printBook(Hotel h, ArrayList<Booking> bookings) {
		
		
		//System.out.println("HERE "+details);
		return null;
	}
}
 