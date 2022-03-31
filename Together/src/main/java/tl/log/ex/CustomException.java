package tl.log.ex;

public class CustomException extends RuntimeException {
	
	//異常錯誤編碼
	private int code;
	//異常信息
	private String message;
	
	private CustomException() {}

	public CustomException(CustomExceptionType exceptionTypeEnum) {
		this.code=exceptionTypeEnum.getCode();
		this.message=exceptionTypeEnum.getDesc();
	}
	
	public CustomException(CustomExceptionType exceptionTypeEnum,String message) {
		this.code=exceptionTypeEnum.getCode();
		this.message=message;
	}
	
	public int getCode() {
		return code;
	}

	@Override
	public String getMessage() {
		return message;
	}

	
}
