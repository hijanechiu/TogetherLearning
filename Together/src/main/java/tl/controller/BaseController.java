package tl.controller;

import org.hibernate.service.spi.ServiceException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import tl.service.exception.AccountDuplicatedException;
import tl.service.exception.AccountNotFoundException;
import tl.service.exception.PasswordNotMatchException;
import tl.util.JsonResult;

@ControllerAdvice
public class BaseController {

	/*操作成功的代號碼*/
	public static final int OK=200;
	
	@ExceptionHandler({ServiceException.class})
	public JsonResult<Void> handleException(Throwable e){
		JsonResult<Void> result=new JsonResult<>(e);
		if(e instanceof AccountDuplicatedException) {
			result.setState(4000);
			result.setMessage("該帳號已被註冊");
		}else if(e instanceof AccountNotFoundException) {
			result.setState(4001);
			result.setMessage("查無該帳號資料");
		}else if(e instanceof PasswordNotMatchException) {
			result.setState(4002);
			result.setMessage("密碼錯誤");
		}
		return result;
	}


}
