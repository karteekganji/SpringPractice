package com.spring.beans.Library;

import lombok.Data;

@Data
public class PageRequestBean {

	 private int pageIndex;
	    private int numberOfRecords;

	    private String type;
	    private String searchText;

	    public int getStart() {
	        return pageIndex * numberOfRecords;
	    }
	
}
