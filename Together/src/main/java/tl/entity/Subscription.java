package tl.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="Subscription")
@Component
public class Subscription {

	@Id
	@Column(name="subscriber_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer subscriberId;
	
	@Column(name="email")
	private String email;
	
	@Column(name="subscribe_time")
	private Date subscribeTime;
	
	@Column(name="send_time")
	private Date sendTime;



	public Integer getSubscriberId() {
		return subscriberId;
	}



	public void setSubscriberId(Integer subscriberId) {
		this.subscriberId = subscriberId;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public Date getSubscribeTime() {
		return subscribeTime;
	}



	public void setSubscribeTime(Date subscribeTime) {
		this.subscribeTime = subscribeTime;
	}



	public Date getSendTime() {
		return sendTime;
	}



	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}



	@Override
	public String toString() {
		return "Subscription [subscriberId=" + subscriberId + ", email=" + email + ", subscribeTime=" + subscribeTime
				+ ", send_time=" + sendTime + "]";
	}
	
	
}
