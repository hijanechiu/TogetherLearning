package tl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;


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
	public String contact(@SessionAttribute Integer sid) {
		System.out.println(sid);
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
	
	@GetMapping("/order_detail")
	public String orderDetail() {
		return "orderDetail";
	}
	
	@GetMapping("/point")
	public String point() {
		return "point";
	}
	
}
