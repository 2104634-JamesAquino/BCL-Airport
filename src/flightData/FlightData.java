package flightData;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FlightData {

	ArrayList<FlightRecord> FlightData;

	public FlightData(String fileLocation) {
		this.FlightData = readCSVFile(fileLocation);
	}

	public ArrayList<FlightRecord> readCSVFile(String fileLocation) {
		ArrayList<FlightRecord> records = new ArrayList<FlightRecord>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileLocation));
			String line;
			while ((line = br.readLine()) != null) {
				String[] values = line.split(",");
				FlightRecord flightRecord = new FlightRecord(values);
				records.add(flightRecord);
			}
			br.close();
		} catch (IOException e) {
			System.out.println("IOException Occured: " + e);
		}
		return records;
	}
	
	public int size() {
		return this.FlightData.size();
	}
}
