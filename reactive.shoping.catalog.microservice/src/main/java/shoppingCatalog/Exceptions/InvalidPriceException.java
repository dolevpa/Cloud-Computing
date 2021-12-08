package shoppingCatalog.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE)

public class InvalidPriceException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1429429977198770699L;

	public InvalidPriceException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InvalidPriceException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public InvalidPriceException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public InvalidPriceException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	

}
