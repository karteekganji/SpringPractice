package com.spring.model.library;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import lombok.Data;
@Data
@Entity
public class LibraryInfo extends BaseEntity{
	@ManyToOne
	private Books book;
	@ManyToOne
	private Library library;
	private Integer copies = 0;

}
