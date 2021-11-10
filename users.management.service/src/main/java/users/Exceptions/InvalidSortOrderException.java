package users.Exceptions;



import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE)
public class InvalidSortOrderException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2982472093639304266L;

	public InvalidSortOrderException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InvalidSortOrderException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public InvalidSortOrderException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public InvalidSortOrderException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public InvalidSortOrderException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	

}
