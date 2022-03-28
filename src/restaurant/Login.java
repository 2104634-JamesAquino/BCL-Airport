package restaurant;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;
import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class Login {
	
	HashMap<String,String> LoginData = new HashMap<String,String>();
	void LoginPage (HashMap<String,String> loginInfoOriginal){
		LoginData = loginInfoOriginal;
	}


	static String fname;
	static String lname;
	static String ticket_num;
	
	static String TickNum;
	static String FIRSTNAME;
	static String SURNAME;
	// These are variables that will be used for the user, input for the restaurant.
	
	private JFrame frame;
	private JTextField TicketNumENTER;
	private JTextField FirstNameENTER;
	private JTextField SurnameENTER;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialise the contents of the frame.
	 */
	private void initialize() {
		
//		ArrayList<Object[]> passengers_login;
//		Object[] passengers_login = new Object[3];
//		
//		passengers_login[0]=fname;
//		passengers_login[1]=lname;
//		passengers_login[2]=ticket_num;
//		Object[] p_clone = passengers_login.clone();
//		passengers_login.add(p_clone);
		
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.CYAN);
		frame.setBounds(200, 200, 578, 394);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel TicketNumLABEL = new JLabel("Ticket Number: ");
		TicketNumLABEL.setFont(new Font("Tahoma", Font.PLAIN, 15));
		TicketNumLABEL.setBounds(10, 49, 119, 19);
		frame.getContentPane().add(TicketNumLABEL);
		// This is a label for the User Interface to show where the customer should input their ticket number.
		
		JLabel FirstNameLABEL = new JLabel("First Name");
		FirstNameLABEL.setFont(new Font("Tahoma", Font.PLAIN, 15));
		FirstNameLABEL.setBounds(10, 112, 108, 19);
		frame.getContentPane().add(FirstNameLABEL);
		// This is a label for the User Interface to show where the customer should input their First name.
		
		JLabel SurnameLABEL = new JLabel("Surname: ");
		SurnameLABEL.setFont(new Font("Tahoma", Font.PLAIN, 15));
		SurnameLABEL.setBounds(10, 181, 96, 19);
		frame.getContentPane().add(SurnameLABEL);
		// This is a label for the User Interface to show where the customer should input their Surname.
		
		TicketNumENTER = new JTextField();
		TicketNumENTER.setBounds(10, 83, 96, 19);
		frame.getContentPane().add(TicketNumENTER);
		TicketNumENTER.setColumns(10);
		// This is a text field where the user inputs their ticket number.
		
		FirstNameENTER = new JTextField();
		FirstNameENTER.setBounds(10, 141, 204, 19);
		frame.getContentPane().add(FirstNameENTER);
		FirstNameENTER.setColumns(10);
		//This is a text field where the user inputs their first name.
		
		SurnameENTER = new JTextField();
		SurnameENTER.setBounds(10, 210, 142, 19);
		frame.getContentPane().add(SurnameENTER);
		SurnameENTER.setColumns(10);
		//This is a text field where the user inputs their surname.
		
		JLabel LoginPageLABEL = new JLabel("Login Page");
		LoginPageLABEL.setFont(new Font("Tahoma", Font.PLAIN, 30));
		LoginPageLABEL.setBounds(175, 2, 211, 37);
		frame.getContentPane().add(LoginPageLABEL);
		// This is where the title for the program will be.
		
		JButton LoginBUTTON = new JButton("Login");
		LoginBUTTON.setFont(new Font("Tahoma", Font.BOLD, 20));
		LoginBUTTON.setBounds(10, 239, 142, 62);
		frame.getContentPane().add(LoginBUTTON);
		// This is the code to have the button on the software page.
		LoginBUTTON.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TickNum = TicketNumENTER.getText();
				FIRSTNAME = FirstNameENTER.getText();
				SURNAME = SurnameENTER.getText();
				// the 3 lines of code above store the user inputs into 3 variables.
				
				if (TickNum.contains("83746578")&& FIRSTNAME.contains("Aaron")&&SURNAME.contains("Samuels")) {
					System.out.println("Sucess");
					TicketNumENTER.setText(null);
					FirstNameENTER.setText(null);
					SurnameENTER.setText(null);
					Menu_page.main(null);	// this line of code opens the next page, which is the menu page.	
					// this is an if statement to see if the user inputs are a match. 
				}
				else if(TickNum.contains("95738494")&& FIRSTNAME.contains("Cady")&&SURNAME.contains("Heron")){
					System.out.println("Sucess");
					TicketNumENTER.setText(null);
					FirstNameENTER.setText(null);
					SurnameENTER.setText(null);
					Menu_page.main(null);	// this line of code opens the next page, which is the menu page.	
					// this is an if statement to see if the user inputs are a match. 
				}
				else if(TickNum.contains("27475839")&& FIRSTNAME.contains("Regina")&&SURNAME.contains("George")){
					System.out.println("Sucess");
					TicketNumENTER.setText(null);
					FirstNameENTER.setText(null);
					SurnameENTER.setText(null);
					Menu_page.main(null);	// this line of code opens the next page, which is the menu page.	
					// this is an if statement to see if the user inputs are a match. 
				}
				else 
				{
					JOptionPane.showMessageDialog(null,"Invalid Login","Login Error",JOptionPane.ERROR_MESSAGE);
					TicketNumENTER.setText(null);
					FirstNameENTER.setText(null);
					SurnameENTER.setText(null);
					// if the user inputs are not a match it will give an error message and state that there is an error.
				}
			}
		});
	
		JSeparator separator = new JSeparator();
		separator.setBounds(20, 37, 456, 2);
		frame.getContentPane().add(separator);
		
		JButton ExitBUTTON = new JButton("Exit");
		ExitBUTTON.setFont(new Font("Tahoma", Font.BOLD, 20));
		ExitBUTTON.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame = new JFrame("Exit");
			    if (JOptionPane.showConfirmDialog( frame,"confirm if you Want to Exit","BCLA",
			            JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
			            System.exit(0);
			}
		});
		ExitBUTTON.setBounds(215, 239, 142, 62);
		frame.getContentPane().add(ExitBUTTON);
	}
}
