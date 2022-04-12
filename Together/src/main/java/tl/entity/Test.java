package tl.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="studenttest")
@Component
public class Test {
	
	@Id
	@Column(name="test_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer tid;
	
	@Column(name="student_id")
	private Integer sid;
	
	@Column(name="item_id")
	private Integer iid;
	
	@Column(name="grade")
	private Integer grade;
	
	@Column(name="test_time")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "GMT+8")
	private Date testTime;
	

	public Integer getTid() {
		return tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public Integer getIid() {
		return iid;
	}

	public void setIid(Integer iid) {
		this.iid = iid;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public Date getTestTime() {
		return testTime;
	}

	public void setTestTime(Date testTime) {
		this.testTime = testTime;
	}

	@Override
	public String toString() {
		return "Test [tid=" + tid + ", sid=" + sid + ", iid=" + iid + ", grade=" + grade + ", testTime=" + testTime
				+ "]";
	}
}
