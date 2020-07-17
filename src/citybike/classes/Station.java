package citybike.classes;

import java.util.HashMap;

public class Station {
	private int stationId;
	private String location;
	private HashMap<Integer, Bike> bikesInStation;

	public Station(int stationId, String location) {
		this.stationId = stationId;
		this.location = location;
		bikesInStation = new HashMap<>();
	}

	public int getStationId() {
		return stationId;
	}

	public String getLocation() {
		return location;
	}

	public HashMap<Integer, Bike> getBikesInStation() {
		return bikesInStation;
	}

	public void addBike(Bike bike) {
		bikesInStation.put(bike.getBikeID(), bike);
	}

	public void removeBike(Bike bike) {
		if (this.bikesInStation.containsKey(bike.getBikeID())) {
			if (bike.getState() == Bike.BikeCondition.CanBeRented) {
				bikesInStation.remove(bike.getBikeID());
				System.out.println("Bike number: " + bike.getBikeID() + " has been removed from " + this.location + " station");
			} else {
				System.out.println("Please select a valid bike");
			}
		} else {
			System.out.println("Bike does not exist in this station");
		}
	}
}
