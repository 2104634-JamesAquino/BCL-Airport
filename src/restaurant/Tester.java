package restaurant;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Tester {
	static int  counter = 0;
	static int counter2 = 0;
	
	public static int Addition(int a) {
		a++;
		System.out.println("Button pressed" + a);
		return a;
	}
	

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tester window = new Tester();
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
	public Tester() {
		initialize();
	}

	/**
	 * Initialise the contents of the frame.
	 * @return 
	 */

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnOne = new JButton("One");
		btnOne.setBounds(20, 101, 85, 21);
		frame.getContentPane().add(btnOne);
		btnOne.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			counter = Addition(counter);			
		}
	});
		JButton btnTwo = new JButton("Two");
		btnTwo.setBounds(135, 101, 85, 21);
		frame.getContentPane().add(btnTwo);
		btnTwo.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			counter2 = Addition(counter2);			
		}
	});
		
		JButton btnThree = new JButton("Three");
		btnThree.setBounds(255, 101, 85, 21);
		frame.getContentPane().add(btnThree);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(39, 158, 45, 13);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(157, 158, 45, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(275, 158, 45, 13);
		frame.getContentPane().add(lblNewLabel_2);
		
		
	}
}
