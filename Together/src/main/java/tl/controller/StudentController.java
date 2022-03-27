package tl.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

@Controller
@SessionAttributes(names={"sid","account","name"})
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
	
	@GetMapping("/student")
	public String student() {
		return "student";
	}
	
	@GetMapping("/aaa")
	public String aaa(SessionStatus session) {
		session.setComplete();
		return "index";
	}
	
	@GetMapping("/logout")
	public String logout() {
		
		return "index";
	}
	
	
	@ResponseBody
	@PostMapping("/reg")
	public JsonResult<Void> register(Student student){
		sService.Register(student);
		return new JsonResult<>(OK);
	}
	
	@ResponseBody
	@PostMapping("/checklogin")
	public JsonResult<Student> checkLogin(String account,String password,ModelAndView m){
		Student data=sService.login(account, password);
		m.addObject("sid", data.getSid());
		m.addObject("name", data.getName());
		m.addObject("account", data.getAccount());
		return new JsonResult<>(OK,data);
	}	
	
}
