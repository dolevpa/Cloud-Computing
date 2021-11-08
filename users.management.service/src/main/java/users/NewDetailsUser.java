package users;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//  "email":"user@afeka.ac.il",
//		  "name":{"first":"Cynthia", "last":"Chambers"},
//		  "password":"ab4de",
//		  "birthdate":"19-11-1963",
//		  "roles":["admin","devs","inspector"]

@Entity
public class NewDetailsUser {
	@Id
	@GeneratedValue
	private Long id;
	private String email;
	private String firstName;
	private String lastName;
	private String password;
	private String birthdate;
	private String roles;

	public NewDetailsUser() {
	}
	public NewDetailsUser(String email, String firstName, String lastName, String password, String birthdate, String roles) {
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.birthdate = birthdate;
		this.roles = roles;
	}

	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
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



	public String getRoles() {
		return roles;
	}



	public void setRoles(String roles) {
		this.roles = roles;
	}



	@Override
	public String toString() {
		return "NewDetailsUser [email=" + email + ", firstName=" + firstName + ", lastName=" + lastName + ", password="
				+ password + ", birthdate=" + birthdate + ", roles=" + roles + "]";
	}


	public void setId(Long id) {
		this.id = id;
	}

	@Id
	public Long getId() {
		return id;
	}
}
