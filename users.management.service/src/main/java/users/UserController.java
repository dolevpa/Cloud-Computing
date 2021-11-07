package users;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	private UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	@RequestMapping(path = "/users", method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public User store(@RequestBody User newUser) {
		return this.userService.store(newUser);
	}

	@RequestMapping(path = "/users/{email}", method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public User userByEmail(@PathVariable("email") String email) {
		User rvUser = new User();
		Name name = new Name();
		name.setFirst("Stav");
		name.setLast("Finz");
		rvUser.setName(name);
		rvUser.setBirthdate(LocalDate.now());
		rvUser.setPassword("ab4de");
		String[] roles = { "admin", "devs", "inspector" };
		rvUser.setRoles(roles);
		rvUser.setEmail(email);
		return rvUser;
	}
	
	@RequestMapping(path = "/users/login/{email}", method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public User loginUser(
			@PathVariable("email") String email,
			@RequestParam(name="password", required = false) String password) {
		User rvUser = new User();
		Name name = new Name();
		name.setFirst("Stav");
		name.setLast("Finz");
		rvUser.setName(name);
		rvUser.setBirthdate(LocalDate.now());
		if(password ==null)
			rvUser.setPassword("ab4de");
		else
			rvUser.setPassword(password);
		String[] roles = { "admin", "devs", "inspector" };
		rvUser.setRoles(roles);
		rvUser.setEmail(email);
		return rvUser;
	}
	
	@RequestMapping(path = "/users/{email}", method = RequestMethod.PUT,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public void updateUser(
			@PathVariable("email") String email,
			@RequestBody User newUser) {

	}
	
	@RequestMapping(
			path = "/users",
			method = RequestMethod.DELETE)
	public void deleteAllUsersInSpace() {
	
	}
	
	@RequestMapping(
			path = "/users/search",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public User[] getSortedUsers(
			@RequestParam(name="size", required = false, defaultValue = "20") int size,
			@RequestParam(name="page", required = false, defaultValue = "0") int page,
			@RequestParam(name="sortBy", required = false, defaultValue = "email") String sortAttribute,
			@RequestParam(name="sortOrder", required = false, defaultValue = "ASC") String order){
		User [] rvUsers = new User[0];
		return rvUsers;
	}
	
	@RequestMapping(
			//?criteriaType=byEmailDomain&criteriaValue={value}&size={size}&page={page}&sortBy={sortAttribute}&sortOrder={order}
			path = "/users/search/byEmailDomain",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public User[] getDomainSortedUsers(
//			@RequestParam(name="criteriaType", required = false, defaultValue = "byEmailDomain") String criteriaType,
			@RequestParam(name="criteriaValue", required = false, defaultValue = "gmail.com") String value,
			@RequestParam(name="size", required = false, defaultValue = "20") int size,
			@RequestParam(name="page", required = false, defaultValue = "0") int page,
			@RequestParam(name="sortBy", required = false, defaultValue = "email") String sortAttribute,
			@RequestParam(name="sortOrder", required = false, defaultValue = "ASC") String order){
		return new User[0];
	}
	
	
	@RequestMapping(
			//?criteriaType=byBirthYear&criteriaValue={value}&size={size}&page={page}&sortBy={sortAttribute}&sortOrder={order}
			path = "/users/search/byBirthYear",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public User[] getYearSortedUsers(
			@RequestParam(name="criteriaValue", required = false) String value,
			@RequestParam(name="size", required = false, defaultValue = "20") int size,
			@RequestParam(name="page", required = false, defaultValue = "0") int page,
			@RequestParam(name="sortBy", required = false, defaultValue = "email") String sortAttribute,
			@RequestParam(name="sortOrder", required = false, defaultValue = "ASC") String order){
		return new User[0];
	}
	
	
	
	
	
	

}
