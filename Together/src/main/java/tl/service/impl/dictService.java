package tl.service.impl;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tl.entity.Dict;
import tl.repository.dictRepository;



@Service
@Transactional
public class dictService {
	
	@Autowired
	private dictRepository dRepo;
	

	
	public Dict insert(Dict dict) {
		return dRepo.save(dict);
		
	}
	
	public Dict findById(String customfield1) {
		Optional<Dict> op = dRepo.findById(customfield1);
		
		if(op.isPresent()) {
			return op.get();
		}
		
		return null;
	}
	
	public List<Dict> findAll(){
		return dRepo.findAll();
	}
	
	
	/*
	 * public Page<Dict> findAllByPage(Pageable pageable){ return
	 * dRepo.findAll(pageable); }
	 */
	
	//測試
	
	
		
	

	
	
	
	
}
