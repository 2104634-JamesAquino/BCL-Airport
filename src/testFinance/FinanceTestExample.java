package testFinance;
import java.util.Random;

import passengerData.passengerData;
import passengerData.passengerRecord;
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
	public void generatePassenger() {
		int bag1 = random(1), food1 = random(3), bag2 = random(1), food2 = random(3), bag3 = random(1), food3 = random(3);
		passengerRecord record1 = new passengerRecord(12312312, "Aaron", "Samuels", "01/04/2001", "83746578", "2007048@brunel.ac.uk",bag1,food1, "1A", "1A");
		passengerRecord record2 = new passengerRecord(12312313, "Regina", "George", "01/03/2002", "27475839", "2007049@brunel.ac.uk",bag2,food2, "6A", "6A");
		passengerRecord record3 = new passengerRecord(12312314, "Cady", "Heron", "05/10/1990", "95738494", "2007038@brunel.ac.uk",bag3,food3, "11A", "11A");
		passengerRecord[] passengers = {record1, record2, record3};
	}
}
