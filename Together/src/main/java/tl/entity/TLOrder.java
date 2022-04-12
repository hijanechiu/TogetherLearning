package tl.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(name="TLOrder")
@Component
public class TLOrder {
	
	@Id
	@Column(name = "order_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer oid;
	
	@Column(name = "student_id")
	private Integer sid;
	
	@Column(name = "order_time")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "GMT+8")
	private Date orderTime;
	
	@Column(name = "total_price")
	private Integer totalPrice;
	
	@OneToMany(cascade = CascadeType.PERSIST)
	@JoinColumn(name="order_id")
	private List<OrderDetail> odetail;

	public Integer getOid() {
		return oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public Integer getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}

	public List<OrderDetail> getOdetail() {
		return odetail;
	}

	public void setOdetail(List<OrderDetail> odetail) {
		this.odetail = odetail;
	}

	@Override
	public String toString() {
		return "TLOrder [oid=" + oid + ", sid=" + sid + ", orderTime=" + orderTime + ", totalPrice=" + totalPrice
				;
	}



}
