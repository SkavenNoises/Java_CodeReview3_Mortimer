package citybike.classes;

import static citybike.Main.userCounter;

public class User {
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

	public void setCurrentlyRentedBike(Bike currentlyRentedBike, Station station) {
		this.currentlyRentedBike = currentlyRentedBike;
		this.currentlyRentedBike.setState(Bike.BikeCondition.InService);
		station.removeBike(currentlyRentedBike);

		System.out.println(this.name + " " + this.surname + " thank you for renting bike " + this.currentlyRentedBike.getBikeID() + " from our " + station.getLocation() + " station");
	}

	public void returnCurrentlyRentedBike(Station station) {
		System.out.println(this.name + " " + this.surname + " thank you for returning bike " + this.currentlyRentedBike.getBikeID() + " to our " + station.getLocation() + " station");

		this.currentlyRentedBike.setState(Bike.BikeCondition.CanBeRented);
		station.addBike(this.currentlyRentedBike);
		this.currentlyRentedBike = null;
	}
}
