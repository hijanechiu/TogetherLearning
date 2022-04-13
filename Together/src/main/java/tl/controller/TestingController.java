package tl.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import tl.entity.TestingSubjects;
import tl.repository.TestingSubjectsRepository;

@Controller
public class TestingController {

	@Autowired
	private TestingSubjectsRepository tsRep;
	

//==========================================================================================================//	
//                                             測驗中心                                                      //
//==========================================================================================================//	
	//-------------------------------------------科目-----------------------------------------------//

	//測驗中心的控制器=>還在製作
	@RequestMapping(value = "/testsubjects")//localhost:8080/testSubjects
	public ModelAndView testSubjects(HttpServletRequest request, HttpServletResponse response){  
		
//		List<TestingSubjects> testingSubjectDataList = tsRep.findAll(); =>此處方法還沒有所以會報錯無法進入網頁
		
		ModelAndView mav=new ModelAndView();  
		mav.setViewName("jsp/testSubjects");//返回路径==>jsp  
//		mav.addObject("testingSubjectList", testingSubjectDataList);//使用ModelAndView的addObject方法将List<CourseRecords> courRecoDataList放進去  

		return mav;
	} 


	//-------------------------------------------測驗介紹-----------------------------------------------//
	
	@RequestMapping(value = "/test-entery")//localhost:8080/test-entery
	public ModelAndView testEntery(HttpServletRequest request, HttpServletResponse response){  
		

		ModelAndView mav=new ModelAndView();  
		mav.setViewName("jsp/testEntery");//返回路径==>jsp  
		
		return mav;
	} 

	//---------------------------------------------測驗-----------------------------------------------//
	
	@RequestMapping(value = "/test")//localhost:8080/test
	public ModelAndView test(HttpServletRequest request, HttpServletResponse response){  
		
		ModelAndView mav=new ModelAndView();  
		mav.setViewName("jsp/test");//返回路径==>jsp  
		
		return mav;
	} 
	


}
