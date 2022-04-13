package tl.service.impl;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.bytebuddy.utility.RandomString;
import tl.entity.AuthenticationProvider;
import tl.entity.Student;
import tl.repository.StudentRepository;
import tl.service.exception.AccountDuplicatedException;
import tl.service.exception.AccountNotFoundException;
import tl.service.exception.PasswordNotMatchException;
import tl.service.exception.UpdateException;
import tl.service.exception.UserNotFoundException;

@Service
@Transactional
public class StudentService {

	@Autowired
	private StudentRepository sRep;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private EmailSenderService emailService;

	public Integer getIdByAccount(String account) {
		Student student=sRep.findByAccount(account);
		Integer sid=student.getSid();
		return sid;
	}
	
	public Student findBySid(Integer sid){
		Student student=sRep.getById(sid);
		return student;
	}
	
	//註冊
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
		
		//補全4個日誌+點數歸零
		student.setCreatedUser(student.getAccount());
		student.setCreatedTime(new Date());
		student.setModifiedUser(student.getAccount());
		student.setModifiedTime(new Date());
		student.setStudentPoints(0);
		sRep.save(student);
	} 
	
	//得到個人資料(要拿來更新)
	public Student getInfoBySid(Integer sid){
		Student result=sRep.getById(sid);
		if(result==null) {
			throw new UserNotFoundException("查無資料");
		}
		Student student=new Student();
		student.setStudentName(result.getStudentName());
		student.setAccount(result.getAccount());
		student.setPhone(result.getPhone());
		student.setEmail(result.getEmail());
		return student;
	}
	//更新資料
	public void changeInfo(Integer sid,String account,Student student) {
		Student result=sRep.getById(sid);
		if(result==null) {
			throw new UserNotFoundException("查無資料");
		}
		String phone=student.getPhone();
		String email=student.getEmail();
		Integer rows=sRep.updateInfo(phone,email,account,new Date(),sid);
		if(rows!=1) {
			throw new UpdateException("更新時產生未知的異常");
		}
	}
	
	//修改密碼
	public void changepwd(Integer sid,String account,String oldPassword,String newPassword) {
		Student result=sRep.getById(sid);
		if(result==null) {
			throw new UserNotFoundException("查無資料");
		}
		if(!passwordEncoder.matches(oldPassword,result.getPassword())){
			throw new PasswordNotMatchException("輸入的原密碼錯誤");
		}
		String bcEncodePwd=passwordEncoder.encode(newPassword);
		Integer rows = sRep.changePassword(bcEncodePwd,account,new Date(),sid);
		if(rows!=1) {
			throw new UpdateException("更新產生未知的異常");
		}
		
	}
	
	public Student getStudentByEmail(String email) {
		return sRep.findByEmail(email);
	}
	
	//更新token
	public void updateResetPasswordToken(String email,HttpServletRequest request) throws UnsupportedEncodingException, MessagingException {
        Student result = sRep.findByEmail(email);
        if (result != null) {
        	String token=RandomString.make(30);
        	result.setModifiedUser("管理員");
        	result.setModifiedTime(new Date());
        	result.setResetPasswordToken(token);
            sRep.save(result);
            String resetPasswordLink=getSiteURL(request)+"/reset_password?token=" + token;
            emailService.sendresetPasswordLink(email, resetPasswordLink);
        } else {
            throw new UserNotFoundException("查無資料");
        }
    }
	
	//用token來尋找用戶
    public Student getByResetPasswordToken(String token) {
        return sRep.findByResetPasswordToken(token);
    }
    
    //更新密碼
    public void updatePassword(Student student, String newPassword) {
        String encodedPassword = passwordEncoder.encode(newPassword);
        student.setPassword(encodedPassword);
        student.setResetPasswordToken(null);
        student.setModifiedUser(student.getStudentName());
        student.setModifiedTime(new Date());
        sRep.save(student);
    }
    
    public void createNewStudentAfterOAuthLoginSuccess(String email,String name,AuthenticationProvider provider) {
    	Student student=new Student();
    	student.setEmail(email);
    	student.setStudentName(name);
    	student.setCreatedUser(name);
    	student.setCreatedTime(new Date());
    	student.setAuthenticationProvider(provider);
    	sRep.save(student);
    }
    
    public void updateStudentAfterOAuthLoginSuccess(Student student,String name,AuthenticationProvider provider) {
    	student.setStudentName(name);
    	student.setAuthenticationProvider(provider);
    	sRep.save(student);
    }
    
    //用來生成驗證碼連結的工具
    public static String getSiteURL(HttpServletRequest request) {
        String siteURL = request.getRequestURL().toString();
        return siteURL.replace(request.getServletPath(), "");
    }
    
    //汶珊寫的方法，用來更新學生點數
	public Student update(Student student) {
		return sRep.save(student);
	}
    
}
