package tl.controller;

import org.hibernate.service.spi.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import tl.service.exception.AccountDuplicatedException;
import tl.service.exception.AccountNotFoundException;
import tl.service.exception.PasswordNotMatchException;
import tl.service.exception.UpdateException;
import tl.service.exception.UserNotFoundException;
import tl.util.JsonResult;

@ControllerAdvice
public class BaseController {

	/*操作成功的代號碼*/
	public static final int OK=200;
	
	@ExceptionHandler(ServiceException.class)
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
		}else if(e instanceof UserNotFoundException) {
			result.setState(4003);
			result.setMessage("用戶資料不存在");
		}else if(e instanceof UpdateException) {
			result.setState(5000);
			result.setMessage("更新時產生未知的異常");
		}
		return result;
	}


}
