package com.example.tour.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class RestComment {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long recnum;
	private String rewriter;
	private Date reregdate;
	private String recontent;
	@ManyToOne @JoinColumn(name = "rebnum")
	private RestBoard rebnum;
	
}
