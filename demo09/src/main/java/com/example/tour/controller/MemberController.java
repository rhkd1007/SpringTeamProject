package com.example.tour.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.tour.model.FreeBoard;
import com.example.tour.model.Member;
import com.example.tour.repository.MemberRepository;
import com.example.tour.service.MemberService;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	@Autowired
	private MemberService mservice;
	@Autowired
	private MemberRepository mRepository;
	
	@GetMapping("signup")
	public String signup() {
		return "/member/signup";
	}
	@PostMapping("signup")
	@ResponseBody
	public String signup(@RequestBody Member member) {
		if(mRepository.findByUsername(member.getUsername())!=null) {
			return "fail";
		}
		mservice.signup(member);
		return "success";
	}
	
	@GetMapping("login")
	public String login() {
		return "/member/login";
	}
	@GetMapping("update/{num}")
	public String update(@PathVariable Long num, Model model) {
		model.addAttribute("member", mservice.findById(num));
		return "/member/userUpdate";
	}		
	@PutMapping("update")
			@ResponseBody
			public String update(@RequestBody Member member) {
				mservice.update(member);
				return "success";
			}

			
}
