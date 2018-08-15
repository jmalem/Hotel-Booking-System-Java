package ass1;

import java.io.File;
import java.io.FileNotFoundException;
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
		        	  
		          }
		          
		          // Handels request for Booking creation
		          else if (allInput[0].equals("Booking")) {
		        	  
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
