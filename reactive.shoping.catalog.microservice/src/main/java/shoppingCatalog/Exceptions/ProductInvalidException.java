package shoppingCatalog.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE)
public class ProductInvalidException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7346817508098286433L;

	public ProductInvalidException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductInvalidException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ProductInvalidException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ProductInvalidException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	

}
