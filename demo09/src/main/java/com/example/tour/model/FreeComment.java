package com.example.tour.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity(name = "free_comment")
public class FreeComment {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long fcnum;
	private String fcontent;
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fregdate")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	private Date fregdate;
	@ManyToOne
	@JoinColumn(name = "fbnum")
	private FreeBoard freeboard;
	//userid
	@ManyToOne
	@JoinColumn(name = "user_id")
	private Member member;
	
	
	
}
