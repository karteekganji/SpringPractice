package com.spring.beans.Library;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
@JsonInclude(Include.NON_NULL)
@Data
public class LibraryInfoBean {
	private Long libraryId;
	private List<BooksSubBean> booksDetails = new ArrayList<>();

}
