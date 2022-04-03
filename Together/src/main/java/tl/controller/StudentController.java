package tl.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import tl.entity.Student;
import tl.service.impl.StudentService;
import tl.util.JsonResult;

@SessionAttributes(names={"sid"})
@Controller
//@RequestMapping("/TL")
public class StudentController extends BaseController {

	@Autowired 
	private StudentService sService;
	
	@GetMapping("/student")
	public String student(@AuthenticationPrincipal User user,Model m) {
		String account=user.getUsername();
		Integer sid=sService.getIdByAccount(account);
		m.addAttribute("sid", sid);
		return "student";
	}
	
	@ResponseBody
	@PostMapping("/reg")
	public JsonResult<Void> register(Student student){
		sService.Register(student);
		return new JsonResult<>(OK);
	}
	
	@ResponseBody
	@GetMapping("/get_info")
	public JsonResult<Student> getInfo(@SessionAttribute Integer sid){
		Student data=sService.getInfoBySid(sid);
		return new JsonResult<Student>(OK,data);
	}
	
	@ResponseBody
	@PostMapping("/change_info")
	public JsonResult<Void> changeInfo(@SessionAttribute Integer sid,@AuthenticationPrincipal User user,Student student){
		String account=user.getUsername();
		sService.changeInfo(sid, account, student);
		return new JsonResult<>(OK);
	}
	
	@ResponseBody
	@PostMapping("/change_password")
	public JsonResult<Void> changePassword(@SessionAttribute Integer sid,@AuthenticationPrincipal User user,String oldPassword,String newPassword){
		String account=user.getUsername();
		sService.changepwd(sid, account,oldPassword , newPassword);
		return new JsonResult<>(OK);
	}
}
