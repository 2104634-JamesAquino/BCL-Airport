package finance;

import java.awt.BorderLayout;
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

import flightData.FlightRecord;
import passengerData.passengerRecord;
import testFinance.FinanceTestExample;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class FinancePage extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private static JTable table_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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

	/**
	 * Create the frame.
	 * test comment
	 */
	public FinancePage() {
		
		DefaultTableModel model;
		
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
		Object[] column = {"First Name", "Last Name", "Date of Birth", "Ticket Number", "Number of Bags", "Food Price", "Ticket Price", "Compensation", "Total Price"};
		table_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		table_1.setModel(model);
		model.setColumnIdentifiers(column);
		scrollPane.setViewportView(table_1);
		
	}
	
	public static int calculateBagPrice(int numBags) {
		int totalBPrice = 0;
		if (numBags > 1) {
			totalBPrice = (numBags - 1) * 25;
		}
		return totalBPrice;
	}
	public static int calculateCompensation(int delayMins) {
		double delayHours = delayMins /60.0;
		int comp = 0;
		if (delayHours > 3.00) {
			comp = 300;
		} else if (delayHours > 2.00 && delayHours <= 3.00) {
			comp = 200;
		} else if (delayHours > 1.00 && delayHours <= 2.00) {
			comp = 100;
		} 
		return comp;
	}
	public static double calculateSeat(String seat, double duration) {
		double Type = 0.5;
		String planeType = "";
		if (duration > 2.00) {
			planeType = "Boeing";
		} else {
			planeType = "Airbus";
		}
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
	public static double calculateTicketPrice(String seatA, String seatB, double durationA, double durationB, double DistanceA, double DistanceB) {
		double ticketPrice = 0;
		double JourneyA = (calculateSeat(seatA, durationA)) * DistanceA;
		double JourneyB = (calculateSeat(seatB, durationB)) * DistanceB;
		ticketPrice = JourneyA + JourneyB;
		return ticketPrice;
	}
	public static double calculateTotalPrice(double BagPrice, double comp, double TicketPrice, double FoodPrice) {
		double totalPrice = (BagPrice + TicketPrice + FoodPrice) - comp;
		return totalPrice;
	}
	public static void displayPassengerData() {
		FinanceTestExample genPassenger = new FinanceTestExample();
		passengerRecord[] booking = genPassenger.generatePassenger();
		int amount = booking.length;
		FlightRecord dep = genPassenger.generateDeparture();
		FlightRecord arr = genPassenger.generateArrival();
		for(int i =0; i<amount;i++) {
			passengerRecord passengerDetails = booking[i];
			String pFName = changeString(passengerDetails.getFirstName());
			String pLName = changeString(passengerDetails.getLastName());
			String pDOB = changeString(passengerDetails.getDoB());
			//passenger String details
			int pTicketNum = passengerDetails.getTicketNumber();
			//calculate bag price
			int pNumBags = passengerDetails.getNumBags();
			double totalBag = Double.valueOf(pNumBags);
			//calculate compensation
			int compA = calculateCompensation(Integer.valueOf(dep.getDelay()));
			int compB = calculateCompensation(Integer.valueOf(arr.getDelay()));
			double totalComp = Double.valueOf(compA + compB);
			//calculate ticket price
			String seatA = passengerDetails.getDepartureSeat();
			String seatB = passengerDetails.getReturningSeat();
			double durationA = Double.valueOf(dep.getFlightDur());
			double durationB = Double.valueOf(arr.getFlightDur());
			double distanceA = Double.valueOf(dep.getDistTravelled());
			double distanceB = Double.valueOf(arr.getDistTravelled());
			double ticketPrice = calculateTicketPrice(seatA, seatB, durationA, durationB, distanceA, distanceB);
			//calculate food price
			double foodPrice = passengerDetails.getFoodCosts();
			//calculate total price
			double totalPrice = calculateTotalPrice(totalBag, totalComp, ticketPrice, foodPrice);
			String[] row = {pFName, pLName, pDOB, String.valueOf(pTicketNum), String.valueOf(totalBag),String.valueOf(foodPrice), String.valueOf(ticketPrice),String.valueOf(totalComp),String.valueOf(totalPrice)};
			table_1.add(row);
			}
		}

	public static boolean checkString(String sVariable) {
		boolean validate = true;
		if(sVariable == "" || sVariable == null) {
			validate = false;
		} 
		return validate;
	}
	public static boolean checkNumeric(String value) {
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
	public static String changeString(String sVariable) {
		String checkedString = "-";
		boolean validate = checkString(sVariable);
		if (validate == true){
			 checkedString = sVariable; 
		} else {
			try {
				FinanceWarningScreen frame = new FinanceWarningScreen();
				frame.setVisible(true);
			} catch (Exception ex) {
				ex.printStackTrace();
		}
		}
		return checkedString;
	}
	public static String changeNumeric(String value) {
		String checkedNumeric = "-1";
		boolean validate = checkNumeric(value);
		if (validate == true) {
			checkedNumeric = value;
		} else {
			try {
				FinanceWarningScreen frame = new FinanceWarningScreen();
				frame.setVisible(true);
			} catch (Exception ey) {
				ey.printStackTrace();
		}
		}
		return checkedNumeric;
	}
}

