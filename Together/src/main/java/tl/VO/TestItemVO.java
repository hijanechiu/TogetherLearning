package tl.VO;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
public class TestItemVO {
	

	@Id
	@Column(name="test_id")
	private Integer tid;
	
	private Integer grade;
	
	@Column(name="item_title")
	private String itemTitle;
	
	@Column(name="test_time")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "GMT+8")
	private Date testTime;

	public Integer getTid() {
		return tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public String getItemTitle() {
		return itemTitle;
	}

	public void setItemTitle(String itemTitle) {
		this.itemTitle = itemTitle;
	}

	public Date getTestTime() {
		return testTime;
	}

	public void setTestTime(Date testTime) {
		this.testTime = testTime;
	}

	@Override
	public String toString() {
		return "TestItemVO [tid=" + tid + ", grade=" + grade + ", itemTitle=" + itemTitle + ", testTime=" + testTime
				+ "]";
	}
	





}