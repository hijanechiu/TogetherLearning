package tl.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/*帳號已被重複註冊的異常*/
//@ResponseStatus(code=HttpStatus.INTERNAL_SERVER_ERROR)
public class AccountDuplicatedException extends ServiceException {


	private static final long serialVersionUID = 1L;

	public AccountDuplicatedException() {
	super();
	}

	public AccountDuplicatedException(String message) {
		super(message);
	}

	public AccountDuplicatedException(Throwable cause) {
		super(cause);
	}

	public AccountDuplicatedException(String message, Throwable cause) {
		super(message, cause);
	}

	public AccountDuplicatedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
