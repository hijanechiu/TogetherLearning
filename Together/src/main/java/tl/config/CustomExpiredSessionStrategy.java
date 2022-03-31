package tl.config;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;

import org.springframework.security.web.session.SessionInformationExpiredEvent;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;

import com.fasterxml.jackson.databind.ObjectMapper;

public class CustomExpiredSessionStrategy implements SessionInformationExpiredStrategy {

	//頁面跳轉的處理邏輯 (第一種方法=>使用頁面跳轉)
//	private RedirectStrategy redirectStrategy=new DefaultRedirectStrategy();
	
	//jackson的JSON處理對象 (第二種方法=>返回JSON值)
	private ObjectMapper objectMapper=new ObjectMapper();
	
	@Override
	public void onExpiredSessionDetected(SessionInformationExpiredEvent event) throws IOException, ServletException {
		//當發現session超時或被踢下線,在此實現自定義的策略
//		redirectStrategy.sendRedirect(event.getRequest(), event.getResponse(), "/invalid"); =>使用頁面跳轉來處理
	Map<String,Object> map=new HashMap<>();
	map.put("code", 403);
	map.put("msg", "登入已超時或者在另一台設備登入,你被迫下線"+event.getSessionInformation().getLastRequest());
		
	String json=objectMapper.writeValueAsString(map);	
		
	event.getResponse().setContentType("application/json;charset=utf-8");
	event.getResponse().getWriter().write(json);
	
	}
}
