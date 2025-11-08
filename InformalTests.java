package exercise_hotel_rooms_ver1;

public class InformalTests {

	public static void main(String[] args) {
		Room r1 = new RegularRoom(228, 3, 2);
		System.out.println(r1);

		Room r2 = new DeluxeRoom(334, 3, 2, 1);
		System.out.println(r2);

		Room r3 = new DeluxeRoom(114, 1, 1);
		System.out.println(r3);
		
		Room r4 = new RegularRoom(356, 2, 3);
		System.out.println(r4);
		
		Hotel h = new Hotel("Indigo");
		h.addRoom(r1);
		h.addRoom(r2);
		h.addRoom(r3);
		h.addRoom(r4);
		
		System.out.println(h);
		
	}

}
