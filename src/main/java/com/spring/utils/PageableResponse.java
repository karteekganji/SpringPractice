package com.spring.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.spring.enums.AlertType;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class PageableResponse extends GeneralResponse{

	private int pageIndex;
    private int numberOfRecords;
    private long totalRecords;

    public PageableResponse(AlertType alertType) {
        super(alertType);
    }

    public PageableResponse(AlertType status, String message) {
        super(message, status);
    }

    public PageableResponse addPageDetails(int pageIndex, int numberOfRecords, long totalRecords) {
        this.setPageIndex(pageIndex);
        this.setNumberOfRecords(numberOfRecords);
        this.setTotalRecords(totalRecords);
        return this;
    }

    public PageableResponse addPayLoad(Object payLoad) {
        super.setPayLoad(payLoad);
        return this;
    }

}
