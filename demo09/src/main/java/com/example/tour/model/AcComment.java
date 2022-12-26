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
public class AcComment {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long accnum;
	private String acwriter;
	private Date acregdate;
	private String accontent;
	@ManyToOne @JoinColumn(name = "acbnum")
	private AcBoard acbnum;
	
}
