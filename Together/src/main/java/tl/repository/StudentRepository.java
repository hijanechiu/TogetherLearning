package tl.repository;


import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import tl.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	public Student findByAccount(String account);
	
	public Student findByEmail(String email);
	
	public Student findByResetPasswordToken(String token);
	
	@Transactional
	@Modifying
	@Query("update Student set phone=?1,email=?2,modified_user=?3,modified_time=?4 where sid=?5")
	public Integer updateInfo(String phone,String email,String modifiedUser,Date modifiedTime,Integer id);

	@Transactional
	@Modifying
	@Query("update Student set password=?1,modified_user=?2,modified_time=?3 where sid=?4")
	public Integer changePassword(String password,String modifiedUser,Date modifiedTime,Integer sid);
	


}
