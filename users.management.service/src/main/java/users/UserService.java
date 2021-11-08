package users;

import java.util.List;

public interface UserService {

//get a new user details, save in db and create a new user object
	public User store(NewDetailsUser newUser);

	public User getUserByEmail(String email);

	public User loginUserWithPassword(String email, String password);

	public void updateUser(String email, NewDetailsUser details);

	public void deleteAllUsers();

	public List<User> getSortedUsers(int size, int page, String sortAtrribute, String sortOrder);

	public List<User> getSortedUsersSameDomain(String value, int size, int page, String sortAtrribute,
			String sortOrder);

	public List<User> getSortedUsersSameBirthYear(String value, int size, int page, String sortAtrribute,
			String sortOrder);

}
