package controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

import Services.Admin;
import Services.Doctor;
import Services.Laboratorist;
import Services.Patient;
import Services.Pharmacist;

public class Login {
	UserController user = new UserController();
	Scanner sc = new Scanner(System.in);
	public void loggedInuser(String username,String password, Admin admin) {
		user.setUsername(username);
		user.setPassword(password);
		while(!isSuccessful()) {
			System.out.println("Invalid User");
			loggedInuser(username, password,admin);
		}
	}
	
	public boolean isSuccessful() {
		if(user.checkUserExist(user.getUsername()) && user.checkPassword(user.getUsername(),user.getPassword())) {
			return true;
		}
		return false;
	}

	public void loggedInAs(Admin admin) {
		System.out.println("Login as 1.Patient \t 2. Doctor \t 3.Laboratorist \t 4.Pharmacist \t 5.Admin\t");
		int choice = sc.nextInt();
		System.out.println("Enter username and password");
		String username = sc.next();
		String password = sc.next();
		boolean flag = false;
		switch(choice) {
		case 1: ArrayList<Patient> patients = admin.getPatients();
				for(int i = 0;i < patients.size();i++) {
					if(patients.get(i).getUsername().equals(username) && patients.get(i).getPassword().equals(password)) {
						loggedInAsPatient(patients.get(i),admin);
						flag = true;
						break;
					}
				}
						
			break;
		case 2: ArrayList<Doctor> doctors = admin.getdoctors();
				for(int i = 0;i < doctors.size();i++) {
					if(doctors.get(i).getUsername().equals(username) && doctors.get(i).getPassword().equals(password)) {
						flag = true;
						loggedInAsDoctor(doctors.get(i),admin);
						break;
					}
				}
		         break;
		case 3:ArrayList<Laboratorist> laboratorists = admin.getLaboratorists();
		for(int i = 0;i < laboratorists.size();i++) {
			if(laboratorists.get(i).getUsername().equals(username) && laboratorists.get(i).getPassword().equals(password)) {
				flag = true;
				loggedInAsLaboratorist(laboratorists.get(i),admin);
				break;
			}
		}
         break;
		case 4:ArrayList<Pharmacist> pharmacist = admin.getPharmacists();
				for(int i = 0;i < pharmacist.size();i++) {
					if(pharmacist.get(i).getUsername().equals(username) && pharmacist.get(i).getPassword().equals(password)) {
						flag = true;
						loggedInAsPharmacist(pharmacist.get(i),admin);
						break;
					}
				}
				break;
		case 5:loggedInAsAdmin(admin);
		   break;
		default :System.out.println("Invalid");
		}
		if(!flag) {
			System.out.print("Invalid username or passwprd");
		}
	}
	

	private void loggedInAsLaboratorist(Laboratorist laboratorist,Admin admin) {
		while(true) {
			System.out.print("1.view prescription\t2. Edit profile\t3.View Doctor List\t4.View Patient List\t5. Logout");
			int choice = sc.nextInt();
			switch(choice) {
			case 1:laboratorist.viewPrescription();
					break;
			case 2:laboratorist.editProfile();
				    break;
			case 3:laboratorist.viewDoctorList();
					break;
			case 4:laboratorist.viewPatientList();
					break;
			case 5:logout(admin);
			break;
			}
		}
	}

	private void loggedInAsPharmacist(Pharmacist pharmacist,Admin admin) {
		// TODO Auto-generated method stub
		while(true) {
			System.out.print("1.Manage Medicine\t2. View Prescription\t3. Edit profile\t4.Availble medicines\t5.view doctor list\t6.view patient list\t7. Logout");
			int choice = sc.nextInt();
			switch(choice) {
			case 1:pharmacist.manageMedicines();
					break;
			case 2:pharmacist.viewPrescription();
					break;
			case 3:pharmacist.editProfile();
					break;
			case 4:pharmacist.medicinesList();
					break;
			case 5:pharmacist.viewDoctorList();
					break;
			case 6:pharmacist.viewPatientList();
					break;
			case 7:logout(admin);
					break;
			}
		}
	}
 
	
	private void loggedInAsAdmin(Admin admin) {
		while(true) {
			System.out.print("1. Add Doctor\t2. Add pateint\t3. Add laboratorist\t4. Pharmacist\t5. Delete Doctor\t6. Delete Patient\t7.Logout\n8.delte laboratorist\t9.delete pharmacist");
			int choose = sc.nextInt();
			int id = 0;
			switch(choose) {
			case 1: admin.addDoctor();
		       		break;
			case 2:admin.addPatient();
					break;
			case 3:admin.addLaboratorist();
			      	break;
			case 4:admin.addPharmacist();
					break;
			case 5:System.out.println("Enter id:");
					id = sc.nextInt();
					admin.deleteDoctor(id);
					break;
			case 6: System.out.println("Enter id: ");
					id = sc.nextInt();
					admin.deletePatient(id);
					break;
			case 7: logout(admin);
						break;
			case 8:System.out.println("Enter id:");
					id = sc.nextInt();
					admin.deleteLaboratorist(id);;
					break;
			case 9:System.out.println("Enter id:");
					id = sc.nextInt();
					admin.deletePharmacist(id);
					break;
      		default: break;
			}
		}
	}

	private void loggedInAsDoctor(Doctor doctor,Admin admin) {
		while(true) {
			System.out.print("1. create prescription \t2. manage profile\t3.logout\t4.view PatientList\t5.view DoctorList\t6.View Laboratorist\t7. view pharmacists\t8.Shedule Appointment\t9.viewSlots");
			int choose = sc.nextInt();
			switch(choose) {
			case 1: doctor.createPrescription();
				break;
			case 2: doctor.editProfile();;
				break;
			case 3:logout(admin);
					break;
			case 4:doctor.viewPatientList();
			       break;
			case 5:doctor.viewDoctorList();
					break;
			case 6:doctor.viewLaboratoristList();
					break;
			case 7:doctor.viewPharmacistList();
					break;
			case 8:try {
					doctor.scheduleAppointment();
				} catch (ParseException e) {
					e.printStackTrace();
				}
				break;
			case 9:doctor.viewSlots();
					break;
			default: break;
			}
			
		}
	}

	private void loggedInAsPatient(Patient patient,Admin admin) {
		while(true) {
			try {
			System.out.print("1.view prescription\t2.get patient id\t3.view doctor list\t4.view laboratorist\t5.view pharmacists\t6.Edit profile\t7.view slots\t8.book appointment\t9.logout");
			int choose = sc.nextInt();
			switch(choose) {
			case 1:patient.viewPrescription();
					break;
			case 2:System.out.println(patient.getId());
					break;
			case 3:patient.viewDoctorList();
			        break;
			case 4:patient.viewLaboratoristList();
					break;
			case 5:patient.viewPharmacistList();
					break;
			case 6:patient.editProfile();
					break;
			case 7:patient.viewSlots();
					break;
			case 8:
				try {
					patient.bookAnAppointment();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			     break;
			case 9:logout(admin);
			default:System.out.println("Invalid ");
			break;
			}
		}catch(Exception e) {
			loggedInAs(admin);
		}
		}
	}
	
	private void logout(Admin admin) {
		SignUp homepage = new SignUp();
		homepage.dashboard(admin);
	}
	
}
