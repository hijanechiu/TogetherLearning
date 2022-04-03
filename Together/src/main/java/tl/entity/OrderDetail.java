package tl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;


@Entity
@Table(name="orderdetail")
@Component
public class OrderDetail {

	@Id
	@Column(name = "detail_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer did;
	
	@Column(name = "product_id")
	private Integer pid;
	
	@Column(name = "quantity")
	private Integer quantity;
	
	@Column(name = "unit_price")
	private Integer unitPrice;
	
	@Column(name = "coupon_id")
	private Integer cid;
	
	@Column(name = "discount")
	private Float discount;
	
	@Transient
	private int oid;
	
	@ManyToOne
	@JoinColumn(name = "order_id")
	private TLOrder order;

	public OrderDetail(Integer quantity, Integer unitPrice) {
		this.quantity = quantity;
		this.unitPrice = unitPrice;
	}
	
	public OrderDetail() {
		
	}

	public Integer getOid() {
		return oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Integer unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public Float getDiscount() {
		return discount;
	}

	public void setDiscount(Float discount) {
		this.discount = discount;
	}

	public TLOrder getOrder() {
		return order;
	}

	public void setOrder(TLOrder order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "OrderDetail [oid=" + oid + ", pid=" + pid + ", quantity=" + quantity + ", unitPrice=" + unitPrice
				+ ", cid=" + cid + ", discount=" + discount + ", order=" + order + "]";
	}
	
	
}
