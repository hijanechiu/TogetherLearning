package tl.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Order {

	private Integer price;
	private String currency;
	private String method;
	private String intent;
	private String description;
	private String onekunit;
	private String fivekunit;
	private String tenkunit;
	
	
	
	public double getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getIntent() {
		return intent;
	}
	public void setIntent(String intent) {
		this.intent = intent;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getOnekunit() {
		return onekunit;
	}
	public void setOnekunit(String onekunit) {
		this.onekunit = onekunit;
	}
	public String getFivekunit() {
		return fivekunit;
	}
	public void setFivekunit(String fivekunit) {
		this.fivekunit = fivekunit;
	}
	public String getTenkunit() {
		return tenkunit;
	}
	public void setTenkunit(String tenkunit) {
		this.tenkunit = tenkunit;
	}

	
}
