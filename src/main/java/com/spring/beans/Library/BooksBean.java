package com.spring.beans.Library;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class BooksBean {
	public Long bookId;
	public String title;
	public String description;
	public Integer pages;
	public Long languageId;
	public String languageName;
	public Long publisherId;
	public String publisherName;
	public Long authorId;
	public String authorName;
	public Long categoryId;
	public String categoryName;
	public Boolean isActive;
	public Integer copies;
}
