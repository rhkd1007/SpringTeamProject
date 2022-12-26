package com.example.tour.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.tour.service.PrincipalOauth2UserService;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired 
	private PrincipalOauth2UserService principalOauth2UserService;
	@Bean
	public BCryptPasswordEncoder encodePwd() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests()
		  .antMatchers("/member/login/").authenticated()
		  .anyRequest()
		  .permitAll()
		.and()
		   .formLogin()
		   .loginPage("/member/login")
		   .defaultSuccessUrl("/")
		 .and()
		    .logout()
		    .logoutUrl("/logout")
		    .logoutSuccessUrl("/")
		    .invalidateHttpSession(true)
		    .and()
		.oauth2Login()				// OAuth2湲곕컲�쓽 濡쒓렇�씤�씤 寃쎌슦
        .loginPage("/member/login")		// �씤利앹씠 �븘�슂�븳 URL�뿉 �젒洹쇳븯硫� /loginForm�쑝濡� �씠�룞
        .defaultSuccessUrl("/")			// 濡쒓렇�씤 �꽦怨듯븯硫� "/" �쑝濡� �씠�룞
        .userInfoEndpoint()			// 濡쒓렇�씤 �꽦怨� �썑 �궗�슜�옄�젙蹂대�� 媛��졇�삩�떎
        .userService(principalOauth2UserService);	//�궗�슜�옄�젙蹂대�� 泥섎━�븷 �븣 �궗�슜�븳�떎
	}
}

