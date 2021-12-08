package shoppingCatalog.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE)

public class InvalidValueException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8709700978431286352L;

	public InvalidValueException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InvalidValueException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public InvalidValueException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public InvalidValueException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	

}
