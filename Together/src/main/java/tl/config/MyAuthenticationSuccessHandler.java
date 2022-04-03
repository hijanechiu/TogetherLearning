package tl.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import tl.util.AjaxResponse;

/*登入成功的處理*/
@Component
public class MyAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
	//SavedRequestAwareAuthenticationSuccessHandler是AuthenticationSuccessHandler介面的實作類別
	//books.html=>login.html=>登入成功=>跳轉回原頁面books.html
	//紀錄一開始請求的頁面=>登入成功後即跳轉回原頁面

	@Value("${spring.security.logintype}")
	private String loginType;
	
	private static ObjectMapper objectMapper=new ObjectMapper();
	
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws ServletException, IOException {
		if(loginType.equalsIgnoreCase("JSON")) {
			response.setContentType("application/json;charset=UTF-8");
			response.getWriter().write(objectMapper.writeValueAsString(AjaxResponse.success()));
		}else {
			//跳轉到上一次請求的頁面
			super.onAuthenticationSuccess(request, response, authentication);
		}
	}

}
