package com.spring.beans.Library;

import lombok.Data;

@Data
public class BooksBean {
	public Long id;
	public String title;
	public String description;
	public Integer pages;
	public String language;
	public String publisher;
	public String author;
	public String section;
	public String isActive;
}
