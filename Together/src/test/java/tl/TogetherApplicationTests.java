package tl;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tl.entity.Student;
import tl.service.impl.StudentService;

@SpringBootTest
class TogetherApplicationTests {

//	@Test
//	void contextLoads() {
//	}

	@Autowired
	private StudentService sService;
	
//	@Test 註冊測試成功
	void saveStudent() {
		Student student=new Student();
		
		student.setAccount("test123");
		student.setPassword("test123");
		sService.Register(student);
	}

//	@Test 成功跳出錯誤:該帳號已被註冊
	void saveStudentAccountDuplicated() {
		Student student=new Student();
		
		student.setAccount("test123");
		student.setPassword("test123");
		sService.Register(student);
	}
	
//	@Test  成功登入,失敗則跳出密碼錯誤 
//	void login() {
//		String account="test123";
//		String password="test123";
//		Student stu=sService.login(account, password);
//		System.out.println(stu);
//	}
	
	
}
