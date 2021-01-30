package Services;

import java.util.ArrayList;
import java.util.Scanner;

public class Patient extends Users{
	private String patientname;
	private static int patientid = 100;
	private String username;
	private String password = "Patient@123";
	Scanner sc = new Scanner(System.in);
	public Patient(String name) {
		// TODO Auto-generated constructor stub
		this.patientid = patientid+1;
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

}
