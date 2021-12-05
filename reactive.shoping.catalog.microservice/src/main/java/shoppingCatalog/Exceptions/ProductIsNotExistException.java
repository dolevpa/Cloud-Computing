package shoppingCatalog.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ProductIsNotExistException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4480745457494168979L;

	public ProductIsNotExistException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductIsNotExistException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ProductIsNotExistException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ProductIsNotExistException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	

}
