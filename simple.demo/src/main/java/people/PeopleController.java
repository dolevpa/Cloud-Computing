package people;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PeopleController {
	private PeopleService people;

	@Autowired	
	public PeopleController(PeopleService people) {
		super();
		this.people = people;
	}

	@RequestMapping(path="/people",
		method = RequestMethod.POST,
		consumes = MediaType.APPLICATION_JSON_VALUE,
		produces = MediaType.APPLICATION_JSON_VALUE)
	public Person store (@RequestBody Person newPerson) {
		return this.people
			.store(newPerson);
	}
}
