package tl.VO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
public class DetailVO {

	@Id
	@Column(name="detail_id")
	private Integer did;
	
	@Column(name="product_point")
	private Integer productPoint;
	
	@Column(name="unit_price")
	private Integer unitPrice;
	
	@Column(name="quantity")
	private Integer quantity;
	
	@Column(name="coupon_id")
	private Integer couponId;
	
	private Float discount;

	public Integer getDid() {
		return did;
	}

	public void setDid(Integer did) {
		this.did = did;
	}

	public Integer getProductPoint() {
		return productPoint;
	}

	public void setProductPoint(Integer productPoint) {
		this.productPoint = productPoint;
	}

	public Integer getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Integer unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getCouponId() {
		return couponId;
	}

	public void setCouponId(Integer couponId) {
		this.couponId = couponId;
	}

	public Float getDiscount() {
		return discount;
	}

	public void setDiscount(Float discount) {
		this.discount = discount;
	}

	@Override
	public String toString() {
		return "DetailVO [did=" + did + ", productPoint=" + productPoint + ", unitPrice=" + unitPrice + ", quantity="
				+ quantity + ", couponId=" + couponId + ", discount=" + discount + "]";
	}


}
