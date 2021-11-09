package users.Logic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import users.Boundary.User;
import users.Exceptions.InvalidDateFormatRangeException;
import users.Exceptions.InvalidEmailAddress;
import users.Exceptions.InvalidNameException;
import users.Exceptions.InvalidPasswordException;
import users.Exceptions.InvalidRoleException;
import users.Exceptions.WrongFormatDateException;

@Component
public class ValidatorImplementation implements Validator {

	@Override
	public boolean isValidPassword(String Password) {
		boolean flag = false;
		if (Password.length() < 5)
			return flag;
		for (int i = 0; i < Password.length(); i++) {
			if (Character.isDigit(Password.charAt(i)))
				flag = true;
		}
		if (flag == false) {
			throw new InvalidPasswordException(
					"Password must be at least 5 characters long and must contain at least 1 digit");
		}
		return flag;
	}

	@Override
	public boolean isValidEmailAddress(String email) {
		Pattern pattern = Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}");
		Matcher mat = pattern.matcher(email);

		if (!mat.matches())
			throw new InvalidEmailAddress("Email is not valid");
		else
			return true;

	}

	@Override
	public boolean isValidName(String str) {
		for (int i = 0; i < str.length(); i++)
			if ((str.charAt(i) >= 'a' && str.charAt(i) <= 'z') || (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z'))
				return true;
		throw new InvalidNameException("First/Last name must have only letters , and at least 1 character long");
	}

	@Override
	public boolean isValidBirthDateFormat(String inputStringDate) {

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		dateFormat.setLenient(false);
		try {
			dateFormat.parse(inputStringDate.trim());
		} catch (ParseException pe) {
			throw new WrongFormatDateException("Date must be in format dd-MM-yyyy");
		}
		return true;
	}

	@Override
	public boolean isValidUser(User user) {

		if (!isValidName(user.getName().getFirst()))
			return false;
		if (!isValidName(user.getName().getLast()))
			return false;

		if (!isValidEmailAddress(user.getEmail()))
			return false;

		if (!isValidPassword(user.getPassword()))
			return false;

		if (!isValidBirthDateFormat(user.getBirthdate()))
			return false;
		
		String[] splittedBD = user.getBirthdate().split("-");
        LocalDate formattedBD = LocalDate.parse(splittedBD[2] + '-' + splittedBD[1] + '-' + splittedBD[0]);
        this.isValidBirthDateRange(formattedBD);

		for (int i = 0; i < user.getRoles().length; i++) {
			if (!isValidRole(user.getRoles()[i]))
				return false;
		}

		return true;
	}

	@Override
	public boolean isValidRole(String role) {
		if (role.isEmpty())
			throw new InvalidRoleException("Role must be at least 1 character");
		return true;
	}

	@Override
	public boolean isValidBirthDateRange(LocalDate date) {
		
		LocalDate start = LocalDate.of( 1900 , 1 , 1 ) ;
		LocalDate stop = LocalDate.now();
		boolean flag = true;
		if(!(date.isBefore(start) ||date.isAfter(stop)))
			return flag;
		throw new InvalidDateFormatRangeException("Date must be in format DD--MM--YYYY,and from 1900 until today");
	}

}
