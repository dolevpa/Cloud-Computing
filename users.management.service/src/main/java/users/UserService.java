package users;

import java.util.List;

public interface UserService {

	public User store(User newUser);

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
