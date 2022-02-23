package restaurant;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Tester {
	

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
	 * Initialize the contents of the frame.
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
		
		JButton btnTwo = new JButton("Two");
		btnTwo.setBounds(135, 101, 85, 21);
		frame.getContentPane().add(btnTwo);
		
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
