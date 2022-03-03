package seatingPlan;

import java.util.ArrayList;

import javax.swing.JButton;

public class D_Selected_Seats {

	ArrayList<String> flight_number = new ArrayList();
	ArrayList<ArrayList<JButton>> selected_seats = new ArrayList();
	
	public D_Selected_Seats() {
		
	}
	
	public void addFlightNum(String flightNum) {
		flight_number.add(flightNum);
	}
	
	public ArrayList<String> returnFlightNum() {
		return flight_number;
	}
	
	public void addSeats(ArrayList<JButton> seats) {
		selected_seats.add(seats);
	}
	
	public ArrayList<ArrayList<JButton>> returnSeats() {
		return selected_seats;
	}
	
}
