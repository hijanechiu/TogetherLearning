package tl.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import tl.service.exception.AccountDuplicatedException;
import tl.service.exception.CustomException;
import tl.service.exception.CustomExceptionType;
import tl.util.AjaxResponse;


@Component
public class MyAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {


@Value("${spring.security.logintype}")
private String loginType;

//springboot默認的json處理框架
private static ObjectMapper objectMapper=new ObjectMapper();

@Override
public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
		AuthenticationException exception) throws IOException, ServletException {
	
	String errorMsg="請檢查帳號和密碼輸入是否正確";
	if(exception instanceof SessionAuthenticationException) {
		errorMsg=exception.getMessage();}
	
	
	
	if(loginType.equalsIgnoreCase("JSON")) {
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().write(objectMapper.writeValueAsString(AjaxResponse.error(new CustomException(CustomExceptionType.USER_INPUT_ERROR,errorMsg))));
	}else {
		response.setContentType("text/html;charset=UTF-8");
		//登入失敗後會自動跳轉回登入頁面
		super.onAuthenticationFailure(request, response, exception);
	}
}



}


