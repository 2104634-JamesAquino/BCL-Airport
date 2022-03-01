package flightData;

import passengerDetails.passengerData;

public class FlightRecord {
	String dateOfFlight;
	String depTime;
	String arrTime;
	String flightDur;
	String distTravelled;
	String delay;
	String depAirport;
	String depCity;
	String arrAirport;
	String arrCity;
	String flightNum;
	String Airline;
	passengerData PassengerData = new passengerData();
	
	public FlightRecord(String[] flightRecord){
		this.dateOfFlight = flightRecord[0];
		this.depTime = flightRecord[1];
		this.arrTime = flightRecord[2];
		this.flightDur = flightRecord[3];
		this.distTravelled = flightRecord[4];
		this.delay = flightRecord[5];
		this.depAirport = flightRecord[6];
		this.depCity = flightRecord[7];
		this.arrAirport = flightRecord[8];
		this.arrCity = flightRecord[9];
		this.flightNum = flightRecord[10];
		this.Airline = flightRecord[11];
	}
	public String getDateOfFlight() {
		return dateOfFlight;
	}
	public void setDateOfFlight(String dateOfFlight) {
		this.dateOfFlight = dateOfFlight;
	}
	public String getDepTime() {
		return depTime;
	}
	public void setDepTime(String depTime) {
		this.depTime = depTime;
	}
	public String getArrTime() {
		return arrTime;
	}
	public void setArrTime(String arrTime) {
		this.arrTime = arrTime;
	}
	public String getFlightDur() {
		return flightDur;
	}
	public void setFlightDur(String flightDur) {
		this.flightDur = flightDur;
	}
	public String getDistTravelled() {
		return distTravelled;
	}
	public void setDistTravelled(String distTravelled) {
		this.distTravelled = distTravelled;
	}
	public String getDelay() {
		return delay;
	}
	public void setDelay(String delay) {
		this.delay = delay;
	}
	public String getDepAirport() {
		return depAirport;
	}
	public void setDepAirport(String depAirport) {
		this.depAirport = depAirport;
	}
	public String getDepCity() {
		return depCity;
	}
	public void setDepCity(String depCity) {
		this.depCity = depCity;
	}
	public String getArrAirport() {
		return arrAirport;
	}
	public void setArrAirport(String arrAirport) {
		this.arrAirport = arrAirport;
	}
	public String getArrCity() {
		return arrCity;
	}
	public void setArrCity(String arrCity) {
		this.arrCity = arrCity;
	}
	public String getFlightNum() {
		return flightNum;
	}
	public void setFlightNum(String flightNum) {
		this.flightNum = flightNum;
	}
	public String getAirline() {
		return Airline;
	}
	public void setAirline(String airline) {
		Airline = airline;
	}
	public passengerData getPassengerData() {
		return PassengerData;
	}
	public void setPassengerData(passengerData passengerData) {
		PassengerData = passengerData;
	}
}
