package com.spring.model.library;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Library extends BaseEntity{

	public String name;
	public String address;
	@ManyToOne
	public City city;
	public Boolean isActive = Boolean.TRUE;
	
	
}
