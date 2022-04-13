package tl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tl.entity.TestingSubjects;

public interface TestingSubjectsRepository extends JpaRepository<TestingSubjects, Integer>{

	public TestingSubjects findByTestingSubjectId(int testingSubjectId);
}
