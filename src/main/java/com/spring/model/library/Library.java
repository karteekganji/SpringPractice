package com.spring.model.library;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Library extends BaseEntity{

	private String name;
	private String address;
	@ManyToOne
	private City city;
	private Boolean isActive = Boolean.TRUE;
	
	
}
