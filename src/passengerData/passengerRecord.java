package passengerData;

public class passengerRecord {
	
	String firstName;
	String lastName;
	String DoB;
	String telNumber;
	String email;
	int numBags;
	String departureSeat;
	String returningSeat;
	int ticketNumber;
	int compensation;
	double foodCosts;
	double totalCosts;
	double bagPrice;
	double ticketPrice;
	
	public passengerRecord(String firstName, String lastName, String DoB, String telNumber, String email, int numBags, String departureSeat, String returningSeat) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.DoB = DoB;
		this.telNumber = telNumber;
		this.email = email;
		this.numBags = numBags;
		this.departureSeat = departureSeat;
		this.returningSeat = returningSeat;
//		this.ticketNumber = randomNumber();
		
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDoB() {
		return DoB;
	}

	public void setDoB(String doB) {
		DoB = doB;
	}

	public String getTelNumber() {
		return telNumber;
	}

	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getNumBags() {
		return numBags;
	}

	public void setNumBags(int numBags) {
		this.numBags = numBags;
	}

	public String getDepartureSeat() {
		return departureSeat;
	}

	public void setDepartureSeat(String departureSeat) {
		this.departureSeat = departureSeat;
	}

	public String getReturningSeat() {
		return returningSeat;
	}

	public void setReturningSeat(String returningSeat) {
		this.returningSeat = returningSeat;
	}

	public int getTicketNumber() {
		return ticketNumber;
	}

	public void setTicketNumber(int ticketNumber) {
		this.ticketNumber = ticketNumber;
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
	
	public double getTotalCosts() {
		return totalCosts;
	}

	public void setTotalCosts(double totalCosts) {
		this.totalCosts = totalCosts;
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
//Test comment
}
