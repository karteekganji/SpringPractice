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
	public String title;
	public String description;
	public Integer pages;

	@ManyToOne
	public Language language;
	public String publisher;
	public String author;
	
	@ManyToOne
	public Category category;
	
	@JsonIgnore
	public String isActive;
}
