package Services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Pharmacist extends Users{
	
	private String name;
	private String username;
	private String password = "Pharmacist@123";
	private static int id = 1700;
	private static Map<String,Float> medicines = new HashMap<String,Float>();
    Scanner sc = new Scanner(System.in);
	public Pharmacist(String string) {
		// TODO Auto-generated constructor stub
		id = id+1;
		name = string;
		username = "Pharmacist"+id;
		System.out.println("Please set your username and password. Default username and password is "+username+" "+password); 
	}
	
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

	public int getId() {
		// TODO Auto-generated method stub
		return id;
	}

	public void manageMedicines() {
		// TODO Auto-generated method stub
		System.out.println("1.add  medicine \t 2. give medicine \t 3. check medicine is available or not ");
		int choice = sc.nextInt();
		System.out.println("medicine name");
		String medicineName = sc.next();
		System.out.print("Quantity: ");
		float quantity = sc.nextFloat();
		switch(choice) {
		case 1: addMedicine(medicineName,quantity);
				break;
		case 2: giveMedicine(medicineName,quantity);
				break;
		case 3:checkAvailable(medicineName, quantity);
				break;
		}
	}

	public void medicinesList() {
		// TODO Auto-generated method stub
		for(Entry<String, Float> entry:medicines.entrySet()) {
			System.out.println(entry.getKey()+" "+entry.getValue());
		}
	}

	private void giveMedicine(String medicineName, float quantity) {
		if(checkAvailable(medicineName,quantity)) {
			medicines.put(medicineName,medicines.get(medicineName)-quantity);
		}
	}

	private boolean checkAvailable(String medicineName, float quantity) {
		if(medicines.containsKey(medicineName)) {
			if(medicines.get(medicineName) >= quantity) {
				return true;
			}else {
				System.out.println("Enough quantity is not available\n Available quantity:"+medicines.get(medicineName));
			}
		}else {
			System.out.println("Not available");
		}
		return false;
	}

	private void addMedicine(String medicineName, float quantity) {
		medicines.put(medicineName, medicines.getOrDefault(medicineName, (float) 0.0)+quantity);
	}

	public void viewPrescription() {
		try {
		Doctor doctor = new Doctor();
		System.out.println("Enter patient Id");
		Prescription prescription = doctor.getPrescription(sc.nextInt());
		ArrayList<ArrayList<String>> medicines = prescription.getMedicines();
		for(int i = 0;i < medicines.size();i++) {
			System.out.println(medicines.get(i).get(0)+" "+medicines.get(i).get(1));
		}
	}catch(Exception e) {
		System.out.println("No prescrption. Please consult doctor");
	   }
	}
}
