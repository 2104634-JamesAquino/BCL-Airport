package flightArrivals;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Arrivals implements MouseListener {

	String file = "Flights.csv";

	SimpleDateFormat current_day_format = new SimpleDateFormat("dd/MM/YYYY");
	String today = current_day_format.format(Calendar.getInstance().getTime());
	
	SimpleDateFormat today_time_format = new SimpleDateFormat("HH:mm");
	String today_time = today_time_format.format(Calendar.getInstance().getTime());
	
	JLabel[] country_labels = new JLabel[26];
	
	String[] countries = {"AMS", "ATH", "BKK", "CAI", "DEL", "DXB", "DUB", "HKG", "JNB", "LOS", "LVS",
		"LIS", "BCL", "MAD", "RAK", "MEX", "SVO", "JFK", "CDG", "FCO", "GRU", "ARN", 
		"SYD", "DFW", "HND", "YYZ"};
	
	JScrollPane delays_scroll;
	
	Arrivals_Modal m= new Arrivals_Modal("");
	
	String[][] delay_values;
	
	JPanel delays = new JPanel();
	
	String[][] arrival_values;
	JPanel arrivals_panel = new JPanel();
	
	Arrivals() {
		JFrame frame = new JFrame("Arrivals");
		
		
		JLabel map = new JLabel(new ImageIcon("map.png"));
		map.setBounds(300,10,944,469);
		
		int length = country_labels.length;

		for(int i=0; i<length; i++) {
			country_labels[i] = new JLabel(countries[i]);
			country_labels[i].addMouseListener(this);
			country_labels[i].setFont(new Font("Arial",Font.BOLD,12));
			country_labels[i].setForeground(new Color(0x0B2696));
		}
		
		country_labels[0].setBounds(428,80,30,30);   // AMS
		country_labels[1].setBounds(480,135,30,30);  // ATH
		country_labels[2].setBounds(728,210,30,30);	 // BKK
		country_labels[3].setBounds(500,170,30,30);	 // CAI
		country_labels[4].setBounds(650,170,30,30);  // DEL
		country_labels[5].setBounds(570,180,30,30);  // DXB
		country_labels[6].setBounds(380,90,30,30);   // DUB
		country_labels[7].setBounds(755,170,30,30);	 // HKG
		country_labels[8].setBounds(490,355,30,30);	 // JNB
		country_labels[9].setBounds(435,230,30,30);	 // LOS
		country_labels[10].setBounds(77,135,30,30);  // LVS
		country_labels[11].setBounds(385,125,30,30);  // LIS
		country_labels[12].setBounds(405,85,30,30);  // BCL
		country_labels[13].setBounds(410,130,30,30);  // MAD
		country_labels[14].setBounds(385,155,30,30);  // RAK
		country_labels[15].setBounds(100,190,30,30);  // MEX
		country_labels[16].setBounds(528,80,30,30);  // SVO
		country_labels[17].setBounds(187,125,30,30);  // JFK
		country_labels[18].setBounds(420,100,30,30);  // CDG
		country_labels[19].setBounds(455,125,30,30);  // FCO
		country_labels[20].setBounds(263,335,30,30);  // GRU
		country_labels[21].setBounds(455,50,30,30);  // ARN
		country_labels[22].setBounds(860,355,30,30);  // SYD
		country_labels[23].setBounds(117,150,30,30);  // DFW
		country_labels[24].setBounds(815,140,30,30);  // HND
		country_labels[25].setBounds(180,100,30,30);  // YYZ
		
		for(int i=0; i<length; i++) {
			map.add(country_labels[i]);
		}

		int delay_count = get_delays_count();
		delay_values = new String[delay_count][6];
		
		insert_delay_values();
		delays_bubble_sort();
		display_delay_values(delay_count);
		
		
		delays.setBackground(Color.WHITE);
		delays.setLayout(new GridLayout(delay_count,6));
		

		delays_scroll = new JScrollPane(delays);
		delays_scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		delays_scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		delays_scroll.setBounds(10,10,260,469);
		
		
		int arrivals_count = get_arrivals_count();
		arrival_values = new String [arrivals_count][4];
		
		//arrivals_panel = new JPanel();
		//arrivals_panel.setBounds(500,460,415,210);
		arrivals_panel.setBackground(Color.WHITE);
		//arrivals_panel.setBorder(border);
		arrivals_panel.setLayout(new GridLayout(arrivals_count,4,0,0));
		
		JLabel arrival_time_label = new JLabel("Time");
		JLabel arrival_to_label = new JLabel("From");
		JLabel arrival_flight_label = new JLabel("Flight");
		JLabel arrival_airline_label = new JLabel("Airline");
		
		arrival_time_label.setFont(new Font("Times New Roman", Font.BOLD, 14));
		arrival_to_label.setFont(new Font("Times New Roman", Font.BOLD, 14));
		arrival_flight_label.setFont(new Font("Times New Roman", Font.BOLD, 14));
		arrival_airline_label.setFont(new Font("Times New Roman", Font.BOLD, 14));

		
		arrivals_panel.add(arrival_time_label);
		arrivals_panel.add(arrival_to_label);
		arrivals_panel.add(arrival_flight_label);
		arrivals_panel.add(arrival_airline_label);
		
		insert_arrival_values();
		arrivals_bubble_sort();
		display_arrival_values(arrivals_count);

		JScrollPane arrivals_panel_scroll = new JScrollPane(arrivals_panel);
		arrivals_panel_scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		arrivals_panel_scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		arrivals_panel_scroll.setBounds(10,500,1234,210);
		
		frame.add(arrivals_panel_scroll);
		

		frame.add(map);
		

		frame.add(delays_scroll);
		
		frame.add(arrivals_panel_scroll);
		
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(1300,800);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setLayout(null);
		frame.setVisible(true);
	}
	
	

	@Override
	public void mouseClicked(MouseEvent e) {}


	@Override
	public void mousePressed(MouseEvent e) {}


	@Override
	public void mouseReleased(MouseEvent e) {}

	
//--------------------------------------------- WHEN THE USER HOVERS OVER AN AIRPORT NAME, THE ARRIVAL MODAL BECOMES VISIBLE----------------		
	@Override
	public void mouseEntered(MouseEvent e) {
		//System.out.println("Country abbrev = " + ((JLabel) e.getSource()).getText());
		m = new Arrivals_Modal(((JLabel) e.getSource()).getText());

		m.setLocationRelativeTo(delays_scroll);
		m.setVisible(true);
	}
//-------------------------------------------------------------------------------------------------------------------------------------------	
	

//--------------------------------------------- WHEN THE USER MOVES THE POINTER AWAY FROM THE AIRPORT NAME, THE ARRIVAL MODAL BECOMES INVISIBLE	
	@Override
	public void mouseExited(MouseEvent e) {
		m.setVisible(false);
	}
//-------------------------------------------------------------------------------------------------------------------------------------------	

	
//----------------------------------------- CONVERT TIME FROM HOURS TO MINUTES---------------------------------------------------------------
	public int get_mins(String time) {

		String[] mins = time.split(":"); 
		int first = Integer.valueOf(mins[0]);
		int second = Integer.valueOf(mins[1]);
		
		int time_mins = (first*60) + second;
		
		return time_mins;
	}
//-------------------------------------------------------------------------------------------------------------------------------------------	

	
//----------------------------------------- COUNTS NUMBER OF VALID RECORDS FOR DELAYS 2D ARRAY----------------------------------------------
	public int get_delays_count() {
		String line = "";
		int departure_counter = 0;
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			
			while((line = br.readLine()) != null) {
				String[] values = line.split(",");
					if(today.equals(values[0])  && get_mins(today_time) < get_mins(values[1]) && Integer.valueOf(values[5])>0) {
						departure_counter++;			
					}
			}
		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return departure_counter;	
	}
//------------------------------------------------------------------------------------------------------------------------------------------	
	
	
//----------------------------------------- INSERTS THE VALID RECORDS INTO THE DELAYS 2D ARRAY-----------------------------------------------
	public void insert_delay_values() {
		
		String line = "";
		int counter = 0;
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			
			while((line = br.readLine()) != null) {
				String[] values = line.split(",");
					if(today.equals(values[0])  && get_mins(today_time) < get_mins(values[1]) && Integer.valueOf(values[5])>0) {
						delay_values[counter][0] = values[1];
						delay_values[counter][1] = values[6];
						delay_values[counter][2] = values[8];
						delay_values[counter][3] = values[2];
						delay_values[counter][4] = values[5];
						delay_values[counter][5] =  new_arrival_time(values[2],values[5]);
						counter++;
					}
			}
		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
//-------------------------------------------------------------------------------------------------------------------------------------------
	
	
//----------------------------------------- SORTS THE DELAYS 2D ARRAY IN ASCENDING ORDER BASED ON TIME---------------------------------------
	public void delays_sort_by_time(int rowa, int rowb) {
		
		String temp1 = delay_values[rowa][0];
		String temp2 = delay_values[rowa][1];
		String temp3 = delay_values[rowa][2];
		String temp4 = delay_values[rowa][3];
		String temp5 = delay_values[rowa][4];
		String temp6 = delay_values[rowa][5];
		
		
		delay_values[rowa][0] = delay_values[rowb][0];
		delay_values[rowa][1] = delay_values[rowb][1];
		delay_values[rowa][2] = delay_values[rowb][2];
		delay_values[rowa][3] = delay_values[rowb][3];
		delay_values[rowa][4] = delay_values[rowb][4];
		delay_values[rowa][5] = delay_values[rowb][5];

		delay_values[rowb][0] = temp1;
		delay_values[rowb][1] = temp2;
		delay_values[rowb][2] = temp3;
		delay_values[rowb][3] = temp4;
		delay_values[rowb][4] = temp5;
		delay_values[rowb][5] = temp6;
}
//-------------------------------------------------------------------------------------------------------------------------------------------

	
//----------------------------------------- PERFORMS BUBBLE SORT ON THE DELAYS 2D ARRAY------------------------------------------------------	
	public void delays_bubble_sort() {
		
		for(int i = delay_values.length-1;i>0;i--) {
			
			for(int j =0;j<i;j++) {
				int counter = 0;
				
				
					if(get_mins(delay_values[j][0]) > get_mins(delay_values[j+1][0])) {
							delays_sort_by_time(j, j+1);
					}
				
			}
			
		}
		
	}
//--------------------------------------------------------------------------------------------------------------------------------------------
	
	
//----------------------------------------- DISPLAYS VALUES FROM THE DELAYS 2D ARRAY TO THE GUI------------------------------------------------		
	public void display_delay_values(int delays_count) {
		
		
		for(int i=0;i<delays_count-1;i++) {
			for(int j=0;j<6;j++) {
				switch (j) {
				case 0:
					JLabel departure_time = new JLabel(delay_values[i][0]);
					departure_time.setFont(new Font("Verdana", Font.PLAIN, 11));
					//left_p1.add(departure_time);
					delays.add(departure_time);
					break;
				case 1:
					JLabel departure_airport = new JLabel(delay_values[i][1]);
					departure_airport.setFont(new Font("Verdana", Font.PLAIN, 11));
					//left_p2.add(arrival_city);
					delays.add(departure_airport);
					break;
				case 2:
					JLabel arrival_airport = new JLabel(delay_values[i][2]);
					arrival_airport.setFont(new Font("Verdana", Font.PLAIN, 11));
					//left_p3.add(flight_number);
					delays.add(arrival_airport);
					break;
				case 3:
					JLabel orgiginal_arrival_time = new JLabel(delay_values[i][3]);
					orgiginal_arrival_time.setFont(new Font("Verdana", Font.PLAIN, 11));
					//left_p4.add(airline);
					delays.add(orgiginal_arrival_time);
					break;
				case 4:
					JLabel delay_time = new JLabel(delay_values[i][4]);
					delay_time.setFont(new Font("Verdana", Font.PLAIN, 11));
					//left_p4.add(airline);
					delays.add(delay_time);
					break;
				case 5:
					JLabel new_arrival_time = new JLabel(delay_values[i][5]);
					new_arrival_time.setFont(new Font("Verdana", Font.PLAIN, 11));
					//left_p4.add(airline);
					delays.add(new_arrival_time);
					break;	
				default:
					break;
					
				}
			}
		}
	}
//--------------------------------------------------------------------------------------------------------------------------------------------		
	
//----------------------------------------- ADDS THE ORIGINAL ARRIVAL TIME(HOURS) AND THE DELAY DURATION(MINUTES) TO GET THE NEW ARRIVAL TIME IN HOURS	
	public String new_arrival_time(String original_arrive_time, String delay) {
		int original_time = get_mins(original_arrive_time);
		int new_time_int = original_time + Integer.valueOf(delay);
		String new_time=null;
	
		int hours = new_time_int / 60;
		int mins = new_time_int % 60;
		
		String hours_str = String.valueOf(hours);
		String mins_str = String.valueOf(mins);
		
		if(hours>9 && hours<24) {
			new_time = String.format("%d:%02d", hours,mins);
		}
		if(hours<=9) {
			new_time = String.format("0%d:%02d", hours,mins);
		}
		if(hours>=24) {
			int x = hours - 24;
			if(x<10) {
				new_time = String.format("0%d:%02d", x,mins);
			}
			else {
				new_time = String.format("%d:%02d", x,mins);
			}
		}
		
		return new_time;
	}
//---------------------------------------------------------------------------------------------------------------------------------------------
	

//---------------------------------------- COUNTS THE NUMBER OF RECORDS THAT SATISFY THE CONSTRAINTS FOR THE BCL ARRIVAL FLIGHTS LIST------------------	
	public int get_arrivals_count() {
			String line = "";
			int arrival_counter = 0;
			
			try {
				BufferedReader br = new BufferedReader(new FileReader(file));
				
				while((line = br.readLine()) != null) {
					String[] values = line.split(",");
						if(today.equals(values[0])  && get_mins(today_time) < get_mins(values[2]) && values[8].equals("BCL")) {
							arrival_counter++;			
						}
				}
			}catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return arrival_counter;	
		}
//-------------------------------------------------------------------------------------------------------------------------------------------------------
		
//---------------------------------------- INSERTS VALID VALUES INTO ARRIVAL 2D ARRAY-----------------------------------------------------------------	
	public void insert_arrival_values() {
			
			String line = "";
			int counter = 0;
			
			try {
				BufferedReader br = new BufferedReader(new FileReader(file));
				
				while((line = br.readLine()) != null) {
					String[] values = line.split(",");
						if(today.equals(values[0])  && get_mins(today_time) < get_mins(values[2]) && values[8].equals("BCL")) {
							arrival_values[counter][0] = values[2];
							arrival_values[counter][1] = values[7];
							arrival_values[counter][2] = values[10];
							arrival_values[counter][3] = values[11];
							counter++;
						}
				}
			}catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
//------------------------------------------------------------------------------------------------------------------------------------------------------	
		
//----------------------------------------  SORTS THE ARRVIALS 2D ARRAY IN ASCENDING ORDER USING BUBBLE SORT----------------------------------------	
	public void arrivals_sort_by_time(int rowa, int rowb) {
						
					String temp1 = arrival_values[rowa][0];
					String temp2 = arrival_values[rowa][1];
					String temp3 = arrival_values[rowa][2];
					String temp4 = arrival_values[rowa][3];
					
					arrival_values[rowa][0] = arrival_values[rowb][0];
					arrival_values[rowa][1] = arrival_values[rowb][1];
					arrival_values[rowa][2] = arrival_values[rowb][2];
					arrival_values[rowa][3] = arrival_values[rowb][3];

					arrival_values[rowb][0] = temp1;
					arrival_values[rowb][1] = temp2;
					arrival_values[rowb][2] = temp3;
					arrival_values[rowb][3] = temp4;
			}
//--------------------------------------------------------------------------------------------------------------------------------------------------------
			
	
//---------------------------------------- PERFORMS BUBBLE SORT ON THE BCL ARRIVALS LIST---------------------------------------------------------------	
	public void arrivals_bubble_sort() {
			
			for(int i = arrival_values.length-1;i>0;i--) {
				
				for(int j =0;j<i;j++) {
					int counter = 0;
					

					if(get_mins(arrival_values[j][0]) > get_mins(arrival_values[j+1][0])) {
						arrivals_sort_by_time(j, j+1);
					}

				}
				
			}
			
		}
//-------------------------------------------------------------------------------------------------------------------------------------------------------	
		
	
//---------------------------------------- DISPLAYS VALUES FROM THE ARRIVAL ARRAY TO THE CORRESPONDING JPANEL------------------------------------------
	public void display_arrival_values(int arrivals_count) {
			
			
			for(int i=0;i<arrivals_count-1;i++) {
				for(int j=0;j<4;j++) {
					switch (j) {
					case 0:
						JLabel arrival_time = new JLabel(arrival_values[i][0]);
						if(get_mins(arrival_values[i][0]) - get_mins(today_time) <= 30) {
							arrival_time.setForeground(Color.RED);
						}
						arrival_time.setFont(new Font("Verdana", Font.PLAIN, 11));
						arrivals_panel.add(arrival_time);
						break;
					case 1:
						JLabel departure_city = new JLabel(arrival_values[i][1]);
						if(get_mins(arrival_values[i][0]) - get_mins(today_time) <= 30) {
							departure_city.setForeground(Color.RED);
						}
						departure_city.setFont(new Font("Verdana", Font.PLAIN, 11));
						arrivals_panel.add(departure_city);
						break;
					case 2:
						JLabel flight_number = new JLabel(arrival_values[i][2]);
						if(get_mins(arrival_values[i][0]) - get_mins(today_time) <= 30) {
							flight_number.setForeground(Color.RED);
						}
						flight_number.setFont(new Font("Verdana", Font.PLAIN, 11));
						arrivals_panel.add(flight_number);
						break;
					case 3:
						JLabel airline = new JLabel(arrival_values[i][3]);
						if(get_mins(arrival_values[i][0]) - get_mins(today_time) <= 30) {
							airline.setForeground(Color.RED);
						}
						airline.setFont(new Font("Verdana", Font.PLAIN, 11));
						arrivals_panel.add(airline);
						break;
					default:
						break;
						
					}
				}
			}
		}
//-------------------------------------------------------------------------------------------------------------------------------------------------------	
		
	
}
