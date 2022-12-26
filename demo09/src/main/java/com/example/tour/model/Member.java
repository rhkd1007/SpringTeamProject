package com.example.tour.model;

import java.security.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "num")
	private Long num;
	private String pwd;
	@Column(name = "id")
	private String username;
	private String age;
	private String email;
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	private Date regdate;
	private String city;
	@Column(nullable = false, name = "username")
	private String id;
	private String role;

    private String provider;    // oauth2를 이용할 경우 어떤 플랫폼을 이용하는지
    private String providerId; 
	
    @Builder(builderClassName = "PrincipalUser", builderMethodName = "principalUser")
	public Member(String name,String pwd, String email) {
        this.id = name;
        this.pwd = pwd;
        this.email = email;
	}
    @Builder(builderClassName = "OAuth2Register", builderMethodName = "oauth2Register")
    public Member(String username, String pwd, String email, String role, String provider, String providerId) {
        this.id = username;
        this.pwd = pwd;
        this.email = email;
        this.role = role;
        this.provider = provider;
        this.providerId = providerId;
        this.username=username;
    }

}
