package citybike.classes;

import java.util.HashMap;

public class Station {
	private int stationId;
	private String location;
	private HashMap<Integer, Bike> bikesInStation;

	public Station(int stationId, String location) {
		this.stationId = stationId;
		this.location = location;
		this.bikesInStation = new HashMap<>();
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
		if (bike.getState() == Bike.BikeCondition.InService) {
				bikesInStation.put(bike.getBikeID(), bike);
		} else {
			System.out.println("Please return a valid bike");
		}
	}
}
