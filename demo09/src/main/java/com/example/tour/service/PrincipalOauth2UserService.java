package com.example.tour.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.example.tour.auth.PrincipalDetails;
import com.example.tour.auth.PrincipalUser;
import com.example.tour.model.Member;
import com.example.tour.model.Role;
import com.example.tour.repository.MemberRepository;

@Service
public class PrincipalOauth2UserService extends DefaultOAuth2UserService{
	 @Autowired
	 private MemberRepository userRepository;


	    @Override
	    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {

	        OAuth2User oAuth2User = super.loadUser(userRequest);

	        String provider = userRequest.getClientRegistration().getRegistrationId();    //google
	        String providerId = oAuth2User.getAttribute("sub");
	        String username = provider+"_"+providerId;  			// 사용자가 입력한 적은 없지만 만들어준다

	        String uuid = UUID.randomUUID().toString().substring(0, 6);
	        String password = "패스워드"+uuid;  // 사용자가 입력한 적은 없지만 만들어준다

	        String email = oAuth2User.getAttribute("email");
	        String role = "ROLE_USER";

	        Member byUsername = userRepository.findByUsername(username);
	        
	        //DB에 없는 사용자라면 회원가입처리
	        if(byUsername == null){
	            byUsername = Member.oauth2Register()
	                    .username(username).pwd(password).email(email).role(role)
	                    .provider(provider).providerId(providerId)
	                    .build();
	            userRepository.save(byUsername);
	        }

	        return new PrincipalUser(byUsername, oAuth2User.getAttributes());
	    }
	}
