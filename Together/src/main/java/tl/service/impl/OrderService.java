package tl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tl.VO.DetailVO;
import tl.entity.TLOrder;
import tl.repository.OrderDetailRepository;
import tl.repository.OrderRepository;

@Service
public class OrderService {

@Autowired
private OrderRepository oRep;

@Autowired
private OrderDetailRepository odRep;

	public List<TLOrder> getOrderBySid(Integer sid) {
		List<TLOrder> list= oRep.findBySid(sid);
		if(!list.isEmpty()) {
		for(TLOrder o:list) {
			o.setOdetail(null);
		}
		return list;
		}else {
			return null;
		} 
	}
	
	public List<DetailVO> getOrderDetailByOid(Integer oid){
		List<DetailVO> list = odRep.findDetailByOid(oid);
		if(!list.isEmpty()) {
			return list;
		}else {
			return null;
		}
		
	}
}
