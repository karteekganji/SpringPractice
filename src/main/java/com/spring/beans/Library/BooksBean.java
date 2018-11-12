package com.spring.beans.Library;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class BooksBean {
	private Long bookId;
	private String title;
	private String description;
	private Integer pages;
	private Long languageId;
	private String languageName;
	private Long publisherId;
	private String publisherName;
	private Long authorId;
	private String authorName;
	private Long categoryId;
	private String categoryName;
	private Boolean isActive;
	private Integer copies;
}
