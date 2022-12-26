package com.example.tour.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tour.auth.PrincipalUser;
import com.example.tour.model.FreeBoard;
import com.example.tour.model.FreeComment;
import com.example.tour.service.fCommentService;




@RestController
@RequestMapping("/reply/*")
public class fCommentController {
	@Autowired
	private fCommentService fcommentService;
	
	//?Œ“ê¸?ì¶”ê?
	@PostMapping("insert/{num}")
	public ResponseEntity<String> commentInsert(@PathVariable Long num, @RequestBody FreeComment freecomment, 
			@AuthenticationPrincipal PrincipalUser principal	) {
		FreeBoard f = new FreeBoard();
		f.setNum(num); //bnum
		freecomment.setFreeboard(f);
		///
//		PrincipalUser p =  (PrincipalUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		comment.setUser(p.getUser());
		
		freecomment.setMember(principal.getMember());
		
		fcommentService.insert(freecomment);
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}
	
	@GetMapping("list/{num}")
	public List<FreeComment> list(@PathVariable Long num){
		System.out.println("num : "+num);
		List<FreeComment> clist = fcommentService.list(num);
		return clist;
	}
	@DeleteMapping("del/{fcnum}")
	public Long delete(@PathVariable Long fcnum) {
		fcommentService.delete(fcnum);
		return fcnum;
	}
	
	

}
