package users;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class JpaUserService implements UserService {

	@Override
	public User store(User newUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User loginUserWithPassword(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateUser(String email, NewDetailsUser details) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllUsers() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> getSortedUsers(int size, int page, String sortAtrribute, String sortOrder) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getSortedUsersSameDomain(String value, int size, int page, String sortAtrribute,
			String sortOrder) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getSortedUsersSameBirthYear(String value, int size, int page, String sortAtrribute,
			String sortOrder) {
		// TODO Auto-generated method stub
		return null;
	}

}
