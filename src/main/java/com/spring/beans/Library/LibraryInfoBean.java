package com.spring.beans.Library;

import java.util.List;

import lombok.Data;

@Data
public class LibraryInfoBean {
	public Long LibraryInfoId;
	public List<Long> bookId;
	public Long libraryId;
	public Integer copies;

}
