package users;

import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import users.Exceptions.UserAlreadyExistException;
import users.Exceptions.UserNotFoundException;

@Service
public class JpaUserService implements UserService {

	private UserDao userDao;
	private Validator validator;
	
	
	public JpaUserService() {
	
	}
	
	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Autowired
	public void setValidator(Validator validator) {
		this.validator = validator;
	}


	@Override
	@Transactional(readOnly = false) // The default value
	public User store(User newUser) {
		this.validator.isValidUser(newUser);
			
		
		if(this.userDao.findById(newUser.getEmail()) != null)
			throw new UserAlreadyExistException("The user is already exist");
		
		UserEntity userEntity = this.toEntity(newUser);
		User rvUser = this.toBoundary(userEntity);
		
		this.userDao.save(userEntity);
			
		return rvUser;
	}

	@Override
	public User getUserByEmail(String email) {
		Optional<UserEntity> optionalUser = this.userDao.findById(email);
		if (optionalUser.isPresent()) {
			UserEntity entity = optionalUser.get();
			User boundary = this.toBoundary(entity);
			return boundary;
		} else {
			throw new UserNotFoundException("Could not find user by email");
		}
	}

	@Override
	public User loginUserWithPassword(String email, String password) {
		Optional<UserEntity> optionalUser = this.userDao.findById(email);
		if (optionalUser.isPresent()) {
			UserEntity entity = optionalUser.get();
			if(entity.getPassword().equals(password)) {
				User boundary = this.toBoundary(entity);
				return boundary;
			}else 
				throw new WrongUserPasswordException("This is not user's password, please try again");
		} else {
			throw new UserNotFoundException("Could not find user by email");
		}
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

	@Override
	public UserEntity toEntity(User user) {
		
		UserEntity rvUserEntity = new UserEntity();
		
		rvUserEntity.setFirstName(user.getName().getFirst());
		rvUserEntity.setLastName(user.getName().getLast());
		
		rvUserEntity.setEmail(user.getEmail());
		
		rvUserEntity.setRoles(user.getRoles());
		
		rvUserEntity.setPassword(user.getPassword());
		
		rvUserEntity.setBirthDate(Date.from(user.getBirthdate().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
		
		return rvUserEntity;
	}

	@Override
	public User toBoundary(UserEntity user) {
		User rvUser = new User();
		
		rvUser.setName(new Name(user.getFirstName(),user.getLastName()));
		rvUser.setEmail(user.getEmail());
		rvUser.setPassword(user.getPassword());
		rvUser.setRoles(user.getRoles());
		
		Date theDate = user.getBirthDate();
		if (theDate instanceof java.sql.Date) {
			theDate = new Date(theDate.getTime());
		}
		
		rvUser.setBirthdate(theDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
		return rvUser;
	}

}
