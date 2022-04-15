package tl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tl.entity.Test;
import tl.repository.StudentTestRepository;

@Service
public class StudentTestService {

	@Autowired
	private StudentTestRepository repository;
	
	public void insert(Test item) {
		repository.save(item);}
	
	
}
