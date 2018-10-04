package com.spring.beans.Library;

import lombok.Data;

@Data
public class LibraryInfoBean {
	public Long LibraryInfoId;
	public Long bookId;
	public Long libraryId;
	public Integer copies;

}
