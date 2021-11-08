package users;


import java.util.List;

public interface UserService {

	public User store(User newUser);

	public User getUserByEmail(String email);

	public User loginUserWithPassword(String email, String password);

	public void updateUser(String email, User userToUpdate);

	public void deleteAllUsers();

	public List<User> getSortedUsers(String criteriaType,String value,int size, int page, String sortAtrribute, String sortOrder);

	public UserEntity toEntity(User user);
	
	public User toBoundary(UserEntity user);

}
