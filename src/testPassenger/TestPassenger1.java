package testPassenger;
import java.util.ArrayList;

import passengerData.passengerData;
import passengerData.passengerRecord;
public class TestPassenger1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		passengerRecord record1 = new passengerRecord("Johann", "Cardona", "01/04/2001", "01213823433", "2007048@brunel.ac.uk", 4, 12345678, "A1", "A2");
		passengerRecord record2 = new passengerRecord("Miguel", "Quevedo", "04/06/2003", "27878127841", "2375732@brunel.ac.uk", 2, 12345679, "A4", "A6");
		passengerData data1 = new passengerData();
		passengerData data2 = new passengerData();
		data1.addPassengerRecord(record1);
		data2.addPassengerRecord(record2);
		System.out.println(data1.getPassengerRecord(0).getFirstName());
		System.out.println(data1.getPassengerRecord(0).getLastName());
		System.out.println(data1.getPassengerRecord(0).getDoB());
		System.out.println(data1.getPassengerRecord(0).getTelNo());
		System.out.println(data1.getPassengerRecord(0).getEmail());
		System.out.println(data1.getPassengerRecord(0).getNumBags());
		System.out.println(data1.getPassengerRecord(0).getDepartureSeat());
		System.out.println(data1.getPassengerRecord(0).getReturningSeat());
		
		System.out.println();
		
		System.out.println(data2.getPassengerRecord(0).getFirstName());
		System.out.println(data2.getPassengerRecord(0).getLastName());
		System.out.println(data2.getPassengerRecord(0).getDoB());
		System.out.println(data2.getPassengerRecord(0).getTelNo());
		System.out.println(data2.getPassengerRecord(0).getEmail());
		System.out.println(data2.getPassengerRecord(0).getNumBags());
		System.out.println(data2.getPassengerRecord(0).getDepartureSeat());
		System.out.println(data2.getPassengerRecord(0).getReturningSeat());
		
	}
}
