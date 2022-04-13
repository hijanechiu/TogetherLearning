package tl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tl.entity.Subjects;

public interface SubjectsRepository extends JpaRepository<Subjects, Integer>{
	
	public Subjects findBySubjectId(int SubjectId);
	

}
