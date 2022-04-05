package tl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import tl.service.impl.StudentService;


@SessionAttributes(names={"sid"})
@Controller
public class EnterController {

	
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
	
	@GetMapping("/update_info")
	public String updateInfo() {
		return "updateInfo";
	}
	
	@GetMapping("/update_password")
	public String updatepwd() {
		return "updatepwd";
	}
	
	
	@GetMapping("/contact")
	public String contact() {
		return "contact";
	}	
	
	@GetMapping("/coupon")
	public String coupon() {
		return "coupon";
	}
	
	@GetMapping("/order")
	public String order() {
		return "order";
	}
	
	@GetMapping("/order_detail/{oid}")
	public String orderDetail(@PathVariable("oid") Integer oid,Model m) {
		m.addAttribute("oid", oid);
		return "orderDetail";
	}
	
	@GetMapping("/point")
	public String point() {
		return "point";
	}
	
	@GetMapping("/test")
	public String test() {
		return "test";
	}
	
}
