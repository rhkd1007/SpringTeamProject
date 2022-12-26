package com.example.tour.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class RestBoard {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long renum;
	private String retitle;
	private String recontent;
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	private Date reregdate;
	@ManyToOne @JoinColumn(name = "rewriter")
	private Member member;
	private Long rereplycnt;
	private Long rehitcnt;
	private String refilename;
	private String reregion;
	
	@PrePersist
	public void prePerist()	{
		this.rehitcnt = this.rehitcnt==null?0 : this.rehitcnt;
		this.rereplycnt = this.rereplycnt==null?0 : this.rereplycnt;
	}
}
