package flightArrivals;

import java.awt.Font;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Arrivals_Modal extends JFrame{

	String file = "Flights.csv";

	SimpleDateFormat current_day_format = new SimpleDateFormat("dd/MM/YYYY");
	String today = current_day_format.format(Calendar.getInstance().getTime());
	
	SimpleDateFormat today_time_format = new SimpleDateFormat("HH:mm");
	String today_time = today_time_format.format(Calendar.getInstance().getTime());
	
	JPanel panel = new JPanel();
	
	String[][] arrival_values;
	
	
	Arrivals_Modal(String airport_name){
		
		setTitle(airport_name + " Arrivals");
		setSize(400,670);
		setLayout(null);
		setResizable(false);
		
		int arrivals_count = get_arrivals_count(airport_name);
		arrival_values = new String[arrivals_count][4];
		
		
		JLabel departure_time_label = new JLabel("Time");
		JLabel departur_city_label = new JLabel("City");
		JLabel departure_airport_label = new JLabel("Airport");
		JLabel flight_number_label = new JLabel("Flight");
		
		panel.add(departure_time_label);
		panel.add(departur_city_label); 
		panel.add(departure_airport_label);
		panel.add(flight_number_label);
		
		//System.out.println(departures_count);
		
		panel.setBounds(0,0,400,670);
		panel.setLayout(new GridLayout(arrivals_count+1,4));
		
		if(arrivals_count!=0 ) {
			insert_arrival_values(airport_name);
			arrivals_bubble_sort();
			display_arrival_values(arrivals_count);
			

		}
		
		add(panel);
		
	}
	
	
	
	//----------------------------------------- CONVERT TIME FROM HOURS TO MINUTES---------------------------------------------------------------	
		public int get_mins(String time) {

			String[] mins = time.split(":"); 
			int first = Integer.valueOf(mins[0]);
			int second = Integer.valueOf(mins[1]);
			
			int time_mins = (first*60) + second;
			
			return time_mins;
		}
	//-------------------------------------------------------------------------------------------------------------------------------------------	

		
	//----------------------------------------- COUNTS NUMBER OF VALID RECORDS FOR ARRIVALS 2D ARRAY----------------------------------------------
		public int get_arrivals_count(String airport_name) {
			String line = "";
			int arrival_counter = 0;
			
			try {
				BufferedReader br = new BufferedReader(new FileReader(file));
				
				while((line = br.readLine()) != null) {
					String[] values = line.split(",");
						if(today.equals(values[0])  && get_mins(today_time) < get_mins(values[1]) && values[8].equals(airport_name)) {
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
	//------------------------------------------------------------------------------------------------------------------------------------------	
		
		
	//----------------------------------------- INSERTS THE VALID RECORDS INTO THE ARRIVALS 2D ARRAY-----------------------------------------------
		public void insert_arrival_values(String airport_name) {
			
			String line = "";
			int counter = 0;
			
			try {
				BufferedReader br = new BufferedReader(new FileReader(file));
				
				while((line = br.readLine()) != null) {
					String[] values = line.split(",");
						if(today.equals(values[0])  && get_mins(today_time) < get_mins(values[1]) && values[8].equals(airport_name)) {
							arrival_values[counter][0] = values[2];
							arrival_values[counter][1] = values[7];
							arrival_values[counter][2] = values[6];
							arrival_values[counter][3] = values[10];
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

		
	//----------------------------------------- SORTS THE ARRIVALS 2D ARRAY IN ASCENDING ORDER BASED ON TIME---------------------------------------
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
	//-------------------------------------------------------------------------------------------------------------------------------------------
		
		
	//----------------------------------------- PERFORMS BUBBLE SORT ON THE ARRIVALS 2D ARRAY------------------------------------------------------
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
	//--------------------------------------------------------------------------------------------------------------------------------------------
		
		
	//----------------------------------------- DISPLAYS VALUES FROM THE ARRIVALS 2D ARRAY TO THE GUI------------------------------------------------	
		public void display_arrival_values(int arrivals_count) {
			
			
			for(int i=0;i<arrivals_count-1;i++) {
				for(int j=0;j<4;j++) {
					switch (j) {
					case 0:
						JLabel arrival_time = new JLabel(arrival_values[i][0]);
						arrival_time.setFont(new Font("Verdana", Font.PLAIN, 11));
						//left_p1.add(departure_time);
						panel.add(arrival_time);
						break;
					case 1:
						JLabel departure_city = new JLabel(arrival_values[i][1]);
						departure_city.setFont(new Font("Verdana", Font.PLAIN, 11));
						//left_p2.add(arrival_city);
						panel.add(departure_city);
						break;
					case 2:
						JLabel departure_airport = new JLabel(arrival_values[i][2]);
						departure_airport.setFont(new Font("Verdana", Font.PLAIN, 11));
						//left_p3.add(flight_number);
						panel.add(departure_airport);
						break;
					case 3:
						JLabel flight_number = new JLabel(arrival_values[i][3]);
						flight_number.setFont(new Font("Verdana", Font.PLAIN, 11));
						//left_p4.add(airline);
						panel.add(flight_number);
						break;
					default:
						break;
						
					}
				}
			}
		}
	//--------------------------------------------------------------------------------------------------------------------------------------------
		
	
}
