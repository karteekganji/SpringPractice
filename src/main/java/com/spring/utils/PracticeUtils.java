package com.spring.utils;

import java.util.UUID;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.repo.Library.AppUserRepo;
@Service
public class PracticeUtils {
	@Autowired
	private AppUserRepo appUserRepo;
	
	public static boolean isNotEmpty(Object object) {
		if (object == null || object == "") { 
			return false;
		}
		return true;
	}
	
	public static String changePasswordKey() {
		return RandomStringUtils.random(8, "12345678900ABCDEFGHIJKLMNOPQRSTUVWXYZ!@#$%^&*+?");
	}

	public static String encryptPassword(final String password) {
		final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		return passwordEncoder.encode(password.trim());
	}
	
	public String generateUUID() {
		UUID uuid = UUID.randomUUID();
		if (this.appUserRepo.findByAuth(uuid.toString()) == null) {
			return uuid.toString();
		} else {
			generateUUID();
		}
		return "";
	}
	public static void main(String[] args) {
	}
}
