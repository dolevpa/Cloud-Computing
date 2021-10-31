package people;

import javax.annotation.PostConstruct;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PeopleServiceImplementation implements PeopleService {
	private String producerUrl;
	private RestTemplate restTemplate;
	private Log log = LogFactory.getLog(PeopleServiceImplementation.class);
	
	@Value("${dependency.service.key-value-store.url}")
	public void setProducerUrl(String producerUrl) {
		this.producerUrl = producerUrl;
	}
	
	@PostConstruct
	public void init() {
		this.restTemplate = new RestTemplate();
	}
	
	@Override
	public Person store(Person newPerson) {
		this.log.debug("sending person to producer service: " + newPerson);
		
		KeyPersonPairBoundary personWithKey = this.restTemplate
			.postForObject(
				this.producerUrl, 
				newPerson, KeyPersonPairBoundary.class);
		
		this.log.debug("received from producer service: " + personWithKey);
		
		Person rv = new Person();
		rv.setBirthdate(personWithKey.getValue().getBirthdate());
		rv.setName(personWithKey.getValue().getName());
		rv.setId(personWithKey.getKey());

		this.log.trace("sending back to consumer: " + rv);
		
		return rv;
	}

}
