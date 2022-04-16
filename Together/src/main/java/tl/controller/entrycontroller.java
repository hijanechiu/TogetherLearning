package tl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import tl.entity.Dict;
import tl.repository.dictRepository;
import tl.service.impl.dictService;

@Controller
@SessionAttributes(names = {"totalPages", "totalElements","sid"})
public class entrycontroller {
	
	
	
	@Autowired
	private dictService DictService;
	
	@Autowired
	private dictRepository DictRepository;
	
	//購買點數頁面 
	@GetMapping("/buycarOrderProduct")
	public String processAction() {
		return "jsp/buycarOrderProduct";
	}
	
	//訂單明細頁面
		@GetMapping("/buycarOrderquerymainaction") 
		public String processQueryMainAction() {
			return "jsp/buycarOrderProductList";
		}
	
		
		@PostMapping("/queryByPage/{pageNo}")
		@ResponseBody
		public List<Dict> processQueryAllByPageAction(@PathVariable("pageNo") int pageNo, Model m,@SessionAttribute Integer sid){
			int pageSize = 10;		
			Pageable pageable = PageRequest.of(pageNo-1, pageSize);		
			String customField11 = Integer.toString(sid);//引入特定學生id
			Page<Dict> page = DictRepository.findBycustomField1(pageable,customField11);
			m.addAttribute("totalPages", page.getTotalPages());
			m.addAttribute("totalElements", page.getTotalElements());
			
			return page.getContent();
		}
	
}
