package shoppingCatalog.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE)
public class InvalidFilterTypeException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4444575378317786184L;

	public InvalidFilterTypeException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InvalidFilterTypeException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public InvalidFilterTypeException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public InvalidFilterTypeException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	
}
