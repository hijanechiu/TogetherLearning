package tl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tl.entity.Point;
import tl.repository.PointRepository;

@Service
public class PointService {

	@Autowired
	private PointRepository pResp;
	
	public List<Point> getPointBySid(Integer sid){
		List<Point> list = pResp.findBySid(sid);
		if(!list.isEmpty()) {
		return list;
		}else{
		return null;
		}
	}
	
	
	
}
