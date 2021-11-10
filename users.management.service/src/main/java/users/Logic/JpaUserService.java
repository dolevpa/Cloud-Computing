package users.Logic;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import users.Boundary.Name;
import users.Boundary.User;
import users.Data.UserDao;
import users.Data.UserEntity;
import users.Exceptions.InvalidCriteriaTypeExcepetion;
import users.Exceptions.UserAlreadyExistException;
import users.Exceptions.UserNotFoundException;
import users.Exceptions.WrongUserPasswordException;

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

		try {
			Optional<UserEntity> optionalUser = this.userDao.findById(newUser.getEmail());
			if (optionalUser.isPresent())
				throw new UserAlreadyExistException("User already exist");
		} catch (UserNotFoundException e) {
			// user does not exists in the database, nothing to do
		}

		UserEntity userEntity = this.toEntity(newUser);
		User rvUser = this.toBoundary(userEntity);
		System.out.println(userEntity.getEmail() + " " + userEntity.getPassword() + " " + userEntity.getBirthDate());
		this.userDao.save(userEntity);
		System.out.println(rvUser);
		return rvUser;
	}

	@Override
	@Transactional(readOnly = false) // The default value
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
	@Transactional(readOnly = false) // The default value
	public User loginUserWithPassword(String email, String password) {
		this.validator.isValidPassword(password);
		Optional<UserEntity> optionalUser = this.userDao.findById(email);
		if (optionalUser.isPresent()) {
			UserEntity entity = optionalUser.get();
			if (entity.getPassword().equals(password)) {
				User boundary = this.toBoundary(entity);
				return boundary;
			} else
				throw new WrongUserPasswordException("This is not user's password, please try again");
		} else {
			throw new UserNotFoundException("Could not find user by email");
		}
	}

	@Override
	@Transactional(readOnly = false)
	public void updateUser(String email, User userToUpdate) {

		Optional<UserEntity> optionalUser = this.userDao.findById(email);
		if (optionalUser.isPresent()) {
			UserEntity entity = optionalUser.get();

			if (userToUpdate.getName() != null) {
				if (userToUpdate.getName().getFirst() != null) {
					this.validator.isValidName(userToUpdate.getName().getFirst());
					entity.setFirstName(userToUpdate.getName().getFirst());
				}
				if (userToUpdate.getName().getLast() != null) {
					this.validator.isValidName(userToUpdate.getName().getLast());
					entity.setLastName(userToUpdate.getName().getLast());
				}
			}
			if (userToUpdate.getPassword() != null) {
				this.validator.isValidPassword(userToUpdate.getPassword());
				entity.setPassword(userToUpdate.getPassword());
			}
			if (userToUpdate.getBirthdate() != null) {
				this.validator.isValidBirthDateFormat(userToUpdate.getBirthdate());
				String[] splittedBD = userToUpdate.getBirthdate().split("-");
				LocalDate formattedBD = LocalDate.parse(splittedBD[2] + '-' + splittedBD[1] + '-' + splittedBD[0]);
				this.validator.isValidBirthDateRange(formattedBD);
				entity.setBirthDate(Date.from(formattedBD.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
			}
			if (userToUpdate.getRoles() != null) {
				for (int i = 0; i < userToUpdate.getRoles().length; i++)
					this.validator.isValidRole(userToUpdate.getRoles()[i]);
				StringBuffer sb = new StringBuffer();
				for (int i = 0; i < userToUpdate.getRoles().length; i++) {
					sb.append(userToUpdate.getRoles()[i]);
					if (i != userToUpdate.getRoles().length - 1)
						sb.append(",");
				}

				entity.setRoles(sb.toString());
			}

			entity = this.userDao.save(entity);

		} else {
			throw new UserNotFoundException("Could not find user by email");
		}

	}

	@Override
	public void deleteAllUsers() {
		this.userDao.deleteAll();

	}

	@Override
	public List<User> getSortedUsers(String criteriaType, String value, int size, int page, String sortAtrribute,
			String sortOrder) {

		this.validator.isValidSortBy(sortAtrribute);
		this.validator.isValidSortOrder(sortOrder);

		Direction direction = Direction.ASC;
		if (sortOrder.equals("DESC"))
			direction = Direction.DESC;

		List<User> rvList = this.userDao.findAll(PageRequest.of(page, size, direction, sortAtrribute)).getContent()
				.stream().map(this::toBoundary).collect(Collectors.toList());
		if (criteriaType == null || value == null) {
			return rvList;
		} else {
			ArrayList<User> rvBetterList = new ArrayList<>();
			if (criteriaType.equals("byEmailDomain")) {
				for (User user : rvList) {
					if (user.getEmail().contains(value))
						rvBetterList.add(user);
				}
				return rvBetterList;
			} else if (criteriaType.equals("byBirthYear")) {
				for (User user : rvList) {
					if (user.getBirthdate().contains(value))
						rvBetterList.add(user);
				}
				return rvBetterList;
			} else if (criteriaType.equals("byRole")) {
				for (User user : rvList) {
					for (int i = 0; i < user.getRoles().length; i++) {
						if (user.getRoles()[i].equals(value)) {
							rvBetterList.add(user);
							break;
						}
					}
				}
				return rvBetterList;

			} else {
				throw new InvalidCriteriaTypeExcepetion("CriteriaType must be byEmailDomain/byBirthYear/byRole");
			}
		}
	}

	@Override
	public UserEntity toEntity(User user) {

		UserEntity rvUserEntity = new UserEntity();

		rvUserEntity.setFirstName(user.getName().getFirst());
		rvUserEntity.setLastName(user.getName().getLast());

		rvUserEntity.setEmail(user.getEmail());
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < user.getRoles().length; i++) {
			sb.append(user.getRoles()[i]);
			if (i != user.getRoles().length - 1)
				sb.append(",");
		}
		rvUserEntity.setRoles(sb.toString());

		rvUserEntity.setPassword(user.getPassword());

		String[] splittedBD = user.getBirthdate().split("-");
		LocalDate formattedBD = LocalDate.parse(splittedBD[2] + '-' + splittedBD[1] + '-' + splittedBD[0]);
		rvUserEntity.setBirthDate(Date.from(formattedBD.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));

		return rvUserEntity;
	}

	@Override
	public User toBoundary(UserEntity user) {
		User rvUser = new User();

		rvUser.setName(new Name(user.getFirstName(), user.getLastName()));
		rvUser.setEmail(user.getEmail());
		rvUser.setPassword(user.getPassword());
		hidePasswordBoundary(rvUser);

		if (user.getRoles().isEmpty())
			rvUser.setRoles(new String[0]);
		else
			rvUser.setRoles(user.getRoles().split(","));

		Date theDate = user.getBirthDate();
		if (theDate instanceof java.sql.Date) {
			theDate = new Date(theDate.getTime());
		}
		String[] splittedBD = theDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().toString().split("-");

		String formattedBD = splittedBD[2] + '-' + splittedBD[1] + '-' + splittedBD[0];
		System.out.println(formattedBD.toString());
		rvUser.setBirthdate(formattedBD);

		return rvUser;
	}

	private void hidePasswordBoundary(User rvUser) {
		StringBuffer hiddenPassword = new StringBuffer("");
		for (int i = 0; i < rvUser.getPassword().length(); i++)
			hiddenPassword.append('*');
		rvUser.setPassword(hiddenPassword.toString());

	}

}
