package tl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tl.VO.TestItemVO;
import tl.repository.TestItemRepository;

@Service
public class TestService {

	@Autowired
	private TestItemRepository tResp;
	
	public List<TestItemVO> getTestListBySid(Integer sid){
		List<TestItemVO> list = tResp.findDetailBySid(sid);
		if(!list.isEmpty()) {
			return list;
		}else {
			return null;
		}
	}
}
