package citybike.classes;

public class User {
	private int userID;
	private String name;
	private String surname;
	private Bike currentlyRentedBike;

	public User(int userID, String name, String surname) {
		this.userID = userID;
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

	public void setCurrentlyRentedBike(Bike currentlyRentedBike) {
		this.currentlyRentedBike = currentlyRentedBike;
	}
}
