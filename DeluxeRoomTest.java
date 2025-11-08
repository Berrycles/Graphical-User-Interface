package exercise_hotel_rooms_ver1;

public class DeluxeRoomTest {

	public static void main(String[] args) {
		testMainConstructor();
		testConvenienceConstructor();
		testGetCost_WithPets_OneGuest();
		testGetCost_WithPets_MoreThanOneGuest();
		testGetCost_WithoutPets_OneGuest();
		testGetCost_WithoutPets_MoreThanOneGuest();
		testEquals_True();
		testEquals_False();
	}
	
	private static void testMainConstructor() {
		System.out.println("-->testMainConstructor()");
		DeluxeRoom dr = new DeluxeRoom(334, 3, 2, 1);
		System.out.println("Expected: Deluxe Room: room number=334, num guests=3, num pets=1, num nights=2, cost=$360.00");
		System.out.println("  Actual: " + dr);
	}
	
	private static void testConvenienceConstructor() {
		System.out.println("\n-->testConvenienceConstructor()");
		DeluxeRoom dr = new DeluxeRoom(228, 2, 2);
		System.out.println("Expected: Deluxe Room: room number=228, num guests=2, num pets=1, num nights=2, cost=$340.00");
		System.out.println("  Actual: " + dr);
	}
	
	private static void testGetCost_WithPets_OneGuest() {
		System.out.println("\n-->testGetCost()");
		DeluxeRoom dr = new DeluxeRoom(401, 1, 2, 3);
		double expected = 420.00;
		System.out.println(String.format("Expected Grand Total = $%,.2f", expected));
		System.out.println(String.format("  Actual Grand Total = $%,.2f", dr.getCost()));
	}
	
	private static void testGetCost_WithPets_MoreThanOneGuest() {
		System.out.println("\n-->testGetCost_WithPets_MoreThanOneGuest()");
		DeluxeRoom dr = new DeluxeRoom(401, 3, 3, 3);
		double expected = 660.00;
		System.out.println(String.format("Expected Grand Total = $%,.2f", expected));
		System.out.println(String.format("  Actual Grand Total = $%,.2f", dr.getCost()));
	}
	
	private static void testGetCost_WithoutPets_OneGuest() {
		System.out.println("\n-->testGetCost_WithoutPets()");
		DeluxeRoom dr = new DeluxeRoom(401, 1, 2, 0);
		double expected = 300.00;
		System.out.println(String.format("Expected Grand Total = $%,.2f", expected));
		System.out.println(String.format("  Actual Grand Total = $%,.2f", dr.getCost()));
	}
	
	private static void testGetCost_WithoutPets_MoreThanOneGuest() {
		DeluxeRoom dr = new DeluxeRoom(401, 5, 2, 0);
		double expected = 360.00;
		System.out.println(String.format("Expected Grand Total = $%,.2f", expected));
		System.out.println(String.format("  Actual Grand Total = $%,.2f", dr.getCost()));
	}
	
	private static void testEquals_True() {
		System.out.println("\n-->testEquals_True()");
		DeluxeRoom dr1 = new DeluxeRoom(228, 1, 1, 1);
		DeluxeRoom dr2 = new DeluxeRoom(228, 1, 1);
		System.out.println("Expected: dr1 is equal to dr2? = true");
		System.out.println("  Actual: dr1 is equal to dr2? = " + dr1.equals(dr2));
	}
	
	private static void testEquals_False() {
		System.out.println("\n-->testEquals_False()");
		DeluxeRoom dr1 = new DeluxeRoom(228, 1, 1, 1);
		DeluxeRoom dr2 = new DeluxeRoom(229, 1, 1);
		System.out.println("Expected: dr1 is equal to dr2? = false");
		System.out.println("  Actual: dr1 is equal to dr2? = " + dr1.equals(dr2));
	}
}
