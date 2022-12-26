package com.example.tour.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@Entity
@NoArgsConstructor
public class Gangseo{
	@Id
	private Long galContentId;
	private String galTitle;
	private String galWebImageUrl;
	private String galPhotographyLocation;
	public Gangseo(Long galContentId,String galTitle,String galWebImageUrl,String galPhotographyLocation) {
		this.galContentId=galContentId;
		this.galTitle=galTitle;
		this.galWebImageUrl=galWebImageUrl;
		this.galPhotographyLocation=galPhotographyLocation;
	}
}
