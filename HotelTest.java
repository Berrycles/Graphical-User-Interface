package exercise_hotel_rooms_ver1;

import java.util.ArrayList;

public class HotelTest {

	public static void main(String[] args) {
		testConstructor_And_AddRoom();
		testAddMultipleRooms();
		testGetNumRegularRooms();
		testGetNumRegularRooms_MixRooms();
		testGetNumDeluxeRooms();
		testGetNumDeluxeRooms_MixRooms();
		testGetRoom_ValidRoom();
		testGetRoom_InvalidRoom();
		testGetTotalCost_5Rooms();
		testGetTotalCost_5RoomsMix();
		testRemoveRoom_ValidRoom();
		testRemoveRoom_InvalidRoom();
		testGetNumPets_RegularRoomsOnly();
		testGetNumPets_MixRooms();
		testGetRegularRooms();
		testGetCrowdedRooms_NoCrowdedRoom();
		testGetCrowdedRooms_MixRooms();
		testToString();
	}
	
	private static void testConstructor_And_AddRoom() {
		System.out.println("-->testConstructor_And_AddRoom()");
		Hotel hotel = new Hotel("Marriot");
		Room rr = new RegularRoom(501);
		hotel.addRoom(rr);
		
		System.out.println("Expected Number of rooms = 1");
		System.out.println("  Actual Number of rooms = " + hotel.getNumRooms());
	}
	
	private static void testAddMultipleRooms() {
		System.out.println("\n-->testAddMultipleRooms");
		Hotel hotel = new Hotel("Marriot");
		Room rr = new RegularRoom(501);
		Room dr = new DeluxeRoom(601, 3, 2, 2);
		hotel.addRoom(rr);
		hotel.addRoom(dr);
		
		System.out.println("Expected Number of rooms = 2");
		System.out.println("  Actual Number of rooms = " + hotel.getNumRooms());
	}
	
	private static void testGetNumRegularRooms() {
		System.out.println("\n-->testGetNumRegularRooms()");
		Hotel hotel = getHotelRegularRooms_5();
		int numRr = hotel.getNumRegularRooms();
		
		System.out.println("Expected: Num Regular Rooms = 5");
		System.out.println("  Actual: Num Regular Rooms = " + numRr);
	}
	
	private static void testGetNumRegularRooms_MixRooms() {
		System.out.println("\n-->testGetNumRegularRooms_MixRooms()");
		Hotel hotel = getHotelMixRooms_5();
		int numRr = hotel.getNumRegularRooms();
		
		System.out.println("Expected: Num Regular Rooms = 2");
		System.out.println("  Actual: Num Regular Rooms = " + numRr);
	}
	
	private static void testGetNumDeluxeRooms() {
		System.out.println("\n-->testGetNumDeluxeRooms()");
		Hotel hotel = getHotelRegularRooms_5();
		int numDr = hotel.getNumDeluxeRooms();
		
		System.out.println("Expected: Num Deluxe Rooms = 0");
		System.out.println("  Actual: Num Deluxe Rooms = " + numDr);
	}
	
	private static void testGetNumDeluxeRooms_MixRooms() {
		System.out.println("\n-->testGetNumDeluxeRooms_MixRooms()");
		Hotel hotel = getHotelMixRooms_5();
		int numDr = hotel.getNumDeluxeRooms();
		
		System.out.println("Expected: Num Deluxe Rooms = 3");
		System.out.println("  Actual: Num Deluxe Rooms = " + numDr);
	}
	
	private static void testGetRoom_ValidRoom() {
		System.out.println("\n-->testGetRoom_ValidRoom()");
		Hotel hotel = getHotelMixRooms_5();
		int room = 401;
		
		System.out.println("Looking for room #" + room + "\n");
		Room retrieved = hotel.getRoom(room);
		System.out.println("Expected: Regular Room: room number=401, num guests=1, num nights=1, cost=$100.00");
		System.out.println("  Actual: " + retrieved);
	}
	
	private static void testGetRoom_InvalidRoom() {
		System.out.println("\n-->testGetRoom_InvalidRoom()");
		Hotel hotel = getHotelMixRooms_5();
		int room = 701;
		
		System.out.println("Looking for room #" + room + "\n");
		Room retrieved = hotel.getRoom(room);
		System.out.println("Expected: null");
		System.out.println("  Actual: " + retrieved);
	}
	
	private static void testGetTotalCost_5Rooms() {
		System.out.println("\n-->testGetTotalCost_5Rooms()");
		Hotel hotel = getHotelRegularRooms_5();
		double total = hotel.getTotalCost();
		
		System.out.println("Expected Grand Total for 5 Regular Rooms = $780.00");
		System.out.println(String.format("  Actual Grand Total for 5 Regular Rooms = $%,.2f", total));
	}
	
	private static void testGetTotalCost_5RoomsMix() {
		System.out.println("\n-->testGetTotalCost_5RoomsMix()");
		Hotel hotel = getHotelMixRooms_5();
		double total = hotel.getTotalCost();
		
		System.out.println("Expected Grand Total for 5 Mix Rooms = $1,580.00");
		System.out.println(String.format("  Actual Grand Total for 5 Mix Rooms = $%,.2f", total));
	}
	
	private static void testRemoveRoom_ValidRoom() {
		System.out.println("\n-->testRemoveRoom_ValidRoom()");
		Hotel hotel = getHotelMixRooms_5();
		int room = 401;
		System.out.println(String.format("Num Rooms before removeRoom(%d) = %d", room, hotel.getNumRooms()));
		
		hotel.removeRoom(room);
		System.out.println(String.format("Num Rooms after removeRoom(%d) = %d", room, hotel.getNumRooms()));
	}
	
	private static void testRemoveRoom_InvalidRoom() {
		System.out.println("\n-->testRemoveRoom_InvalidRoom()");
		Hotel hotel = getHotelMixRooms_5();
		int room = 701;
		System.out.println(String.format("Num Rooms before removeRoom(%d) = %d", room, hotel.getNumRooms()));
		
		hotel.removeRoom(room);
		System.out.println(String.format("Num Rooms after removeRoom(%d) = %d", room, hotel.getNumRooms()));
	}
	
	private static void testGetNumPets_RegularRoomsOnly() {
		System.out.println("\n-->testGetNumPets_RegularRoomsOnly()");
		Hotel hotel = getHotelRegularRooms_5();
		System.out.println("Expected Num Pets = 0");
		System.out.println("  Actual Num Pets = " + hotel.getNumPets());
	}
	
	private static void testGetNumPets_MixRooms() {
		System.out.println("\n-->testGetNumPets_MixRooms()");
		Hotel hotel = getHotelMixRooms_5();
		System.out.println("Expected Num Pets = 3");
		System.out.println("  Actual Num Pets = " + hotel.getNumPets());
	}
	
	private static void testGetRegularRooms() {
		System.out.println("\n-->testGetRegularRooms()");
		Hotel hotel = getHotelMixRooms_5();
		System.out.println("Num Regular Rooms = "
				+ hotel.getNumRegularRooms() 
				+ "\nRooms:");
		
		for(Room room : hotel.getRegularRooms()) {
			System.out.println(room);
		}
	}
	
	private static void testGetCrowdedRooms_NoCrowdedRoom() {
		System.out.println("\n-->testGetCrowdedRooms_NoCrowdedRoom()");
		Hotel hotel = getHotelRegularRooms_5();
		ArrayList<Room> crowdedRooms = hotel.getCrowdedRooms();
		
		System.out.println("Num Crowded Rooms = "
				+ crowdedRooms.size() 
				+ "\nRooms:");
		
		for(Room room : crowdedRooms) {
			System.out.println(room);
		}	
	}
	
	private static void testGetCrowdedRooms_MixRooms() {
		System.out.println("\n-->testGetCrowdedRooms_MixRooms()");
		Hotel hotel = hetHotelWithCrowdedRooms();
		ArrayList<Room> crowdedRooms = hotel.getCrowdedRooms();
		
		System.out.println("Num Crowded Rooms = "
				+ crowdedRooms.size() 
				+ "\nRooms:");
		
		for(Room room : crowdedRooms) {
			System.out.println(room);
		}
	}
	
	private static void testToString() {
		System.out.println("\n-->testToString()");
		Hotel hotel = indigo();
		System.out.println(hotel.toString());
	}
	
	
	
	
	/**
	 * Helpers
	 */
	private static Hotel getHotelRegularRooms_5() {
		Hotel hotel = new Hotel("Marriot");
		Room r1 = new RegularRoom(101); //--> $100.00
		Room r2 = new RegularRoom(201, 2, 2); //--> $240.00	
		Room r3 = new RegularRoom(301, 2, 2); //--> $240.00
		Room r4 = new RegularRoom(401);	//--> $100.00
		Room r5 = new RegularRoom(501); //--> $100.00
		hotel.addRoom(r1);
		hotel.addRoom(r2);
		hotel.addRoom(r3);
		hotel.addRoom(r4);
		hotel.addRoom(r5);
		
		return hotel;
	}
	
	private static Hotel getHotelMixRooms_5() {
		Hotel hotel = new Hotel("Marriot");
		Room r1 = new DeluxeRoom(101, 3, 2); //--> $360.00
		Room r2 = new RegularRoom(201, 2, 2); //--> $240.00
		Room r3 = new DeluxeRoom(301, 2, 2); //--> $340.00
		Room r4 = new RegularRoom(401); //--> $100.00
		Room r5 = new DeluxeRoom(501, 3, 3); //--> $540.00
		
		hotel.addRoom(r1);
		hotel.addRoom(r2);
		hotel.addRoom(r3);
		hotel.addRoom(r4);
		hotel.addRoom(r5);
		
		return hotel;
	}
	
	private static Hotel hetHotelWithCrowdedRooms() {
		Hotel hotel = new Hotel("Marriot");
		Room r1 = new DeluxeRoom(101, 3, 2);
		Room r2 = new RegularRoom(201, 2, 2);
		Room r3 = new DeluxeRoom(301, 4, 2);
		Room r4 = new RegularRoom(401, 4, 2);
		Room r5 = new DeluxeRoom(501, 3, 3);
		
		hotel.addRoom(r1);
		hotel.addRoom(r2);
		hotel.addRoom(r3);
		hotel.addRoom(r4);
		hotel.addRoom(r5);
		
		return hotel;
	}
	
	private static Hotel indigo() {
		Hotel hotel = new Hotel("Indigo");
		Room r1 = new RegularRoom(228, 3, 2);
		Room r2 = new DeluxeRoom(334, 3, 2);
		Room r3 = new DeluxeRoom(114, 1, 1);
		Room r4 = new RegularRoom(356, 2, 3);
		
		hotel.addRoom(r1);
		hotel.addRoom(r2);
		hotel.addRoom(r3);
		hotel.addRoom(r4);
		
		return hotel;
	}
}
