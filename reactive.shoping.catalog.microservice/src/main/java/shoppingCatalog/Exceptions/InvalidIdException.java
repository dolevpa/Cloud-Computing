package shoppingCatalog.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE)

public class InvalidIdException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3442889542590028639L;

	public InvalidIdException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InvalidIdException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public InvalidIdException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public InvalidIdException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	

}
