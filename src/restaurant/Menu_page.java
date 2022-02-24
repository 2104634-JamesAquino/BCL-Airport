package restaurant;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;

public class Menu_page {
	static int Total_MenuItems;
	static int Total_Price;
	static int Item_OneCounter ;
	static int Item_TwoCounter;
	static int Item_ThreeCounter;
	static int Item_FourCounter;
	static int Item_FiveCounter;
	static int Item_SixCounter;
	static int Item_SevenCounter;
	static int Item_EightCounter;
	static int Item_NineCounter;
	static int Item_TenCounter;
	static int Item_ElevenCounter;
	static int Item_TwelveCounter;
	
	public static int Plus_button(int a) {
		a++;
		if(a>100) {
			System.out.println("You cannot order this much");
			a = 99;	
		}
		System.out.println("Item One: "+a);
		return a;
	}
	
	
	public static int Minus_button(int b) {
		b--;
	return b;	
	}
	private JFrame frame;
	
	JLabel Show_StockCount_1;
	

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
		
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.CYAN);
		frame.setBounds(100, 100, 875, 864);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Inventory");
		frame.getContentPane().setLayout(null);
		
		JLabel Title = new JLabel("Restaurant");
		Title.setFont(new Font("Tahoma", Font.BOLD, 41));
		Title.setHorizontalAlignment(SwingConstants.CENTER);
		Title.setBounds(232, 10, 423, 56);
		frame.getContentPane().add(Title);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 8));
		panel_1.setBounds(58, 95, 165, 100);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel Item_1 = new JLabel("Toast (3 Slices)");
		Double Toast = 1.5;
		Item_1.setBounds(42, 22, 91, 13);
		panel_1.add(Item_1);
		
		Show_StockCount_1 = new JLabel(""+Item_OneCounter);
		Show_StockCount_1.setBounds(71, 62, 24, 13);
		panel_1.add(Show_StockCount_1);
		
		JButton Plus_1 = new JButton("+");
		Plus_1.setBounds(105, 58, 50, 21);
		panel_1.add(Plus_1);
		Plus_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item_OneCounter = Plus_button(Item_OneCounter);
				
				Show_StockCount_1.setText(String.valueOf(Item_OneCounter));
			}
		});
		
		JButton Minus_1 = new JButton("-");
		Minus_1.setBounds(10, 58, 50, 21);
		panel_1.add(Minus_1);
		Minus_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item_OneCounter= Minus_button(Item_OneCounter);
				if(Item_OneCounter<0) {
					System.out.println("Error, order cannot go Bellow 0");
					Item_OneCounter=0;	
				}
				Show_StockCount_1.setText(String.valueOf(Item_OneCounter));
				System.out.println("Item One: "+Item_OneCounter);
			}
		});
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 8));
		panel_2.setBounds(336, 95, 165, 100);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
			
		JLabel Item_2 = new JLabel("Sausages (3 Pieces)");
		Double Sausages = 3.0;
		Item_2.setBounds(36, 24, 119, 13);
		panel_2.add(Item_2);
		
		JButton Plus_2 = new JButton("+");
		Plus_2.setBounds(101, 58, 50, 21);
		panel_2.add(Plus_2);
		Plus_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item_TwoCounter++;
				if(Item_TwoCounter>100) {
					System.out.println("You cannot order this much");
					Item_TwoCounter = 99;	
				}
				System.out.println("Item Two: "+Item_TwoCounter);		
				}
		});
		
		JButton Minus_2 = new JButton("-");
		Minus_2.setBounds(10, 58, 50, 21);
		panel_2.add(Minus_2);
		
		JLabel Show_StockCount_2 = new JLabel("null");
		Show_StockCount_2.setBounds(70, 62, 24, 13);
		panel_2.add(Show_StockCount_2);
		Minus_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item_TwoCounter--;
				if(Item_TwoCounter<0) {
					System.out.println("Error, order cannot go Bellow 0");
					Item_TwoCounter=0;
					
				}
				System.out.println("ItemTwo: "+Item_TwoCounter);
			}
		});
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0), 8));
		panel_3.setBounds(627, 95, 165, 100);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JLabel Item_3 = new JLabel("Pancakes (3 Pieces)");
		Double Pancakes = 4.5;
		Item_3.setBounds(20, 24, 121, 13);
		panel_3.add(Item_3);
		
		JButton Plus_3 = new JButton("+");
		Plus_3.setBounds(105, 58, 50, 21);
		panel_3.add(Plus_3);
		Plus_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item_ThreeCounter++;
				if(Item_ThreeCounter>100) {
					System.out.println("You cannot order this much");
					Item_ThreeCounter = 99;	
				}
				System.out.println("Item Three: "+Item_ThreeCounter);		
				}
		});
		
		JButton Minus_3 = new JButton("-");
		Minus_3.setBounds(10, 58, 50, 21);
		panel_3.add(Minus_3);
		
		JLabel Show_StockCount_3 = new JLabel("null");
		Show_StockCount_3.setBounds(70, 62, 24, 13);
		panel_3.add(Show_StockCount_3);
		Minus_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item_ThreeCounter--;
				if(Item_ThreeCounter<0) {
					System.out.println("Error, order cannot go Bellow 0");
					Item_ThreeCounter=0;
					
				}
				System.out.println("Item Three: "+Item_ThreeCounter);
			}
		});
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0), 8));
		panel_4.setBounds(58, 271, 165, 100);
		frame.getContentPane().add(panel_4);
		panel_4.setLayout(null);
		
		JLabel Item_4 = new JLabel("Rice and Curry");
		Double Rice_and_Curry = 8.00;
		Item_4.setBounds(32, 23, 96, 13);
		panel_4.add(Item_4);
		
		JButton Plus_4 = new JButton("+");
		Plus_4.setBounds(105, 57, 50, 21);
		panel_4.add(Plus_4);
		Plus_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item_FourCounter++;
				if(Item_FourCounter>100) {
					System.out.println("You cannot order this much");
					Item_FourCounter = 99;	
				}
				System.out.println("Item Four: "+Item_FourCounter);		
				}
		});
		
		JButton Minus_4 = new JButton("-");
		Minus_4.setBounds(10, 57, 50, 21);
		panel_4.add(Minus_4);
		
		JLabel Show_StockCount_4 = new JLabel("null");
		Show_StockCount_4.setBounds(70, 65, 24, 13);
		panel_4.add(Show_StockCount_4);
		Minus_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item_FourCounter--;
				if(Item_FourCounter<0) {
					System.out.println("Error, order cannot go Bellow 0");
					Item_FourCounter=0;
					
				}
				System.out.println("Item Four: "+Item_FourCounter);
			}
		});
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0), 8));
		panel_5.setBounds(336, 271, 165, 100);
		frame.getContentPane().add(panel_5);
		panel_5.setLayout(null);
		
		JLabel Item_5 = new JLabel("Fish and Chips");
		Double Fish_and_Chips = 11.50;
		Item_5.setBounds(34, 30, 96, 13);
		panel_5.add(Item_5);
		
		JButton Plus_5 = new JButton("+");
		Plus_5.setBounds(101, 57, 50, 21);
		panel_5.add(Plus_5);
		Plus_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item_FiveCounter++;
				if(Item_FiveCounter>100) {
					System.out.println("You cannot order this much");
					Item_FiveCounter = 99;	
				}
				System.out.println("Item Five: "+Item_FiveCounter);		
				}
		});
		
		JButton Minus_5 = new JButton("-");
		Minus_5.setBounds(10, 57, 50, 21);
		panel_5.add(Minus_5);
		
		JLabel Show_StockCount_5 = new JLabel("null");
		Show_StockCount_5.setBounds(67, 61, 24, 13);
		panel_5.add(Show_StockCount_5);
		Minus_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item_FiveCounter--;
				if(Item_FiveCounter<0) {
					System.out.println("Error, order cannot go Bellow 0");
					Item_FiveCounter=0;
					
				}
				System.out.println("Item Five: "+Item_FiveCounter);
			}
		});
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new LineBorder(new Color(0, 0, 0), 8));
		panel_6.setBounds(627, 271, 165, 100);
		frame.getContentPane().add(panel_6);
		panel_6.setLayout(null);
		
		JLabel Item_6 = new JLabel("Pasta");
		Double Pasta = 10.0;
		Item_6.setBounds(65, 27, 67, 13);
		panel_6.add(Item_6);
		
		JButton Plus_6 = new JButton("+");
		Plus_6.setBounds(105, 57, 50, 21);
		panel_6.add(Plus_6);
		Plus_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item_SixCounter++;
				if(Item_SixCounter>100) {
					System.out.println("You cannot order this much");
					Item_SixCounter = 99;	
				}
				System.out.println("Item Six: "+Item_SixCounter);		
				}
		});
		
		JButton Minus_6 = new JButton("-");
		Minus_6.setBounds(10, 57, 50, 21);
		panel_6.add(Minus_6);
		
		JLabel Show_StockCount_6 = new JLabel("null");
		Show_StockCount_6.setBounds(71, 61, 24, 13);
		panel_6.add(Show_StockCount_6);
		Minus_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item_SixCounter--;
				if(Item_SixCounter<0) {
					System.out.println("Error, order cannot go Bellow 0");
					Item_SixCounter=0;
					
				}
				System.out.println("Item Six: "+Item_SixCounter);
			}
		});
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new LineBorder(new Color(0, 0, 0), 8));
		panel_7.setBounds(58, 439, 165, 100);
		frame.getContentPane().add(panel_7);
		panel_7.setLayout(null);
		
		JLabel Item_7 = new JLabel("CheeeseCake (Two Slices)");
		Double CheeseCake = 4.50;
		Item_7.setBounds(10, 29, 155, 13);
		panel_7.add(Item_7);
		
		JButton Plus_7 = new JButton("+");
		Plus_7.setBounds(101, 95, 54, 21);
		panel_7.add(Plus_7);
		Plus_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item_SevenCounter++;
				if(Item_SevenCounter>100) {
					System.out.println("You cannot order this much");
					Item_SevenCounter = 99;	
				}
				System.out.println("Item Seven: "+Item_SevenCounter);		
				}
		});
		
		JButton Minus_7 = new JButton("-");
		Minus_7.setBounds(20, 95, 39, 21);
		panel_7.add(Minus_7);
		
		JLabel Show_StockCount_7 = new JLabel("null");
		Show_StockCount_7.setBounds(69, 66, 24, 13);
		panel_7.add(Show_StockCount_7);
		Minus_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item_SevenCounter--;
				if(Item_SevenCounter<0) {
					System.out.println("Error, order cannot go Bellow 0");
					Item_SevenCounter=0;
					
				}
				System.out.println("Item Seven: "+Item_SevenCounter);
			}
		});
		
		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new LineBorder(new Color(0, 0, 0), 8));
		panel_8.setBounds(336, 439, 165, 100);
		frame.getContentPane().add(panel_8);
		panel_8.setLayout(null);
		
		JLabel Item_8 = new JLabel("Choclate Cake (2 Slices)");
		Double Choclate_Cake = 5.50;
		Item_8.setBounds(10, 21, 145, 13);
		panel_8.add(Item_8);
		
		JButton Plus_8 = new JButton("+");
		Plus_8.setBounds(116, 97, 39, 21);
		panel_8.add(Plus_8);
		Plus_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item_EightCounter++;
				if(Item_EightCounter>100) {
					System.out.println("You cannot order this much");
					Item_EightCounter = 99;	
				}
				System.out.println("Item Eight: "+Item_EightCounter);		
				}
		});
		
		JButton Minus_8 = new JButton("-");
		Minus_8.setBounds(10, 97, 39, 21);
		panel_8.add(Minus_8);		
		
		JLabel Show_StockCount_8 = new JLabel("null");
		Show_StockCount_8.setBounds(67, 65, 24, 13);
		panel_8.add(Show_StockCount_8);
		Minus_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item_EightCounter--;
				if(Item_EightCounter<0) {
					System.out.println("Error, order cannot go Bellow 0");
					Item_EightCounter=0;
					
				}
				System.out.println("Item Eight: "+Item_EightCounter);
			}
		});
			
		JPanel panel_9 = new JPanel();
		panel_9.setBorder(new LineBorder(new Color(0, 0, 0), 8));
		panel_9.setBounds(627, 439, 165, 100);
		frame.getContentPane().add(panel_9);
		panel_9.setLayout(null);
		
		JLabel Item_9 = new JLabel("MilkShake (Vanila)");
		Double MilkShake = 6.70;
		Item_9.setBounds(10, 25, 120, 13);
		panel_9.add(Item_9);
		
		JButton Plus_9 = new JButton("+");
		Plus_9.setBounds(116, 93, 39, 21);
		panel_9.add(Plus_9);
		Plus_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item_NineCounter++;
				if(Item_NineCounter>100) {
					System.out.println("You cannot order this much");
					Item_NineCounter = 99;	
				}
				System.out.println("Item Nine: "+Item_NineCounter);
			}
		});
		
		JButton Minus_9 = new JButton("-");
		Minus_9.setBounds(10, 93, 39, 21);
		panel_9.add(Minus_9);
		
		JLabel Show_StockCount_9 = new JLabel("null");
		Show_StockCount_9.setBounds(70, 62, 24, 13);
		panel_9.add(Show_StockCount_9);
		Minus_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item_NineCounter--;
				if(Item_NineCounter<0) {
					System.out.println("Error, order cannot go Bellow 0");
					Item_NineCounter=0;
					
				}
				System.out.println("Item Nine: "+Item_NineCounter);
			}
		});
		
		JPanel panel_10 = new JPanel();
		panel_10.setBorder(new LineBorder(new Color(0, 0, 0), 8));
		panel_10.setBounds(58, 603, 165, 100);
		frame.getContentPane().add(panel_10);
		panel_10.setLayout(null);
		
		JLabel Item_10 = new JLabel("Orange Juice");
		Double Orange_Juice = 2.0;
		Item_10.setBounds(37, 27, 107, 13);
		panel_10.add(Item_10);
		
		JButton Plus_10 = new JButton("+");
		Plus_10.setBounds(116, 94, 39, 21);
		panel_10.add(Plus_10);
		Plus_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item_TenCounter++;
				if(Item_TenCounter>100) {
					System.out.println("You cannot order this much");
					Item_TenCounter = 99;	
				}
				System.out.println("Item Ten: "+Item_TenCounter);		
				}
		});
		
		JButton Minus_10 = new JButton("-");
		Minus_10.setBounds(10, 94, 39, 21);
		panel_10.add(Minus_10);
		
		JLabel Show_StockCount_10 = new JLabel("null");
		Show_StockCount_10.setBounds(69, 65, 24, 13);
		panel_10.add(Show_StockCount_10);
		Minus_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item_TenCounter--;
				if(Item_TenCounter<0) {
					System.out.println("Error, order cannot go Bellow 0");
					Item_TenCounter=0;
					
				}
				System.out.println("Item Ten: "+Item_TenCounter);
			}
		});
		
		JPanel panel_11 = new JPanel();
		panel_11.setBorder(new LineBorder(new Color(0, 0, 0), 8));
		panel_11.setBounds(336, 603, 165, 100);
		frame.getContentPane().add(panel_11);
		panel_11.setLayout(null);
		
		JLabel Item_11 = new JLabel("Apple Juice");
		Double Apple_Juice = 2.0;
		Item_11.setBounds(31, 20, 96, 13);
		panel_11.add(Item_11);
		
		JButton Plus_11 = new JButton("+");
		Plus_11.setBounds(116, 95, 39, 21);
		panel_11.add(Plus_11);
		Plus_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item_ElevenCounter++;
				if(Item_ElevenCounter>99) {
					System.out.println("You cannot order this much");
					Item_ElevenCounter = 99;	
				}
				System.out.println("Item Eleven: "+Item_ElevenCounter);		
				}
		});
		
		JButton Minus_11 = new JButton("-");
		Minus_11.setBounds(10, 95, 39, 21);
		panel_11.add(Minus_11);
		
		JLabel Show_StockCount_11 = new JLabel("null");
		Show_StockCount_11.setBounds(66, 65, 24, 13);
		panel_11.add(Show_StockCount_11);
		Minus_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item_ElevenCounter--;
				if(Item_ElevenCounter<0) {
					System.out.println("Error, order cannot go Bellow 0");
					Item_ElevenCounter=0;
					
				}
				System.out.println("Item Eleven: "+ Item_ElevenCounter);
			}
		});
		
		JPanel panel_12 = new JPanel();
		panel_12.setBorder(new LineBorder(new Color(0, 0, 0), 8));
		panel_12.setBounds(627, 603, 165, 100);
		frame.getContentPane().add(panel_12);
		panel_12.setLayout(null);
		
		JLabel Item_12 = new JLabel("Coffee");
		Double Coffee = 4.0;
		Item_12.setBounds(34, 25, 75, 13);
		panel_12.add(Item_12);
		
		JButton Plus_12 = new JButton("+");
		Plus_12.setBounds(116, 92, 39, 21);
		panel_12.add(Plus_12);
		Plus_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item_TwelveCounter++;
				if(Item_TwelveCounter>100) {
					System.out.println("You cannot order this much");
					Item_TwelveCounter = 99;	
				}
				System.out.println("Item Twelve: "+Item_TwelveCounter);		
				}
		});

		JButton Minus_12 = new JButton("-");
		Minus_12.setBounds(10, 92, 39, 21);
		panel_12.add(Minus_12);
		
		JLabel Show_StockCount_12 = new JLabel("null");
		Show_StockCount_12.setBounds(70, 64, 24, 13);
		panel_12.add(Show_StockCount_12);
		Minus_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item_TwelveCounter--;
				if(Item_TwelveCounter<0) {
					System.out.println("Error, order cannot go Bellow 0");
					Item_TwelveCounter=0;
					
				}
				System.out.println("Item Twelve: "+ Item_TwelveCounter);
			}
		});
		
		JButton Check_out = new JButton("Check Out");
		Check_out.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Total_MenuItems = Item_OneCounter+Item_TwoCounter + Item_ThreeCounter + Item_FourCounter +Item_FiveCounter
						+ Item_SixCounter + Item_SevenCounter + Item_EightCounter + Item_NineCounter + Item_TenCounter + Item_ElevenCounter
						+ Item_TwelveCounter;
				Total_Price = (int) ((Item_OneCounter*Toast)+(Item_TwoCounter*Sausages)+(Item_ThreeCounter*Pancakes)+(Item_FourCounter*Rice_and_Curry)+
						(Item_FiveCounter*Fish_and_Chips)+(Item_SixCounter*Pasta)+(Item_SevenCounter*CheeseCake)+(Item_EightCounter*Choclate_Cake)
						+(Item_NineCounter*MilkShake)+(Item_TenCounter*Orange_Juice)+(Item_ElevenCounter*Apple_Juice)+(Item_TwelveCounter*Coffee));
				System.out.println(Total_Price);
				
				Check_Out info = new Check_Out();
				Check_Out.main(null);
			}
		});
		Check_out.setBounds(688, 776, 111, 21);
		frame.getContentPane().add(Check_out);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setForeground(Color.CYAN);
		panel.setBounds(743, 0, 118, 66);
		frame.getContentPane().add(panel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(823, 66, 38, 751);
		frame.getContentPane().add(scrollPane);
	}

	public void setVisible(boolean b) {
		
	}
}
