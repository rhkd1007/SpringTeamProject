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
public class AcBoard {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long acnum;
	private String actitle;
	private String accontent;
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	private Date acregdate;
	@ManyToOne @JoinColumn(name = "acwriter")
	private Member member;
	private Long acreplycnt;
	private Long achitcnt;
	private String acfilename;
	private String acregion;
	
	@PrePersist
	public void prePerist()	{
		this.achitcnt = this.achitcnt==null?0 : this.achitcnt;
		this.acreplycnt = this.acreplycnt==null?0 : this.acreplycnt;
	}
	
}
