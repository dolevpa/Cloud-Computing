package users;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JpaUserService implements UserService {
	@Autowired
	private DTO userRepository;


	@Override
	public User store(NewDetailsUser newUser) {
		try {
			userRepository.save(newUser);
		}
		catch (Exception e){
			e.printStackTrace();
		}
		String[] roles = newUser.getRoles().split("[,]");
		String[] splittedBD = newUser.getBirthdate().split("-");
		LocalDate formattedBD = LocalDate.parse(splittedBD[2]+"-"+splittedBD[1]+"-"+splittedBD[0]);

		return new User(newUser.getEmail(), new Name(newUser.getFirstName(), newUser.getLastName()), newUser.getPassword(), formattedBD, roles);
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
