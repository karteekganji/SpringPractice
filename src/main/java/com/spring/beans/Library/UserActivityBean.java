package com.spring.beans.Library;

import lombok.Data;

@Data
public class UserActivityBean {
		
		public Long userActivityId;
		public Long appUserId;
		public Long libraryId;
		public Long bookId;
		public Integer copies;
		
}
