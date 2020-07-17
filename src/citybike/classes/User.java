package citybike.classes;

import java.time.LocalDateTime;

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
		super.setBikeId(currentlyRentedBike.getBikeID());

		// Assigning the current date and time to the rent class
		LocalDateTime currentDateTime = LocalDateTime.now();
		super.setRentStart(currentDateTime);

		// Assigning the paid time to the rent class, will be used to determine if the bike is returned late
		super.setRentEnd(currentDateTime.plusHours(numberOfHours));

		System.out.println(this.name + " " + this.surname + " thank you for renting bike " + this.currentlyRentedBike.getBikeID() + " from our " + station.getLocation() + " station");
	}

	public void returnCurrentlyRentedBike(Station station) {
		if (!station.checkIfFull()) {
			System.out.println(this.name + " " + this.surname + " thank you for returning bike " + this.currentlyRentedBike.getBikeID() + " to our " + station.getLocation() + " station");

			// TODO - remove bike id from rent, calculate cost - add late fees


			this.currentlyRentedBike.setState(Bike.BikeCondition.CanBeRented);
			station.addBike(this.currentlyRentedBike);
			this.currentlyRentedBike = null;
		} else {
			System.out.println("I'm sorry " + this.name + " " + this.surname + " this station is full, please return your rented bike to a different station");
		}
	}
}
