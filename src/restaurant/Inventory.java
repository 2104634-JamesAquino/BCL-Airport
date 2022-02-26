package restaurant;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class Inventory {
	
	public static LinkedHashMap  HasData() {
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
		return (LinkedHashMap) Restrant_data;
		// This is a Hashmap, this used to store the data of the stock for the products
		
		
	}

	public static void main(String[] args) {
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
		// This is a Hashmap, this used to store the data of the stock for the products 
		

	}

}
