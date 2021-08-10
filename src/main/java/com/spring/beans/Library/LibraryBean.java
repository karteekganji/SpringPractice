package com.spring.beans.Library;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class LibraryBean {
	private Long id;
	private String name;
	private String address;
	private Long cityId;
	private String cityName;
	private Boolean isActive;
}
