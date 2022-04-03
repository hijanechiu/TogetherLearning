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
	@Column(name="Points")
	private Integer pid;

	@Column(name="student_id")
	private Integer sid;
	@Column(name="point")
	private Integer points;
	@Column(name="changed_reason")
	private String changedReasion;
	@Column(name="changed_date")
	private Date changedTime;


}
