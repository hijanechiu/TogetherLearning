package tl.config;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;
import tl.service.impl.MyUserDetailService;

@Configuration
@EnableWebSecurity
public class WebSercurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private MyAuthenticationSuccessHandler myAuthenticationSuccessHandler;
	
	@Autowired
	private MyAuthenticationFailureHandler myAuthenticationFailureHandler;
	
	@Autowired
	private MyUserDetailService myUserDetailService; 
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private CaptchaCodeFilter captchaCodeFilter;
	
//	@Autowired
//	private CustomOAuth2UserService oAuth2UserService;
	
//	@Autowired
//	private OAuth2LoginSuccessHandler oAuth2LoginSuccessHandler;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
		.userDetailsService(myUserDetailService)
		.passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		  .addFilterBefore(captchaCodeFilter, UsernamePasswordAuthenticationFilter.class) 
		  //在UsernamePasswordAuthenticationFilter之前添加captchaCodeFilter
		  .rememberMe()
		  .rememberMeParameter("remember-me")
		  .rememberMeCookieName("gfdgdfh")
		  .tokenValiditySeconds(1*24*60*60)
		  .tokenRepository(persistentTokenRepository())//將cookies存到資料庫內
		  .and()
	      .authorizeRequests()
	      .antMatchers(HttpMethod.GET,"/student").authenticated()
	      .antMatchers(HttpMethod.GET).permitAll()
	      .antMatchers(HttpMethod.POST,"/addCourseRecord").authenticated()
	      .antMatchers(HttpMethod.POST).permitAll()
	      .anyRequest().authenticated()
		  .and()
		  .logout()
		  .logoutUrl("/logout")
		  .logoutSuccessUrl("/index")
		  .deleteCookies("JSESSIONID")
		  .and()
		  .csrf().disable()
		  .formLogin()
	      .loginPage("/login")
	      .loginProcessingUrl("/loggin")
	      .usernameParameter("username")
	      .passwordParameter("password")
	      .successHandler(myAuthenticationSuccessHandler)
	      .failureHandler(myAuthenticationFailureHandler)
		  .and()
		  .oauth2Login()
		  .loginPage("/login")
//		  .userInfoEndpoint().userService(oAuth2UserService)
//		  .and()
//		  .successHandler(oAuth2LoginSuccessHandler)
		  .and()
	      .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
	      .sessionFixation().migrateSession()
	      .maximumSessions(1) 
		  .maxSessionsPreventsLogin(false) 
		  .expiredSessionStrategy(new CustomExpiredSessionStrategy())
		  .and()
		  ;
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/assets/**");	
	}
	
	@Bean 
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public PersistentTokenRepository persistentTokenRepository() {
		JdbcTokenRepositoryImpl tokenRepository=new JdbcTokenRepositoryImpl();
		tokenRepository.setDataSource(dataSource);
		return tokenRepository;}
	
	@Bean
	public ServerEndpointExporter serverEndpointExporter() {
		return new ServerEndpointExporter();
	}
	
	@Bean
	public SimpleMailMessage message() {
		return new SimpleMailMessage();
	}

}
