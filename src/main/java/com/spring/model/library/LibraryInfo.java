package com.spring.model.library;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import lombok.Data;
@Data
@Entity
public class LibraryInfo extends BaseEntity{
	@ManyToOne
	public Books book;
	@ManyToOne
	public Library library;
	public Integer copies = 0;

}
