package users.Exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE)
public class InvalidRoleException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7082343871736441032L;

	public InvalidRoleException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InvalidRoleException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public InvalidRoleException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public InvalidRoleException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public InvalidRoleException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	

}
