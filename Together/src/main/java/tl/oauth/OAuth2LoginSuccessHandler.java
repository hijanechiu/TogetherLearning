//package tl.oauth;
//
//import java.io.IOException;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
//import org.springframework.stereotype.Component;
//
//import tl.entity.AuthenticationProvider;
//import tl.entity.Student;
//import tl.service.impl.StudentService;
//
//@Component
//public class OAuth2LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler{
//
//	@Autowired
//	private StudentService sService;
//	
//	@Override
//	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
//			Authentication authentication) throws IOException, ServletException {
//		CustomOAuth2User oAuth2User=(CustomOAuth2User)authentication.getPrincipal();
//		String email=oAuth2User.getEmail();
//		String name=oAuth2User.getName();
//		Student student=sService.getStudentByEmail(email);
//		if(student==null) {
//			sService.createNewStudentAfterOAuthLoginSuccess(email, name, AuthenticationProvider.GOOGLE);
//		}else {
//			sService.updateStudentAfterOAuthLoginSuccess(student,name,AuthenticationProvider.GOOGLE);
//		}
//		System.out.println(email);
//		super.onAuthenticationSuccess(request, response, authentication);
//	}
//
//}
