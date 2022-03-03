package seatingPlan;

import javax.swing.*;

import Flight.Filtered_Flights;
import passengerData.passengerRecord;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.ArrayList;

public class Returning_Airbus extends JFrame implements ActionListener {

	String[] btn_text = {"1A","2A","3A","4A","5A","1B","2B","3B","4B","5B","6A","6B","6C","7A","7B","7C","8A","8B","8C","9A","9B","9C",
			"10A","10B","10C","11A","11B","11C","12A","12B","12C","13A","13B", "13C","14A","14B","14C","6D","6E","6F",
				"7D","7E","7F","8D","8E","8F","9D","9E","9F","10D","10E","10F","11D","11E","11F","12D","12E","12F",
					"13D","13E","13F","14D","14E","14F"};

	JButton[] btns = new JButton[64];

	JButton done;
	
	String ticket_num;
	
	int counter = 0;
	ArrayList<JButton> btn = new ArrayList();
	ArrayList<JButton> d_btn = new ArrayList();
	
	public ArrayList<JButton> ra_seat_selected = new ArrayList();
	
	
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
	
	Returning_Airbus(int a_flight_duration, String ticket_num, String a_flight_num, String from, String to, String depart_date, 
						String return_date, ArrayList<JButton> d_btn, String d_flight_num, D_Selected_Seats dss, R_Selected_Seats rss, 
							passengerRecord pr, Boolean d_isAirbus, Boolean a_isAirbus, Double d_flight_distance, Double a_flight_distance,
								int d_delay){
		this.from = from;
		this.to = to;
		this.depart_date = depart_date;
		this.return_date = return_date;
		this.d_btn = d_btn;
		
		this.dss = dss;
		this.rss = rss;
		
		this.d_flight_num = d_flight_num;
		this.a_flight_num = a_flight_num;
		
		
		this.ticket_num=ticket_num;
		
		//this.pd = pd;
		
		this.pr = pr;
		
		this.d_isAirbus =d_isAirbus;
		this.a_isAirbus =a_isAirbus;
		
		this.d_flight_distance = d_flight_distance;
		this.a_flight_distance = a_flight_distance;
		
		this.d_delay = d_delay;
		
		setTitle("Returning- Airbus A318");
		
		JLabel airbus_label = new JLabel("Airbus A318");
		airbus_label.setForeground(new Color(0x2A9296));
		airbus_label.setBounds(45,20,160,30);
		airbus_label.setFont(new Font("Verdana", Font.BOLD,20));
		
		JLabel select_label = new JLabel("Select " + ticket_num + (Integer.valueOf(ticket_num) > 1 ? " Seats":" Seat"));
		select_label.setForeground(new Color(0x2A9296));
		select_label.setBounds(45,65,160,30);
		select_label.setFont(new Font("Verdana", Font.BOLD,14));
		
		JLabel business_label = new JLabel("Business Class");
		business_label.setForeground(new Color(0x2A9296));
		business_label.setBounds(45,110,160,30);
		business_label.setFont(new Font("Verdana", Font.BOLD,14));
		
		JPanel b1 = new JPanel();
		b1.setBounds(225,135,60,150);
		b1.setLayout(new GridLayout(5,1,0,10));
		
		JPanel b2 = new JPanel();
		b2.setBounds(485,135,60,150);
		b2.setLayout(new GridLayout(5,1,0,10));
		
		JLabel economy_label = new JLabel("Economy");
		economy_label.setForeground(new Color(0x2A9296));
		economy_label.setBounds(45,300,100,30);
		economy_label.setFont(new Font("Verdana", Font.BOLD,14));
		
		JPanel e1 = new JPanel();
		e1.setBounds(225,310,180,280);
		e1.setLayout(new GridLayout(9,3,5,10));
		
		JPanel e2 = new JPanel();
		e2.setBounds(420,310,180,280);
		e2.setLayout(new GridLayout(9,3,5,10));
		
		done = new JButton("Done");
		done.setBackground(new Color(0x2A9296));
		done.setForeground(Color.WHITE);
		done.setBounds(45,590,100,30);
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
				b1.add(btns[i]);
			}
			
			if(i>=5 && i<=9) {
				b2.add(btns[i]);
			}
			
			if(i>=10 && i<=36) {
				e1.add(btns[i]);
			}
			
			if(i>=37) {
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
		
		add(airbus_label);
		add(select_label);
		add(business_label);
		add(b1);
		add(b2);
		add(economy_label);
		add(e1);
		add(e2);
		add(done);
		
		setLayout(null);
		setSize(650,675);
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
					ra_seat_selected.remove(btns[i]);
					btns[i].setBackground(new Color(0x2A9296));
					counter--;
				}
				else {
					btns[i].setBackground(Color.red);
					btn.add(btns[i]);
					counter++;
					ra_seat_selected.add(btns[i]);
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
