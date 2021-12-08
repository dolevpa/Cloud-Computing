package shoppingCatalog.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE)
public class InvalidSortAttributeException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1266709290300653649L;

	public InvalidSortAttributeException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InvalidSortAttributeException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public InvalidSortAttributeException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public InvalidSortAttributeException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
