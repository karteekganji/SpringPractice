package com.spring.beans.Library;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class AuthorBean {
	public Long id;
	public String firstName;
	public String lastName;
	public String description;
}
