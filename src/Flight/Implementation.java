package Flight;

import javax.swing.*;

import com.toedter.calendar.JDateChooser;

import finance.FinancePage;
import flightArrivals.*;
import restaurant.*;
import passengerData.passengerRecord;
import seatingPlan.D_Selected_Seats;
import seatingPlan.R_Selected_Seats;

import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
public class Implementation implements ActionListener{

	JFrame frame;
	
	String file = "C:\\Users\\2109689\\OneDrive - Brunel University London\\Implementation\\Flights (2).csv";
	
	SimpleDateFormat current_day_format = new SimpleDateFormat("dd/MM/YYYY");
	String today = current_day_format.format(Calendar.getInstance().getTime());
	
	SimpleDateFormat today_time_format = new SimpleDateFormat("HH:mm");
	String today_time = today_time_format.format(Calendar.getInstance().getTime());
	
	JComboBox from_countries;
	JComboBox to_countries;
	
	JDateChooser depart_date;
	JDateChooser return_date;
	
	JButton search;
	
	JButton restaurant;
	JButton finances;
	
	JButton arrivals;
	JButton departures;
	
	String [][] departure_values;
	String [][] arrival_values;
	
	JPanel left = new JPanel();
	JPanel right = new JPanel();
	
	D_Selected_Seats dss = new D_Selected_Seats();
	R_Selected_Seats rss = new R_Selected_Seats();
	
	passengerRecord pr;
	
	Boolean d_isAirbus =false;
	Boolean a_isAirbus =false;
	
	Double d_flight_distance =0.0;
	Double a_flight_distance =0.0;
	
	int d_delay = 0;
	
			
	public Implementation(){
		frame = new JFrame("BCL AIRPORT");
		
		JLabel logo = new JLabel();
		
		logo.setIcon(new ImageIcon("BCL_Logo.png"));
		logo.setBounds(80,50,300,148);
		
		restaurant = new JButton("Restaurant");
		finances = new JButton("Finances");
		
		restaurant.setBackground(new Color(0x0B2382));
		finances.setBackground(new Color(0xB2383));
		
		restaurant.setForeground(Color.WHITE);
		finances.setForeground(Color.WHITE);
		
		restaurant.setFocusable(false);
		finances.setFocusable(false);
		
		restaurant.setBounds(500,190,100,30);
		finances.setBounds(620,190,115,30);
		
		JLabel from_label = new JLabel("From");
		JLabel to_label = new JLabel("To");
		JLabel depart_label = new JLabel("Depart");
		JLabel return_label = new JLabel("Return");
		
		from_label.setForeground(new Color(0x0B2696));
		to_label.setForeground(new Color(0x0B2696));
		depart_label.setForeground(new Color (0x0B2696));
		return_label.setForeground(new Color(0x0B2696));
		
		from_label.setBounds(100,270,60,20);
		to_label.setBounds(470,270,60,20);
		depart_label.setBounds(100,325,60,20);
		return_label.setBounds(470,325,60,20);
		
		String fromCountries[] = {"Amsterdam", "Athens", "Bangkok", "Cairo", "Delhi", "Dubai", "Dublin", "Hong Kong", "Johannesburg", "Lagos", "Las Vegas", "Sydney", "Texas", "Tokyo", "Toronto"};
		from_countries = new JComboBox(fromCountries);
		from_countries.setBounds(190,270,200,20);
		
		String toCountries[] = {"Amsterdam", "Athens", "Bangkok", "Cairo", "Delhi", "Dubai", "Dublin", "Hong Kong", "Johannesburg", "Lagos", "Las Vegas", "Sydney", "Texas", "Tokyo", "Toronto"};
		to_countries = new JComboBox(toCountries);
		to_countries.setBounds(550,270,200,20);
		
		depart_date = new JDateChooser();
		depart_date.setBounds(190,325,200,25);
		
		return_date = new JDateChooser();
		return_date.setBounds(550,325,200,25);
		
		search = new JButton("Search");
		search.setBounds(380,365,100,30);
		search.setFocusable(false);
		search.setBackground(new Color (0x0B2383));
		search.setForeground(Color.WHITE);
		
		departures = new JButton("Departures");
		departures.setBounds(180,400,110,30);
		departures.setBackground(new Color (0x0B2383));
		departures.setForeground(Color.WHITE);
		departures.setFocusable(false);
		
		arrivals= new JButton("Arrivals");
		arrivals.setBounds(560,400,110,30);
		arrivals.setBackground(new Color (0x0B2383));
		arrivals.setForeground(Color.WHITE);
		arrivals.setFocusable(false);
		
		search.addActionListener(this);
		finances.addActionListener(this);
		restaurant.addActionListener(this);
		arrivals.addActionListener(this);
		
		frame.add(logo);
		frame.add(restaurant);
		frame.add(finances);
		frame.add(from_label);
		frame.add(to_label);
		frame.add(depart_label);
		frame.add(return_label);
		frame.add(from_countries);
		frame.add(to_countries);
		frame.add(depart_date);
		frame.add(return_date);
		frame.add(search);
		
		frame.add(departures);
		frame.add(arrivals);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(840,550);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setLayout(null);
		frame.setVisible(true);
		
		
		}
		
	public int date_difference(String d1, String d2) {
		String[] d1_values = d1.split("/");
		String[] d2_values = d2.split("/");
		
		LocalDate d_1 = LocalDate.of(Integer.valueOf(d1_values[2]),Integer.valueOf(d1_values[1]),Integer.valueOf(d1_values[0]));
		LocalDate d_2 = LocalDate.of(Integer.valueOf(d2_values[2]),Integer.valueOf(d2_values[1]),Integer.valueOf(d2_values[0]));
		
		int days_difference = Period.between(d_1,  d_2).getDays();
		
		return days_difference;
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
	
	if(e.getSource()==departures) {
	//	new Departures();
			
	}
	if(e.getSource()==arrivals) {
		new Arrivals();
	}
	
	if(e.getSource()==restaurant) {
		Login frameLogin = new Login();
		frameLogin.main(null);
	}
	
	if(e.getSource()==finances) {
		FinancePage frame = new FinancePage();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	if(e.getSource()==search) {
		if(depart_date.getDate()==null || return_date.getDate()==null) {
			JOptionPane.showMessageDialog(frame, "Departure and return date must not be empty");
		}
		else {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
			
			String d1 = sdf.format(depart_date.getDate());
			String d2 = sdf.format(return_date.getDate());
			
			String last_date = "29/04/2022";
			
			if(date_difference(d1,today)>0 && date_difference(d2,today)>0) {
				JOptionPane.showMessageDialog(frame, "Departure and return date must not have already passed.");
			}
			else if(date_difference(d1,today)>0) {
				JOptionPane.showMessageDialog(frame, "Departure date must not have already passed.");
			}
			else if(date_difference(d2,today)>0) {
				JOptionPane.showMessageDialog(frame, "Return date must not have already passed.");
			}
			else if(date_difference(d1,d2)<0) {
				JOptionPane.showMessageDialog(frame, "Departure date must be before return date.");
			}
			else if(date_difference(d1,d2)==0) {
				JOptionPane.showMessageDialog(frame, "Departure and return date must not be the same.");
			}
			else if(date_difference(d1,last_date)<0 || date_difference(d2,last_date)<0) {
				JOptionPane.showMessageDialog(frame, "Departure and return date must be before 29/04/2022.");
			}
			else {
				String from = (String) from_countries.getSelectedItem();
				String to = (String) to_countries.getSelectedItem();
				
				if(from.equals(to)) {
					JOptionPane.showMessageDialog(frame, "Departure and return city must not be the same.");
				}
				else {
					Filtered_Flights f = new Filtered_Flights(from,to,d1,d2,dss,rss,pr, d_isAirbus, a_isAirbus, 
							d_flight_distance, a_flight_distance, d_delay);
					f.setLocationRelativeTo(frame);
					
				}
				
			}
		}
	
	
	}
		
	}

	
}
