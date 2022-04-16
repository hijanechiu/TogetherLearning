package tl.controller;

import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import ecpay.payment.integration.AllInOne;
import tl.entity.Dict;
import tl.entity.Point;
import tl.entity.Student;
import tl.service.impl.PointService;
import tl.service.impl.StudentService;
import tl.service.impl.dictService;

//本控制器用以接收付款者在付款成功後，從用戶端回傳的付款結果。
@Controller
public class MyController3 {
	@Autowired
	private dictService dService;
	
	@Autowired
	private StudentService sService;
	
	@Autowired
	private PointService poiService;
	
	
	
	public static AllInOne all = new AllInOne("");	
	
	
	//【ECPayServer.java】obj.setClientBackURL("http://localhost:8080/ecpay/ECPayServer3");
	//綠界付款成功畫面會增加「返回商店」按鈕，消費者點選此按鈕後，會將頁面導回到此設定的網址
	//(注意：導回時不會帶付款結果到此網址，只是將頁面(以GET方法)導回而已。)	
	@GetMapping(value="/ecpay/ECPayServer3")  
	 public String processPaymentResult() { 
		return  "th/success"; 
	}	 
	
	//【ECPayServer.java】obj.setOrderResultURL("http://localhost:8080/ecpay/ECPayServer3"); 
	//當消費者付款完成後，綠界會將付款結果參數以幕前(Client POST)回傳到該網址。			
	//若與[ClientBackURL]同時設定，將會以此參數為主。
	@PostMapping(value="/ecpay/ECPayServer3",  produces="text/html;charset=utf-8") //預設response的字元編碼為ISO-8859-1
	
	public String processPaymentResult2(HttpServletRequest request) {		
		Hashtable<String, String> dict = new Hashtable<String, String>();
		Enumeration<String> enumeration = request.getParameterNames();
		while(enumeration.hasMoreElements()) {
			String paramName = enumeration.nextElement();
			String paramValue = request.getParameter(paramName);
			dict.put(paramName, paramValue);			
		}
		System.out.printf("【ECPayServer3.java】用戶端付款成功後回傳「付款結果」通知給伺服端的參數們：\n%s\n", dict.toString());
		//輸出範例：
		//【ECPayServer3.java】用戶端付款成功後回傳「付款結果」通知給伺服端的參數們：
		//{CheckMacValue=028D288F5CB566EB1FA5E204FA46B6FC68AB3ED68EC12AE17E561A6A9AF885F5, 
		//TradeDate=2021/08/31 11:09:08, TradeNo=2108311109087900, MerchantID=2000132, 
		//PaymentTypeChargeFee=21, PaymentType=Credit_CreditCard, TradeAmt=1050, RtnMsg=Succeeded, StoreID=, CustomField4=, 
		//MerchantTradeNo=III1630379348465, CustomField3=, 
		//PaymentDate=2021/08/31 11:10:23, SimulatePaid=0, CustomField2=, CustomField1=, RtnCode=1}

		boolean checkStatus = all.compareCheckMacValue(dict); //true：表示資料未被竄改
		//消費者付款成功且檢查碼正確的時候：	(RtnCode:交易狀態(1:成功，其餘為失敗))	
		if ("1".equals(dict.get("RtnCode")) && checkStatus==true ){
			//---------------------------//
			Dict dict1=new Dict();
			dict1.setCheckMacValue(dict.get("CheckMacValue"));
			dict1.setTradeDate(dict.get("TradeDate"));
			dict1.setTradeNo(dict.get("TradeNo"));
			dict1.setMerchantID(dict.get("MerchantID"));
			dict1.setPaymentTypeChargeFee(dict.get("PaymentTypeChargeFee"));
			dict1.setPaymentType(dict.get("PaymentType"));
			dict1.setTradeAmt(dict.get("TradeAmt"));
			dict1.setRtnMsg(dict.get("RtnMsg"));
			dict1.setStoreID(dict.get("StoreID"));
			dict1.setCustomField4(dict.get("CustomField4"));
			dict1.setMerchantTradeNo(dict.get("MerchantTradeNo"));
			dict1.setCustomField3(dict.get("CustomField3"));
			dict1.setPaymentDate(dict.get("PaymentDate"));
			dict1.setSimulatePaid(dict.get("SimulatePaid"));
			dict1.setCustomField2(dict.get("CustomField2"));
			dict1.setCustomField1(dict.get("CustomField1")); //學生id
			dict1.setRtnCode(dict.get("RtnCode"));
			dService.insert(dict1);
			
			Integer sid=Integer.parseInt(dict.get("CustomField1"));
			
			Student student=sService.findBySid(sid);
			int stuPoint = student.getStudentPoints();
			student.setStudentPoints(stuPoint+Integer.parseInt(dict.get("TradeAmt")));
			sService.update(student);
			
			Point point1=new Point(); //創建一個新point
            point1.setSid(sid); //抓session的sid
            point1.setPoints(Integer.parseInt(dict.get("TradeAmt")));  //設置異動點數
            point1.setChangedReason("點數購買");  //設置異動原因
            point1.setChangedTime(new Date());  
            poiService.insert(point1);
            
			
			//---------------------------//
			//回應用戶端(付款者)
			return "th/success";			 
		}
		else
			return "th/failed";	
	}
}
