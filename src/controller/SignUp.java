package controller;

import java.util.Scanner;

import Services.Admin;

public class SignUp extends UserController{
	static Scanner sc = new Scanner(System.in);
	public void createAccount() {
		UserController newuser = new UserController();
		System.out.print("Enter username: ");
		newuser.setUsername(sc.next());
		System.out.print("Enter password");
		newuser.setPassword(sc.next());
		System.out.print("Enter confirm password");
		String confirmPassword = sc.next();
		Validation isValidUser = new Validation(); 
		if(!newuser.checkUserExist(newuser.getUsername())) {
			if(isValidUser.checkPassword(newuser.getPassword(),confirmPassword)) {
				newuser.addNewUser(newuser.getUsername(),newuser.getPassword());
				System.out.println("Registerd Successfully");
			}else {
				System.out.println("password not match");
				createAccount();
			}
		}else {
			System.out.println("Username already exists");
			createAccount();
		}
		}
	public static void main(String[] args) {
		Admin admin = new Admin();
		admin.defaultusers();
		dashboard(admin);
	}
	public static void dashboard(Admin admin) {
		while(true) {
			System.out.println("1.Create account\t2. Login");
			int choose = sc.nextInt();
			switch(choose) {
			case 1: SignUp newuser = new SignUp();
					newuser.createAccount();
					break;
			case 2:
					Login login = new Login();
					login.loggedInAs(admin);
					break;
			default: System.out.println("Please login");
						break;
			}
			}
	}
}
