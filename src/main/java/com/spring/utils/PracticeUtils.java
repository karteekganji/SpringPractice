package com.spring.utils;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PracticeUtils {
	public static String RandomStrInt() {
		return RandomStringUtils.random(10, "abcdefghijklmnopqrstuvwxyz1234567890");
	}

	public static boolean isNotEmpty(Object object) {
		if (object == null) {
			return false;
		}
		return true;
	}
	
	public static String encryptPassword(final String password) {
		final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		return passwordEncoder.encode(password.trim());
	}

}
