package tl.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity @Table(name = "dict" )
@Component
public class Dict {
	
	@Id@Column(name="dictnumber")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int    dictNumber;
	
	@Column(name="checkmacvalue")
	private String checkMacValue;
	
	@Column(name="tradedate")
	private String tradeDate;
	
	@Column(name="tradeno")
	private String tradeNo;
	
	@Column(name="merchantid")
	private String merchantID;
	
	@Column(name="paymenttypechargefee")
	private String paymentTypeChargeFee;
	
	@Column(name="paymenttype")
	private String paymentType;
	
	@Column(name="tradeamt")
	private String tradeAmt;
	
	@Column(name="rtnmsg")
	private String rtnMsg;
	
	@Column(name="storeid")
	private String storeID;
	
	@Column(name="customfield4")
	private String customField4;
	
	@Column(name="merchanttradeno")
	private String merchantTradeNo;
	
	@Column(name="customfield3")
	private String customField3;
	
	@Column(name="paymentdate")
	private String paymentDate;
	
	@Column(name="simulatepaid")
	private String simulatePaid;
	
	@Column(name="customfield2")
	private String customField2;
	
	@Column(name="customfield1")
	private String customField1;
	
	@Column(name="rtncode")
	private String rtnCode;
	
	

	public int getDictNumber() {
		return dictNumber;
	}

	public void setDictNumber(int dictNumber) {
		this.dictNumber = dictNumber;
	}

	public String getCheckMacValue() {
		return checkMacValue;
	}

	public void setCheckMacValue(String checkMacValue) {
		this.checkMacValue = checkMacValue;
	}

	public String getTradeDate() {
		return tradeDate;
	}

	public void setTradeDate(String tradeDate) {
		this.tradeDate = tradeDate;
	}

	public String getTradeNo() {
		return tradeNo;
	}

	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}

	public String getMerchantID() {
		return merchantID;
	}

	public void setMerchantID(String merchantID) {
		this.merchantID = merchantID;
	}

	public String getPaymentTypeChargeFee() {
		return paymentTypeChargeFee;
	}

	public void setPaymentTypeChargeFee(String paymentTypeChargeFee) {
		this.paymentTypeChargeFee = paymentTypeChargeFee;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getTradeAmt() {
		return tradeAmt;
	}

	public void setTradeAmt(String tradeAmt) {
		this.tradeAmt = tradeAmt;
	}

	public String getRtnMsg() {
		return rtnMsg;
	}

	public void setRtnMsg(String rtnMsg) {
		this.rtnMsg = rtnMsg;
	}

	public String getStoreID() {
		return storeID;
	}

	public void setStoreID(String storeID) {
		this.storeID = storeID;
	}

	public String getCustomField4() {
		return customField4;
	}

	public void setCustomField4(String customField4) {
		this.customField4 = customField4;
	}

	public String getMerchantTradeNo() {
		return merchantTradeNo;
	}

	public void setMerchantTradeNo(String merchantTradeNo) {
		this.merchantTradeNo = merchantTradeNo;
	}

	public String getCustomField3() {
		return customField3;
	}

	public void setCustomField3(String customField3) {
		this.customField3 = customField3;
	}

	public String getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getSimulatePaid() {
		return simulatePaid;
	}

	public void setSimulatePaid(String simulatePaid) {
		this.simulatePaid = simulatePaid;
	}

	public String getCustomField2() {
		return customField2;
	}

	public void setCustomField2(String customField2) {
		this.customField2 = customField2;
	}

	public String getCustomField1() {
		return customField1;
	}

	public void setCustomField1(String customField1) {
		this.customField1 = customField1;
	}

	public String getRtnCode() {
		return rtnCode;
	}

	public void setRtnCode(String rtnCode) {
		this.rtnCode = rtnCode;
	}

	
	

	
	
}