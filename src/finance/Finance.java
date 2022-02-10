package finance;

public class Finance {
	public int calculateBagPrice(int numBags) {
		int totalBPrice = 0;
		if (numBags > 1) {
			totalBPrice = (numBags - 1) * 25;
		}
		return totalBPrice;
	}
	public int calculateCompensation(int delayMins) {
		double delayHours = delayMins /60;
		int comp = 0;
		if (delayHours >= 3.00) {
			comp = 300;
		} else if (delayHours < 3.00 && delayHours >= 2.00) {
			comp = 200;
		} else if (delayHours < 2.00 && delayHours >= 1.00) {
			comp = 100;
		} 
		return comp;
	}
	public double calculateSeat(String seat, String planeType) {
		double Type = 0.5;
		String[] airClassBui = {"1A","1B","2A","2B","3A","3B","4A","4B","5A","5B"};
		String[] boeClassFir = {"1A","1B","2A","2B","3A","3B","4A","4B","5A","5B"};
		String[] boeClassBui = {"6A","6B","6C","6D","7A","7B","7C","7D","8A","8B","8C","8D","9A","9B","9C","9D","10A","10B","10C","10D"};
		if(planeType == "Airbus") {
			for(int i=0; i < airClassBui.length; i++) {
				if(seat == airClassBui[i]) {
					Type = 1.5;
				}
			}
		} else if(planeType == "Boeing") {
			for(int i=0;i < boeClassFir.length;i++) {
				if(seat == boeClassFir[i]) {
					Type = 1.5;
				}
			}
			for(int j=0;j<boeClassBui.length;j++) {
				if(seat == boeClassBui[j]) {
					Type = 1.0;
				}
			}
		} 
		return Type;
	}
	public double calculateTicketPrice() {
		double ticketPrice = 0, FlightDistance = 1000.00;
		String seatA = "5A", seatB = "6A", planeType = "Boeing";
		double JourneyA = (calculateSeat(seatA, planeType)) * FlightDistance;
		double JourneyB = (calculateSeat(seatB,planeType)) * FlightDistance;
		ticketPrice = JourneyA + JourneyB;
		return ticketPrice;
	}
	public double calculateTotalPrice(int BagPrice, int comp, double TicketPrice, double FoodPrice) {
		double totalPrice = 0;
		double dBagPrice = Double.valueOf(BagPrice);
		double dComp = Double.valueOf(comp);
		totalPrice = (dBagPrice + TicketPrice + FoodPrice) - dComp;
		return totalPrice;
	}
	public void displayPassengerData() {
		String[][] booking = {{"James","Aquino","05/08/2003","12345678","5","","","",""},{"Jennie","Phuong","20/04/2003","23456789","1","","","",""}};
		int amount = booking.length;
		for(int i =0; i<amount;i++) {
			String[] passengerDetails = booking[i];
			String pFName = changeString(passengerDetails[0]);
			String pLName = changeString(passengerDetails[1]);
			String pDOB = changeString(passengerDetails[2]);
			//set details
			String pTicketNum = changeNumeric(passengerDetails[3]);
			String pNumBags = changeNumeric(passengerDetails[4]);
			if (pNumBags == "-1") {
				//setBagPrice(1);
			} else {
				//calculate bag price
			}
			String pFoodPrice = changeNumeric(passengerDetails[5]);
			if (pFoodPrice == "-1") {
				//setFoodPrice = 0;
			} else {
				//setFoodPrice(pFoodPrice);
			}
			/* String pTicketPrice = (calculateTicketPrice()).toString();
			 
			 */
			int delayMins = 100 ;
			String pCompensation = String.valueOf(calculateCompensation(delayMins));
			System.out.println(pFName+","+pLName+","+pDOB+","+pTicketNum+","+pNumBags+","+pFoodPrice+","+pCompensation/*+pTicketPrice+","+","+pTotalPrice*/);
			
		}
	}
	public boolean checkString(String sVariable) {
		boolean validate = true;
		if(sVariable == "" || sVariable == null) {
			validate = false;
			//output warning
		} 
		return validate;
	}
	public boolean checkNumeric(String value) {
		boolean validate = checkString(value);
		if (validate == true){
			try {
				int number = Integer.parseInt(value);
				if (number < 0) {
					validate = false;
				}
			} catch (Exception e) {
				validate = false;
				//Print error
			}
		}
		 return validate;
	}
	public String changeString(String sVariable) {
		String checkedString = "-";
		boolean validate = checkString(sVariable);
		if (validate == true){
			 checkedString = sVariable; 
		} 
		return checkedString;
	}
	public String changeNumeric(String value) {
		String checkedNumeric = "-1";
		boolean validate = checkNumeric(value);
		if (validate == true) {
			checkedNumeric = value;
		}
		return checkedNumeric;
	}
	public void main(String args[]) {
		displayPassengerData();
		
	}

}

