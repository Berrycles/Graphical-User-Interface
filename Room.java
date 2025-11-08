package exercise_hotel_rooms_ver1;

public abstract class Room {
	protected int number;
	protected int numGuests;
	protected int numNights;

	public Room(int number, int numGuests, int numNights) {
		this.number = number;
		this.numGuests = numGuests;
		this.numNights = numNights;
	}
	
	public Room(int number) {
		this(number,1,1);
	}

	public int getNumber() {
		return number;
	}

	public int getNumNights() {
		return numNights;
	}

	public int getNumGuests() {
		return numGuests;
	}

	public void setNumNights(int numNights) {
		this.numNights = numNights;
	}

	public void setNumGuests(int numGuests) {
		this.numGuests = numGuests;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Room) {
			Room r = (Room)o;
			return this.number == r.number;
		}
		return false;
	}

	public abstract double getCost();
}
