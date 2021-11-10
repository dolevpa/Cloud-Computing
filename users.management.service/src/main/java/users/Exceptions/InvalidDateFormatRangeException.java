package users.Exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE)
public class InvalidDateFormatRangeException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 293232098324463860L;

	public InvalidDateFormatRangeException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InvalidDateFormatRangeException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public InvalidDateFormatRangeException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public InvalidDateFormatRangeException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public InvalidDateFormatRangeException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	
}
