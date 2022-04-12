package tl.controller;



import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttributes;




@SessionAttributes(names={"sid"})
@Controller
public class EnterController {

	
	@GetMapping("/{url}")
	public String url(@PathVariable("url") String url,Model m) {
		return url;
	}
	
	@GetMapping("/update_info")
	public String updateInfo() {
		return "updateInfo";
	}
	
	@GetMapping("/update_password")
	public String updatepwd() {
		return "updatepwd";
	}
	
	@GetMapping("/order_detail/{oid}")
	public String orderDetail(@PathVariable("oid") Integer oid,Model m) {
		m.addAttribute("oid", oid);
		return "orderDetail";
	}
	
	
}
