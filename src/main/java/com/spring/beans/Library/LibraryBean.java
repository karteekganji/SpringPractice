package com.spring.beans.Library;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class LibraryBean {
	public Long id;
	public String name;
	public String address;
	public String city;
	public Boolean isActive;
}
