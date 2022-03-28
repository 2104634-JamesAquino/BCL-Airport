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
		// The code above shows the customer how many items they have ordered.
		
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
		// This will is a jlabel, next to this jlabel it will show how many items of this product the customer has ordered.
		
		JLabel OrderList_2 = new JLabel("Sausages:");
		OrderList_2.setBounds(10, 27, 80, 13);
		panel_2.add(OrderList_2);
		// This will is a jlabel, next to this jlabel it will show how many items of this product the customer has ordered.
		
		JLabel OrderList_3 = new JLabel("Pancakes:");
		OrderList_3.setBounds(10, 44, 101, 13);
		// This will is a jlabel, next to this jlabel it will show how many items of this product the customer has ordered.
		panel_2.add(OrderList_3);
		
		JLabel OrderList_4 = new JLabel("Rice and Curry:");
		OrderList_4.setBounds(10, 61, 115, 13);
		panel_2.add(OrderList_4);
		// This will is a jlabel, next to this jlabel it will show how many items of this product the customer has ordered.
		
		JLabel OrderList_5 = new JLabel("Fish and Chips:");
		OrderList_5.setBounds(10, 78, 115, 13);
		panel_2.add(OrderList_5);
		// This will is a jlabel, next to this jlabel it will show how many items of this product the customer has ordered.
		
		JLabel OrderList_6 = new JLabel("Pasta:");
		OrderList_6.setBounds(10, 95, 101, 13);
		panel_2.add(OrderList_6);
		// This will is a jlabel, next to this jlabel it will show how many items of this product the customer has ordered.
		
		JLabel OrderList_7 = new JLabel("Cheesecake:");
		OrderList_7.setBounds(10, 112, 115, 13);
		panel_2.add(OrderList_7);
		// This will is a jlabel, next to this jlabel it will show how many items of this product the customer has ordered.
		
		JLabel OrderList_8 = new JLabel("Choclate Cake:");
		OrderList_8.setBounds(10, 129, 115, 13);
		panel_2.add(OrderList_8);
		// This will is a jlabel, next to this jlabel it will show how many items of this product the customer has ordered.
		
		JLabel OrderList_9 = new JLabel("MilkShake:");
		OrderList_9.setBounds(10, 146, 115, 13);
		panel_2.add(OrderList_9);
		// This will is a jlabel, next to this jlabel it will show how many items of this product the customer has ordered.
		
		JLabel OrderList_10 = new JLabel("Orange Juice:");
		OrderList_10.setBounds(10, 163, 115, 13);
		panel_2.add(OrderList_10);
		// This will is a jlabel, next to this jlabel it will show how many items of this product the customer has ordered.
		
		JLabel OrderList_11 = new JLabel("Apple Juice:");
		OrderList_11.setBounds(10, 180, 115, 13);
		panel_2.add(OrderList_11);
		// This will is a jlabel, next to this jlabel it will show how many items of this product the customer has ordered.
		
		JLabel OrderList_12 = new JLabel("Coffee:");
		OrderList_12.setBounds(10, 197, 115, 13);
		panel_2.add(OrderList_12);
		// This will is a jlabel, next to this jlabel it will show how many items of this product the customer has ordered.
		
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
		// This is the code that will show the customer how much they are ordering for this item.
		
		JLabel ShowItem_2 = new JLabel("X "+Menu_page.Item_TwoCounter);
		ShowItem_2.setBounds(145, 27, 39, 13);
		panel_2.add(ShowItem_2);
		// This is the code that will show the customer how much they are ordering for this item.
		
		JLabel ShowItem_3 = new JLabel("X "+Menu_page.Item_ThreeCounter);
		ShowItem_3.setBounds(145, 44, 39, 13);
		panel_2.add(ShowItem_3);
		// This is the code that will show the customer how much they are ordering for this item.
		
		JLabel ShowItem_4 = new JLabel("X "+Menu_page.Item_FourCounter);
		ShowItem_4.setBounds(145, 61, 39, 13);
		panel_2.add(ShowItem_4);
		// This is the code that will show the customer how much they are ordering for this item.
		
		JLabel ShowItem_5 = new JLabel("X "+Menu_page.Item_FiveCounter);
		ShowItem_5.setBounds(145, 78, 39, 13);
		panel_2.add(ShowItem_5);
		// This is the code that will show the customer how much they are ordering for this item.
		
		JLabel ShowItem_6 = new JLabel("X "+Menu_page.Item_SixCounter);
		ShowItem_6.setBounds(145, 95, 39, 13);
		panel_2.add(ShowItem_6);
		// This is the code that will show the customer how much they are ordering for this item.
		
		JLabel ShowItem_7 = new JLabel("X "+Menu_page.Item_SevenCounter);
		ShowItem_7.setBounds(145, 112, 39, 13);
		panel_2.add(ShowItem_7);
		// This is the code that will show the customer how much they are ordering for this item.
		
		JLabel ShowItem_8 = new JLabel("X "+Menu_page.Item_EightCounter);
		ShowItem_8.setBounds(145, 129, 39, 13);
		panel_2.add(ShowItem_8);
		// This is the code that will show the customer how much they are ordering for this item.
		
		JLabel ShowItem_9 = new JLabel("X "+Menu_page.Item_NineCounter);
		ShowItem_9.setBounds(145, 146, 39, 13);
		panel_2.add(ShowItem_9);
		// This is the code that will show the customer how much they are ordering for this item.
		
		JLabel ShowItem_10 = new JLabel("X "+Menu_page.Item_TenCounter);
		ShowItem_10.setBounds(145, 163, 39, 13);
		panel_2.add(ShowItem_10);
		// This is the code that will show the customer how much they are ordering for this item.
		
		JLabel ShowItem_11 = new JLabel("X "+Menu_page.Item_ElevenCounter);
		ShowItem_11.setBounds(145, 180, 39, 13);
		panel_2.add(ShowItem_11);
		// This is the code that will show the customer how much they are ordering for this item.
		
		JLabel ShowItem_12 = new JLabel("X "+Menu_page.Item_TwelveCounter);
		ShowItem_12.setBounds(145, 197, 39, 13);
		panel_2.add(ShowItem_12);
		// This is the code that will show the customer how much they are ordering for this item.
		
		JLabel lblItemOrderList = new JLabel("Item Order List: ");
		lblItemOrderList.setBounds(30, 196, 167, 30);
		lblItemOrderList.setFont(new Font("Tahoma", Font.BOLD, 20));
		frame.getContentPane().add(lblItemOrderList);
		
		JButton btnNewButton = new JButton("Confirm Payment");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Hash_Stock.stock_1 = Hash_Stock.stock_1 - Menu_page.Item_OneCounter;
				Hash_Stock.stock_2 = Hash_Stock.stock_2 - Menu_page.Item_TwoCounter;
				Hash_Stock.stock_3 = Hash_Stock.stock_3 - Menu_page.Item_ThreeCounter;
				Hash_Stock.stock_4 = Hash_Stock.stock_4 - Menu_page.Item_FourCounter;
				Hash_Stock.stock_5 = Hash_Stock.stock_5 - Menu_page.Item_FiveCounter;
				Hash_Stock.stock_6 = Hash_Stock.stock_6 - Menu_page.Item_SixCounter;
				Hash_Stock.stock_7 = Hash_Stock.stock_7 - Menu_page.Item_SevenCounter;
				Hash_Stock.stock_8 = Hash_Stock.stock_8 - Menu_page.Item_EightCounter;
				Hash_Stock.stock_9 = Hash_Stock.stock_9 - Menu_page.Item_NineCounter;
				Hash_Stock.stock_10 = Hash_Stock.stock_10 - Menu_page.Item_TenCounter;
				Hash_Stock.stock_11 = Hash_Stock.stock_11 - Menu_page.Item_ElevenCounter;
				Hash_Stock.stock_12 = Hash_Stock.stock_12 - Menu_page.Item_TwelveCounter;
				// The twelve lines of code above, change the stock figures, once the customer confirms the check out.
				System.exit(0);
				Menu_page.Item_OneCounter = 0;
				Menu_page.Item_TwoCounter = 0;
				Menu_page.Item_ThreeCounter = 0;
				Menu_page.Item_FourCounter = 0;
				Menu_page.Item_FiveCounter = 0;
				Menu_page.Item_SixCounter = 0;
				Menu_page.Item_SevenCounter = 0;
				Menu_page.Item_EightCounter = 0;
				Menu_page.Item_NineCounter = 0;
				Menu_page.Item_TenCounter = 0;
				Menu_page.Item_ElevenCounter = 0;
				Menu_page.Item_TwelveCounter = 0;
				// The twelve lines above reset the count of how many of the product the customer is ordering.
				
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
