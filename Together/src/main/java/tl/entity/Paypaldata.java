package tl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity@Table(name="dict")
@Component
public class Paypaldata {
	
	@Id@Column(name="dictnumber")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int paypalnumber;
	
	@Column(name="customfield1")
	private String customfield1;
	
	@Column(name="tradedate")
	private String tradedate;
	
	@Column(name="tradeno")
    private String tradeno;
	
	@Column(name="tradeamt")
    private String tradeamt;
	
	@Column(name="rtncode")
    private String rtncode;
	
	@Column(name="customfield4")
	private String customField4;
	
	@Column(name="customfield3")
	private String customField3;
	
	@Column(name="customfield2")
	private String customField2;
    
    
	public int getPaypalnumber() {
		return paypalnumber;
	}
	public void setPaypalnumber(int paypalnumber) {
		this.paypalnumber = paypalnumber;
	}
	public String getCustomfield1() {
		return customfield1;
	}
	public void setCustomfield1(String customfield1) {
		this.customfield1 = customfield1;
	}
	public String getTradedate() {
		return tradedate;
	}
	public void setTradedate(String tradedate) {
		this.tradedate = tradedate;
	}
	public String getTradeno() {
		return tradeno;
	}
	public void setTradeno(String tradeno) {
		this.tradeno = tradeno;
	}
	public String getTradeamt() {
		return tradeamt;
	}
	public void setTradeamt(String tradeamt) {
		this.tradeamt = tradeamt;
	}
	public String getRtncode() {
		return rtncode;
	}
	public void setRtncode(String rtncode) {
		this.rtncode = rtncode;
	}
	public String getCustomField4() {
		return customField4;
	}
	public void setCustomField4(String customField4) {
		this.customField4 = customField4;
	}
	public String getCustomField3() {
		return customField3;
	}
	public void setCustomField3(String customField3) {
		this.customField3 = customField3;
	}
	public String getCustomField2() {
		return customField2;
	}
	public void setCustomField2(String customField2) {
		this.customField2 = customField2;
	}

    
    

  
}