package com.spring.beans.Library;

import lombok.Data;

@Data
public class LibraryBean {
	public Long id;
	public String name;
	public String address;
	public String city;
	public Boolean isActive;
}
