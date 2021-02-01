package Services;


import java.text.ParseException;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Doctor extends Users{
	
	private static int Id = 1500;
	private String username;
	private String password;
	private String doctorname;
	private String specialization;
	private static Map<Integer,Prescription> prescripts = new HashMap<Integer,Prescription>();
	Scanner sc = new Scanner(System.in);
	AppointmentBooking appointment;
	public Doctor(String doctorname, String specialization) {
		super();
		this.doctorname = doctorname;
		this.specialization = specialization;
		Id++;
		username = "Doctor"+Id;
		password = "Doctor@123";
		System.out.println("Please set your username and password. Default username and password is "+username+" "+password);
		appointment = new AppointmentBooking(Id);
	}
	public Doctor(String username1) {
		System.out.println("Logged in as Dr."+doctorname);
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


	public static Map<Integer, Prescription> getPrescripts() {
		return prescripts;
	}


	public static void setPrescripts(Map<Integer, Prescription> prescripts) {
		Doctor.prescripts = prescripts;
	}


	public Doctor() {
		// TODO Auto-generated constructor stub
	}
  
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getDoctorname() {
		return doctorname;
	}

	public void setDoctorname(String doctorname) {
		this.doctorname = doctorname;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	
	public Prescription getPrescription(int id) {
		return prescripts.get(id);
	}

	public void createPrescription() {
		System.out.println("Enter pateint id: ");
		int patientId = sc.nextInt();
		ArrayList<ArrayList<String>> medicines = new ArrayList<ArrayList<String>>();
		while(true) {
			String addmedicine = "";
			System.out.println("would you like to add medicine");
			addmedicine = sc.next();
			if(addmedicine.equals("no")) break;
			if(addmedicine.equals("yes")) {
			System.out.println("Medicine name & dosage:");
			String medicineName = sc.next();
			String dosage = sc.next();
			ArrayList<String> medicine1 = new ArrayList<String>();
			medicine1.add(medicineName);
			medicine1.add(dosage);
			medicines.add(medicine1);
			}
		}
		Prescription script = new Prescription(patientId,medicines);
		prescripts.put(patientId,script);
	}
	 
	public void scheduleAppointment() throws ParseException {
		appointment.appointmentScheduling();
	}
	
	@Override
	public void viewSlots() {
		System.out.println("Enter Doctor id");
		int id = sc.nextInt();
		HashMap<String,String> getslots = getSlots().get(id);
		for(Map.Entry<String, String> mapElement :  getslots.entrySet()) {
			String isbooked = "";
            if(!mapElement.getValue().equals("vacancy"))
            	isbooked = mapElement.getValue(); 
            else {
            	isbooked = "vacancy";
            }
            System.out.println(mapElement.getKey() + " : " + isbooked); 
		}
	}
}
