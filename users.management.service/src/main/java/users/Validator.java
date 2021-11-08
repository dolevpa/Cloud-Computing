package users;

import java.time.LocalDate;

public interface Validator {
	
	public boolean isValidPassword(String Password);//Checking if password is by rules
	
	public boolean isValidEmailAddress(String email);//Checking if email address is written by rules
	
	public boolean isValidName(String str);//Checking if string isn't empty ---> firstName/lastName
	
	public boolean isValidRole(String role);
	
	public boolean isValidBirthDate(LocalDate date);//Checking if date is written by rules ---> if good, returns as LocalDate, not good will return null
	
	public boolean isValidUser(User user);
	
}
