package Services;

import java.util.ArrayList;
public abstract class Users extends Admin{
	public void viewDoctorList() {
		ArrayList<Doctor> listOfDoctors= super.getdoctors();
		System.out.println("Available Doctors"+listOfDoctors.size());
		for(int i = 0;i < listOfDoctors.size();i++) {
			System.out.println("Doctor name"+listOfDoctors.get(i).getDoctorname()+"\t Specialization:"+listOfDoctors.get(i).getSpecialization()+"\t id: "+listOfDoctors.get(i).getId());
		}
	}
	public void viewPatientList() {
		ArrayList<Patient> listOfPatients= super.getPatients();
		System.out.println("Available patients"+listOfPatients.size());
		for(int i = 0;i < listOfPatients.size();i++) {
			System.out.println("name"+listOfPatients.get(i).getPatientname()+"\t id: "+listOfPatients.get(i).getId());
		}
	}
	public void viewLaboratoristList() {
		ArrayList<Laboratorist> listOfLaboratorists= super.getLaboratorists();
		System.out.println("Available Laboratorists"+listOfLaboratorists.size());
		for(int i = 0;i < listOfLaboratorists.size();i++) {
			System.out.println("name:"+listOfLaboratorists.get(i).getName()+"\t id: "+listOfLaboratorists.get(i).getId());
		}
	}
	public void viewPharmacistList() {
		ArrayList<Pharmacist> listOfPharmacist= super.getPharmacists();
		System.out.println("Available Pharmacists"+listOfPharmacist.size());
		for(int i = 0;i < listOfPharmacist.size();i++) {
			System.out.println("name:"+listOfPharmacist.get(i).getName()+"\t id: "+listOfPharmacist.get(i).getId());
		}
	}
	public void editProfile() {
		System.out.println("Change 1.username \t 2.password");
		int choice= sc.nextInt();
		switch(choice) {
		case 1:setUsername(sc.next());
		       System.out.println("Username changed to"+getUsername());
				break;
		case 2:setPassword(sc.next());
		System.out.println("Password changed to"+getPassword());
				break;
		}
	}
	
	protected abstract String getPassword();
	protected abstract String getUsername();
	protected abstract  void setPassword(String next);
	protected abstract void setUsername(String next);
}
