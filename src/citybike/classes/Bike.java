package citybike.classes;

import static citybike.Main.bikeCounter;

public class Bike {
	private int bikeID;
	private BikeColour colour;
	private BikeCondition state;

	public enum BikeColour {
		Red,
		Blue,
		Green,
		Silver,
		Black,
		Purple
	}

	public enum BikeCondition {
		CanBeRented,
		CanNotBeRented,
		InService,
		Discarded
	}

	public Bike(BikeColour colour, BikeCondition state) {
		// Incrementing the counter before adding the ID to the bike obj
		bikeCounter++;
		this.bikeID = bikeCounter;

		this.colour = colour;
		this.state = state;
	}

	public int getBikeID() {
		return bikeID;
	}

	public BikeColour getColour() {
		return colour;
	}

	public BikeCondition getState() {
		return state;
	}
}
