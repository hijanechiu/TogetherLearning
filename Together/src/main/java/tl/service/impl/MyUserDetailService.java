package tl.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import tl.entity.Student;
import tl.repository.StudentRepository;

@Component
public class MyUserDetailService implements UserDetailsService {

	
	@Autowired
	private StudentRepository sRep;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		//loadUserByUsername(String username)傳入的username值就是.usernameParameter("username")傳入的值
		
		//用戶基礎數據加載
		Student student = sRep.findByAccount(username);
		if(student==null) {
			throw new UsernameNotFoundException("帳號不存在");
		}
		//把對應的用戶信息封裝成UserDetail對象
		return new User(student.getAccount(),student.getPassword(),Collections.EMPTY_LIST);
		
	}

}
