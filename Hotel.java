package exercise_hotel_rooms_ver1;

import java.util.ArrayList;

public class Hotel {
	private String name;
	private ArrayList<Room> rooms = new ArrayList<>();
	private ArrayList<DeluxeRoom> deluxeRooms = new ArrayList<>();
	
	public Hotel(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public int getNumRooms() {
		return rooms.size();
	}
	
	public int getNumDeluxeRooms() {
		return deluxeRooms.size();
	}
	
	public int getNumRegularRooms() {
		return getNumRooms()-getNumDeluxeRooms();
	}

	public boolean addRoom(Room r) {
		if(rooms.contains(r)) {
			return false; 
		}
		rooms.add(r);
		if(r instanceof DeluxeRoom) {
			deluxeRooms.add((DeluxeRoom)r);
		}
		return true;
	}
	
	public Room getRoom(int number) {
		Room r = new RegularRoom(number);
		int loc = rooms.indexOf(r);
		if(loc==-1) {
			return null;
		}
		return rooms.get(loc);
	}

	public boolean removeRoom(int number) {
		Room r = new RegularRoom(number);
		int loc = rooms.indexOf(r);
		if(loc==-1) {
			return false;
		}
		rooms.remove(r);
		if(r instanceof DeluxeRoom) {
			deluxeRooms.remove(r);
		}
		return true;
	}

	public double getTotalCost() {
		double sum = 0.0;
		for(Room r : rooms) {
			sum+= r.getCost();
		}
		return sum;
	}
	
	public int getNumPets() {
		int sum = 0;
		for(DeluxeRoom dr : deluxeRooms) {
			sum += dr.getNumPets();
		}
		return sum;
	}
	
	public ArrayList<RegularRoom> getRegularRooms() {
		ArrayList<RegularRoom> regRooms = new ArrayList<>();
		for(Room r : rooms) {
			if(r instanceof RegularRoom) {
				regRooms.add((RegularRoom)r);
			}
		}
		return regRooms;
	}
	
	public ArrayList<Room> getCrowdedRooms() {
		ArrayList<Room> crowdedRooms = new ArrayList<>();
		for(Room r : rooms) {
			if(r.getNumGuests()>3) {
				crowdedRooms.add(r);
			}
		}
		return crowdedRooms;
	}
	
	@Override
	public String toString() {
		String msg = "Hotel: " + name + "\n";
		msg +=       "------------------ \n";
		msg += String.format("Num rooms: %d, num reg rooms: %d, num deluxe rooms: %d, total cost=$%,.2f\n",
				this.getNumRooms(), this.getNumRegularRooms(), this.getNumDeluxeRooms(), this.getTotalCost());
		msg +=       "------------------ \n";
		int i=1;
		for(Room r : rooms) {
			msg += (i++) + ".  " + r.toString() + "\n";
		}
		return msg;
	}
}
