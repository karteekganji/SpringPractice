package com.spring.model.library;

import javax.persistence.Entity;

import lombok.Data;
@Data
@Entity
public class LibraryInfo extends BaseEntity{
	
	public Long bookId;
	public Long libraryId;
	public Integer copies = 0;

}
