package ass1;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * 
 * @author jansen
 * This class implements booking system that is able to make booking across hotels
 * also able to change, cancel, and print booking
 */
public class HotelBookingSystem {
	private ArrayList<Hotel> hotels;
	
	public HotelBookingSystem() {
		this.hotels = new ArrayList<Hotel>();
	}
	/**
	 * Find a hotel in collection of hotels
	 * if found return the hotel object else return null
	 * @param hotelName
	 * @return Hotel
	 */
	public Hotel hotelExist(String hotelName) {
		
		for(Hotel h:hotels) {
			if(h.getHotelName().equals(hotelName)) {
				return h;
			}
		}
		return null;
	}
	/**
	 * Parse input string and creates a new Hotel or add rooms to existing hotels
	 * Utilizes hotelExist method to simplify hotel search
	 * Adds the new hotel to this.bookings
	 * @param input A line of string from the input.txt
	 */
	public void makeNewHotel(String input) {
		// Create new instance of hotel booking system
        // each hotel has 1 booking system
        
        String[] allInput = input.split(" ");
		
        // Handles request for Hotel Creation
        
      	  ArrayList<Room> rooms  = new ArrayList<Room>();
      	  // create all the rooms and put it in a list
      	  for(int i =2; i <allInput.length;i+=2) {
      		  if(Integer.valueOf(allInput[i+1])<=3) {
      			  rooms.add(new Room(Integer.valueOf(allInput[i]), Integer.valueOf(allInput[i+1]), allInput[1]));
      		  }
      	  }
      	  Hotel h = hotelExist(allInput[1]);
      	  if(h==null) {
    		  Hotel x = new Hotel(allInput[1], rooms);
    		  hotels.add(x);
    	  } else {
    		  h.addRoom(rooms);
    	  }
      	  
	}
	/**
	 * This method looks for a collection of single, double, and triple room in the hotel
	 * that is available from start to end
	 * @param ws wanted single room
	 * @param wd wanted double room
	 * @param wt wanted triple room
	 * @param start booking start date
	 * @param end booking end date
	 * @return
	 */
	public ArrayList<Room> findARoom(int ws, int wd, int wt, LocalDate start, LocalDate end) {
		ArrayList <Room> result = new ArrayList<Room>();
		int s = 0;// single room in the hotel
		int d = 0;
		int t = 0;
		int found=0;
		Hotel foundHotel = null;
		for(Hotel h : hotels) {
			ArrayList<Room> hotelRooms = h.getRoom();
			Booking b = null;
			s=0;
			d=0;
			t=0;
			
			for(Room r : hotelRooms) {
				// b is the booking for that room
				b=r.getBooking();
				if(b==null) {
					//System.out.println("Here");
					if(r.getCapacity()==1 && s<ws) {
						s++;
					} else if(r.getCapacity()==2 && d<wd) {
						d++;
					} else if(r.getCapacity()==3 && t<wt) {
						t++;
					}
					
				} else {
					// check the date first
					LocalDate bookingStart = b.getStart(); // start date of that room
					LocalDate bookingEnd = b.getEnd(); //end date of that room
					if(bookingStart.isAfter(end)||bookingStart.isEqual(end)||bookingEnd.isBefore(start) || bookingEnd.isEqual(start)) {
						
						// now check the capacity
						if(r.getCapacity()==1) {
							s++;
						} else if(r.getCapacity()==2) {
							d++;
						} else if(r.getCapacity()==3) {
							t++;
						}
					}
				}
				if(s>=ws && d>=wd && t>=wt) {
					found=1;
					foundHotel=h;
					break;
				}
				
				
			}
			if(found==0) {
				continue;
			}
			//Go through the room in the hotel and add them to to result
			s=0;
			d=0;
			t=0;
			for(Room r : foundHotel.getRoom()) {
				// b is the booking for that room
				b=r.getBooking();
				
				
				if(b==null) {
					if(r.getCapacity()==1 && s!=ws) {
						result.add(r);
						s++;
					} else if(r.getCapacity()==2 && d!=wd) {
						result.add(r);
						d++;
					} else if(r.getCapacity()==3 && t!=wt) {
						result.add(r);
						t++;
					}
				} else {
					// check the date first
					LocalDate bookingStart = b.getStart(); // start date of that room
					LocalDate bookingEnd = b.getEnd(); //end date of that room
					if(bookingStart.isAfter(end)||bookingStart.isEqual(end)||bookingEnd.isBefore(start) || bookingEnd.isEqual(start)) {
						
						// now check the capacity
						if(r.getCapacity()==1 && s!=ws) {
							result.add(r);
							s++;
						} else if(r.getCapacity()==2 && d!=wd) {
							result.add(r);
							d++;
						} else if(r.getCapacity()==3 && t!=wt) {
							result.add(r);
							t++;
						}
						
					}
				}
				if(s==ws && d==wd && t==wt) {
					return result;
				}
				
				
			}
		}
		
		return null;
	}
	/**
	 * Parses the input and create a booking
	 * Can be used to change existing booking by specifying typeOfBooking as "Change"
	 * Utilizes findARoom and hotelExist to make search easier
	 * @param input contains the desired room type, the quantity, booking start date, and length of stay
	 * @param typeOfBooking either "Booking" or "Change" the method prints the typeOfBooking to show whether this method is called to make a new booking or to change existing booking
	 */
	public void makeNewBooking(String input, String typeOfBooking) {
		String[] allInput = input.split(" ");
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
	    
	    
  	  	Hotel wanted = null;
  	  	
  	  	toBeBooked = findARoom(singleRoom, doubleRoom, tripleRoom, date, date.plusDays(night));
  	  	if( toBeBooked==null || toBeBooked.isEmpty()) {
  	  		System.out.println("Booking rejected");
			return;
  	  	}
  	  	String hotelName = toBeBooked.get(0).getHotel();
	  	// hotel definitely exist so dont have to check
  	  	wanted = hotelExist(hotelName);
	  	
  	  	
  		System.out.print(typeOfBooking+" ");
	  	
  	  	wanted.makeBooking(toBeBooked, name, date, night);
  	  	
  	  	
	}
	/**
	 * Cancel all the bookings for the user specified in input
	 * when typeOfInput.equals("Change") this function outputs nothing
	 * @param input Contains username
	 * @param typeOfInput Either "Booking" or "Change", produces output for "Booking" but not for "Change"
	 */
	public void cancelBooking(String input, String typeOfInput) {
		String[] allInput = input.split(" ");
		String name = allInput[1];
		//System.out.println(name);
		int found = 0;
		for (Hotel h : this.hotels) {
			ArrayList<Booking> hotelBookings = h.getBookings();
			
			found = 0;
			int hotelIndex = -1;
			for(Booking b : hotelBookings) {
				if(b.getName().equals(name)) {
					found=1;
					hotelIndex=hotels.indexOf(h);
					break;
				}
				
				
			}
			if(found==1) {
				Hotel rem = hotels.get(hotelIndex);
				rem.cancelBooking(name, typeOfInput);
				break;
			}
  	  	}
		if (found==0) {
  	  		// if no room was found just exit and dont print anything
  	  		return;
  	  	}
	}
	/**
	 * Changes an existing booking
	 * Utilizes cancelBooking and makeNewBooking method
	 * @param input
	 */
	 
	public void changeBooking(String input) {
		String[] allInput = input.split(" ");
		String name = allInput[1];
		cancelBooking(name, "Change");
		makeNewBooking(input, "Change");
		
	}
	
	/**
	 * Print the status of room in the specified hotel
	 * Starts by displaying the rooms without any booking in order
	 * Then displays all the rooms with booking according to the booking date in ascending order
	 * @param hotelName Hotel Name which room is going to be shown
	 */
	public void roomStatus(String hotelName) {
		Hotel h = hotelExist(hotelName);
		
		if(h==null) {
			System.out.println("Hotel not found");
			return;
		} else {
			// check bookings for every room in the hotel and match it with the room in the collection of bookings
			// then print them accordingly
			ArrayList<Booking> allBookings = h.getBookings();
			ArrayList<Room> allRooms = h.getRoom();
			for(Room r : allRooms) {
				if(r==null || r.getBooking()==null) {
					System.out.println(r.getHotel()+" "+r.getRoomNumber());
				} else {
					System.out.print(r.getHotel()+" "+r.getRoomNumber());
					for(Booking a : allBookings) {
						ArrayList<Room> inBooking = a.getRooms();
						for(Room q : inBooking) {
							if(q.getRoomNumber()==r.getRoomNumber()) {
								DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd");
								String startDate =a.getStart().format(formatter);
								System.out.print(" "+startDate+" "+a.getNight());
							}
						}
					}
					System.out.println();				
				}
			}
		}
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
		          if(allInput[0].equals("Hotel")) { // Handles hotel creation
		        	  hotelSys.makeNewHotel(input);
		        	  
		          } else if (allInput[0].equals("Booking")) { // Handles booking creation
		        	  hotelSys.makeNewBooking(input, "Booking");
		        	  
		          } else if (allInput[0].equals("Cancel")) { // Handles Cancel booking
		        	  hotelSys.cancelBooking(input, "Booking");
		        	  
		          } else if (allInput[0].equals("Change")) { // Handles booking change
		        	  hotelSys.cancelBooking(input, "Change");
		        	  hotelSys.makeNewBooking(input, "Change");
		          } else if (allInput[0].equals("Print")) { // Handles Print
		        	  hotelSys.roomStatus(allInput[1]);
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
