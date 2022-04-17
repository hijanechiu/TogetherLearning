package tl.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.paypal.api.payments.Links;

import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;

import tl.entity.Order;
import tl.entity.Paypaldata;
import tl.entity.Point;
import tl.entity.Student;
import tl.service.impl.PaypalService;
import tl.service.impl.PaypaldataService;
import tl.service.impl.PointService;
import tl.service.impl.StudentService;

@Controller
@SessionAttributes(names={"sid"})
public class PaypalController {

	@Autowired
    PaypalService service;
	@Autowired
	PaypaldataService pservice;
	@Autowired
	private StudentService sService;
	@Autowired
	private PointService poiService;
	
	private String onekunit;
	private String fivekunit;
	private String tenkunit;

    
	public static final String SUCCESS_URL = "pay/success";
	public static final String FAILED_URL = "pay/failed";

	@GetMapping("/buypaypal")
	public String home() {
		return "jsp/buypaypal";
	}

	@PostMapping("/pay")
	public String payment(@ModelAttribute("order") Order order) {
		try {
			Payment payment = service.createPayment(order.getPrice(), order.getCurrency(), order.getMethod(),
					order.getIntent(), order.getDescription(), "http://localhost:8080/" + FAILED_URL,
					"http://localhost:8080/" + SUCCESS_URL);
			onekunit=order.getOnekunit();
			fivekunit=order.getFivekunit();
			tenkunit=order.getTenkunit();
			for(Links link:payment.getLinks()) {
				if(link.getRel().equals("approval_url")) {
					return "redirect:"+link.getHref();
				}
			}
			
		} catch (PayPalRESTException e) {
		
			e.printStackTrace();
		}
		return "redirect:/";
	}
	
	 @GetMapping(value = FAILED_URL)
	    public String cancelPay() {
	        return "th/failed";
	    }


	    @GetMapping(value = SUCCESS_URL)
	    public String successPay(@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId,@SessionAttribute Integer sid) {
	    	Date date=new Date();
	    	try {
	            Payment payment = service.executePayment(paymentId, payerId);
	            System.out.println(payment.toJSON());
	            if (payment.getState().equals("approved")) {
	            	Paypaldata paypal1=new Paypaldata();
	            	paypal1.setCustomfield1(Integer.toString(sid)); //學生id
	            	paypal1.setRtncode(payment.getState());
	            	paypal1.setTradeno(payment.getId());
	            	SimpleDateFormat format=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	            	String fomatDate = format.format(date);
	            	paypal1.setTradedate(fomatDate);
	            	String stringTotal=payment.getTransactions().get(0).getAmount().getTotal().split("\\.")[0];
	            	paypal1.setTradeamt(stringTotal);
	            	paypal1.setCustomField2(onekunit);
	            	paypal1.setCustomField3(fivekunit);
	            	paypal1.setCustomField4(tenkunit);
	            	pservice.insert(paypal1);
	            	
	            	
	            	Student student=sService.findBySid(sid);
	    			int stuPoint = student.getStudentPoints();
	    			Integer total=Integer.parseInt(stringTotal);
	    			student.setStudentPoints(stuPoint+total);
	    			sService.update(student);
	    			
	    			Point point1=new Point(); //創建一個新point
	                point1.setSid(sid); //抓session的sid
	                point1.setPoints(total);  //設置異動點數
	                point1.setChangedReason("點數購買");  //設置異動原因
	                point1.setChangedTime(date);  
	                poiService.insert(point1);
	            	
	                return "th/success";
	            }
	        } catch (PayPalRESTException e) {

	         System.out.println(e.getMessage());
	        }
	        return "redirect:/";
	    }

}
