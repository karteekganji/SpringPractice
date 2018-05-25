package com.spring.utils;

import org.apache.commons.lang3.RandomStringUtils;

public class PracticeUtils {

	public static String RandomStrInt() {
	    return RandomStringUtils.random(10, "abcdefghijklmnopqrstuvwxyz1234567890");
	}

}
