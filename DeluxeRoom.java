package exercise_hotel_rooms_ver1;

public class DeluxeRoom extends Room {
	private final double rate = 150.0;
	private final double guestFee = 10.0;
	private final double petFee = 20.0;
	protected int numPets=0;

	
	public DeluxeRoom(int number, int numGuests, int numNights) {
		this(number, numGuests, numNights, 1);
	}

	public DeluxeRoom(int number, int numGuests, int numNights, int numPets) {
		super(number, numGuests, numNights);
		this.numPets = numPets;
	}

	public double getNumPets() {
		return numPets;
	}

	@Override
	public double getCost() {
		double cost = rate + numPets*petFee;
		if(numGuests>2) {
			cost += (numGuests-2)*guestFee;
		}
		return cost*getNumNights();
	}

	@Override
	public String toString() {
		String msg = String.format("Deluxe Room: room number=%d, num guests=%d, num pets=%d, num nights=%d, cost=$%.2f", 
				number, numGuests, numPets, numNights, getCost());
		return msg;
	}
}
