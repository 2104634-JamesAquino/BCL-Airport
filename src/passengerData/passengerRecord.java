package passengerData;

public class passengerRecord {
	
	String firstName;
	String lastName;
	String DoB;
	String email;
	String telNo;
	int numBags;
	int ticketNumber;
	int bookingID;
	String departureSeat;
	String returningSeat;
	int compensation;
	double foodCosts;
	double totalPrice;
	double bagPrice;
	double ticketPrice;
	
//	public passengerRecord() {
//	}
	
	public passengerRecord(int ticketNo, String fName, String lName, String DoB, String emailAddress, String telNum, int numOfBags, String departSeat, String returnSeat) {
		
		this.ticketNumber = ticketNo;
		this.firstName = fName;
		this.lastName = lName;
		this.DoB = DoB;
		this.email = emailAddress;
		this.telNo = telNum;
		this.numBags = numOfBags;
		//this.foodCosts = 0.0;
		this.departureSeat = departSeat;
		this.returningSeat = returnSeat;
		
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String fName) {
		this.firstName = fName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lName) {
		this.lastName = lName;
	}

	public String getDoB() {
		return DoB;
	}

	public void setDoB(String DoB) {
		this.DoB = DoB;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String emailAddress) {
		this.email = emailAddress;
	}

	public String getTelNo() {
		return telNo;
	}

	public void setTelNo(String telNum) {
		this.telNo = telNum;
	}

	public int getNumBags() {
		return numBags;
	}

	public void setNumBags(int numOfBags) {
		this.numBags = numOfBags;
	}

	public int getTicketNumber() {
		return ticketNumber;
	}

	public void setTicketNumber(int ticketNo) {
		this.ticketNumber = ticketNo;
	}

	public String getDepartureSeat() {
		return departureSeat;
	}

	public void setDepartureSeat(String departSeat) {
		this.departureSeat = departSeat;
	}

	public String getReturningSeat() {
		return returningSeat;
	}

	public void setReturningSeat(String returnSeat) {
		this.returningSeat = returnSeat;
	}

	public int getCompensation() {
		return compensation;
	}

	public void setCompensation(int compensation) {
		this.compensation = compensation;
	}

	public double getFoodCosts() {
		return foodCosts;
	}

	public void setFoodCosts(double foodCosts) {
		this.foodCosts = foodCosts;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public double getBagPrice() {
		return bagPrice;
	}

	public void setBagPrice(double bagPrice) {
		this.bagPrice = bagPrice;
	}

	public double getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	
	public int randomNum()
	{
		int min = 11111111;
		int max = 99999999;
		
		int positiveNum = (int) Math.floor(Math.random()*(max - min + 1) + min);
		return positiveNum;
		
	}
	
}
