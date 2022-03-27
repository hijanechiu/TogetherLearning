package tl.service.exception;

/*帳號已被重複註冊的異常*/
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
