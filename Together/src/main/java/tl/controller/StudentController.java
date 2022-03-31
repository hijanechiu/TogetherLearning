package tl.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import tl.entity.Student;
import tl.service.impl.StudentService;
import tl.util.JsonResult;

//@SessionAttributes(names={"sid","account","name"})
@Controller
//@RequestMapping("/TL")
public class StudentController extends BaseController {

	@Autowired 
	private StudentService sService;
	
	@GetMapping("/index")
	public String index() {
		return "index";
	}
	
	@GetMapping("/register")
	public String register() {
		return "register";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/contact")
	public String contact() {
		return "contact";
	}	
	
	
	@GetMapping("/student")
	public String student(@AuthenticationPrincipal User user) {
		String account=user.getUsername();
		String pwd=user.getPassword();
		System.out.println("account:"+account+"pwd:"+pwd);
		return "student";
	}
	
	@ResponseBody
	@PostMapping("/reg")
	public JsonResult<Void> register(Student student){
		sService.Register(student);
		return new JsonResult<>(OK);
	}
	
	/*@ResponseBody
	@PostMapping("/checklogin")
	public JsonResult<Student> checkLogin(String account,String password,ModelAndView m){
		Student data=sService.login(account, password);
		m.addObject("sid", data.getSid());
		m.addObject("name", data.getName());
		m.addObject("account", data.getAccount());
		return new JsonResult<>(OK,data);
		//試看看能不能直接將data存到session就好
	}	*/
	
}
