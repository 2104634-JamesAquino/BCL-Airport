package restaurant;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class Login_Page {
	public static String[] FNUMBER = {"J334","S232"};
	public static String[] UNAME = {"James","Lola"};
	public static String[] PWORD = {"NAME","232"};

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
					Login_Page window = new Login_Page();
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
	public Login_Page() {
		initialize();
	}

	/**
	 * Initialise the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.CYAN);
		frame.setBounds(200, 200, 578, 394);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel TicketNumLABEL = new JLabel("Ticket Number: ");
		TicketNumLABEL.setFont(new Font("Tahoma", Font.PLAIN, 15));
		TicketNumLABEL.setBounds(10, 49, 119, 19);
		frame.getContentPane().add(TicketNumLABEL);
		
		JLabel FirstNameLABEL = new JLabel("First Name:");
		FirstNameLABEL.setFont(new Font("Tahoma", Font.PLAIN, 15));
		FirstNameLABEL.setBounds(10, 112, 108, 19);
		frame.getContentPane().add(FirstNameLABEL);
		
		JLabel SurnameLABEL = new JLabel("Surname: ");
		SurnameLABEL.setFont(new Font("Tahoma", Font.PLAIN, 15));
		SurnameLABEL.setBounds(10, 181, 96, 19);
		frame.getContentPane().add(SurnameLABEL);
		
		TicketNumENTER = new JTextField();
		TicketNumENTER.setBounds(10, 83, 96, 19);
		frame.getContentPane().add(TicketNumENTER);
		TicketNumENTER.setColumns(10);
		
		FirstNameENTER = new JTextField();
		FirstNameENTER.setBounds(10, 141, 96, 19);
		frame.getContentPane().add(FirstNameENTER);
		FirstNameENTER.setColumns(10);
		
		SurnameENTER = new JTextField();
		SurnameENTER.setBounds(10, 210, 142, 19);
		frame.getContentPane().add(SurnameENTER);
		SurnameENTER.setColumns(10);
		
		JLabel LoginPageLABEL = new JLabel("Login Page");
		LoginPageLABEL.setFont(new Font("Tahoma", Font.PLAIN, 30));
		LoginPageLABEL.setBounds(175, 2, 211, 37);
		frame.getContentPane().add(LoginPageLABEL);
		
		JButton LoginBUTTON = new JButton("Login");
		LoginBUTTON.setFont(new Font("Tahoma", Font.BOLD, 20));
		LoginBUTTON.setBounds(10, 239, 142, 62);
		frame.getContentPane().add(LoginBUTTON);
		LoginBUTTON.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//String path = "C:\\Users\\Wasif Khan\\OneDrive - Brunel University London\\CS1701 Group Projects\\CS1810\\Passenger_Data.csv",
						//Ticket_Number = Ticket_NumberTxt.getText(),First_Name,Surname ;
				
				
			//new Passenger_Open_CSV().ReadFile(path,Ticket_Number, First_Name, Surname);
				String TickNum = TicketNumENTER.getText();
				String FIRSTNAME = FirstNameENTER.getText();
				String SURNAME = SurnameENTER.getText();
				
				if (TickNum.contains("LK88")&& FIRSTNAME.contains("Wasif")&&SURNAME.contains("Wasim")) {
					System.out.println("Sucess");
					TicketNumENTER.setText(null);
					FirstNameENTER.setText(null);
					SurnameENTER.setText(null);
					
					Inventory_counter info = new Inventory_counter();
					Inventory_counter.main(null);
				}
				else {
					JOptionPane.showMessageDialog(null,"Invalid Login","Login Error",JOptionPane.ERROR_MESSAGE);
					TicketNumENTER.setText(null);
					FirstNameENTER.setText(null);
					SurnameENTER.setText(null);
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