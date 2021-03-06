package tl.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import tl.VO.JsonAcepter;
import tl.entity.CourseRecords;
import tl.entity.Courses;
import tl.entity.Point;
import tl.entity.Student;
import tl.entity.Subjects;
import tl.entity.Tutors;
import tl.repository.CourseRecordsRepository;
import tl.repository.CoursesRepository;
import tl.repository.SubjectsRepository;
import tl.repository.TutorsRepository;
import tl.service.impl.CourseRecordsService;
import tl.service.impl.PointService;
import tl.service.impl.StudentService;

@SessionAttributes(names={"sid"})
@Controller
public class ChooseCourseController extends BaseController{

	@Autowired
	CoursesRepository cRep;
	
	@Autowired
	TutorsRepository tRep;
	
	@Autowired
	SubjectsRepository sRep;
	
	@Autowired
	CourseRecordsRepository courRecoRep;
	
	
	@Autowired
	PointService pService;
	
	@Autowired
	StudentService stuService;
	
	@Autowired
	CourseRecordsService CourRecoService;

//==========================================================================================================//	
//                                                  ????????????                                                //
//==========================================================================================================//	
	//-------------------------------------------??????-----------------------------------------------//

	@RequestMapping(value = "/myschedule")//localhost:8080/myschedule
	public ModelAndView myschedule(HttpServletRequest request, HttpServletResponse response,@SessionAttribute Integer sid){  
		
		List<CourseRecords> courRecoDataList = CourRecoService.findByStudentIdOrderByCourseDateAsc(sid); //???CourseRecords??????????????????????????????
		
		for(CourseRecords c :courRecoDataList) {
			Courses course = cRep.findByCourseId(c.getCourseId());
			c.setCourses(course);
		}
		
		ModelAndView mav=new ModelAndView();  
		mav.setViewName("jsp/myschedule");//????????????==>jsp  
		mav.addObject("courRecoList", courRecoDataList);//??????ModelAndView???addObject?????????List<CourseRecords> courRecoDataList?????????  
		return mav;
	} 
	
	//----------------------------------------??????????????????---------------------------------------------//
	
	@RequestMapping(value = "/deleteCourseRecord")
	public String deleteCourseRecord(HttpServletRequest request, @RequestParam(value = "courseRecordId") int crId,
			@SessionAttribute Integer sid) { //session???sid
		
		CourRecoService.daleteCourseRecord(crId, sid);
		
		return "redirect:/myschedule";
	}
	
	
//==========================================================================================================//	
//                                                 ????????????                                                 //
//==========================================================================================================//		
	
	@RequestMapping(value = "/subjects")//localhost:8080/subjects
	public ModelAndView subjects(HttpServletRequest request, HttpServletResponse response){  
		
		List<Subjects> subjectDataList = sRep.findAll(); //???subject??????????????????????????????
		
		ModelAndView mav=new ModelAndView();  
		mav.setViewName("jsp/subjects");//????????????==>jsp  
		mav.addObject("subjectList", subjectDataList);//??????ModelAndView???addObject?????????List<Subjects> subjectList?????????  
		
		return mav;
	} 
	
	
//==========================================================================================================//	
//                                                 ?????????????????????                                            //
//==========================================================================================================//	

	
	@RequestMapping(value = "/courses")//localhost:8080/courses
	public ModelAndView courses(HttpServletRequest request, HttpServletResponse response , @RequestParam(value = "subjectId") int sId){  
		
		List<Courses> courseDataList = cRep.findBySubjectId(sId); //???course???????????????SubjectId????????????????????????
		Subjects subjects = sRep.findBySubjectId(sId);
		ModelAndView mav=new ModelAndView();  
		mav.setViewName("jsp/subTutors");//????????????==>jsp  
		mav.addObject("courseList", courseDataList);//??????ModelAndView???addObject?????????List<Subjects> subjectList?????????  
		mav.addObject("subjects", subjects);//??????ModelAndView???addObject?????????List<Subjects> subjectList?????????  
		
		return mav;
	} 
	
//==========================================================================================================//	
//                                            ?????????????????????????????????                                         //
//==========================================================================================================//	
	
//-------------????????????????????????Courses & tutors table ; ????????????????????????course_records table-------------//
	
	@RequestMapping(value = "/courseDetail")//localhost:8080/courseDetail
	public ModelAndView courseDetail(HttpServletRequest request, HttpServletResponse response ,
			@RequestParam(value = "courseId") int cId, @RequestParam(value = "reminder",required=false) String reminder){  
		
		Courses courses = cRep.findByCourseId(cId);
		Tutors tutors = tRep.findByTutorId(courses.getTutorId());//findByTutorId??????TutorId??????courses???getTutor_id()??????
		
	    ModelAndView mav=new ModelAndView();  
	    mav.setViewName("jsp/courseDetail"); //????????????==>jsp  
	    
	    mav.addObject("courses", courses); //??????ModelAndView???addObject?????????course?????????  
	    mav.addObject("tutors", tutors); //??????ModelAndView???addObject?????????tutors????????? ("tutors"==>key, tutors==>value) 
	    mav.addObject("reminder", reminder);
	    return mav;  
	} 
	
//-------------------------------------------????????????-----------------------------------------------//
	
	@RequestMapping(value = "/addCourseRecord",method = RequestMethod.POST)
	public ResponseEntity<String> addCourseRecord(@RequestBody JsonAcepter data,@SessionAttribute Integer sid) throws Exception{
		
		int cId = data.getCourseId();
		int subId = data.getSubjectId();
		int rPoints = data.getRequiredPoints();
		String tName = data.getTutorName();
		String cDate = data.getCourseDate();
		String cTime = data.getCourseTime();
		
		
		CourseRecords courReco = new CourseRecords();
		Point pointReco = new Point();
		Student student = stuService.findBySid(sid);
		Courses courses = cRep.findByCourseId(cId);
		
		String courseDate = cDate +" "+ cTime; 
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		
		CourseRecords courRecoCheckDateTime = courRecoRep.findByCourseIdAndCourseDate(cId, format.parse(courseDate));
		List<CourseRecords> courRecoCheckFirstCourse = courRecoRep.findBySubjectIdAndStudentId(subId, sid);
		
		int stuPoint = student.getStudentPoints();
		int courPoint = courses.getRequiredPoints();
		int negativeCourPoint = -courPoint;
		
		String reminder = null;
		Date changedDate = new Date();
		

		if(stuPoint < courPoint) {
			
			reminder = "????????????????????????????????????????????????????????????????????????";
			
		}else if(courRecoCheckDateTime != null) {
			
			reminder = "????????????????????????????????????????????????????????????";
		
		}else if(courRecoCheckFirstCourse.size() == 0 ) {
			
			reminder = "?????????????????????????????????????????????????????????????????????????????????????????????????????????????????????";
			
			//?????????
			student.setStudentPoints(stuPoint-courPoint);
			stuService.update(student);
			
			//??????????????????
			courReco.setCourseId(cId);
			courReco.setStudentId(sid);
			courReco.setSubjectId(subId);
			courReco.setCourseDate(format.parse(courseDate));
			courReco.setRequiredPoints(rPoints);
			courReco.setTutorName(tName);
			
			CourRecoService.insert(courReco);
			
			//????????????????????????
			pointReco.setSid(sid);
			pointReco.setPoints(negativeCourPoint);
			pointReco.setChangedReason("??????(????????????)");
			pointReco.setChangedTime(changedDate);
			
			pService.insert(pointReco);
			
			
			
		}else {
			reminder = "???????????????";
			
			//?????????
			student.setStudentPoints(stuPoint-courPoint);
			stuService.update(student);
			
			//??????????????????
			courReco.setCourseId(cId);
			courReco.setStudentId(sid);
			courReco.setSubjectId(subId);
			courReco.setCourseDate(format.parse(courseDate));
			courReco.setRequiredPoints(rPoints);
			courReco.setTutorName(tName);
			
			CourRecoService.insert(courReco);
			
			//????????????????????????
			pointReco.setSid(sid);
			pointReco.setPoints(negativeCourPoint);
			pointReco.setChangedReason("??????(????????????)");
			pointReco.setChangedTime(changedDate);
			
			pService.insert(pointReco);
			
		}
		return ResponseEntity.ok(reminder);
	}
	
}
	
	

