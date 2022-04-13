package tl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tl.entity.Courses;

public interface CoursesRepository extends JpaRepository<Courses, Integer>{

	public Courses findByCourseId(int courseId); //courseId為主鍵，因此只會有一筆

	public List<Courses> findBySubjectId(int subjectId); //subjectId有多筆，因此要用list裝起來


}
