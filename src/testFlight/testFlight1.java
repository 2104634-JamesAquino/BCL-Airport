package testFlight;

import flightData.FlightData;

public class testFlight1 {
	public static void main(String[] args) {
		FlightData data = new FlightData("./Flights.csv");
		System.out.println(data.size());
		//test comment
	}
}
