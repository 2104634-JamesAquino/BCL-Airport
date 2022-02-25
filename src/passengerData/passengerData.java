package passengerData;

import java.util.ArrayList;

public class passengerData {
	
	ArrayList<passengerRecord> passengersData;
	
	public passengerData() {
		
		this.passengersData = new ArrayList<passengerRecord>();
		
	}
	
	public void addPassengerRecord(passengerRecord record)
	{
		this.passengersData.add(record);
	}
	
	public passengerRecord getPassengerRecord(int index)
	{
		return this.passengersData.get(index);
	}

}
