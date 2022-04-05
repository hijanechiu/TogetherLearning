package tl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tl.entity.Coupon;
import tl.repository.CouponRepository;

@Service
public class CouponService {

	@Autowired
	private CouponRepository cRep;

	public List<Coupon> getCouponBySid(Integer sid){
		List<Coupon> list = cRep.findBySid(sid);
		if(!list.isEmpty()) {
		return list;
		}else{
		return null;
		}
	}






}
