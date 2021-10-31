package demo;

import java.util.Collections;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KeyValueController {
	@RequestMapping(
		path="/keyValue",
		method = RequestMethod.POST,
		consumes = MediaType.APPLICATION_JSON_VALUE,
		produces = MediaType.APPLICATION_JSON_VALUE)
	public KeyValuePairBoundary store (
			@RequestBody Map<String, Object> value) {
		// STUB IMPLE
		KeyValuePairBoundary rv = new KeyValuePairBoundary();
		rv.setValue(value);
		rv.setKey(UUID.randomUUID().toString());
		
		return rv;
	}
	
	@RequestMapping(
			path="/keyValue/{key}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public KeyValuePairBoundary getByKey (
			@PathVariable("key") String key) {
		// STUB IMPLE
		return new KeyValuePairBoundary(key, Collections.singletonMap("message", "dummy value for: "  + key));
	}
	
	@RequestMapping(
			path="/keyValue/{key}",
			method = RequestMethod.PUT,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public void update (
			@PathVariable("key") String key,
			@RequestBody Map<String, Object> updatedValue) {
		// STUB IMPLE
	}

	@RequestMapping(
			path="/keyValue",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public KeyValuePairBoundary[] getAll(
			@RequestParam(name="page", required = false, defaultValue = "0") int page,
			@RequestParam(name="size", required = false, defaultValue = "10") int size) {
		// STUB IMPLE
		return IntStream.range(0, size)
			.map(i->i + (page * size) + 1)
			.mapToObj(i -> new KeyValuePairBoundary(UUID.randomUUID().toString(), Collections.singletonMap("content", "item #"  + i)))
			.collect(Collectors.toList())
			.toArray(new KeyValuePairBoundary[0]);			
	}

	@RequestMapping(
			path="/keyValue/{key}",
			method = RequestMethod.DELETE)
	public void deleteByKey(
			@PathVariable("key") String key) {
		// STUB IMPLE
	}
	
	@RequestMapping(
			path="/keyValue",
			method = RequestMethod.DELETE)
	public void deleteAll() {
		// STUB IMPLE
	}

}
