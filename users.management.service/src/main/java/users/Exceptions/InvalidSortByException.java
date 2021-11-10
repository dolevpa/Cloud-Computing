package users.Exceptions;


import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE)
public class InvalidSortByException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3113496704435737637L;

	public InvalidSortByException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InvalidSortByException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public InvalidSortByException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public InvalidSortByException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public InvalidSortByException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	

}
