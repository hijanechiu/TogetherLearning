package tl.util;

import tl.service.exception.CustomException;
import tl.service.exception.CustomExceptionType;

public class AjaxResponse {

	private boolean isok; // 請求是否處理成功

	private int code; // 請求響應狀態碼(200,400,500)

	private String message; // 請求結果描述信息

	private Object data; // 請求結果數據

	private AjaxResponse() {
	};

	// 請求出現異常時的響應數據封裝
	public static AjaxResponse error(CustomException e) {
		AjaxResponse resultBean = new AjaxResponse();
		resultBean.setIsok(false);
		resultBean.setCode(e.getCode());
		resultBean.setMessage(e.getMessage());
		return resultBean;
	}

	// 請求出現異常時的響應數據封裝
	public static AjaxResponse error(CustomExceptionType customExceptionType, String errorMessage) {
		AjaxResponse resultBean = new AjaxResponse();
		resultBean.setIsok(false);
		resultBean.setCode(customExceptionType.getCode());
		resultBean.setMessage(errorMessage);
		return resultBean;
	}

	// 請求出現異常時的響應數據封裝
	public static AjaxResponse userInputError(String errorMessage) {
		AjaxResponse resultBean = new AjaxResponse();
		resultBean.setIsok(false);
		resultBean.setCode(CustomExceptionType.USER_INPUT_ERROR.getCode());
		resultBean.setMessage(errorMessage);
		return resultBean;
	}
	

	// 請求成功的響應,不帶查詢數據(用於刪除、修改、新增接口)
	public static AjaxResponse success() {
		AjaxResponse resultBean = new AjaxResponse();
		resultBean.setIsok(true);
		resultBean.setCode(200);
		resultBean.setMessage("請求響應成功");
		return resultBean;
	}
	// 請求成功的響應,不帶查詢數據(用於刪除、修改、新增接口)
	public static AjaxResponse success(Object obj) {
		AjaxResponse resultBean = new AjaxResponse();
		resultBean.setIsok(true);
		resultBean.setCode(200);
		resultBean.setMessage("請求響應成功");
		resultBean.setData(obj);
		return resultBean;
	}
	
	// 請求成功的響應,不帶查詢數據(用於刪除、修改、新增接口)
	public static AjaxResponse success(Object obj,String message) {
		AjaxResponse resultBean = new AjaxResponse();
		resultBean.setIsok(true);
		resultBean.setCode(200);
		resultBean.setMessage(message);
		resultBean.setData(obj);
		return resultBean;
	}

	public boolean isIsok() {
		return isok;
	}

	public void setIsok(boolean isok) {
		this.isok = isok;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
