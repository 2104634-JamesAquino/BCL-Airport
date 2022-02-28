package Flight;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class Filtered_Flights extends JFrame implements ActionListener {

	String file = "C:\\Users\\2109689\\OneDrive - Brunel University London\\Implementation\\Flights (2).csv";
	
	SimpleDateFormat current_day_format = new SimpleDateFormat("dd/MM/YYYY");
	String today = current_day_format.format(Calendar.getInstance().getTime());
	
	SimpleDateFormat today_time_format = new SimpleDateFormat("HH:mm");
	String today_time = today_time_format.format(Calendar.getInstance().getTime());
	
	JButton seating_plan;
	JButton purchase;
	
	Object[] d_row = new Object[8];
	JTable d_table;
	DefaultTableModel d_model;
	
	Object[] a_row = new Object[8];
	JTable a_table;
	DefaultTableModel a_model;
	
	JComboBox tickets_selection;
	
	int d_flight_duration;
	int a_flight_duration;
	
	String d_flight_num;
	String a_flight_num;
	
	Main m = new Main();
	
	JPanel dsp;
	JPanel rsp;
	
	JLabel[] dsp_btn = new JLabel[12];
	JLabel[] rsp_btn = new JLabel[12];
	
	ArrayList<String> d_seats;
	
	JButton showSeats;
	
	String from;
	String to;
	String depart_date;
	String return_date;
	
	Boolean seats_been_selected = false;
	Boolean second_instantation = false;
	
//	D_Selected_Seats dss;
//	R_Selected_Seats rss;
	
	ArrayList d_btn;
	ArrayList r_btn;
	
//	Passenger_Details pd;
	
	double d_distance;
	double a_distance;
	
	Boolean d_isAirbus;
	Boolean a_isAirbus;
	
	double d_flight_distance;
	double a_flight_distance;
	
	int d_delay;
	
//	FilteredFlights(String from, String to, String depart_date, String return_date, D_Selected_Seats dss, R_Selected_Seats rss, Passenger_Details pd, Boolean d_isAirbus, Boolean a_isAirbus, Double d_flight_distance, Double a_flight_distance, int d_delay){
//		
//		
//	}
	
	Filtered_Flights(String from, String to, String depart_date, String return_date, Boolean d_isAirbus, Boolean a_isAirbus, Double d_flight_distance, Double a_flight_distance, int d_delay){
	
		this.from = from;
		this.to = to;
		this.depart_date = depart_date;
		this.return_date = return_date;
		
//		this.dss = dss;
//		this.rss = rss;
		
//		this.pd = pd;
		
		this.d_isAirbus = d_isAirbus;
		this.a_isAirbus = a_isAirbus;
		
		this.d_flight_distance = d_flight_distance;
		this.a_flight_distance = a_flight_distance;
		
		this.d_delay = d_delay;
		
		setTitle("Filtered Flights");
		
		JLabel available_flights = new JLabel("Available Flights");
		available_flights.setBounds(85,35,270,30);
		available_flights.setFont(new Font("Verdana",Font.BOLD,21));
		available_flights.setForeground(new Color(0x2A9296));
		
		JLabel departures_flights = new JLabel("Available Flights");
		departures_flights.setBounds(85,35,270,30);
		departures_flights.setFont(new Font("Verdana",Font.BOLD,15));
		departures_flights.setForeground(new Color(0x2A9296));
		
		JLabel arrivals_label = new JLabel("Arrivals");
		arrivals_label.setBounds(85,350,100,30);
		arrivals_label.setFont(new Font("Verdana",Font.BOLD,15));
		arrivals_label.setForeground(new Color(0x2A9296));
		
		JLabel tickets_label = new JLabel("Select Number of Tickets:");
		tickets_label.setBounds(85,610,240,30);
		tickets_label.setFont(new Font("Verdana",Font.BOLD,15));
		
		String[] tickets = {"1","2","3","4","5","6","7","8","9","10","11","12"};
		tickets_selection = new JComboBox(tickets);
		tickets_selection.setBounds(355,610,40,30);
		
		seating_plan = new JButton("View seating Plan");
		seating_plan.setBounds(85,660,150,30);
		seating_plan.setBackground(new Color(0x2A9296));
		seating_plan.setForeground(Color.WHITE);
		seating_plan.setFocusable(false);
		
		purchase = new JButton("Purchase");
		purchase.setBounds(85,710,95,30);
		purchase.setBackground(new Color(0x2A9296));
		purchase.setForeground(Color.WHITE);
		purchase.setFocusable(false);
		
		JLabel departing_seats = new JLabel("Departing seats:");
		departing_seats.setForeground(new Color(0x2A9296));
		departing_seats.setBounds(450,610,150,30);
		departing_seats.setFont(new Font("Verdana", Font.BOLD,15));
		
		JLabel returning_seats = new JLabel("Returning seats:");
		returning_seats.setForeground(new Color(0x2A9296));
		returning_seats.setBounds(650,610,150,30);
		returning_seats.setFont(new Font("Verdana", Font.BOLD,15));
		
		dsp = new JPanel();
		dsp.setBounds(450,645,170,115);
		dsp.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		rsp = new JPanel();
		rsp.setBounds(650,645,170,115);
		rsp.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		for(int i=0; i<dsp_btn.length;i++) {
			dsp_btn[i]=new JLabel();
			dsp_btn[i].setText("");
			dsp_btn[i].setFont(new Font("Times New Roman", Font.PLAIN, 18));
			dsp_btn[i].setForeground(Color.red);
			dsp_btn[i].setPreferredSize(new Dimension(35,30));
			dsp.add(dsp_btn[i]);
		}
		
		for(int i=0; i<rsp_btn.length;i++) {
			rsp_btn[i]=new JLabel();
			rsp_btn[i].setText("");
			rsp_btn[i].setFont(new Font("Times New Roman", Font.PLAIN, 18));
			rsp_btn[i].setForeground(Color.red);
			rsp_btn[i].setPreferredSize(new Dimension(35,30));
			rsp.add(rsp_btn[i]);
			
		}
		Object[] d_cols= {"Departing From","Airport","Arriving To","Airport","Departure Time","Arrival Time","Flight Number","Economy Price"};
		d_table = new JTable();
		d_model = new DefaultTableModel();
		d_model.setColumnIdentifiers(d_cols);
		d_table.setModel(d_model);
		d_table.setBackground(Color.WHITE);
		d_table.setBounds(85,125,680,200);
		d_table.setRowHeight(30);
		
		JScrollPane d_scroll = new JScrollPane(d_table);
		d_scroll.setBounds(85,125,680,200);
		
		add_departure_values(from,to,depart_date);
		
		Object[] a_cols= {"Departing From","Airport","Arriving To","Airport","Departure Time","Arrival Time","Flight Number","Economy Price"};
		a_table = new JTable();
		a_model = new DefaultTableModel();
		a_model.setColumnIdentifiers(a_cols);
		a_table.setModel(a_model);
		a_table.setBackground(Color.WHITE);
		a_table.setBounds(85,125,680,200);
		a_table.setRowHeight(30);
		
		JScrollPane a_scroll = new JScrollPane(a_table);
		a_scroll.setBounds(85,395,680,200);
		
		add_arrival_values(from,to,return_date);
		
		seating_plan.addActionListener(this);
		purchase.addActionListener(this);
		
		add(available_flights);
		//add(departures_label);
		add(d_scroll);
		add(arrivals_label);
		add(a_scroll);
		add(tickets_label);
		add(tickets_selection);
		add(seating_plan);
		add(purchase);
		add(departing_seats);
		add(returning_seats);
		add(dsp);
		add(rsp);
		
		
		setLayout(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(850,800);
		setResizable(false);
		setVisible(true);
		
		}
	
	
	public int get_mins(String time) {
		String[] mins = time.split(":");
		int first = Integer.valueOf(mins[0]);
		int second = Integer.valueOf(mins[1]);
		
		int time_mins = (first*60) + second;
		
		return time_mins;
	}
		
	public int mins_difference(String a, String b) {
		String[] a_values = a.split(":");
		int a_first = Integer.valueOf(a_values[0]);
		int a_second = Integer.valueOf(a_values[1]);
		
		String[] b_values = b.split(":");
		int b_first = Integer.valueOf(b_values[0]);
		int b_second = Integer.valueOf(b_values[1]);
		
		int diff=0;
		
		if(a_first < b_first) {
			int mins_a = (a_first*60) + a_second;
			int mins_b = (b_first*60) + b_second;
			diff = mins_b - mins_a;
			}
		else {
			b_second += 24;
			int mins_a = (a_first*60) + a_second;
			int mins_b = (b_first*60) + b_second;
			diff = mins_b - mins_a;
		}
	return diff;	
	}
	


	public double get_hours(double num) {
	double x = num/60;
	double res = Math.floor(x);
	
	return res;
	
	}
	
		public void add_departure_values(String from, String to, String depart_date) {
			
			String line = "";
			int counter = 0;
			
			try {
				BufferedReader br = new BufferedReader(new FileReader(file));
				
				while((line = br.readLine()) != null) {
					String[] values = line.split(",");
					if((values[0].equals(depart_date)) && values[7].equals(from) && values[9].equals(to)) {
						d_row[0] = values[7];
						d_row[1] = values[6];
						d_row[2] = values[9];
						d_row[3] = values[8];
						d_row[4] = values[1];
						d_row[5] = values[2];
						d_row[6] = values[10];
						d_row[7] = Double.valueOf(values[4])*0.5;
						
						d_flight_duration = mins_difference(values[1],values[2]);
						
						d_flight_distance = Double.valueOf(values[4]);
						
						d_delay = Integer.valueOf(values[5]);
						
						d_flight_num = values[10];
						
						d_model.addRow(d_row);
					}
				}
			}catch (FileNotFoundException e) {
				e.printStackTrace();
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		public void add_arrival_values(String from, String to, String return_date) {
			
			String line = "";
			int counter = 0;
			
			try {
				BufferedReader br = new BufferedReader (new FileReader(file));
				
				while((line = br.readLine()) != null){
					String[] values = line.split(",");
					if((values[0].equals(return_date)) && values[7].equals(to) && values[9].equals(from)) {
						a_row[0] = values[7];
						a_row[1] = values[6];
						a_row[2] = values[9];
						a_row[3] = values[8];
						a_row[4] = values[1];
						a_row[5] = values[2];
						a_row[6] = values[10];
						a_row[7] = Double.valueOf(values[4])*0.5;
						
						a_flight_duration = mins_difference(values[1],values[2]);
						
						a_flight_distance = Double.valueOf(values[4]);
						
						a_flight_num = values[10];
						
						a_model.addRow(a_row);
						
					}
					
				}
			}catch (FileNotFoundException e) {
				e.printStackTrace();
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
		
			
		
		
					
				
			
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==seating_plan) {
			
			if(second_instantiation) {
				JOptionPane.showMessageDialog(this, "Restart the program to view this page.");
			}
			else {
				if(d_table.getSelectedRow()==-1 || a_table.getSelectedRow()==-1) {
					JOptionPane.showMessageDialog(this, "You must select both a departure and return flight.");
				}
				else {
					String ticket_num = (String) tickets_selection.getSelectedItem();
					
				if(d_flight_duration>120) {
					a_isAirbus = false;
					Departing_Boeing m = new Departing_Boeing(a_flight_duration, ticket_num, d_flight_num, a_flight_num, from, to, depart_date, return_date, dss, rss, pd, d_distance, a_distance, d_isAirbus, a_isAirbus, d_flight_distance, a_flight_distance, d_delay);
					
					m.setLocationRelativeTo(this);
					dispose();
				}
				else {
					d_isAirbus = true;
					Departing_Airbus m = new Departing_Airbus(a_flight_duration, ticket_num, d_flight_num, a_flight_num, from, to, depart_date, return_date, dss, rss, pd, d_distance, a_distance, d_isAirbus, a_isAirbus, d_flight_distance, a_flight_distance, d_delay);
					
					m.setLocationRelativeTo(this);
					dispose();
					
				}
				}
			}
		
	}

	
	
	if(e.getSource()==purchase) {
		
		if(seats_been_selected==false) {
			JOptionPane.showMessageDialog(this, "You must select your seats. Click the 'view seating plan' button to do this.");
		}
		else {
			Passenger p = new Passenger(pd, d_isAirbus, d_flight_distance, a_flight_distance, d_delay);
			p.startGUI((String)tickets_selection.getSelectedItem(),"1");
			p.addSelectedSeats(d_btn, r_btn);
			p.setLocationRelativeTo(null);
			
			dispose();
		}
		
		}
	}
	
	
	public void change_text(ArrayList<JButton> d_btn, ArrayList<JButton> r_btn) {
		for(int i=0;i<d_btn.size();i++) {
			dsp_btn[i].setText(d_btn.get(i).getText());
		}
		for(int i=0;i<r_btn.size();i++) {
			rsp_btn[i].setText(r_btn.get(i).getText());
		}
		
		this.d_btn = d_btn;
		this.r_btn = r_btn;
	}
	
	public void change_bool_val() {
		seats_been_selected = true;
		second_instantiation = true;
	}
	
	public void restore_ticket_value(String ticket_num) {
		tickets_selection.setSelectedItem(ticket_num);
	}
	
	public void select_tbl_rows() {
		d_table.selectAll();
		a_table.selectAll();
	}
	
	}
	
	
		}
	}

