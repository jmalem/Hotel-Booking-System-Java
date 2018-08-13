package ass1;

import java.time.*;
import java.util.ArrayList;

public class Booking {
	String name;
	ArrayList<Room> rooms;
	LocalDate start;
	LocalDate end;
	public Booking (String name, ArrayList<Room> roomsWanted, LocalDate start,int lengthOfStay) {
		this.name = name;
		this.rooms = new ArrayList<Room>(roomsWanted);
		this.start = start;
		this.end = start.plusDays(lengthOfStay);
	}
	public String getName() {
		return name;
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
	
}
