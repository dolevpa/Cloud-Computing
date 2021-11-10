package users.Exceptions;


import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE)
public class InvalidCriteriaTypeExcepetion extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4878374012963921895L;

	public InvalidCriteriaTypeExcepetion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InvalidCriteriaTypeExcepetion(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public InvalidCriteriaTypeExcepetion(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public InvalidCriteriaTypeExcepetion(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public InvalidCriteriaTypeExcepetion(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	

}
