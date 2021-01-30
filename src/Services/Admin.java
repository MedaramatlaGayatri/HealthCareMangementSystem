package Services;

import java.util.ArrayList;
import java.util.Scanner;

import controller.User;

public class Admin{
	Scanner sc = new Scanner(System.in);
	User user = new User();
	private static ArrayList<Doctor> doctors = new ArrayList<Doctor>();
	private static ArrayList<Patient> patients = new ArrayList<Patient>();
	private static ArrayList<Laboratorist> labtechnicians = new ArrayList<Laboratorist>();
	private static ArrayList<Pharmacist> pharmacists = new ArrayList<Pharmacist>();
	
	
	public void defaultusers() {
		doctors.add(new Doctor("Mahesh","cardiologist"));
		patients.add(new Patient("Suresh"));
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
		System.out.print("Enter patient name: ");
		String name = sc.next();
		Patient patient = new Patient(name);
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
	
}
