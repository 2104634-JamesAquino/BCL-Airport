package passengerData;

import java.util.ArrayList;

public class passengerData {
	
	ArrayList<ArrayList<passengerRecord>> passenger_Data;
	
	ArrayList<passengerRecord> passengerData;
	
	//******************************* Constructor of the passengerData class
	
	public passengerData() {
		
		this.passenger_Data = new ArrayList<ArrayList<passengerRecord>>();
		
	}
	
//	public PassengerData() {
//		
//		this.passengerData = new ArrayList<passengerRecord>();
//		
//	}
	
	//This method is used to add a passenger record to the ArrayList 
	
	public void addPassengerRecord(ArrayList<passengerRecord> record)
	{
		this.passenger_Data.add(record);
	}
	
//	public void addPassengerRecord(passengerRecord record)
//	{
//		this.passengerData.add(record);
//	}
	
	//This method is used to get the index of a passengerRecord
	
	public ArrayList<passengerRecord> getPassengerRecord(int index)
	{
		return this.passenger_Data.get(index);
	}
	
//	public passengerRecord getPassengerRecord(int index) 
//	{
//		return this.passengerData.get(index);
//	}
}
