package tl.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import tl.VO.DetailVO;
import tl.VO.TestItemVO;
import tl.entity.Coupon;
import tl.entity.Point;
import tl.entity.Student;
import tl.entity.TLOrder;
import tl.repository.TestItemRepository;
import tl.service.impl.CouponService;
import tl.service.impl.OrderService;
import tl.service.impl.PointService;
import tl.service.impl.StudentService;
import tl.service.impl.TestService;
import tl.util.JsonResult;

@SessionAttributes(names={"sid"})
@Controller
public class StudentController extends BaseController {

	@Autowired 
	private StudentService sService;
	
	@Autowired
	private OrderService oService;
	
	@Autowired
	private CouponService cService;
	
	@Autowired
	private PointService pService;
	
	@Autowired
	private TestService tService;
	
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
	
	@ResponseBody
	@GetMapping("/orders")
	public JsonResult<List<TLOrder>> viewOrders(@SessionAttribute Integer sid){
		List<TLOrder> data=oService.getOrderBySid(sid);
		return new JsonResult<>(OK,data);		
	}

	@ResponseBody
	@GetMapping("/check_coupon")
	public JsonResult<List<Coupon>> viewCoupons(@SessionAttribute Integer sid){
	List<Coupon> data=cService.getCouponBySid(sid);
	return new JsonResult<>(OK,data);
	}

	@ResponseBody
	@GetMapping("/check_point")
	public JsonResult<List<Point>> viewPoints(@SessionAttribute Integer sid){
	List<Point> data=pService.getPointBySid(sid);
	return new JsonResult<>(OK,data);
	}
	
	@ResponseBody
	@GetMapping("/check_test")
	public JsonResult<List<TestItemVO>> viewTests(@SessionAttribute Integer sid){
	List<TestItemVO> data=tService.getTestListBySid(sid);
	return new JsonResult<>(OK,data);
	}
	
	@ResponseBody
	@GetMapping("/check/{oid}/orderDetail")
	public JsonResult<List<DetailVO>> viewOrderDetail(@PathVariable("oid") Integer oid){
	List<DetailVO> data=oService.getOrderDetailByOid(oid);
	return new JsonResult<>(OK,data);
	}
	
	
	
	


}
