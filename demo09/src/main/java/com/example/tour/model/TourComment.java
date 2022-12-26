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
public class TourComment {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long tcnum;
	private String twriter;
	private Date tregdate;
	private String tcontent;
	@ManyToOne @JoinColumn(name = "tbnum")
	private TourBoard tbnum;
	
}
