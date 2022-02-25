package restaurant;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.awt.event.ActionEvent;

public class Menu_page {
	
	static int Stock_Updater(int C, String D, HashMap<String, Integer> E, int J) {
		C = (int) E.get(D);
		C =C -J;
		E.put(D,C);
		System.out.println(E.get(D));
		E.put(D,C);
		return C;			
		// This is a Method that is used to update the stock, this method will be called at the end.
		//when the user has decided on all items they will like to order
		
	}
	
	static int Total_MenuItems;
	static int Total_Price;
	static int Item_OneCounter = 0;
	static int Item_TwoCounter = 0;
	static int Item_ThreeCounter = 0;
	static int Item_FourCounter = 0;
	static int Item_FiveCounter = 0;
	static int Item_SixCounter = 0;
	static int Item_SevenCounter = 0;
	static int Item_EightCounter = 0;
	static int Item_NineCounter = 0;
	static int Item_TenCounter = 0;
	static int Item_ElevenCounter = 0;
	static int Item_TwelveCounter = 0;
	// All of these variables are used to keep count of each item of which will be ordered.
	// The variable "Total_MenuItems" is used for the check out page to show how many Products are being ordered. 
	// The variable "Total_Price" is also used for the Check out page to show how much the user has spent, it will also be used to add the amount to the finances. 
	
	public static int Plus_button(int a, HashMap<String, Integer> L, String K, int G) {
		a++;
		G = (int) L.get(K);
		if(a>100 || a > G) {
			a = 99;	
			JOptionPane.showMessageDialog(null,"Cannot Order This Many","Login Error",JOptionPane.ERROR_MESSAGE); 
			// This is an error message that will pop up if the use is ordering more than 100 or the amount of stock left.
		}
		return a;
	}
	// This is a method that has 2 Functions 
	// Function one is, to increment how many of the products will be added to the basket
	// Function tow is to, make sure there is no order above 100, or the amount of stock left.
	public static int Minus_button(int b) {
		b--;
		if(b<0) {
			b=0;
			JOptionPane.showMessageDialog(null,"Cannot Order below 0", null, JOptionPane.ERROR_MESSAGE); 
			// this is an error message if the customer tries to order bellow 0.
		}
		return b;	
	}
	// This Method has 2 functions.
	// The first Function is to reduce the number of that product by 1.
	// The Second function is to make sure the customer is not ordering any products below 0
	
	private JFrame frame;
	JLabel Show_StockCount_1;
	JLabel Show_StockCount_2;
	JLabel Show_StockCount_3;
	JLabel Show_StockCount_4;
	JLabel Show_StockCount_5;
	JLabel Show_StockCount_6;
	JLabel Show_StockCount_7;
	JLabel Show_StockCount_8;
	JLabel Show_StockCount_9;
	JLabel Show_StockCount_10;
	JLabel Show_StockCount_11;
	JLabel Show_StockCount_12;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu_page window = new Menu_page();
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
	public Menu_page() {
		initialize();
	}

	/**
	 * Initialise the contents of the frame.
	 */
	private void initialize() {
		
		HashMap<String , Integer> Restrant_data = new HashMap<String, Integer>();
		
		Restrant_data.put("Toast", 100);
		Restrant_data.put("Sausages", 100);
		Restrant_data.put("Pancakes", 100);
		Restrant_data.put("Rice and Curry", 100);
		Restrant_data.put("Fish and Chips", 100);
		Restrant_data.put("Pasta", 100);
		Restrant_data.put("CheeseCake", 100);
		Restrant_data.put("Choclate Cake", 100);
		Restrant_data.put("MilkShake", 100);
		Restrant_data.put("Orange Juice", 100);
		Restrant_data.put("Apple Juice", 100);
		Restrant_data.put("Coffee", 100);
		
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.CYAN);
		frame.setBounds(100, 100, 839, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Inventory");
		frame.getContentPane().setLayout(null);
		
		JLabel Title = new JLabel("Restaurant");
		Title.setBounds(231, 0, 423, 46);
		Title.setFont(new Font("Tahoma", Font.BOLD, 41));
		Title.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(Title);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(56, 64, 190, 100);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 8));
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel Item_1 = new JLabel("Toast (3 Slices)");
		Double Toast = 1.5;
		Item_1.setBounds(42, 22, 91, 13);
		panel_1.add(Item_1);
		
		Show_StockCount_1 = new JLabel(""+Item_OneCounter);
		Show_StockCount_1.setBounds(93, 62, 24, 13);
		panel_1.add(Show_StockCount_1);
		
		JButton Plus_1 = new JButton("+");
		Plus_1.setBounds(116, 58, 50, 21);
		panel_1.add(Plus_1);
		Plus_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item_OneCounter = Plus_button(Item_OneCounter, Restrant_data, "Toast", 0);
				Show_StockCount_1.setText(String.valueOf(Item_OneCounter));
			}
		});
		
		JButton Minus_1 = new JButton("-");
		Minus_1.setBounds(21, 58, 50, 21);
		panel_1.add(Minus_1);
		Minus_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item_OneCounter= Minus_button(Item_OneCounter);
				Show_StockCount_1.setText(String.valueOf(Item_OneCounter));
			}
		});
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(334, 64, 190, 100);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 8));
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
			
		JLabel Item_2 = new JLabel("Sausages (3 Pieces)");
		Double Sausages = 3.0;
		Item_2.setBounds(36, 24, 119, 13);
		panel_2.add(Item_2);

		Show_StockCount_2 = new JLabel(""+Item_TwoCounter);
		Show_StockCount_2.setBounds(70, 62, 24, 13);
		panel_2.add(Show_StockCount_2);
		
		JButton Plus_2 = new JButton("+");
		Plus_2.setBounds(101, 58, 50, 21);
		panel_2.add(Plus_2);
		Plus_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item_TwoCounter = Plus_button(Item_TwoCounter, Restrant_data, "Sausages", 0);
				Show_StockCount_2.setText(String.valueOf(Item_TwoCounter));
				
				}
		});
		
		JButton Minus_2 = new JButton("-");
		Minus_2.setBounds(10, 58, 50, 21);
		panel_2.add(Minus_2);
		Minus_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item_TwoCounter = Minus_button(Item_TwoCounter);
				Show_StockCount_2.setText(String.valueOf(Item_TwoCounter));
			}
		});
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(625, 64, 190, 100);
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0), 8));
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JLabel Item_3 = new JLabel("Pancakes (3 Pieces)");
		@SuppressWarnings("unused")
		Double Pancakes = 4.5;
		Item_3.setBounds(20, 24, 121, 13);
		panel_3.add(Item_3);
		
		Show_StockCount_3 = new JLabel(""+Item_ThreeCounter);
		Show_StockCount_3.setBounds(70, 62, 24, 13);
		panel_3.add(Show_StockCount_3);
		
		JButton Plus_3 = new JButton("+");
		Plus_3.setBounds(105, 58, 50, 21);
		panel_3.add(Plus_3);
		Plus_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item_ThreeCounter = Plus_button(Item_ThreeCounter, Restrant_data, "Pancakes", 0);
				Show_StockCount_3.setText(String.valueOf(Item_ThreeCounter));
				}
		});
		
		JButton Minus_3 = new JButton("-");
		Minus_3.setBounds(10, 58, 50, 21);
		panel_3.add(Minus_3);
		Minus_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item_ThreeCounter =  Minus_button(Item_ThreeCounter);
				Show_StockCount_3.setText(String.valueOf(Item_ThreeCounter));
			}
		});
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(56, 195, 190, 100);
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0), 8));
		frame.getContentPane().add(panel_4);
		panel_4.setLayout(null);
		
		JLabel Item_4 = new JLabel("Rice and Curry");
		Double Rice_and_Curry = 8.00;
		Item_4.setBounds(47, 22, 96, 13);
		panel_4.add(Item_4);
		
		JLabel Show_StockCount_4 = new JLabel(""+Item_FourCounter);
		Show_StockCount_4.setBounds(95, 61, 24, 13);
		panel_4.add(Show_StockCount_4);
		
		JButton Plus_4 = new JButton("+");
		Plus_4.setBounds(119, 57, 50, 21);
		panel_4.add(Plus_4);
		Plus_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item_FourCounter =  Plus_button(Item_FourCounter, Restrant_data,"Rice and Curry", 0);
				Show_StockCount_4.setText(String.valueOf(Item_FourCounter));
			}
		});
		
		JButton Minus_4 = new JButton("-");
		Minus_4.setBounds(24, 57, 50, 21);
		panel_4.add(Minus_4);
		Minus_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item_FourCounter =  Minus_button(Item_FourCounter);
				Show_StockCount_4.setText(String.valueOf(Item_FourCounter));
			}
		});
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(334, 195, 190, 100);
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0), 8));
		frame.getContentPane().add(panel_5);
		panel_5.setLayout(null);
		
		JLabel Item_5 = new JLabel("Fish and Chips");
		Double Fish_and_Chips = 11.50;
		Item_5.setBounds(34, 30, 96, 13);
		panel_5.add(Item_5);
		
		JLabel Show_StockCount_5 = new JLabel(""+Item_FiveCounter);
		Show_StockCount_5.setBounds(67, 61, 24, 13);
		panel_5.add(Show_StockCount_5);
		
		JButton Plus_5 = new JButton("+");
		Plus_5.setBounds(101, 57, 50, 21);
		panel_5.add(Plus_5);
		Plus_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item_FiveCounter = Plus_button(Item_FiveCounter,Restrant_data, "Fish and Chips", 0);
				Show_StockCount_5.setText(String.valueOf(Item_FiveCounter));		
				}
		});
		
		JButton Minus_5 = new JButton("-");
		Minus_5.setBounds(10, 57, 50, 21);
		panel_5.add(Minus_5);
		Minus_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item_FiveCounter = Minus_button(Item_FiveCounter);
				Show_StockCount_5.setText(String.valueOf(Item_FiveCounter));			
			}
			
		});
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(625, 195, 190, 100);
		panel_6.setBorder(new LineBorder(new Color(0, 0, 0), 8));
		frame.getContentPane().add(panel_6);
		panel_6.setLayout(null);
		
		JLabel Item_6 = new JLabel("Pasta");
		Double Pasta = 10.0;
		Item_6.setBounds(65, 27, 67, 13);
		panel_6.add(Item_6);
		
		JLabel Show_StockCount_6 = new JLabel(""+Item_SixCounter);
		Show_StockCount_6.setBounds(71, 61, 24, 13);
		panel_6.add(Show_StockCount_6);
		
		JButton Plus_6 = new JButton("+");
		Plus_6.setBounds(105, 57, 50, 21);
		panel_6.add(Plus_6);
		Plus_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item_SixCounter = Plus_button(Item_SixCounter, Restrant_data, "Pasta", 0);
				Show_StockCount_6.setText(String.valueOf(Item_SixCounter));		
				}
		});
		
		JButton Minus_6 = new JButton("-");
		Minus_6.setBounds(10, 57, 50, 21);
		panel_6.add(Minus_6);
		Minus_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item_SixCounter = Minus_button(Item_SixCounter);
				Show_StockCount_6.setText(String.valueOf(Item_SixCounter));
			}
		});
		
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(56, 329, 190, 100);
		panel_7.setBorder(new LineBorder(new Color(0, 0, 0), 8));
		frame.getContentPane().add(panel_7);
		
		JLabel Item_7 = new JLabel("CheeeseCake (Two Slices)");
		Item_7.setBounds(20, 23, 170, 13);
		Double CheeseCake = 4.50;
		panel_7.setLayout(null);
		panel_7.add(Item_7);
		
		JLabel Show_StockCount_7 = new JLabel(""+Item_SevenCounter);
		Show_StockCount_7.setBounds(89, 60, 24, 13);
		panel_7.add(Show_StockCount_7);
		
		JButton Plus_7 = new JButton("+");
		Plus_7.setBounds(111, 56, 54, 21);
		panel_7.add(Plus_7);
		Plus_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item_SevenCounter = Plus_button(Item_SevenCounter, Restrant_data, "CheeseCake", 0);
				Show_StockCount_7.setText(String.valueOf(Item_SevenCounter));
				}
		});
		
		JButton Minus_7 = new JButton("-");
		Minus_7.setBounds(20, 56, 49, 21);
		panel_7.add(Minus_7);
		Minus_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item_SevenCounter = Minus_button(Item_SevenCounter);
				Show_StockCount_7.setText(String.valueOf(Item_SevenCounter));
			}
		});
		
		JPanel panel_8 = new JPanel();
		panel_8.setBounds(334, 329, 190, 100);
		panel_8.setBorder(new LineBorder(new Color(0, 0, 0), 8));
		frame.getContentPane().add(panel_8);
		panel_8.setLayout(null);
		
		JLabel Item_8 = new JLabel("Choclate Cake (2 Slices)");
		Double Choclate_Cake = 5.50;
		Item_8.setBounds(32, 21, 148, 13);
		panel_8.add(Item_8);		
		
		JLabel Show_StockCount_8 = new JLabel(""+Item_EightCounter);
		Show_StockCount_8.setBounds(70, 58, 24, 13);
		panel_8.add(Show_StockCount_8);
		
		JButton Plus_8 = new JButton("+");
		Plus_8.setBounds(104, 54, 51, 21);
		panel_8.add(Plus_8);
		Plus_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item_EightCounter = Plus_button(Item_EightCounter, Restrant_data, "Choclate Cake", 0);
				Show_StockCount_8.setText(String.valueOf(Item_EightCounter));		
				}
		});
		
		JButton Minus_8 = new JButton("-");
		Minus_8.setBounds(10, 54, 50, 21);
		panel_8.add(Minus_8);
		Minus_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item_EightCounter = Minus_button(Item_EightCounter);
				Show_StockCount_8.setText(String.valueOf(Item_EightCounter));
			}
		});
			
		JPanel panel_9 = new JPanel();
		panel_9.setBounds(625, 329, 190, 100);
		panel_9.setBorder(new LineBorder(new Color(0, 0, 0), 8));
		frame.getContentPane().add(panel_9);
		panel_9.setLayout(null);
		
		JLabel Item_9 = new JLabel("MilkShake (Vanila)");
		Double MilkShake = 6.70;
		Item_9.setBounds(33, 25, 133, 13);
		panel_9.add(Item_9);
		
		JLabel Show_StockCount_9 = new JLabel(""+Item_NineCounter);
		Show_StockCount_9.setBounds(70, 62, 24, 13);
		panel_9.add(Show_StockCount_9);
		
		JButton Plus_9 = new JButton("+");
		Plus_9.setBounds(104, 62, 51, 21);
		panel_9.add(Plus_9);
		Plus_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item_NineCounter = Plus_button(Item_NineCounter, Restrant_data, "MilkShake", 0);
				Show_StockCount_9.setText(String.valueOf(Item_NineCounter));
			}
		});
		
		JButton Minus_9 = new JButton("-");
		Minus_9.setBounds(10, 62, 50, 21);
		panel_9.add(Minus_9);
		Minus_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item_NineCounter = Minus_button(Item_NineCounter);
				Show_StockCount_9.setText(String.valueOf(Item_NineCounter));
					
				}
		});
		
		JPanel panel_10 = new JPanel();
		panel_10.setBounds(56, 459, 190, 100);
		panel_10.setBorder(new LineBorder(new Color(0, 0, 0), 8));
		frame.getContentPane().add(panel_10);
		panel_10.setLayout(null);
		
		JLabel Item_10 = new JLabel("Orange Juice");
		Double Orange_Juice = 2.0;
		Item_10.setBounds(59, 30, 107, 13);
		panel_10.add(Item_10);
		
		JLabel Show_StockCount_10 = new JLabel(""+Item_TenCounter);
		Show_StockCount_10.setBounds(92, 73, 24, 13);
		panel_10.add(Show_StockCount_10);
		
		JButton Plus_10 = new JButton("+");
		Plus_10.setBounds(114, 69, 52, 21);
		panel_10.add(Plus_10);
		Plus_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item_TenCounter = Plus_button(Item_TenCounter, Restrant_data, "Orange Juice", 0);
				Show_StockCount_10.setText(String.valueOf(Item_TenCounter));		
				}
		});
		
		JButton Minus_10 = new JButton("-");
		Minus_10.setBounds(21, 69, 49, 21);
		panel_10.add(Minus_10);
		Minus_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item_TenCounter = Minus_button(Item_TenCounter);
				Show_StockCount_10.setText(String.valueOf(Item_TenCounter));
			}
		});
		
		JPanel panel_11 = new JPanel();
		panel_11.setBounds(334, 459, 190, 100);
		panel_11.setBorder(new LineBorder(new Color(0, 0, 0), 8));
		frame.getContentPane().add(panel_11);
		
		JLabel Item_11 = new JLabel("Apple Juice");
		Item_11.setBounds(59, 20, 96, 13);
		Double Apple_Juice = 2.0;
		panel_11.setLayout(null);
		panel_11.add(Item_11);

		
		JLabel Show_StockCount_11 = new JLabel(""+Item_ElevenCounter);
		Show_StockCount_11.setBounds(66, 65, 24, 13);
		panel_11.add(Show_StockCount_11);
		
		JButton Plus_11 = new JButton("+");
		Plus_11.setBounds(100, 65, 55, 21);
		panel_11.add(Plus_11);
		Plus_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item_ElevenCounter = Plus_button(Item_ElevenCounter, Restrant_data, "Apple Juice", 0);
				Show_StockCount_11.setText(String.valueOf(Item_ElevenCounter));
			}
		});
		
		JButton Minus_11 = new JButton("-");
		Minus_11.setBounds(10, 65, 46, 21);
		panel_11.add(Minus_11);
		Minus_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item_ElevenCounter = Minus_button(Item_ElevenCounter);
				Show_StockCount_11.setText(String.valueOf(Item_ElevenCounter));
			}
		});
		
		JPanel panel_12 = new JPanel();
		panel_12.setBounds(625, 459, 190, 100);
		panel_12.setBorder(new LineBorder(new Color(0, 0, 0), 8));
		frame.getContentPane().add(panel_12);
		
		JLabel Item_12 = new JLabel("Coffee");
		Item_12.setBounds(56, 23, 75, 13);
		Double Coffee = 4.0;
		panel_12.setLayout(null);
		panel_12.add(Item_12);
		
		JLabel Show_StockCount_12 = new JLabel(""+Item_TwelveCounter);
		Show_StockCount_12.setBounds(70, 64, 24, 13);
		panel_12.add(Show_StockCount_12);
		
		JButton Plus_12 = new JButton("+");
		Plus_12.setBounds(104, 64, 51, 21);
		panel_12.add(Plus_12);
		Plus_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item_TwelveCounter = Plus_button(Item_TwelveCounter, Restrant_data, "Coffee", 0);
				Show_StockCount_12.setText(String.valueOf(Item_TwelveCounter));	
				}
		});

		JButton Minus_12 = new JButton("-");
		Minus_12.setBounds(10, 64, 50, 21);
		panel_12.add(Minus_12);
		Minus_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item_TwelveCounter = Minus_button(Item_TwelveCounter);
				Show_StockCount_12.setText(String.valueOf(Item_TwelveCounter));
			}
		});
		
		JButton Check_out = new JButton("Check Out");
		Check_out.setBounds(691, 586, 111, 21);
		Check_out.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Total_MenuItems = Item_OneCounter+Item_TwoCounter + Item_ThreeCounter + Item_FourCounter +Item_FiveCounter
						+ Item_SixCounter + Item_SevenCounter + Item_EightCounter + Item_NineCounter + Item_TenCounter + Item_ElevenCounter
						+ Item_TwelveCounter;
				
				Total_Price = (int) ((Item_OneCounter*Toast)+(Item_TwoCounter*Sausages)+(Item_ThreeCounter*Pancakes)+(Item_FourCounter*Rice_and_Curry)+
						(Item_FiveCounter*Fish_and_Chips)+(Item_SixCounter*Pasta)+(Item_SevenCounter*CheeseCake)+(Item_EightCounter*Choclate_Cake)
						+(Item_NineCounter*MilkShake)+(Item_TenCounter*Orange_Juice)+(Item_ElevenCounter*Apple_Juice)+(Item_TwelveCounter*Coffee));
				
				int Temp = 0;
				Stock_Updater(Temp, "Toast", Restrant_data, Item_OneCounter ); //1
				Stock_Updater(Temp, "Sausages", Restrant_data, Item_TwoCounter ); //2
				Stock_Updater(Temp, "Pancakes", Restrant_data, Item_ThreeCounter ); //3
				Stock_Updater(Temp, "Rice and Curry", Restrant_data, Item_FourCounter ); //4
				Stock_Updater(Temp, "Fish and Chips", Restrant_data, Item_FiveCounter ); //5
				Stock_Updater(Temp, "Pasta", Restrant_data, Item_SixCounter ); //6
				Stock_Updater(Temp, "CheeseCake", Restrant_data, Item_SevenCounter ); //7
				Stock_Updater(Temp, "Choclate Cake", Restrant_data, Item_EightCounter ); //8
				Stock_Updater(Temp, "MilkShake", Restrant_data, Item_NineCounter ); //9
				Stock_Updater(Temp, "MilkShake", Restrant_data, Item_TenCounter ); //10
				Stock_Updater(Temp, "Apple Juice", Restrant_data, Item_ElevenCounter ); //11
				Stock_Updater(Temp, "Coffee", Restrant_data, Item_TwelveCounter ); //12
				
				System.out.println(Restrant_data);
				Check_Out.main(null);
			}
		});
		frame.getContentPane().add(Check_out);
		
	}
}
