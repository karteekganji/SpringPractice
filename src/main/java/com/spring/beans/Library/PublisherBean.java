package com.spring.beans.Library;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
@JsonInclude(Include.NON_NULL)
@Data
public class PublisherBean {
	private Long id;
	private String name;
	private String description;
}
