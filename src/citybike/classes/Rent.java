package citybike.classes;

import java.time.LocalDateTime;

public class Rent {
	protected int bikeId;
	protected LocalDateTime rentStart;
	protected LocalDateTime rentEnd;
	protected int numberOfHoursRented;

	protected final double pricePerHour = 1.50;
	protected final double lateFeePerHour = 2.00;

	public int getBikeId() {
		return bikeId;
	}

	public void setBikeId(int bikeId) {
		this.bikeId = bikeId;
	}

	public LocalDateTime getRentStart() {
		return rentStart;
	}

	public void setRentStart(LocalDateTime rentStart) {
		this.rentStart = rentStart;
	}

	public LocalDateTime getRentEnd() {
		return rentEnd;
	}

	public void setRentEnd(LocalDateTime rentEnd) {
		this.rentEnd = rentEnd;
	}

	public int getNumberOfHoursRented() {
		return numberOfHoursRented;
	}

	public void setNumberOfHoursRented(int numberOfHoursRented) {
		this.numberOfHoursRented = numberOfHoursRented;
	}
}
