package users;

import java.time.LocalDate;

public interface Validator {
	
	public boolean isValidPassword(String Password);//Checking if password is by rules
	
	public boolean isValidEmailAddress(String email);//Checking if email address is written by rules
	
	public boolean isValidString(String str);//Checking if string isn't empty ---> firstName/lastName/Role
	
	public LocalDate isValidBirthDate(String date);//Checking if date is written by rules ---> if good, returns as LocalDate, not good will return null
	
}
