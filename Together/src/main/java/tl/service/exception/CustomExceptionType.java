package tl.service.exception;

public enum CustomExceptionType{

	USER_INPUT_ERROR(400,"您輸入的數據錯誤貨您沒有權限訪問資源"),
	SYSTEM_ERROR(500,"系統出現異常,請您稍後再試或聯絡客服"),
	OTHER_ERROR(999,"系統出現未知異常,請聯絡客服");
	
	private String desc;
	
	private int code;

	CustomExceptionType(int code,String desc) {
		this.desc = desc;
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public int getCode() {
		return code;
	}

}