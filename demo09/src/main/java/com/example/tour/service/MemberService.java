package com.example.tour.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.tour.model.FreeBoard;
import com.example.tour.model.Member;
import com.example.tour.repository.MemberRepository;


@Service
public class MemberService {
	@Autowired
	private BCryptPasswordEncoder encoder; 
	
	@Autowired
	private MemberRepository mRepository;

	
	
	//占쎌돳占쎌뜚揶쏉옙占쎌뿯
	public void signup(Member member) {
		//�뜮袁⑥쓰 占쎈릊占쎌깈占쎌넅 占쎈뻻占쎄텕�⑨옙 �빊遺쏙옙
		String rawPassword = member.getPwd();
		String encPassword = encoder.encode(rawPassword);
		member.setPwd(encPassword); //占쎈릊占쎌깈占쎌넅 占쎈쭆 �뜮袁⑥쓰
		member.setRole("ROLE_USER");
		mRepository.save(member);
	}
	@Transactional
	public Member findById(Long num) {
		Member member = mRepository.findById(num).get();
		return member;
	}
	//�닔�젙==>�뜑�떚泥댄궧
	
		@Transactional
		public void update(Member member) {
			String rawPassword = member.getPwd();
			String encPassword = encoder.encode(rawPassword);
			member.setPwd(encPassword); //占쎈릊占쎌깈占쎌넅 占쎈쭆 �뜮袁⑥쓰
			Member b = mRepository.findById(member.getNum()).get();
			b.setId(member.getId());
			b.setUsername(member.getUsername());
			b.setPwd(member.getPwd());
			b.setEmail(member.getEmail());
			
		}
}
