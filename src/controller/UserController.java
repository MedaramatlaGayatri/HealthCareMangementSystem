package controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import Services.Admin;
import Services.Users;

public class UserController{
    private String username;
    private String password;
    private static Map<String,String> users = new HashMap<String,String>();
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
	public Map<String,String> getUsers(){
		return users;
	}
	public void addNewUser(String username, String password) {
		users.put(username,password);
	}
	public boolean checkUserExist(String username) {
		if(users.containsKey(username))
			return true;
		return false;
	}
	
	public void deleteUser(String username) {
		users.remove(username);
	}
	public boolean checkPassword(String username, String password) {
		if(users.get(username).equals(password)) {
			return true;
		}
		return false;
	}
}
