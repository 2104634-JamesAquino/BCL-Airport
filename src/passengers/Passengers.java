package passengers;

import java.awt.*;

import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import com.toedter.calendar.JDateChooser;

//import passengerDetails.PassengerData;
import passengerData.passengerData;
import passengerData.passengerRecord;
/******************************  Class name that extends a JFrame and implements action listener class ***********************************/

//action listener class is added in order to use it in the Passengers class
//action listener class contains the Action Performed method
public class Passengers extends JFrame implements ActionListener {
	
/******************************  Passenger Data declaration ***********************************/
	passengerData passengers = new passengerData();
	passengerRecord newPassengerRecord;
	
/******************************  Declaring the labels for the Passengers Form ***********************************/
	
	JLabel lblPassengerFormTitle;
	JLabel lblLogo;
	JLabel lblFirstName;
	JLabel lblLastName;
	JLabel lblDateOfBirth;
	JLabel lblTelephoneNum;
	JLabel lblEmail;
	JLabel lblNumOfBags;
	JLabel lblDepartingSeats;
	JLabel lblReturningSeats;
	
/******************************  Declaring the text fields for the Passengers Form ***********************************/	
	
	JTextField txtFirstName;
	JTextField txtLastName;
	JTextField txtTelephoneNumber;
	JTextField txtEmailAddress;
	
/******************************  Declaring the JDateChooser calendar for the Passengers Form ***********************************/
	
	JDateChooser dateOfBirth;
	
/******************************  Declaring the combo boxes (drop-down lists) for the Passengers form ***********************************/
	
	JComboBox<Integer> numberOfBags;
	JComboBox<String> departingSeats;
	JComboBox<String> returningSeats;
	
/******************************  Declaring the button for the Passengers form ***********************************/
	
	JButton submit;
	
/******************************  Declaring the constant variables used for date formatting ***********************************/
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	String currentDate = sdf.format(Calendar.getInstance().getTime());
	
/******************************  Declaring the variable that will hold the values for the bag's combo box ***********************************/
	
	Integer[] numBags = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
	String[] rSeats = {"A1", "A2", "A3", "A4", "A5"};
	String[] dSeats = {"A6", "A7", "A8", "A9", "A10"};
	
/******************************  variables for the ticket number and the passenger Count ***********************************/
	
//	int ticketNum;
//	int passengerCount;
	
/******************************  variables used for storing the inputs from the user ***********************************/
	
	String first_Name;
	String last_Name;
	String date_Of_Birth;
	String telephone_Number;
	String emailAddress;
	int number_Of_Bags;
	String departing_Seat;
	String returning_Seat;
	
	public Passengers()
	{
		
/******************************  Creating instances of the Jlabel ***********************************/
		
		//label for the passengers form title
		lblPassengerFormTitle = new JLabel("Passenger Form Details");
		lblPassengerFormTitle.setForeground(Color.BLUE);
		lblPassengerFormTitle.setFont(new Font("Arial", Font.PLAIN, 22));
		//bounds --> x, y, width, length
		lblPassengerFormTitle.setBounds(35, 79, 236, 34);
		
		//image icon class used to pass the image file path to its constructor
		ImageIcon BCLlogo = new ImageIcon("./BCL_Logo_Passengers.PNG");
		
		//label for the logo
		lblLogo = new JLabel("Logo");
		//add the logo to the label
		lblLogo.setIcon(BCLlogo);
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setBounds(310, 11, 443, 176);
		
		//label for the for the first name
		lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Arial", Font.PLAIN, 18));
		lblFirstName.setBounds(183, 228, 90, 27);
	
		//label for the last name
		lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Arial", Font.PLAIN, 18));
		lblLastName.setBounds(183, 290, 87, 27);
		
		//label for the date of birth
		lblDateOfBirth = new JLabel("Date of Birth");
		lblDateOfBirth.setFont(new Font("Arial", Font.PLAIN, 18));
		lblDateOfBirth.setBounds(183, 352, 101, 27);
		
		//label for the telephone number
		lblTelephoneNum = new JLabel("Telephone Number");
		lblTelephoneNum.setFont(new Font("Arial", Font.PLAIN, 18));
		lblTelephoneNum.setBounds(183, 414, 153, 27);
		
		//label for the email address
		lblEmail = new JLabel("Email Address");
		lblEmail.setFont(new Font("Arial", Font.PLAIN, 18));
		lblEmail.setBounds(183, 476, 117, 27);
		
		//label for the bags
		lblNumOfBags = new JLabel("Bags");
		lblNumOfBags.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNumOfBags.setBounds(183, 538, 41, 27);
		
		//label for the departing seats
		lblDepartingSeats = new JLabel("Departing Seats");
		lblDepartingSeats.setFont(new Font("Arial", Font.PLAIN, 18));
		lblDepartingSeats.setBounds(183, 600, 135, 27);
		
		//label for the returning seats
		lblReturningSeats = new JLabel("Returning Seats");
		lblReturningSeats.setFont(new Font("Arial", Font.PLAIN, 18));
		lblReturningSeats.setBounds(183, 668, 135, 27);
		
		/******************************  Creating instances of the JTextfield and JDateChooser ***********************************/
		
		//text field for the first name
		txtFirstName = new JTextField();
		txtFirstName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtFirstName.setColumns(10);
		txtFirstName.setBounds(410, 233, 191, 20);
		
		//text field for the last name
		txtLastName = new JTextField();
		txtLastName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtLastName.setColumns(10);
		txtLastName.setBounds(410, 295, 191, 20);
		
		//calendar for the date of birth
		dateOfBirth = new JDateChooser();
		dateOfBirth.setBounds(410, 359, 191, 20);
		
		//text field for the telephone number
		txtTelephoneNumber = new JTextField();
		txtTelephoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtTelephoneNumber.setColumns(10);
		txtTelephoneNumber.setBounds(410, 419, 191, 20);
		
		//text field for the email address
		txtEmailAddress = new JTextField();
		txtEmailAddress.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtEmailAddress.setColumns(10);
		txtEmailAddress.setBounds(410, 481, 191, 20);
		
/****************************** Creating instances for the combo boxes ****************************************/
		
		//combo box for the number of bags
		numberOfBags = new JComboBox<Integer>(numBags);
		numberOfBags.setFont(new Font("Tahoma", Font.PLAIN, 15));
		numberOfBags.setBounds(410, 542, 61, 22);
		numberOfBags.addActionListener(this);
		
		//combo box for the departing seats
		departingSeats = new JComboBox<String>(dSeats);
		departingSeats.setFont(new Font("Tahoma", Font.PLAIN, 15));
		departingSeats.setBounds(410, 604, 61, 22);
		departingSeats.addActionListener(this);
		
		//combo box for the returning seats
		returningSeats = new JComboBox<String>(rSeats);
		returningSeats.setFont(new Font("Tahoma", Font.PLAIN, 15));
		returningSeats.setBounds(410, 672, 61, 22);
		returningSeats.addActionListener(this);
		
		//button to submit the passengers form
		submit = new JButton("Submit");
		submit.setForeground(Color.BLUE);
		submit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		submit.setBounds(550, 750, 123, 54);
		//button is added to the components tracked by an action event
		//action listener is added so the code linked to the button is executed
		submit.addActionListener(this);
		
/******************************  Adding the labels to the component's frame ***********************************/
		
		add(lblPassengerFormTitle);
		add(lblLogo);
		
		add(lblFirstName);
		add(lblLastName);
		add(lblDateOfBirth);
		add(lblTelephoneNum);
		add(lblEmail);
		add(lblNumOfBags);
		add(lblDepartingSeats);
		add(lblReturningSeats);
		
/******************************  Adding the text fields to the component's frame ***********************************/
		
		add(txtFirstName);
		add(txtLastName);
		add(dateOfBirth);
		add(txtTelephoneNumber);
		add(txtEmailAddress);
		add(numberOfBags);
		add(departingSeats);
		add(returningSeats);
		
/****************************** Adding the button to the component's frame ***********************************/
		
		add(submit);
		
		//setting the title for the frame
		setTitle("Passengers");
		//setting the close operation for the frame
		//When the window is closed, the program won't stop running
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//setting the size for the window
		setSize(800, 900);
		//setting the layout to be null
		//no specific layout has been selected
		setLayout(null); //absolute layout is the default layout when layout is null, meaning the all the positioning is hard coded using setBounds
		//frame is placed right in the center of the screen
		setLocationRelativeTo(null);
		//setting the frame to be visible
		setVisible(true);	
	}

	
/****************************** This method is used to add the chosen seats to the combo boxes in the form ***********************************/
	
	public void chosenSeats(ArrayList<String> departureSeats, ArrayList<String> returnSeats)
	{
		
		
		for(int i=0;i<departureSeats.size();i++)
		{
			departingSeats.addItem(departureSeats.get(i));
		}
		for(int i=0;i<returnSeats.size();i++)
		{
			returningSeats.addItem(returnSeats.get(i));
		}
	}
	
/****************************** This method is used to generate a random number that contains 8 digits ***********************************/
	
	public int randomNum()
	{
		int min = 11111111; //minimum value is declared
		int max = 99999999; //maximum value is declared
		
		//integer variable to store the value of the 8-digit random number
		//Math.random only gives numbers between 0 and 0.9999999, that is why we need the min and max values
		//Math.floor is used to to turn float into integer e.g. 1.99999 to 1
		//+1 is used after max - min in order to get the max which is 99999999 instead of 88888888
		int positiveNum = (int)Math.floor(Math.random()*(max - min + 1) + min);
		
		//When the method is called, the random number with 8 digits must be returned
		return positiveNum;
	}
	
/****************************** This method is used to validate the first and last name inputs from the user ***********************************/
	
	public boolean isValidString(JTextField fName, JTextField lName)
	{
		if(fName.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(null, "First Name is required.", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if(lName.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(null, "Last Name is required.", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		else if(!fName.getText().matches("[a-zA-Z\\s]{3,}"))
		{
			JOptionPane.showMessageDialog(null, "Input a valid first name.", "Warning", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		else if(!lName.getText().matches("[a-zA-Z\\s]{3,}")) 
		{
			JOptionPane.showMessageDialog(null, "Input a valid last name.", "Warning", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		else 
		{
			return true;
		}
		
	}
	
	public int date_difference(String DoBirth, String today)
	{
		String[] doBirthString = DoBirth.split("/");
		String[] todayString = today.split("/");
		
		LocalDate birthDate = LocalDate.of(Integer.valueOf(doBirthString[2]), Integer.valueOf(doBirthString[1]), Integer.valueOf(doBirthString[0]));
		LocalDate todayDate = LocalDate.of(Integer.valueOf(todayString[2]), Integer.valueOf(todayString[1]), Integer.valueOf(todayString[0]));
		
		int date_difference = Period.between(birthDate, todayDate).getDays();
		
		return date_difference;
	}
	
/****************************** This method is used to validate the date selected by the user ***********************************/
	
	public boolean isValidDOB(JDateChooser dob)
	{
		
		if(dob.getDate() == null)
		{
			JOptionPane.showMessageDialog(null, "Date of Birth is required.", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		else if (date_difference(sdf.format(dateOfBirth.getDate()), currentDate) <= 0) {
				JOptionPane.showMessageDialog(null, "The date of birth cannot be a future date.", "Warning", JOptionPane.WARNING_MESSAGE);
				return false;
		}
		else {
			return true;
		}
		
	}
	
/****************************** This method is used to validate the telephone number inputs from the user ***********************************/
	
	public boolean isValidNumber(JTextField telNo)
	{
		if(telNo.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(null, "Telephone number is required.", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		else if(telNo.getText().matches("\\d{10}"))
		{
			return true;
		}
		else if(telNo.getText().matches("\\d{11}"))
		{
			return true;
		}
		else if (telNo.getText().matches("[0-9]{3,4}[-\\.\\s][0-9]{3}[-\\.\\s][0-9]{3,4}")) 
		{
			return true;
		}
		else if (telNo.getText().matches("(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[-\\.\\s]?[0-9]{3}[-\\.\\s]?[0-9]{4}")) 
		{
			return true;
		}
		else {
			JOptionPane.showMessageDialog(null, "Input a valid telephone number.", "Warning", JOptionPane.WARNING_MESSAGE);
			return false;
		}
	}
	
/****************************** This method is used to validate the email address inputs from the user ***********************************/
	
	public boolean isValidEmail(JTextField email)
	{
		if(email.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(null, "Email address is required.", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		else if(!email.getText().matches("^[a-zA-Z0-9._%+-]+@(([a-zA-Z]+\\.[a-zA-Z]{2,3})|(brunel\\.ac\\.uk))$"))
		{
			JOptionPane.showMessageDialog(null, "Input a valid email address.", "Warning", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		else 
		{
			return true;
		}
	}
	
	/****************************** This method is used to to handle the actions that are performed by the component ***********************************/
	//method is overwritten as it is already declared in the Action Listener class
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == submit) 
		{
			
//			if(ticketNum != passengerCount)
//			{
				if(isValidString(txtFirstName, txtLastName) == false)
				{
					
				}
				else if (isValidDOB(dateOfBirth) == false) {
					
				}
				else if (isValidNumber(txtTelephoneNumber) == false) {
					
				}
				else if (isValidEmail(txtEmailAddress) == false) {
					
				}
				else {
					first_Name = txtFirstName.getText();
					last_Name = txtLastName.getText();
					date_Of_Birth = sdf.format(dateOfBirth.getDate());
					telephone_Number = txtTelephoneNumber.getText();
					emailAddress = txtEmailAddress.getText();
					number_Of_Bags = (int)numberOfBags.getSelectedItem();
					departing_Seat = (String) departingSeats.getSelectedItem();
					returning_Seat = (String) returningSeats.getSelectedItem();
					
					System.out.println(first_Name + " " + last_Name + " " + date_Of_Birth + " " + telephone_Number + " " + emailAddress + " " + number_Of_Bags + " " + departing_Seat + " " + returning_Seat);
					int randomNumber = randomNum();
					System.out.println(randomNumber);
					
					newPassengerRecord = new passengerRecord(randomNumber, first_Name, last_Name, date_Of_Birth, telephone_Number, emailAddress, number_Of_Bags, departing_Seat, returning_Seat);
					passengers.addPassengerRecord(newPassengerRecord);
//					try {
					//newPassengerRecord = new passengerRecord(randomNumber, first_Name, last_name, date_of_birth, telephoneNumber, emailAddress, number_Of_Bags, departSeat, returnSeat);
//					passengers.addPassengerRecord(new ArrayList<passengerRecord>());
//					passengers.getPassengerRecord(0).add(newPassengerRecord);
//					passengers.addPassengerRecord(newPassengerRecord);
					//passengers.addPassengerRecord(newPassengerRecord);
					//passengers.addPassengerRecord(randomNumber,first_Name, last_name, date_of_birth, telephoneNumber, emailAddress, number_Of_Bags, departSeat, returnSeat);
//					} catch (Exception e2) {
//						// TODO: handle exception
//						System.out.println("Cannot save the data into the addPassengerRecord method" + e2);
//					}
					
//					
					
					System.out.println();
					
					JOptionPane.showMessageDialog(this, "Thank you for the purchase. Your ticket number is: " + randomNumber);
					
					departingSeats.removeItem(departing_Seat);
					returningSeats.removeItem(returning_Seat);
					
					dispose();
					Passengers passenger = new Passengers();
					passenger.setLocationRelativeTo(null);
				}
		}
		}
//			}
//			else {
//				
//				first_Name = txtFirstName.getText();
//				last_Name = txtLastName.getText();
//				date_Of_Birth = sdf.format(dateOfBirth.getDate());
//				telephone_Number = txtTelephoneNumber.getText();
//				emailAddress = txtEmailAddress.getText();
//				number_Of_Bags = (int)numberOfBags.getSelectedItem();
//				departing_Seat = (String) departingSeats.getSelectedItem();
//				returning_Seat = (String) returningSeats.getSelectedItem();
//	
//				System.out.println(first_Name + " " + last_Name + " " + date_Of_Birth + " " + telephone_Number + " " + emailAddress + " " + number_Of_Bags + " " + departing_Seat + " " + returning_Seat);
//				int randomNumber = randomNum();
//				System.out.println(randomNumber);
//	
//				newPassengerRecord.addPassengerRecord(randomNumber, first_Name, last_Name, date_Of_Birth, telephone_Number, emailAddress, number_Of_Bags, departing_Seat, returning_Seat);
//				
//				dispose();
//				
//			}
			
//		}
		
//	}
	
/******************************  Main method for displaying the Passengers UI constructor with all the content ***********************************/
	
	public static void main(String[] args)
	{
		new Passengers();
	}
	
}


