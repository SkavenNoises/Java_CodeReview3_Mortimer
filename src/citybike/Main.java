package citybike;

import citybike.classes.Bike;
import citybike.classes.Station;
import citybike.classes.User;

import java.util.HashMap;

public class Main {
	// ID counters
	public static int bikeCounter = 0;
	public static int userCounter = 0;

	public static void main(String[] args) {
		// Creation of the bike objects
		Bike bike1 = new Bike(Bike.BikeColour.Black, Bike.BikeCondition.CanBeRented);
		Bike bike2 = new Bike(Bike.BikeColour.Blue, Bike.BikeCondition.CanNotBeRented);
		Bike bike3 = new Bike(Bike.BikeColour.Green, Bike.BikeCondition.InService);
		Bike bike4 = new Bike(Bike.BikeColour.Purple, Bike.BikeCondition.Discarded);
		Bike bike5 = new Bike(Bike.BikeColour.Red, Bike.BikeCondition.CanBeRented);
		Bike bike6 = new Bike(Bike.BikeColour.Silver, Bike.BikeCondition.CanBeRented);
		Bike bike7 = new Bike(Bike.BikeColour.Black, Bike.BikeCondition.InService);
		Bike bike8 = new Bike(Bike.BikeColour.Purple, Bike.BikeCondition.InService);
		Bike bike9 = new Bike(Bike.BikeColour.Silver, Bike.BikeCondition.CanBeRented);
		Bike bike10 = new Bike(Bike.BikeColour.Silver, Bike.BikeCondition.CanBeRented);
		Bike bike11 = new Bike(Bike.BikeColour.Silver, Bike.BikeCondition.CanBeRented);
		Bike bike12 = new Bike(Bike.BikeColour.Silver, Bike.BikeCondition.CanBeRented);
		Bike bike13 = new Bike(Bike.BikeColour.Silver, Bike.BikeCondition.CanBeRented);
		Bike bike14 = new Bike(Bike.BikeColour.Silver, Bike.BikeCondition.CanBeRented);
		Bike bike15 = new Bike(Bike.BikeColour.Silver, Bike.BikeCondition.CanBeRented);

		// Storing all created bikes into the hashmap
		HashMap<Integer, Bike> bikeHashMap = new HashMap<>();
		bikeHashMap.put(bike1.getBikeID(), bike1);
		bikeHashMap.put(bike2.getBikeID(), bike2);
		bikeHashMap.put(bike3.getBikeID(), bike3);
		bikeHashMap.put(bike4.getBikeID(), bike4);
		bikeHashMap.put(bike5.getBikeID(), bike5);
		bikeHashMap.put(bike6.getBikeID(), bike6);
		bikeHashMap.put(bike7.getBikeID(), bike7);
		bikeHashMap.put(bike8.getBikeID(), bike8);
		bikeHashMap.put(bike9.getBikeID(), bike9);
		bikeHashMap.put(bike10.getBikeID(), bike10);
		bikeHashMap.put(bike11.getBikeID(), bike11);
		bikeHashMap.put(bike12.getBikeID(), bike12);
		bikeHashMap.put(bike13.getBikeID(), bike13);
		bikeHashMap.put(bike14.getBikeID(), bike14);
		bikeHashMap.put(bike15.getBikeID(), bike15);

		// Creating the 3 station objects
		Station station1 = new Station(1, "Schönbrunn");
		Station station2 = new Station(2, "MuseumsQuartier");
		Station station3 = new Station(3, "Donauinsel");

		// Storing all the created stations in a hashmap
		HashMap<Integer, Station> stationHashMap = new HashMap<>();
		stationHashMap.put(station1.getStationId(), station1);
		stationHashMap.put(station2.getStationId(), station2);
		stationHashMap.put(station3.getStationId(), station3);

		// Calling the addBike function to put the bikes into the required station
		stationHashMap.get(1).addBike(bikeHashMap.get(9));
		stationHashMap.get(1).addBike(bikeHashMap.get(10));
		stationHashMap.get(1).addBike(bikeHashMap.get(11));
		stationHashMap.get(2).addBike(bikeHashMap.get(12));
		stationHashMap.get(2).addBike(bikeHashMap.get(13));
		stationHashMap.get(2).addBike(bikeHashMap.get(14));
		stationHashMap.get(2).addBike(bikeHashMap.get(15));

		// Creating the 4 users
		User user1 = new User("John", "Smith");
		User user2 = new User("Jane", "Doe");
		User user3 = new User("Howard", "Baker");
		User user4 = new User("Hannah", "Jefferies");

		// User rents bike from station
		user1.setCurrentlyRentedBike(stationHashMap.get(1).getBikesInStation().get(9), stationHashMap.get(1));

		// User returns bike to a different station
		user1.returnCurrentlyRentedBike(stationHashMap.get(2));
	}
}
