package tl.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="Points")
@Component
public class Point {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="point_record_id")
	private Integer pointRecordId;
//	private int pointRecordId;

	@Column(name="student_id")
	private Integer sid;
//	private int studentId;
	
	@Column(name="point")
	private Integer points;
	
	@Column(name="changed_reason")
	private String changedReason;
	
	@Column(name="changed_time")//這邊資料表欄位跟汶珊不一樣
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "GMT+8")
	private Date changedTime;
//	private Date changedDate;

	public Integer getPointRecordId() {
		return pointRecordId;
	}

	public void setPointRecordId(Integer pointRecordId) {
		this.pointRecordId = pointRecordId;
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
		return "Point [pointRecordId=" + pointRecordId + ", sid=" + sid + ", points=" + points + ", changedReason="
				+ changedReason + ", changedTime=" + changedTime + "]";
	}

	

	
	


}
