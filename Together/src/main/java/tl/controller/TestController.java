package tl.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import tl.VO.TestResultAceptor;
import tl.entity.Test;
import tl.service.impl.StudentTestService;

@SessionAttributes(names={"sid"})
@Controller
public class TestController{
	
	@Autowired
	private StudentTestService testService;
	
	//國文(科目id1)成績判斷
	@ResponseBody
	@PostMapping("/cnc/m1")
	public String cnTest(@RequestBody TestResultAceptor data,@SessionAttribute Integer sid) {
		String q1 = data.getAnswer1();
		String q2 = data.getAnswer2();
		String q3 = data.getAnswer3();
		String q4 = data.getAnswer4();
		
		int score = 0;
		if(q1.equals("c")) {
			score+=25;
		}
		if(q2.equals("c")) {
			score+=25;
		}
		if(q3.equals("c")) {
			score+=25;
		}
		if(q4.equals("a")) {
			score+=25;
		}
		
		Test item = new Test();
		item.setSid(sid);
		item.setIid(1);
		item.setGrade(score);
		item.setTestTime(new Date());
		
		testService.insert(item);
		return "分數:"+score;
	}
	
	//英文(科目id2)成績判斷
	@ResponseBody
	@PostMapping("/cnc/m2")
	public String enTest(@RequestBody TestResultAceptor data,@SessionAttribute Integer sid) {
		String q1 = data.getAnswer1();
		String q2 = data.getAnswer2();
		String q3 = data.getAnswer3();
		String q4 = data.getAnswer4();
		
		int score = 0;
		if(q1.equals("a")) {
			score+=25;
		}
		if(q2.equals("c")) {
			score+=25;
		}
		if(q3.equals("d")) {
			score+=25;
		}
		if(q4.equals("a")) {
			score+=25;
		}
		
		Test item = new Test();
		item.setSid(sid);
		item.setIid(2);
		item.setGrade(score);
		item.setTestTime(new Date());
		
		testService.insert(item);
		return "分數:"+score;
	}
	
	//數學(科目id3)成績判斷
	@ResponseBody
	@PostMapping("/cnc/m3")
	public String maTest(@RequestBody TestResultAceptor data,@SessionAttribute Integer sid) {
		String q1 = data.getAnswer1();
		String q2 = data.getAnswer2();
		String q3 = data.getAnswer3();
		String q4 = data.getAnswer4();
		
		int score = 0;
		if(q1.equals("b")) {
			score+=25;
		}
		if(q2.equals("a")) {
			score+=25;
		}
		if(q3.equals("c")) {
			score+=25;
		}
		if(q4.equals("a")) {
			score+=25;
		}
		
		Test item = new Test();
		item.setSid(sid);
		item.setIid(3);
		item.setGrade(score);
		item.setTestTime(new Date());
		
		testService.insert(item);
		return "分數:"+score;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
	}
	
	
	
	

