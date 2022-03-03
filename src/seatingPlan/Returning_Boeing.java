package seatingPlan;

import javax.swing.*;

import Flight.Filtered_Flights;
import passengerData.passengerRecord;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.ArrayList;

public class Returning_Boeing extends JFrame implements ActionListener {

	String[] btn_text = {"1A","2A","3A","4A","5A","1B","2B","3B","4B","5B","6A","7A","8A","9A","10A","6B","7B","8B","9B","10B","6C","7C",
			"8C","9C","10C","6D","7D","8D","9D","10D","11A","11B","11C","12A","12B","12C","13A","13B","13C","14A","14B","14C",
				"15A","15B","15C","16A","16B","16C","17A","17B","17C","18A","18B","18C","19A","19B","19C", "11D","11E","11F",
				"12D","12E","12F","13D","13E","13F","14D","14E","14F","15D","15E","15F","16D","16E","16F","17D","17E","17F",
				"18D","18E","18F","19D","19E","19F"};

	JButton[] btns = new JButton[84];

	JButton done;	
	
	String ticket_num;
	
	int counter = 0;
	ArrayList<JButton> btn = new ArrayList();
	ArrayList<JButton> d_btn = new ArrayList();
	
	//public ArrayList<ArrayList<JButton>> rb_seats_selected = new ArrayList();
	public ArrayList<JButton> rb_seat_selected = new ArrayList();
	
	
	String from;
	String to;
	String depart_date;
	String return_date;
	
	String d_flight_num;
	String a_flight_num;
	
	D_Selected_Seats dss;
	R_Selected_Seats rss;
	
	//Passenger_Details pd;
	
	passengerRecord pr;
	
	Boolean d_isAirbus;
	Boolean a_isAirbus;
	
	Double d_flight_distance;
	Double a_flight_distance;
	
	int d_delay;
	
	Returning_Boeing(int a_flight_duration, String ticket_num, String a_flight_num, String from, String to, 
						String depart_date, String return_date,ArrayList<JButton> d_btn, String d_flight_num, 
							D_Selected_Seats dss, R_Selected_Seats rss, 	passengerRecord pr, Boolean d_isAirbus, Boolean a_isAirbus,
							Double d_flight_distance, Double a_flight_distance, int d_delay){
		this.from = from;
		this.to = to;
		this.depart_date = depart_date;
		this.return_date = return_date;
		this.d_btn = d_btn;
		
		this.dss = dss;
		this.rss = rss;
		
		this.d_flight_num = d_flight_num;
		this.a_flight_num = a_flight_num;
		
		//JFrame frame = new JFrame("Returning Boeing 747");
		
		this.ticket_num=ticket_num;
		
		//this.pd = pd;
		
		this.pr = pr;
		
		this.d_isAirbus =d_isAirbus;
		this.a_isAirbus =a_isAirbus;
		
		this.d_flight_distance = d_flight_distance;
		this.a_flight_distance = a_flight_distance;
		
		this.d_delay = d_delay;
		
		setTitle("Returning- Boeing 747");	
				
		
		JPanel panel = new JPanel();
		panel.setBounds(0,0,650,820);
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		
		JLabel boeing_label = new JLabel("Boeing 747");
		boeing_label.setForeground(new Color(0x2A9296));
		boeing_label.setBounds(45,10,160,30);
		boeing_label.setFont(new Font("Verdana", Font.BOLD,20));
		
		JLabel select_label = new JLabel("Select " + ticket_num + (Integer.valueOf(ticket_num) > 1 ? " Seats":" Seat"));
		select_label.setForeground(new Color(0x2A9296));
		select_label.setBounds(45,55,160,30);
		select_label.setFont(new Font("Verdana", Font.BOLD,14));
		
		JLabel first_label = new JLabel("First Class");
		first_label.setForeground(new Color(0x2A9296));
		first_label.setBounds(45,100,160,30);
		first_label.setFont(new Font("Verdana", Font.BOLD,14));
		
		JPanel f1 = new JPanel();
		f1.setBounds(225,125,60,150);
		f1.setLayout(new GridLayout(5,1,0,10));
		
		JPanel f2 = new JPanel();
		f2.setBounds(485,125,60,150);
		f2.setLayout(new GridLayout(5,1,0,10));
		
		JLabel business_label = new JLabel("Business Class");
		business_label.setForeground(new Color(0x2A9296));
		business_label.setBounds(45,290,190,30);
		business_label.setFont(new Font("Verdana", Font.BOLD,14));
		
		JPanel b1 = new JPanel();
		b1.setBounds(225,310,60,150);
		b1.setBackground(Color.white);
		b1.setLayout(new GridLayout(5,1,0,10));
		
		JPanel b2 = new JPanel();
		b2.setBounds(320,310,60,150);
		b2.setBackground(Color.white);
		b2.setLayout(new GridLayout(5,1,0,10));
		
		JPanel b3 = new JPanel();
		b3.setBounds(390,310,60,150);
		b3.setBackground(Color.white);
		b3.setLayout(new GridLayout(5,1,0,10));
		
		JPanel b4 = new JPanel();
		b4.setBounds(485,310,60,150);
		b4.setBackground(Color.white);
		b4.setLayout(new GridLayout(5,1,0,10));
		
		JLabel economy_label = new JLabel("Economy");
		economy_label.setForeground(new Color(0x2A9296));
		economy_label.setBounds(45,480,100,30);
		economy_label.setFont(new Font("Verdana", Font.BOLD,14));
		
		JPanel e1 = new JPanel();
		e1.setBounds(225,490,180,280);
		e1.setBackground(Color.white);
		e1.setLayout(new GridLayout(9,3,5,10));
		
		JPanel e2 = new JPanel();
		e2.setBounds(420,490,180,280);
		e2.setBackground(Color.white);
		e2.setLayout(new GridLayout(9,3,5,10));
		
		done = new JButton("Done");
		done.setBackground(new Color(0x2A9296));
		done.setForeground(Color.WHITE);
		done.setBounds(45,740,100,30);
		done.setFocusable(false);
		done.setFont(new Font("Verdana", Font.BOLD,14));
		done.addActionListener(this);
		
		for(int i =0;i<btns.length;i++) {
			btns[i]=new JButton();
			btns[i].setText(btn_text[i]);
			btns[i].setForeground(Color.WHITE);
			btns[i].setBackground(new Color(0x2A9296));
			btns[i].setFocusable(false);
			btns[i].addActionListener(this);
			btns[i].setBorderPainted(false);
		
			if(i>=0 && i<=4) {
				f1.add(btns[i]);
			}
			
			if(i>=5 && i<=9) {
				f2.add(btns[i]);
			}
			
			if(i>=10 && i<=14) {
				b1.add(btns[i]);
			}
			
			if(i>=15 && i<=19) {
				b2.add(btns[i]);
			}
			
			if(i>=20 && i<=24) {
				b3.add(btns[i]);
			}
			
			if(i>=25 && i<=29) {
				b4.add(btns[i]);
			}
			
			if(i>=30 && i<=56) {
				e1.add(btns[i]);
			}
			
			if(i>=57) {
				e2.add(btns[i]);
			}
			
		}
		
		ArrayList<String> flight_number = rss.returnFlightNum();
		ArrayList<ArrayList<JButton>> selected_seats = rss.returnSeats();
		
		for(int i=0; i<btns.length; i++) {
		
			for(int j =0; j<flight_number.size();j++) {
				
				if(flight_number.get(j).equals(a_flight_num)) {
					
					
					for(int k=0; k<selected_seats.get(j).size();k++) {
						if(selected_seats.get(j).get(k).getText().equals(btns[i].getText())) {
							btns[i].setEnabled(false);
							btns[i].setBackground(Color.gray);
						
						}
					}
					
					
				}
			}

			
		}
		
		panel.add(boeing_label);
		panel.add(select_label);
		panel.add(first_label);
		panel.add(f1);
		panel.add(f2);
		panel.add(business_label);
		panel.add(b1);
		panel.add(b2);
		panel.add(b3);
		panel.add(b4);
		panel.add(economy_label);
		panel.add(e1);
		panel.add(e2);
		panel.add(done);
		
		
		add(panel);

		
		
		setLayout(null);
		setSize(650,820);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	


	@Override
	public void actionPerformed(ActionEvent e) {


		for(int i=0;i<btns.length;i++) {
			if(e.getSource()==btns[i]) {
				if(btn.contains(btns[i])) {
					btn.remove(btns[i]);
					rb_seat_selected.remove(btns[i]);
					btns[i].setBackground(new Color(0x2A9296));
					counter--;
				}
				else {
					btns[i].setBackground(Color.red);
					btn.add(btns[i]);
					counter++;
					rb_seat_selected.add(btns[i]);
				}
			}
		}
		
		if(e.getSource()==done) {	
			
			if(counter!=Integer.valueOf(ticket_num)) {
				JOptionPane.showMessageDialog(this, "You must select " + ticket_num + (Integer.valueOf(ticket_num) > 1 ? " Seats.":" Seat."));
			}
			else {
				
				dss.addFlightNum(d_flight_num);
				dss.addSeats(d_btn);
				
				rss.addFlightNum(a_flight_num);
				rss.addSeats(btn);
				
				
				Filtered_Flights f = new Filtered_Flights(from,to,depart_date,return_date, dss, rss, pr, d_isAirbus, a_isAirbus,
															d_flight_distance, a_flight_distance, d_delay);
				f.setLocationRelativeTo(null);
				f.change_text(d_btn,btn);
				f.change_bool_val();
				f.restore_ticket_value(ticket_num);
				f.select_tbl_rows();
				
				dispose();
			}
		}
		
	}
	
	
}
