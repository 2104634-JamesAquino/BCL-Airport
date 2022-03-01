package testFinance;
import java.util.Random;
import flightData.FlightRecord;
import passengerDetails.passengerData;
import passengerDetails.passengerRecord;
public class FinanceTestExample {
	public static void main(String[] args) {
		
		

	}
	public static int random(int num) {
		int min = 1;
		int max = 0;
		if (num == 1) {
			 max = 5;
		} else if (num == 3) {
			 max = 50;
		}
		Random random = new Random();
		int value = random.nextInt(max+min) + min;
		return value;
	}
	public static passengerRecord[] generatePassenger() {
		int bag1 = random(1), food1 = random(3), bag2 = random(1), food2 = random(3), bag3 = random(1), food3 = random(3);
		passengerRecord record1 = new passengerRecord(12312312, "Aaron", "Samuels", "01/04/2001", "83746578", "2007048@brunel.ac.uk",bag1,"1A", "1A");
		record1.setFoodCosts(food1);
		passengerRecord record2 = new passengerRecord(12312313, "Regina", "George", "01/03/2002", "27475839", "2007049@brunel.ac.uk",bag2, "6A", "6A");
		record2.setFoodCosts(food2);
		passengerRecord record3 = new passengerRecord(12312314, "Cady", "Heron", "05/10/1990", "95738494", "2007038@brunel.ac.uk",bag3, "11A", "11A");
		record3.setFoodCosts(food3);
		passengerRecord[] passengers = {record1, record2, record3};
		return passengers;
	}
	public static FlightRecord generateDeparture() {
		String[] dep = {"08/03/2022", "06:20", "11:57", "05:37", "7021.04", "179", "HND", 
				"Tokyo", "SYD", "Sydney", "TS4977", "Easyplane"};
		FlightRecord departure = new FlightRecord(dep);
		return departure;
	}
	public static FlightRecord generateArrival() {
		String[] arr = {"27/03/2022", "18:23", 
				"03:44", "09:21", "11687.85", "10", "SYD", "Sydney", "HND", "Tokyo", "ST4138", "Eastair"};
		FlightRecord arrival = new FlightRecord(arr);
		return arrival;
	}
}
