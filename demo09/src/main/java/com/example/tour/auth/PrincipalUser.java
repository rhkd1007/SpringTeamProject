package com.example.tour.auth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import com.example.tour.model.Member;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PrincipalUser  implements UserDetails, OAuth2User{

	private Member member;
	private Map<String, Object> attributes;

	public PrincipalUser(Member member) {
		this.member = member;
	}
	public PrincipalUser(Member member, Map<String,Object>atttributes) {
		this.member=member;
		this.attributes=atttributes;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> collect = new ArrayList<>();
		collect.add(()->{
			return member.getRole();
		});
		return collect;
	}

	
	
	@Override
	public String getPassword() {
			return member.getPwd();
	}

	@Override
	public String getUsername() {
		return member.getUsername();
	}
	

	@Override
	public boolean isAccountNonExpired() {
			return true;
	}

	@Override
	public boolean isAccountNonLocked() {
			return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
			return true;
	}
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
	   @Override
	    public Map<String, Object> getAttributes() {
	        return attributes;
	    }
}
