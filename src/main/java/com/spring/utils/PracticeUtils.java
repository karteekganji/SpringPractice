package com.spring.utils;

import java.util.UUID;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.spring.repo.Library.AppUserRepo;

public class PracticeUtils {
	@Autowired
	private static AppUserRepo appUserRepo;
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
	
	public static String generateUUID() {
		UUID uuid = UUID.randomUUID();
		if (appUserRepo.findByAuth(uuid.toString()) == null) {
			return uuid.toString();
		} else {
			generateUUID();
		}
		return "";
	}
}
