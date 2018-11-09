package com.spring.beans.Library;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.spring.model.library.Books;
import com.spring.model.library.Library;

import lombok.Data;
@JsonInclude(Include.NON_NULL)
@Data
public class LibraryInfoBean {
	public Long LibraryInfoId;
	public Long bookId;
	public Long libraryId;
	public Integer copies;
	List<BooksBean> booksBeans = new ArrayList<>();

}
