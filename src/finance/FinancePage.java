package finance;
//all imports  
import java.awt.BorderLayout;//JFrame
import java.awt.Component;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import testFinance.FinanceTestExample;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import flightData.FlightRecord;//To use getter and setter from classes
import passengerData.passengerRecord;
import testFinance.FinanceTestExample;//To get the data from test folder
import javax.swing.JLabel;//More JFrame 
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.math.BigDecimal;//To allow code to round double
import java.math.RoundingMode;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
public class FinancePage extends JFrame {
	
	private JPanel contentPane;
	private JTable table;
	private static JTable table_1;
	DefaultTableModel model;
	//When displaying the data, the format remains consistent
	Object[] row = new Object[10];
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {//Displays the finance table - if code was combined would have this highlighted
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FinancePage frame = new FinancePage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public FinancePage() {//creates the table, label and icon that can be seen on JFrame
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 553);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		ImageIcon image = new ImageIcon("./BCL_Logo.png");
		JLabel imageLabel = new JLabel("");
		imageLabel.setBounds(10,9,277,134);
		imageLabel.setIcon(image);
		contentPane.add(imageLabel);
		JLabel lblNewLabel = new JLabel("Brunel Airport - Finance page");
		lblNewLabel.setFont(new Font("Cambria", Font.PLAIN, 20));
		lblNewLabel.setBounds(307, 36, 298, 43);
		contentPane.add(lblNewLabel);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 179, 766, 327);
		contentPane.add(scrollPane);
		table_1 = new JTable();
		model = new DefaultTableModel();
		//Column name for the data - data will follow this format
		Object[] column = {"First Name", "Last Name", "Date of Birth", "Ticket Number", "Bag Costs", "Food Price", "Ticket Price", "Compensation", "Total Price"};
		table_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		table_1.setModel(model);
		model.setColumnIdentifiers(column);
		//Gets an arrayList of passenger data as objects, 
		ArrayList<Object[]> rows = new ArrayList<Object[]>(displayPassengerData());
		int amount = rows.size();
		for(int i=0;i<amount;i++) {
			//displays the passenger data row by row
			Object[] row = rows.get(i);
			//One row is about one passenger
			model.addRow(row);
		}
		scrollPane.setViewportView(table_1);
	}
	
	public static int calculateBagPrice(int numBags) {//calculates the price for bag
		int totalBPrice = 0;
		if (numBags > 1) {//method only calculates when number of bags are greater than one, else returns 0
			//One bag is free, every extra bag is 25 pounds extra
			totalBPrice = (numBags - 1) * 25;
		}
		return totalBPrice;
	}
	public static int calculateCompensation(int delayMins) {//calculates compensation for a flight
		double delayHours = delayMins /60.0;//Parameter is minute so must convert into hours
		int comp = 0;
		if (delayHours > 3.00) {//Compensation if greater than 3
			comp = 300;
		} else if (delayHours > 2.00 && delayHours <= 3.00) {//Compensation of 200 when delay greater than 2 hrs but less than or equal to 3
			comp = 200;
		} else if (delayHours > 1.00 && delayHours <= 2.00) {
			comp = 100;
		} 
		return comp;
	}
	public static double calculateSeat(String seat, double duration) {
		double Type = 0.5;
		String planeType = "";
		if (duration > 2.00) {//Calculate which plane is being used for flight
			planeType = "Boeing";//Flight duration more than 2 hours
		} else {
			planeType = "Airbus";
		}
		String[] airClassBui = {"1A","1B","2A","2B","3A","3B","4A","4B","5A","5B"};//Array of seats in first class and business class for both planes
		String[] boeClassFir = {"1A","1B","2A","2B","3A","3B","4A","4B","5A","5B"};
		String[] boeClassBui = {"6A","6B","6C","6D","7A","7B","7C","7D","8A","8B","8C","8D","9A","9B","9C","9D","10A","10B","10C","10D"};
		if(planeType == "Airbus") {
			for(int i=0; i < airClassBui.length; i++) {
				if(seat == airClassBui[i]) {
					Type = 1.5;// returns a multiplier that will be multiplied with the flight distance
				}// first class - 1.5x, Business 1.0x, Economy - 0.5x
			}
		} else if(planeType == "Boeing") {
			for(int i=0;i < boeClassFir.length;i++) {
				if(seat == boeClassFir[i]) {
					Type = 1.5;
				}
			}
			for(int j=0;j<boeClassBui.length;j++) {
				if(seat == boeClassBui[j]) {//Method checks if seat passenger picks is in what type of class
					Type = 1.0;
			}
		} 
		}
		return Type;
	}
	public static double calculateTicketPrice(String seatA, String seatB, double durationA, double durationB, double DistanceA, double DistanceB) {
		double ticketPrice = 0;
		//TicketPrice = class multiplier * flight distance

		double JourneyA = (calculateSeat(seatA, durationA)) * DistanceA;
		double JourneyB = (calculateSeat(seatB, durationB)) * DistanceB;//Two journey as there is flight arrival and departure
		ticketPrice = JourneyA + JourneyB;
		return ticketPrice;
	}
	public static double calculateTotalPrice(double BagPrice, double comp, double TicketPrice, double FoodPrice) {
		double totalPrice = (BagPrice + TicketPrice + FoodPrice) - comp;
		return totalPrice;
	}
	public static double calculateDuration(String time) {//Time comes in format HH:MM so must convert into double for calculations
		String[] timearray = time.split(":");//Splits string at : character
		String StringHours = timearray[0];
		String StringMinutes = timearray[1];
		double totalTime = Double.valueOf(StringHours) + (Double.valueOf(StringMinutes)/60.0);//Converts minutes into hours
		return totalTime;
	}
	public static double round(double value) {//method to round double to 2 decimal places
		BigDecimal bd = new BigDecimal(value).setScale(2,RoundingMode.HALF_UP);
		double newValue = bd.doubleValue();
		return newValue;
	}
	public ArrayList<Object[]> displayPassengerData() {
		ArrayList<Object[]> total = new ArrayList<Object[]>();//will store passenger data to display in this arrayList
		FinanceTestExample genPassenger = new FinanceTestExample();//To get the data from test class and methods
		passengerRecord[] booking = genPassenger.generatePassenger();
		int amount = booking.length;
		FlightRecord dep = genPassenger.generateDeparture();//Get test data - flight and arrival
		FlightRecord arr = genPassenger.generateArrival();
		for(int i =0; i<amount;i++) {//gets data about passenger one at a time
			passengerRecord passengerDetails = booking[i];
			String pFName = changeString(passengerDetails.getFirstName());
			String pLName = changeString(passengerDetails.getLastName());
			String pDOB = changeString(passengerDetails.getDoB());
			//passenger String details
			int pTicketNum = passengerDetails.getTicketNumber();
			//gets ticket Number
			//calculate bag price
			int pNumBags = passengerDetails.getNumBags();
			double totalBag = Double.valueOf(calculateBagPrice(pNumBags));
			//calculate compensation
			int compA = calculateCompensation(Integer.valueOf(dep.getDelay()));
			int compB = calculateCompensation(Integer.valueOf(arr.getDelay()));
			double totalComp = Double.valueOf(compA + compB);
			//calculate ticket price
			String seatA = passengerDetails.getDepartureSeat();
			String seatB = passengerDetails.getReturningSeat();
			double durationA = calculateDuration(dep.getFlightDur());
			double durationB = calculateDuration(arr.getFlightDur());
			double distanceA = Double.valueOf(dep.getDistTravelled());
			double distanceB = Double.valueOf(arr.getDistTravelled());
			double ticketPrice = round(calculateTicketPrice(seatA, seatB, durationA, durationB, distanceA, distanceB));
			//calculate food price
			double foodPrice = round(passengerDetails.getFoodCosts());
			//calculate total price
			double totalPrice = round(calculateTotalPrice(totalBag, totalComp, ticketPrice, foodPrice));
			System.out.println(totalBag+" "+foodPrice+" "+ticketPrice+" "+totalPrice);
			Object[] row = {pFName, pLName, pDOB, String.valueOf(pTicketNum), String.valueOf(totalBag),String.valueOf(foodPrice), String.valueOf(ticketPrice),String.valueOf(totalComp),String.valueOf(totalPrice)};
			total.add(row);
			}
		return total;
		}

	public static boolean checkString(String sVariable) {//Checks if variable is empty or null
		boolean validate = true;
		if(sVariable == "" || sVariable == null) {
			validate = false;//Not a valid variable, failed validation
		} 
		return validate;
	}
	public static String changeString(String sVariable) {
		String checkedString = "-";//If variable has failed validation, error handling symbol to replace empty
		boolean validate = checkString(sVariable);
		if (validate == true){
			 checkedString = sVariable; 
		} else {
			try {
				FinanceWarningScreen frame = new FinanceWarningScreen();//Warning screen to alert user
				frame.setVisible(true);
			} catch (Exception ex) {
				ex.printStackTrace();
		}
		}
		return checkedString;
	}
}

