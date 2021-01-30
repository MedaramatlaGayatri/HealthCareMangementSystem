package controller;

public class Validation {

	public boolean checkPassword(String password, String confirmPassword) {
		if(password.length() > 0 && password.equals(confirmPassword)) return true;
		return false;
	}
      
}
