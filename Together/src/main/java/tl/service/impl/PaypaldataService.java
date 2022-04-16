package tl.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tl.entity.Paypaldata;
import tl.repository.PaypalRepository;

@Service
@Transactional
public class PaypaldataService {
	
	@Autowired
	private  PaypalRepository pRepo;
	
	public Paypaldata insert (Paypaldata paypaldata ) {
		return pRepo.save(paypaldata);
	}
	

}
