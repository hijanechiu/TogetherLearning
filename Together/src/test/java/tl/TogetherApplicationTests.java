package tl;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tl.VO.DetailVO;
import tl.VO.TestItemVO;
import tl.entity.Contact;
import tl.entity.Coupon;
import tl.entity.CourseRecords;
import tl.entity.OrderDetail;
import tl.entity.Point;
import tl.entity.Student;
import tl.entity.Subscription;
import tl.entity.TLOrder;
import tl.repository.ContactRepository;
import tl.repository.CouponRepository;
import tl.repository.OrderDetailRepository;
import tl.repository.OrderRepository;
import tl.repository.SubcriptionRepository;
import tl.repository.TestItemRepository;
import tl.service.impl.ContactService;
import tl.service.impl.CourseRecordsService;
import tl.service.impl.EmailSenderService;
import tl.service.impl.PointService;
import tl.service.impl.StudentService;
import tl.service.impl.SubScriptionService;

@SpringBootTest
class TogetherApplicationTests {

//	@Test
//	void contextLoads() {
//	}

	@Autowired
	private StudentService sService;
	
	
//	@Test 註冊測試成功
	void saveStudent() {
		Student student=new Student();
		
		student.setAccount("test123");
		student.setPassword("test123");
		sService.Register(student);
	}

//	@Test 成功跳出錯誤:該帳號已被註冊
	void saveStudentAccountDuplicated() {
		Student student=new Student();
		
		student.setAccount("test123");
		student.setPassword("test123");
		sService.Register(student);
	}
	
//	@Test  成功登入,失敗則跳出密碼錯誤 
//	void login() {
//		String account="test123";
//		String password="test123";
//		Student stu=sService.login(account, password);
//		System.out.println(stu);
//	}
	
	@Test
	void updateResetPasswordToken() {
	}
	
	
	@Autowired
	private OrderRepository oResp;
	
	@Test
	void oneToMany() {
		
		OrderDetail od=new OrderDetail();
		od.setQuantity(55);
		od.setPid(2);
		OrderDetail od2=new OrderDetail();
		od.setQuantity(100);
		od.setPid(50);
		
		List<OrderDetail> list=new ArrayList<>();
		list.add(new OrderDetail(50, 100));
		list.add(new OrderDetail(150, 200));
		
		TLOrder order=new TLOrder();
		order.setOrderTime(new Date());
		order.setOdetail(list);
		oResp.save(order);
		
	}
	
	@Test
	void updateInfo() {
		Student s=new Student();
		s.setEmail("dddaaaH");
		s.setPhone("8123456");
		sService.changeInfo(5,"管理員",s);
	}
	@Test
	void changepwd() {
		sService.changepwd(6, "Jane", "123", "321");
	}
	
	@Test
	void findOrderBySid() {
		List<TLOrder> list = oResp.findBySid(5);
		for(TLOrder o:list) {
		System.out.println(o);
		}
		
	}
	
//	@Test
//	void test() {
//		List<DetailVO> list = odRep.findDetailByOrderID(12);
//		System.out.println(list);
//		
//	}
	
	@Autowired
	private CouponRepository cRep;
	
	@Test
	void findCouponBySid() {
		List<Coupon>list=cRep.findBySid(4);
		if(!list.isEmpty())
		System.out.println(list);
	}
	
	@Autowired
	private PointService pService;
	
	@Test
	void findPointBySid() {
		List<Point> list = pService.getPointBySid(5);
		System.out.println(list);
	}
	
	@Autowired 
	private TestItemRepository tRep;
	
	@Test
	void findDetailBySid() {
		List<TestItemVO> list=tRep.findDetailBySid(5);
		System.out.println(list);
	}
	
	@Autowired
	private OrderDetailRepository odRep;
	
	@Test
	void findOrderDetailByOid() {
		List<DetailVO> list = odRep.findDetailByOid(12);
		System.out.println(list);
	}
	
	@Autowired
	private SubcriptionRepository subRep;
	
	@Test
	void insertSubscription() {
		Subscription sub=new Subscription();
		sub.setEmail("abc@gamil");
		sub.setSendTime(new Date());
		sub.setSubscribeTime(new Date());
		subRep.save(sub);
	}
	
	@Autowired
	private SubScriptionService subService;
	
	@Test
	void sendEmail() {
		String mail="hijanechiu@gmail.com";
		subService.SendSubcriptionMail(mail);
	}
	
	@Test
	void findSubscriptor() {
	Subscription subtor = subRep.findByEmail("hijanechiu@gmail.com");
	System.out.println(subtor);
	}
	
	@Autowired
	private ContactRepository conRep;
	
	@Test
	void savecontact() {
		Contact contact=new Contact();
		contact.setContactName("JAE");
		contact.setEmail("123");
		contact.setSubject("ABC");
		contact.setMessage("123123");
		contact.setSendTime(new Date());
		Contact save = conRep.save(contact);
		System.out.println(save.getContactId());
	}
	
	@Autowired
	private ContactService conService;
	
	@Test
	void contactReply() {
		Contact contact=new Contact();
		contact.setContactName("JAE");
		contact.setEmail("hijanechiu@gmail.com");
		contact.setSubject("ABC");
		contact.setMessage("123123");
		conService.ContactReply(contact);
		
	}
	
	@Autowired
	private CourseRecordsService courService;
	
	@Test
	void saveCourse() { //沒有課程資料
		CourseRecords c=new CourseRecords();
		c.setRequiredPoints(100);
		c.setStudentId(6);
		c.setTutorName("BANANA");
		c.setCourseId(1);
		c.setCourseDate(new Date());
		courService.insert(c);
	}

	
}
