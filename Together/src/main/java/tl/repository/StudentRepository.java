package tl.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import tl.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	public Student findByAccount(String account);

}
