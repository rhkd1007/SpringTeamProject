package com.example.tour.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.tour.auth.PrincipalUser;
import com.example.tour.model.TourBoard;




//@Controller
//@RequestMapping("/tour/*")
//public class BoardController {
	//@Autowired
	//private BoardService boardService;
	
	//추�??��
	//@GetMapping("insert")
	//@PreAuthorize("isAuthenticated()")
	//public String insert() {
	//	return "/tour/insert";
	//}
	//추�?
	//@PostMapping("insert")
	//public String insert(TourBoard board, @AuthenticationPrincipal PrincipalUser principal) {
	//	boardService.insert(board, principal.getMember());
	//	return "redirect:list";
	//}
	//게시�??��?��보기
//	@GetMapping("list")
//	public String list(Model model) {
//		model.addAttribute("count", boardService.count());
//		model.addAttribute("barr", boardService.findAll());
//		return "/board/list";
//	}
	
	//게시�??��?��보기:?��?���?===>?��?���? ?���? + data(게시�? ?���?)
//	@GetMapping("list")
//	public String list(Model model, @PageableDefault(size = 5 , sort = "num", direction = Direction.DESC)Pageable pageable) {
//		
//		Page<Board> lists =  boardService.findAll(pageable);
//		System.out.println("lists : "+lists);
//		model.addAttribute("count", boardService.count());
//		model.addAttribute("barr",lists);
//		return "/board/list";
//	}
	
	//게시�? ?��체보�? : ?��?���?+�??��

	
	
	
	
	

//}
