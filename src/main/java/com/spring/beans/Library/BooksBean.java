package com.spring.beans.Library;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class BooksBean {
	public Long id;
	public String title;
	public String description;
	public Integer pages;
	public Long languageId;
	public String languageName;
	public Long publisherId;
	public Long publisherName;
	public String author;
	public Long categoryId;
	public String categoryName;
	public Boolean isActive;
}
