package tl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity	@Table(name = "testing_subjects")
@Component
public class TestingSubjects {

	@Id @Column(name = "TESTINGSUBJECT_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int testingSubjectId;
	
	@Column(name = "TESTINGSUBJECT")
	private String testingSubject;
	
	@Column(name = "TESTINGSUBJECT_PHOTO")
	private String testingSubjectPhoto;

	
	@Column(name = "TESTINGSUBJECT_INTRO_CONTENTS")
	private String testingSubjectIntroContents;


	public int getTestingSubjectId() {
		return testingSubjectId;
	}


	public void setTestingSubjectId(int testingSubjectId) {
		this.testingSubjectId = testingSubjectId;
	}


	public String getTestingSubject() {
		return testingSubject;
	}


	public void setTestingSubject(String testingSubject) {
		this.testingSubject = testingSubject;
	}


	public String getTestingSubjectPhoto() {
		return testingSubjectPhoto;
	}


	public void setTestingSubjectPhoto(String testingSubjectPhoto) {
		this.testingSubjectPhoto = testingSubjectPhoto;
	}


	public String getTestingSubjectIntroContents() {
		return testingSubjectIntroContents;
	}


	public void setTestingSubjectIntroContents(String testingSubjectIntroContents) {
		this.testingSubjectIntroContents = testingSubjectIntroContents;
	}
	
	
	
}
