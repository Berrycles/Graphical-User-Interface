package exercise_hotel_rooms_ver1;

public class RegularRoomTest {

	public static void main(String[] args) {
		testMainConstructor();
		testConvinienceConstructor();
		testGetCost();
		testEquals_True();
		testEquals_False();
	}
	
	private static void testMainConstructor() {
		System.out.println("-->testMainConstructor()");
		RegularRoom rr = new RegularRoom(228, 3,2);
		System.out.println("Expected: Regular Room: room number=228, num guests=3, num nights=2, cost=$280.00");
		System.out.println("  Actual: " + rr.toString());
	}
	
	private static void testConvinienceConstructor() {
		System.out.println("\n-->testConvinienceConstructor()");
		RegularRoom rr = new RegularRoom(505);
		System.out.println("Expected: Regular Room: room number=505, num guests=1, num nights=1, cost=$100.00");
		System.out.println("  Actual: " + rr.toString());
	}
	
	private static void testGetCost() {
		System.out.println("\n-->testGetCost()");
		RegularRoom rr = new RegularRoom(401, 4, 6);
		double expected = 960.00;
		System.out.println(String.format("Expected Grand Total: $%,.2f", expected));
		System.out.println(String.format("  Actual Grand Total: $%,.2f", rr.getCost()));
	}
	
	private static void testEquals_True() {
		System.out.println("\n-->testEquals()");
		RegularRoom rr1 = new RegularRoom(505, 5, 5);
		RegularRoom rr2 = new RegularRoom(505);
		
		System.out.println("Expected: rr1 is equal to rr2? = true");
		System.out.println("  Actual: rr1 is equal to rr2? = " + rr1.equals(rr2));
	}
	
	private static void testEquals_False() {
		System.out.println("\n-->testEquals_False()");
		RegularRoom rr1 = new RegularRoom(505, 5, 5);
		RegularRoom rr2 = new RegularRoom(401);
		
		System.out.println("Expected: rr1 is equal to rr2? = false");
		System.out.println("  Actual: rr1 is equal to rr2? = " + rr1.equals(rr2));
	}
}
