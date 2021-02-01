package Services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import controller.UserController;

public class Admin{
	Scanner sc = new Scanner(System.in);
	UserController user = new UserController();
	private static ArrayList<Doctor> doctors = new ArrayList<Doctor>();
	private static ArrayList<Patient> patients = new ArrayList<Patient>();
	private static ArrayList<Laboratorist> labtechnicians = new ArrayList<Laboratorist>();
	private static ArrayList<Pharmacist> pharmacists = new ArrayList<Pharmacist>();
	private  HashMap<Integer,HashMap<String,String>> slots = new HashMap<Integer,HashMap<String,String>>();
	private int patientid = 100;
	public int getPatientid() {
		return patientid;
	}
	public void setPatientid(int patientid) {
		this.patientid = patientid;
	}
	public void defaultusers() {
		doctors.add(new Doctor("Mahesh","cardiologist"));
		patients.add(new Patient("Suresh",100));
		labtechnicians.add(new Laboratorist("John"));
		pharmacists.add(new Pharmacist("Ali"));
	}
	public void addDoctor() {
		System.out.print("Enter doctorname & specialization: ");
		String doctorname = sc.next();
		String specialization = sc.next();
		Doctor newdoctor = new Doctor(doctorname,specialization);	
		doctors.add(newdoctor);
	}
	public void addPatient() {
		patientid++;
		System.out.print("Enter patient name: ");
		String name = sc.next();
		Patient patient = new Patient(name,patientid);
		patients.add(patient);
	}
	
	public void addLaboratorist() {
		System.out.print("Enter Laboratorist name: ");
		String name = sc.next();
		Laboratorist labtechnician = new Laboratorist(name);
		labtechnicians.add(labtechnician);
	}
	
	public void addPharmacist() {
		System.out.print("Enter Pharmacist name: ");
		String name = sc.next();
		Pharmacist pharmacist = new Pharmacist(name);
		pharmacists.add(pharmacist);
	}
	
	public void deleteDoctor(int id) {
		int index = 0;
		for(int i = 0;i < doctors.size();i++) {
			if(doctors.get(i).getId() == id) {
				index = i;
				break;
			}
		}
		System.out.print(doctors.get(index).getDoctorname()+" is deleted");
		doctors.remove(index);
	}
	
	public void deletePatient(int id) {
		for(int i = 0;i < patients.size();i++) {
			if(patients.get(i).getId() == id) {
				System.out.println(patients.get(i).getId()+"is deleted");
				patients.remove(i);
				break;
			}
		}
		
	}
	
	public void deleteLaboratorist(int id) {
		for(int i = 0;i < labtechnicians.size();i++) {
			if(labtechnicians.get(i).getId() == id) {
				System.out.println(labtechnicians.get(i).getId()+"is deleted");
				labtechnicians.remove(i);
				break;
			}
		}
	}
	
	public void deletePharmacist(int id) {
		for(int i = 0;i < pharmacists.size();i++) {
			if(pharmacists.get(i).getId() == id) {
				System.out.println(pharmacists.get(i).getId()+"is deleted");
				pharmacists.remove(i);
				break;
			}
		}
	}
	
	
	public ArrayList<Doctor> getdoctors(){
		return doctors;
	}
	
	public ArrayList<Patient> getPatients(){
		return patients;
	}
	
	public ArrayList<Laboratorist> getLaboratorists(){
		return labtechnicians;
	}
	
	public ArrayList<Pharmacist> getPharmacists(){
		return pharmacists;
	}
	
	public HashMap<Integer, HashMap<String, String>> getSlots() {
		return slots;
	}
	public void setSlots(HashMap<Integer, HashMap<String,String>> slots) {
		this.slots = slots;
	}
	public HashMap<String,String> getSlotForAppoitment(){
		System.out.println("Enter Doctor id");
		int id = sc.nextInt();
		if(slots.containsKey(id))
		return slots.get(id);
		else
			slots.put(id, new HashMap<String,String>());
		return slots.get(id);
	}
	
	public void setSlotForAppoitment(int id,HashMap<String,String> slot){
		System.out.println("setSlotForAppoitment "+slot.size());
		 slots.put(id, slot);
	}
	
	public void viewSlots() {
		System.out.println("Enter Doctor id");
		int id = sc.nextInt();
		HashMap<String,String> getslots = slots.get(id);
		for(Map.Entry<String, String> mapElement :  getslots.entrySet()) {
			String isbooked = "";
            if(!mapElement.getValue().equals("vacancy"))
            	isbooked = "Booked"; 
            else {
            	isbooked = "vacancy";	
            }
            System.out.println(mapElement.getKey() + " : " + isbooked); 
		}
	}
	
}
