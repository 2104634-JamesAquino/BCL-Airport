package restaurant;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Passenger_Open_CSV {

	public static void ReadFile(String path, String Ticket_Number, String First_Name, String Surname){
		
		BufferedReader buff = null;
		String line = "";
		String Delimiter =";";
		try {
			buff = new BufferedReader(new FileReader(path));
			while ((line = buff.readLine())!=null) {
				String [] file = line.split(Delimiter);
				System.out.println("USER");
				
				if (file[0].equals(Ticket_Number)&& file[1].equals(First_Name)&& file[2].equals(Surname)) {
					new Inventory_counter().setVisible(true);
				}
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
