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

    
    

  
}