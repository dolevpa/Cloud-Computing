package users.Exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE)
public class InvalidEmailAddress extends RuntimeException {

	public InvalidEmailAddress() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InvalidEmailAddress(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public InvalidEmailAddress(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public InvalidEmailAddress(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public InvalidEmailAddress(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -9193381445397786684L;

}
