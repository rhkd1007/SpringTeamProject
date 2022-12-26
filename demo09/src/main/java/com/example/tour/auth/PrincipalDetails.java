package com.example.tour.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.tour.model.Member;
import com.example.tour.repository.MemberRepository;

@Service
public class PrincipalDetails implements UserDetailsService {
	@Autowired
	private MemberRepository mRepository;

	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	   System.out.println("loadUserByUsername");
	   Member member =   mRepository.findByUsername(username);
	  if(member ==null) return null;
	  // �쉶�썝�씠�씪硫� �떆�걧由ы떚媛� �쟻�슜�릺 User 由ы꽩
	  PrincipalUser puser = new PrincipalUser(member);
	  System.out.println("puser :" + puser);
		return puser;
	}
	
}
