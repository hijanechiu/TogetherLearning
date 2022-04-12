package tl.entity;


import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Table(name="Student")
@Entity
@Component
public class Student extends BaseEntity {
	
	@Id
	@Column(name="student_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer sid;
	
	@Column(name="account")
	private String account;
	
	@Column(name="password")
	private String password; 
	
	@Column(name="student_name")
	private String name;
	
	@Column(name="birth")
	private Date birth;

	@Column(name="phone")
	private String phone;
	
	@Column(name="email")
	private String email;
	
	@Column(name="student_gender")
	private Integer gender; //0為男1為女
	
	@Column(name="point")
	private Integer point;
	
	@Column(name="reset_password_token")
	private String resetPasswordToken;
	
	@Enumerated(EnumType.STRING)
	@Column(name="auth_provider")
	private AuthenticationProvider authenticationProvider;

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public Integer getPoint() {
		return point;
	}

	public void setPoint(Integer point) {
		this.point = point;
	}

	public String getResetPasswordToken() {
		return resetPasswordToken;
	}

	public void setResetPasswordToken(String resetPasswordToken) {
		this.resetPasswordToken = resetPasswordToken;
	}

	public AuthenticationProvider getAuthenticationProvider() {
		return authenticationProvider;
	}

	public void setAuthenticationProvider(AuthenticationProvider authenticationProvider) {
		this.authenticationProvider = authenticationProvider;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", account=" + account + ", password=" + password + ", name=" + name + ", birth="
				+ birth + ", phone=" + phone + ", email=" + email + ", gender=" + gender + ", point=" + point
				+ ", resetPasswordToken=" + resetPasswordToken + ", authenticationProvider=" + authenticationProvider
				+ "]";
	}

	
	
}
