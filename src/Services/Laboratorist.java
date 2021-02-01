package Services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Laboratorist extends Users{
	
     private String name;
     private int id = 1600;
     private String username;
     private String Password = "Laboratorist@123";
     Scanner sc = new Scanner(System.in);
     Map<Integer,ArrayList<String>> diagonosticReports = new HashMap<Integer,ArrayList<String>>();
    
     public Laboratorist(String string) {
 		id++;
 		name = string;
 		username ="Laboratorist"+id;
 		System.out.println("Please set your username and password. Default username and password is "+username+" "+Password); 
 	
 	}

     public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
		}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}
	
	
	public Laboratorist() {
		// TODO Auto-generated constructor stub
		id++;
		username = String.valueOf(id);
	}

	public int getId() {
		// TODO Auto-generated method stub
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void editProfile() {
		// TODO Auto-generated method stub
		System.out.println("Change 1.username \t 2.password");
		int choice= sc.nextInt();
		switch(choice) {
		case 1:this.setUsername(sc.next());
				break;
		case 2:this.setPassword(sc.next());
				break;
		}
	}
	
	public void viewPrescription() {
		Doctor doctor = new Doctor();
		try {
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

	public void uploadDiagonistsReport() {
		System.out.println("Enter patientId: ");
		int id = sc.nextInt();
		System.out.println("Enter image address");
		ArrayList<String> reports = new ArrayList<String>(diagonosticReports.getOrDefault(id, null));
		reports.add(sc.nextLine());
		diagonosticReports.put(id,reports);
	}

}
