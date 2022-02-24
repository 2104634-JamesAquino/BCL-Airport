package restaurant;

import java.util.HashMap;

public class testing_pls {
	
	static int Stock_Updater(int C, String D, HashMap E, int F) {
		C = (int) E.get(D);
		C = C - F;
		E.put(D,C);
		System.out.println(E.get(D));
		E.put(D,C);
		return C;
		
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
		Restrant_data.put("Coffee", 1030);
		
		int temp = 0;
		
		Stock_Updater(temp, "Toast", Restrant_data, temp);
		
//		int Temp;
//		Temp = Restrant_data.get("Toast");
//		System.out.println(Temp);
//		Temp = Temp - 10;
//		System.out.println(Temp);
//		Restrant_data.put("Toast",Temp);
//		System.out.println(Restrant_data.get("Toast"));
		
	
	}

}
