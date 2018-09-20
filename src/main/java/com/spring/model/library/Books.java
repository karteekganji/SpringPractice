package com.spring.model.library;

import javax.persistence.Entity;

import com.spring.model.user.BaseEntity;

@Entity
public class Books extends BaseEntity {
	public String title;
	public String description;
	public Integer pages;
	public String language;
	public String publisher;
	public String author;
	public String section;
}
