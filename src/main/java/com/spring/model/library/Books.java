package com.spring.model.library;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class Books extends BaseEntity {
	@NotNull
	private String title;
	private String description;
	private Integer pages;

	@ManyToOne
	private Language language;
	@ManyToOne
	private Publisher publisher;
	@ManyToOne
	private Author author;
	
	@ManyToOne
	private Category category;
	
	@JsonIgnore
	private Boolean isActive = Boolean.FALSE;
			
	private Integer copies;
}
