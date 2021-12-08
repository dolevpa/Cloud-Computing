package shoppingCatalog.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE)
public class InvalidOrderException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6201417502089951263L;

	public InvalidOrderException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InvalidOrderException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public InvalidOrderException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public InvalidOrderException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	

}
