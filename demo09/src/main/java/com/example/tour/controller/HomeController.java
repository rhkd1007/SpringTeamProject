package com.example.tour.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.tour.model.FreeBoard;
import com.example.tour.model.NoticeBoard;
import com.example.tour.service.FreeboardService;
import com.example.tour.service.NoticeService;



@Controller
public class HomeController {
	@Autowired
	private FreeboardService fserService;
	@Autowired
	private NoticeService nserService;
	
	@GetMapping("/")
	public String home(Model model, @Qualifier("FreeBoard") @PageableDefault(size = 5, sort = "num", direction = Direction.DESC)Pageable  pageable,
			@RequestParam(required = false, defaultValue = "")String field,
			@RequestParam(required = false, defaultValue = "")String word,
			@Qualifier("NoticeBoard") @PageableDefault(size = 5, sort = "nbnum", direction = Direction.DESC)Pageable  npageable,
			@RequestParam(required = false, defaultValue = "")String nfield,
			@RequestParam(required = false, defaultValue = "")String nword) {
			  Page<FreeBoard> lists = fserService.findAll(field, word, pageable);
			  Page<NoticeBoard> nlists = nserService.nfindAll(nfield, nword, npageable);
			  model.addAttribute("nboards", nlists);
			  model.addAttribute("boards", lists);
		return "index";
	}	
	
	@GetMapping("gijang")
	public String gijang() {
		return "gijang";
	}
	
	
	
	
}






