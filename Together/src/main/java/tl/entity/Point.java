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
@Table(name="Points")
@Component
public class Point {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="point_record_id")
	private Integer pid;

	@Column(name="student_id")
	private Integer sid;
	@Column(name="point")
	private Integer points;
	@Column(name="changed_reason")
	private String changedReason;
	@Column(name="changed_time")
	private Date changedTime;
	
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public Integer getPoints() {
		return points;
	}
	public void setPoints(Integer points) {
		this.points = points;
	}
	public String getChangedReason() {
		return changedReason;
	}
	public void setChangedReason(String changedReason) {
		this.changedReason = changedReason;
	}
	public Date getChangedTime() {
		return changedTime;
	}
	public void setChangedTime(Date changedTime) {
		this.changedTime = changedTime;
	}
	@Override
	public String toString() {
		return "Point [pid=" + pid + ", sid=" + sid + ", points=" + points + ", changedReason=" + changedReason
				+ ", changedTime=" + changedTime + "]";
	}


}
