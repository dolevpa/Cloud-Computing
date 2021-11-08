package users;



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
;
		return this.userService.getUserByEmail(email);
	}
	
	@RequestMapping(path = "/users/login/{email}", method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public User loginUser(
			@PathVariable("email") String email,
			@RequestParam(name="password", required = false) String password) {
		return this.userService.loginUserWithPassword(email, password);
	}
	
	@RequestMapping(path = "/users/{email}", method = RequestMethod.PUT,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public void updateUser(
			@PathVariable("email") String email,
			@RequestBody NewDetailsUser details) {
		this.userService.updateUser(email, details);

	}
	
	@RequestMapping(
			path = "/users",
			method = RequestMethod.DELETE)
	public void deleteAllUsersInSpace() {
		this.userService.deleteAllUsers();
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
		
		return this.userService.getSortedUsers(size, page, sortAttribute, order).toArray(new User[0]);
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
		return this.userService.getSortedUsersSameDomain(value, size, page, sortAttribute, order).toArray(new User[0]);
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
		return this.userService.getSortedUsersSameBirthYear(value, size, page, sortAttribute, order).toArray(new User[0]);
	}
	
	
	
	
	
	

}
