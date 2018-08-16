package ass1;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class HotelBookingSystem {
	
	private static ArrayList<Hotel> hotels;
	public HotelBookingSystem() {
		this.hotels = new ArrayList<Hotel>();
	}
	
	public void addHotel(Hotel h) {
		this.hotels.add(h);
	}
	
	
	public static void main (String args[]) {
		  Scanner sc = null;
		  HotelBookingSystem hotelSys= new HotelBookingSystem();

	      try
	      {
	    	  // args[0] is the first command line argument	    	  
	    	  sc = new Scanner(new File(args[0]));
	    	  // Read input from the scanner here
	          while(sc.hasNextLine()) { // go through all lines in input
		    	  String input = sc.nextLine();
		          String[] allInput = input.split(" ");
		          
		          // Create new instance of hotel booking system
		          // each hotel has 1 booking system
		          
		          
		          
		          // Handles request for Hotel Creation
		          if(allInput[0].equals("Hotel")) {
		        	  ArrayList<Room> rooms  = new ArrayList<Room>();
		        	  // create all the rooms and put it in a list
		        	  for(int i =2; i <allInput.length;i+=2) {
		        		  rooms.add(new Room(Integer.valueOf(allInput[i]), Integer.valueOf(allInput[i+1]), allInput[1]));
		        	  }
		        	  
		        	  
		        	  int hotelExist =0;
		        	  for(Hotel x :hotels) {
		        		  if(x.getHotelName().equals(allInput[1])) {
		        			  hotelExist=1;//if hotel exist set indicator to 1
		        			  x.addRoom(rooms);// and add all the new rooms
		        			  System.out.println("Hotel "+x.getHotelName()+" now has "+x.numRooms()+" rooms");
		        			  break;
		        		  }
		        	  }
		        	  if(hotelExist==0) {
		        		  // create the hotel with all the rooms
		        		  Hotel z = new Hotel(allInput[1], rooms);
		        	  
		        	  	  // insert the hotel object into the list of hotels
		        		  hotelSys.addHotel(z);
		        		  
		        		  System.out.println("Hotel "+z.getHotelName()+" now has "+z.numRooms()+" rooms");// testing purpose
		        	  }
		        	  /*
			          //display the rooms in every hotel
			          // testing purpose
			          for(Hotel e : hotels) {
			        	  ArrayList<Room> all = e.getRoom();
			        	  for(Room l : all) {
			        		  System.out.println(l.toString());
			        	  }
			          }*/
		          }
		          
		          
		          
		          // Handles request for Booking creation
		          else if (allInput[0].equals("Booking")) {

		        	  String name = allInput[1];
		        	  //System.out.println(name);
		        	  String booking_date = "2018-"+allInput[2]+"-"+allInput[3];
		        	  DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MMM-dd");
		        	  LocalDate date = LocalDate.parse(booking_date, format); // date is the start date
		        	  int night = Integer.valueOf(allInput[4]);
		        	  ArrayList<Room> toBeBooked = new ArrayList<Room>();
		        	  
		        	  // starting from allInput[5] and so on is the room type and the amount of room booked
		        	  int singleRoom = 0;
		        	  int doubleRoom = 0;
		        	  int tripleRoom = 0;
		        	  // count the number of single double and triple room wanted
		        	  for(int i=5;i<allInput.length; i+=2) {
		        		  
		        		  if(allInput[i].equals("single")) {
		        			  
		        			  singleRoom+=Integer.parseInt(allInput[i+1]);
		        		  } else if(allInput[i].equals("double")) {
		        			  
		        			  doubleRoom+=Integer.parseInt(allInput[i+1]);
		        		  } else if(allInput[i].equals("triple")) {
		        			  
		        			  tripleRoom+=Integer.parseInt(allInput[i+1]);
		        		  }
		        		  
		        	  }
		        	  /*
		        	  // testing--------
		        	  System.out.println("s "+singleRoom);
		      		  System.out.println("d "+doubleRoom);
		      		  System.out.println("t "+tripleRoom);
		        	  */
		        	  Hotel wanted = null;
		        	  ArrayList<Room> roomCollection = new ArrayList<Room>();
		        	  int found = 0;
		        	  for(Hotel h : hotels) {
		        		  found=0;
		        		  roomCollection = h.getRoom();
		        		  //h.displayRoom();
		        		  //ArrayList<Room> order = new ArrayList<Room>();
		        		  int s = 0;// single room in hotel h
		        		  int d = 0;// double room in hotel h
		        		  int t = 0;// triple room in hotel h
		        		  
		        		  
		        		  
		        		  for (Room r : roomCollection) {
		        			  //System.out.println(r.toString());
		        			  if(r.getCapacity()==1) {
		        				  s++;
		        			  } else if (r.getCapacity()==2) {
		        				  d++;
		        			  } else if (r.getCapacity()==3) {
		        				  t++;
		        			  }
		        			  
		        			  if(singleRoom<=s && doubleRoom<=d && tripleRoom<=t) {
		        				  found=1;
		        				  //System.out.println("Rooms found in hotel "+h.getHotelName()+" for "+name);
		        				  wanted = h;
		        				  break;
		        			  }
		        			  
		        		  }
		        		  // to stop the loop from searching in other hotel again
		        		  if(found==1) {
		        			  break;
		        		  }
		        	  }
		        	  
		        	  //System.out.println(s+" " +" "+ d+" " +t);
		        	  if(wanted==null) {
		        		  System.out.println("No room was found");
		        		  return;
		        	  } else {
		        		  	// get all rooms and do some checking on the date
		        		  	ArrayList<Room> hotelRooms = wanted.getRoom();
		        		  
		        		  	int ws = singleRoom;
		        		  	int wd = doubleRoom;
		        		  	int wt = tripleRoom;
		        		  	// we are sure that the hotel contains the room
		        		  	for(Room r : hotelRooms) {
		        		  		//System.out.println(r.toString());
		        		  		Booking currRoom = r.getBooking();
		        			  	if(r.getCapacity()==1 && ws!=0 && (currRoom==null || currRoom.getEnd().equals(date) || currRoom.getEnd().isBefore(date))) {
		        				  	//System.out.println("S add "+r.getRoomNumber());	  		
		        				  	toBeBooked.add(r);
		        				  	ws--;
		        			  	} else if (r.getCapacity()==2 && wd!=0 && (currRoom==null || currRoom.getEnd().equals(date) || currRoom.getEnd().isBefore(date))) {
		        				  	//System.out.println("D add "+r.getRoomNumber());
		        				  	toBeBooked.add(r);
		        				  	wd--;
		        			  	} else if (r.getCapacity()==3 && wt!=0 && (currRoom==null || currRoom.getEnd().equals(date) || currRoom.getEnd().isBefore(date))) {
		        				  	//System.out.println("T add "+r.getRoomNumber());
		        				  	toBeBooked.add(r);
		        				  	wt--;
		        			  	}
		        			  	if(ws==0 && wd==0 && wt==0) {
		        				  	break;
		        			  	}
		        			  
		        		  	}
		        		  
		        	  }
		        	  // Make the booking
		        	  wanted.makeBooking(toBeBooked, name, date, night);
		        	  // test purpose: display all the booking
		        	  for(Booking b: wanted.getBookings()) {
		        		  System.out.println(b.toString());
		        	  }
		        	  System.out.println("\n\n");
		          } else if (allInput[0].equals("Cancel")) {
		        	  String name = allInput[1];
		        	  for (Hotel h : hotels) {
		        		  for(Booking b : h.getBookings()) {
		        			  if(b.getName().equals(name)) {
		        				  ArrayList<Room> rooms = b.getRooms();
		        				  for(Room r : rooms) {
		        					  if(r.getBooking()!=null) {
		        						  r.setBooking(null);
		        					  }
		        				  }
		        				  // cancel the booking after we remove the booking
		        				  // from the room
		        				  h.cancelBooking(b.getName());
		        				  
		        			  }
		        		  }
		        	  }
		        	  System.out.println("DELETION:\n");
		        	  for(Hotel h : hotels) {
		        		  if(h.getBookings()==null) break;
			        	  for(Booking b: h.getBookings()) {
			        		  System.out.println(b.toString());
			        	  }
		        	  }
		          }
		          
	          }
	      }
	      catch (FileNotFoundException e)
	      {
	          System.out.println(e.getMessage());
	      }
	      finally
	      {
	          if (sc != null) sc.close();
	      }
	}
}
