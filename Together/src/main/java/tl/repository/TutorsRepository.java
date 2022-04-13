package tl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tl.entity.Tutors;

public interface TutorsRepository extends JpaRepository<Tutors, Integer>{
	
	public Tutors findByTutorId(int TutorId);
	

}
