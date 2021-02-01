package Services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class Patient extends Users{
	private String patientname;
	private String username;
	private String password = "Patient@123";
	int patientid;
	Scanner sc = new Scanner(System.in);
	public Patient(String name,int patientid) {
		this.patientid = patientid;
		this.patientname = name;
		username = "Patient"+patientid;
		System.out.println("Please set your username and password. Default username and password is "+username+" "+password); 
	}
	public String getUsername() {
		return username;
	}
	public String getPatientname() {
		return patientname;
	}
	public void setPatientname(String patientname) {
		this.patientname = patientname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getId() {
		return patientid;
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
     
	public void bookAnAppointment() throws ParseException {
		try {
		System.out.println("Enter Doctor id");
		int id = sc.nextInt();
		sc.nextLine();
		HashMap<String,String> getslots = getSlots().get(id);
		
		System.out.print("Enter Date in 2010-01-04 01:32:27 UTC format");
		String inputDate = sc.nextLine();
		Date from = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z").parse(inputDate);
		
	    System.out.print("Enter Date in 2010-01-04 01:32:27 UTC format");
		inputDate = sc.nextLine();
		Date to = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z").parse(inputDate);
		//HashMap<String,String> dateTime = new HashMap<String,String>();
		
		String slot = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(from);
		slot = slot +" "+ new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(to);
		
		if(getslots.get(slot).equals("vacancy")) {
		getslots.put(slot, String.valueOf(getId()));
		System.out.println("Successfully booked appoitment on "+slot); 
		}else {
			System.out.println("Please select other slot. This slot is already booked");
		}
		}catch(Exception e) {
			System.out.println("Invalid");
		}
	}

}
