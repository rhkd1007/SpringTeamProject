package com.example.tour.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity(name = "free_board")
public class FreeBoard {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long num;
	private String title;
	private String content;
	private String free;
	
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	@Column(name = "regdate")
	private Date regdate;
	private Long hitcnt;
	private Long replycnt;
	@OneToMany(mappedBy = "freeboard", cascade=CascadeType.REMOVE)
	@JsonIgnoreProperties("freeboard")
	private List<FreeComment> freecomments;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "writer")
	@JsonIgnore
	private Member member;
	@Transient
	private MultipartFile upload; //���ε��� ����
	private String fileimage ; //���̺� ������ ���� �̸�

	@PrePersist
	public void prePerist()	{
		this.hitcnt = this.hitcnt==null?0 : this.hitcnt;
		this.replycnt = this.replycnt==null?0 : this.replycnt;
	}
}
