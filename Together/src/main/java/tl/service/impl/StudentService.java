package tl.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tl.entity.Student;
import tl.repository.StudentRepository;
import tl.service.exception.AccountDuplicatedException;
import tl.service.exception.AccountNotFoundException;
import tl.service.exception.PasswordNotMatchException;

@Service
@Transactional
public class StudentService {

	@Autowired
	private StudentRepository sRep;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	public Student findBySid(Integer sid){
		Student student=sRep.getById(sid);
		return student;
	}
	
	public void Register(Student student) {
		//先查詢該帳號是否已被註冊
		String account=student.getAccount();
		Student result=sRep.findByAccount(account);
		
		if(result!=null) {
			throw new AccountDuplicatedException("該帳號已被註冊");
		}
		//密碼加密處理
		String bcEncodePwd=passwordEncoder.encode(student.getPassword());
		student.setPassword(bcEncodePwd);
		
		//補全4個日誌
		student.setCreatedUser(student.getAccount());
		student.setCreatedTime(new Date());
		student.setModifiedUser(student.getAccount());
		student.setModifiedTime(new Date());
		sRep.save(student);
	} 
	
	/*
	public Student login(String account,String password) {
		Student result=sRep.findByAccount(account);
		if(result==null) {
			throw new AccountNotFoundException("查無該帳號資料");
		}
		
		String bcEncodePwd=result.getPassword();
		if(!passwordEncoder.matches(password,bcEncodePwd)){
			throw new PasswordNotMatchException("密碼錯誤");
		}
		
		Student student=new Student();
		student.setSid(result.getSid());
		student.setAccount(result.getAccount());
		student.setName(result.getName());
		
		return student;
	}*/
	
	//boolean result=new BCryptPasswordEncoder().matches("用戶輸入的密碼",從資料庫去撈出加密的密碼)


}
