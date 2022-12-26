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
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class TourBoard {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long tnum;
	private String ttitle;
	private String tcontent;
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	private Date tregdate;
	@ManyToOne @JoinColumn(name = "twriter")
	private Member member;
	private Long treplycnt;
	private Long thitcnt;
	@Transient
	private MultipartFile upload;
	private String tfilename;
	private String tregion;
	private String titleimage;
	
	@PrePersist
	public void prePerist()	{
		this.thitcnt = this.thitcnt==null?0 : this.thitcnt;
		this.treplycnt = this.treplycnt==null?0 : this.treplycnt;
	}
}
