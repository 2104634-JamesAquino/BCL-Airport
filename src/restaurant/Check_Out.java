package restaurant;

import java.awt.Color;
import java.util.HashMap;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;

public class Check_Out {
	static int Counter_reset(int Counters) {
		Counters = 0;
		return Counters;
		
	}
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Check_Out window = new Check_Out();
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
	public Check_Out() {
		initialize();
	}

	/**
	 * Initialise the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.CYAN);
		frame.setBounds(100, 100, 600, 499);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNumberOfItems = new JLabel("Number of Items: " + Menu_page.Total_MenuItems);
		lblNumberOfItems.setBounds(30, 133, 236, 30);
		lblNumberOfItems.setFont(new Font("Tahoma", Font.BOLD, 20));
		frame.getContentPane().add(lblNumberOfItems);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(30, 133, 236, 30);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(30, 222, 184, 230);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel OrderList_1 = new JLabel("Toast:");
		OrderList_1.setBounds(10, 10, 80, 13);
		panel_2.add(OrderList_1);
		
		JLabel OrderList_2 = new JLabel("Sausages:");
		OrderList_2.setBounds(10, 27, 80, 13);
		panel_2.add(OrderList_2);
		
		JLabel OrderList_3 = new JLabel("Pancakes:");
		OrderList_3.setBounds(10, 44, 101, 13);
		panel_2.add(OrderList_3);
		
		JLabel OrderList_4 = new JLabel("Rice and Curry:");
		OrderList_4.setBounds(10, 61, 115, 13);
		panel_2.add(OrderList_4);
		
		JLabel OrderList_5 = new JLabel("Fish and Chips:");
		OrderList_5.setBounds(10, 78, 115, 13);
		panel_2.add(OrderList_5);
		
		JLabel OrderList_6 = new JLabel("Pasta:");
		OrderList_6.setBounds(10, 95, 101, 13);
		panel_2.add(OrderList_6);
		
		JLabel OrderList_7 = new JLabel("Cheesecake:");
		OrderList_7.setBounds(10, 112, 115, 13);
		panel_2.add(OrderList_7);
		
		JLabel OrderList_8 = new JLabel("Choclate Cake:");
		OrderList_8.setBounds(10, 129, 115, 13);
		panel_2.add(OrderList_8);
		
		JLabel OrderList_9 = new JLabel("MilkShake:");
		OrderList_9.setBounds(10, 146, 115, 13);
		panel_2.add(OrderList_9);
		
		JLabel OrderList_10 = new JLabel("Orange Juice:");
		OrderList_10.setBounds(10, 163, 115, 13);
		panel_2.add(OrderList_10);
		
		JLabel OrderList_11 = new JLabel("Apple Juice:");
		OrderList_11.setBounds(10, 180, 115, 13);
		panel_2.add(OrderList_11);
		
		JLabel OrderList_12 = new JLabel("Coffee:");
		OrderList_12.setBounds(10, 197, 115, 13);
		panel_2.add(OrderList_12);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 27, 164, 13);
		panel_2.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 44, 164, 13);
		panel_2.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 61, 164, 13);
		panel_2.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(10, 78, 164, 13);
		panel_2.add(separator_3);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(10, 78, 164, 13);
		panel_2.add(separator_4);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(10, 95, 164, 13);
		panel_2.add(separator_5);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setBounds(10, 95, 164, 13);
		panel_2.add(separator_6);
		
		JSeparator separator_7 = new JSeparator();
		separator_7.setBounds(10, 112, 164, 13);
		panel_2.add(separator_7);
		
		JSeparator separator_8 = new JSeparator();
		separator_8.setBounds(10, 129, 164, 13);
		panel_2.add(separator_8);
		
		JSeparator separator_9 = new JSeparator();
		separator_9.setBounds(10, 146, 164, 13);
		panel_2.add(separator_9);
		
		JSeparator separator_10 = new JSeparator();
		separator_10.setBounds(10, 163, 164, 13);
		panel_2.add(separator_10);
		
		JSeparator separator_11 = new JSeparator();
		separator_11.setBounds(10, 180, 164, 13);
		panel_2.add(separator_11);
		
		JSeparator separator_12 = new JSeparator();
		separator_12.setBounds(10, 197, 164, 13);
		panel_2.add(separator_12);
		
		JLabel ShowItem_1 = new JLabel("X "+Menu_page.Item_OneCounter);
		ShowItem_1.setBounds(145, 10, 39, 13);
		panel_2.add(ShowItem_1);
		
		JLabel ShowItem_2 = new JLabel("X "+Menu_page.Item_TwoCounter);
		ShowItem_2.setBounds(145, 27, 39, 13);
		panel_2.add(ShowItem_2);
		
		JLabel ShowItem_3 = new JLabel("X "+Menu_page.Item_ThreeCounter);
		ShowItem_3.setBounds(145, 44, 39, 13);
		panel_2.add(ShowItem_3);
		
		JLabel ShowItem_4 = new JLabel("X "+Menu_page.Item_FourCounter);
		ShowItem_4.setBounds(145, 61, 39, 13);
		panel_2.add(ShowItem_4);
		
		JLabel ShowItem_5 = new JLabel("X "+Menu_page.Item_FiveCounter);
		ShowItem_5.setBounds(145, 78, 39, 13);
		panel_2.add(ShowItem_5);
		
		JLabel ShowItem_6 = new JLabel("X "+Menu_page.Item_SixCounter);
		ShowItem_6.setBounds(145, 95, 39, 13);
		panel_2.add(ShowItem_6);
		
		JLabel ShowItem_7 = new JLabel("X "+Menu_page.Item_SevenCounter);
		ShowItem_7.setBounds(145, 112, 39, 13);
		panel_2.add(ShowItem_7);
		
		JLabel ShowItem_8 = new JLabel("X "+Menu_page.Item_EightCounter);
		ShowItem_8.setBounds(145, 129, 39, 13);
		panel_2.add(ShowItem_8);
		
		JLabel ShowItem_9 = new JLabel("X "+Menu_page.Item_NineCounter);
		ShowItem_9.setBounds(145, 146, 39, 13);
		panel_2.add(ShowItem_9);
		
		JLabel ShowItem_10 = new JLabel("X "+Menu_page.Item_TenCounter);
		ShowItem_10.setBounds(145, 163, 39, 13);
		panel_2.add(ShowItem_10);
		
		JLabel ShowItem_11 = new JLabel("X "+Menu_page.Item_ElevenCounter);
		ShowItem_11.setBounds(145, 180, 39, 13);
		panel_2.add(ShowItem_11);
		
		JLabel ShowItem_12 = new JLabel("X "+Menu_page.Item_TwelveCounter);
		ShowItem_12.setBounds(145, 197, 39, 13);
		panel_2.add(ShowItem_12);
		
		JLabel lblItemOrderList = new JLabel("Item Order List: ");
		lblItemOrderList.setBounds(30, 196, 167, 30);
		lblItemOrderList.setFont(new Font("Tahoma", Font.BOLD, 20));
		frame.getContentPane().add(lblItemOrderList);
		
		JButton btnNewButton = new JButton("Confirm Payment");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login.main(null);
				Counter_reset(Menu_page.Item_OneCounter);
				Counter_reset(Menu_page.Item_TwoCounter);
				Counter_reset(Menu_page.Item_ThreeCounter);
				Counter_reset(Menu_page.Item_FourCounter);
				Counter_reset(Menu_page.Item_FiveCounter);
				Counter_reset(Menu_page.Item_SixCounter);
				Counter_reset(Menu_page.Item_SevenCounter);
				Counter_reset(Menu_page.Item_EightCounter);
				Counter_reset(Menu_page.Item_NineCounter);
				Counter_reset(Menu_page.Item_TenCounter);
				Counter_reset(Menu_page.Item_ElevenCounter);
				Counter_reset(Menu_page.Item_TwelveCounter);
			}
		});
		btnNewButton.setBounds(276, 395, 276, 57);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		frame.getContentPane().add(btnNewButton);
		
		JLabel Total = new JLabel("Total Price: £"+Menu_page.Total_Price);
		Total.setBounds(30, 80, 190, 25);
		frame.getContentPane().add(Total);
		Total.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JPanel panel = new JPanel();
		panel.setBounds(30, 80, 216, 25);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
	}
}
