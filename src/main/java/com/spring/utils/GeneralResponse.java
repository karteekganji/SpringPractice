package com.spring.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class GeneralResponse {

	private String status;

	private Object payLoad;

	private String errorMessage;

	private Exception exception;

	public GeneralResponse(String status) {
		this.status = status;
	}

	public GeneralResponse(Object payload) {
		this.payLoad = payload;
	}

	public GeneralResponse(String status, Object payload) {
		this.status = status;
		this.payLoad = payload;
	}

	public GeneralResponse(String status, String errorMessage) {
		this.status = status;
		this.errorMessage = errorMessage;
	}

	public GeneralResponse(String status, Exception errorMessage) {
		this.status = status;
		this.exception = errorMessage;
	}
}
