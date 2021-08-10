package com.spring.beans.Library;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class UserActivityBean {
	private Long appUserId;
	private Long libraryId;
	private List<BooksSubBean> booksDetails = new ArrayList<>();
		
}
