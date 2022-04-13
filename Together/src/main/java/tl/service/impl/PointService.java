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
	
	//查看點數異動紀錄
	public List<Point> getPointBySid(Integer sid){
		List<Point> list = pResp.findBySid(sid);
		if(!list.isEmpty()) {
		return list;
		}else{
		return null;
		}
	}
	
	//--------------------------------------新增點數異動紀錄(汶珊)-------------------------------------------	
	public Point insert(Point points) {
		return pResp.save(points);		
	}
	
	
}
