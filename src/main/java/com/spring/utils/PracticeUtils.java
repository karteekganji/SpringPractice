package com.spring.utils;

import org.apache.commons.lang3.RandomStringUtils;

public class PracticeUtils {
	 public Long id;
	public static String RandomStrInt() {
	    return RandomStringUtils.random(10, "abcdefghijklmnopqrstuvwxyz1234567890");
	}
	
	 public static boolean isNotEmpty(Object object) {
	        if (object == null) {
	            return false;
	        }
	        return true;
	    }
	
}
