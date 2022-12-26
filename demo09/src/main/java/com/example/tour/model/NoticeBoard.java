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
public class NoticeBoard {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long nbnum;
	private String nbtitle;
	private String nbcontent;
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	private Date nbregdate;
	@ManyToOne @JoinColumn(name = "nbwriter")
	private Member member;
	private Long nbreplycnt;
	private Long nbhitcnt;
	
	@PrePersist
	public void prePerist()	{
		this.nbhitcnt = this.nbhitcnt==null?0 : this.nbhitcnt;
		this.nbreplycnt = this.nbreplycnt==null?0 : this.nbreplycnt;
	}
	
}
