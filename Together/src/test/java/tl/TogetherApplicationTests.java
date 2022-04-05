package tl;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tl.VO.DetailVO;
import tl.VO.TestItemVO;
import tl.entity.Coupon;
import tl.entity.OrderDetail;
import tl.entity.Point;
import tl.entity.Student;
import tl.entity.TLOrder;
import tl.repository.CouponRepository;
import tl.repository.OrderDetailRepository;
import tl.repository.OrderRepository;
import tl.repository.TestItemRepository;
import tl.service.impl.PointService;
import tl.service.impl.StudentService;

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
		List<TLOrder> list = oResp.findBySid(6);
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
	
}
