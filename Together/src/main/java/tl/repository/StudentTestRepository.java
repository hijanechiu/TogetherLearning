package tl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tl.entity.Test;

public interface StudentTestRepository extends JpaRepository<Test, Integer>{

}
