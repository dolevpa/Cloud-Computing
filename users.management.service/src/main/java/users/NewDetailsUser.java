package users;


import java.util.Arrays;

public class NewDetailsUser {
	private String firstName;
	private String lastName;
	private String password;
	private String birthdate;
	private String[] roles;
	
	public NewDetailsUser() {
	}
	

	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getBirthdate() {
		return birthdate;
	}



	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}



	public String[] getRoles() {
		return roles;
	}



	public void setRoles(String[] roles) {
		this.roles = roles;
	}



	@Override
	public String toString() {
		return "NewDetailsUser [firstName=" + firstName + ", lastName=" + lastName + ", password="
				+ password + ", birthdate=" + birthdate + ", roles=" + Arrays.toString(roles) + "]";
	}
	

}
