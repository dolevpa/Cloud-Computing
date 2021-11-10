package users.Exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE)
public class InvalidNameException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4769691636828927404L;
	public InvalidNameException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InvalidNameException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public InvalidNameException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public InvalidNameException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public InvalidNameException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}



}
