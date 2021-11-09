package users.Logic;

import java.time.LocalDate;

import users.Boundary.User;

public interface Validator {
	
	public boolean isValidPassword(String Password);//Checking if password is by rules
	
	public boolean isValidEmailAddress(String email);//Checking if email address is written by rules
	
	public boolean isValidName(String str);//Checking if string isn't empty ---> firstName/lastName
	
	public boolean isValidRole(String role);//Checking if string Role is written by rules
	
	public boolean isValidBirthDateFormat(String inputStringDate);//Checking if String date is written by rules - dd--mm--yyyy
	
	public boolean isValidBirthDateRange(LocalDate date);//Checking if date is in range between 1/1/1900 until today
	
	public boolean isValidUser(User user);
	
	
	
	
	
}
