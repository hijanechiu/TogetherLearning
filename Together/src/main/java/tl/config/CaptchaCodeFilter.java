package tl.config;

import java.io.IOException;
import java.util.Objects;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.filter.OncePerRequestFilter;
import org.thymeleaf.util.StringUtils;

import tl.VO.CaptchaImageVO;
import tl.util.MyContants;

@Component
public class CaptchaCodeFilter extends OncePerRequestFilter {

	@Resource
	MyAuthenticationFailureHandler myAuthenticationFailureHandler;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		if(StringUtils.equals("/loggin", request.getRequestURI())&&StringUtils.equalsIgnoreCase(request.getMethod(),"post")) {
			try {
				validate(new ServletWebRequest(request));
			}catch(AuthenticationException e) {
				myAuthenticationFailureHandler.onAuthenticationFailure(request,response,e);
				return;
			}
		}
		filterChain.doFilter(request, response);
	}
	
	private void validate(ServletWebRequest request) throws ServletRequestBindingException {
		HttpSession session = request.getRequest().getSession();
		String codeInRequest=ServletRequestUtils.getStringParameter(request.getRequest(),"captchaCode");
		if(StringUtils.isEmpty(codeInRequest)) {
			throw new SessionAuthenticationException("驗證碼不能為空");
		}
		//3.獲取session池中的驗證碼謎底
		CaptchaImageVO codeInSession=(CaptchaImageVO)session.getAttribute(MyContants.CAPTCHA_SESSION_KEY);
		if(Objects.isNull(codeInSession)) {
			throw new SessionAuthenticationException("驗證碼不存在");
		}
		//4.校驗伺服器session池中的驗證碼是否過期
		if(codeInSession.isExpired()) {
			session.removeAttribute(MyContants.CAPTCHA_SESSION_KEY);
			throw new SessionAuthenticationException("驗證碼已過期");
		}
		//5.請求驗證碼校驗
		if(!StringUtils.equals(codeInSession.getCode(), codeInRequest)) {
			throw new SessionAuthenticationException("驗證碼不正確");
		}
	}
}
