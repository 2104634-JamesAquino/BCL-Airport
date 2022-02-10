package passengerData;

import java.util.ArrayList;

public class passengerData {
	
	ArrayList<passengerRecord> passengerData;
	
	public passengerData() {
		
		this.passengerData = new ArrayList<passengerRecord>();
		
	}
	
	public void addPassengerRecord(passengerRecord record)
	{
		this.passengerData.add(record);
	}
	
	public passengerRecord getPassengerRecord(int index)
	{
		return this.passengerData.get(index);
	}

}
