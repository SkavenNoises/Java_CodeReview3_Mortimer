package citybike.classes;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import static citybike.Main.userCounter;

public class User extends Rent {
	private int userID;
	private String name;
	private String surname;
	private Bike currentlyRentedBike;

	public User(String name, String surname) {
		userCounter++;
		this.userID = userCounter;

		this.name = name;
		this.surname = surname;
	}

	public int getUserID() {
		return userID;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public Bike getCurrentlyRentedBike() {
		return currentlyRentedBike;
	}

	public void setCurrentlyRentedBike(Bike currentlyRentedBike, Station station, int numberOfHours) {
		// Renting Bike, removing it from the station, setting it as in-service
		this.currentlyRentedBike = currentlyRentedBike;
		station.removeBike(currentlyRentedBike);
		this.currentlyRentedBike.setState(Bike.BikeCondition.InService);

		// Assigning the bike id to the rent class
		this.setBikeId(currentlyRentedBike.getBikeID());

		// Storing the amount of hours the bike is rented for
		this.setNumberOfHoursRented(numberOfHours);

		// Assigning the current date and time to the rent class
		LocalDateTime currentDateTime = LocalDateTime.now();
		this.setRentStart(currentDateTime);

		// Assigning the paid time to the rent class, will be used to determine if the bike is returned late
		this.setRentEnd(currentDateTime.plusHours(this.getNumberOfHoursRented()));

		System.out.println(this.name + " " + this.surname + " thank you for renting bike " + this.currentlyRentedBike.getBikeID() + " from our " + station.getLocation() + " station");
	}

	public void returnCurrentlyRentedBike(Station station) {
		if (!station.checkIfFull()) {
			// Determining how long the bike has been actually rented for
			LocalDateTime currentDateTime = LocalDateTime.now();
			long hoursElapsed = ChronoUnit.HOURS.between(currentDateTime, this.getRentEnd());

			// Cost of rent
			double totalCostOfRent;

			// Calculating how much rent the user will pay
			if (hoursElapsed > this.getNumberOfHoursRented()) {
				totalCostOfRent = (this.pricePerHour * this.getNumberOfHoursRented()) + (this.lateFeePerHour * (hoursElapsed - this.getNumberOfHoursRented()));

				System.out.println(String.format("%s %s thank you for returning bike %s to our %s station\nYou will be charged: €%.2f Due to the addition of late fees", this.name, this.surname, this.currentlyRentedBike.getBikeID(), station.getLocation(), totalCostOfRent));
			} else {
				totalCostOfRent = this.pricePerHour * hoursElapsed;

				System.out.println(String.format("%s %s thank you for returning bike %s to our %s station\nYou will be charged: €%.2f", this.name, this.surname, this.currentlyRentedBike.getBikeID(), station.getLocation(), totalCostOfRent));
			}

			// Returning the bike to a station
			this.currentlyRentedBike.setState(Bike.BikeCondition.CanBeRented);
			station.addBike(this.currentlyRentedBike);
			this.currentlyRentedBike = null;

		} else {
			System.out.println("I'm sorry " + this.name + " " + this.surname + " this station is full, please return your rented bike to a different station");
		}
	}
}
