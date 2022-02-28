package passengerData;

import java.util.ArrayList;

public class PassengerData {

//************************* Declaring the ArrayList of Object array that contains passenger data *******************************//
	
	ArrayList<Object[]> passengerData = new ArrayList<>();
	
//************************* Declaring the Object array of size 10 that will be added to the ArrayList *******************************//
	
	Object[] passengers = new Object[10];
	
	public PassengerData()
	{
		
	}
	
//************************* Method used to add inputs from user to ArrayList *******************************//
	
	public void addPassengerRecord(int ticketNum, String fName, String lName, String dob, String telNum, String email, int numBags, String departingSeats, String returningSeats) {
		
		passengers[0] = ticketNum;
		passengers[1] = fName;
		passengers[2] = lName;
		passengers[3] = dob;
		passengers[4] = 0.00;
		passengers[5] = 0.00;
		passengers[6] = 0.00;
		passengers[7] = 0.00;
		passengers[8] = 0.00;
		passengers[9] = 0.00;
		
		Object[] passenger = passengers.clone();
		passengerData.add(passenger);
		
	}
	
//************************* Method used to return the passenger records that are stored in the ArrayList *******************************//
	
	public ArrayList<Object[]> returnPassengerRecords()
	{
		return passengerData;
	}
	
}

