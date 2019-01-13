package com.spring.repo.Library;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.enums.Role;
import com.spring.model.library.AppUser;

@Repository
public interface AppUserRepo extends JpaRepository<AppUser, Long> {

	List<AppUser> findEmailByIdIsNotNull();
	
	AppUser findByEmailIgnoreCase(String email);
	
	AppUser findByPasswordKey(String key);

	AppUser findByMobileNumber(String mobileNumber);

	AppUser findByEmailIgnoreCaseAndIdNot(String email, Long id);

	AppUser findByMobileNumberAndIdNot(String mobileNumber, Long id);
	
	List<AppUser> findByIsActiveTrue();
	
	List<AppUser> findByIsActiveFalse();
	
	AppUser findByAuth(String auth);
	
	List<AppUser> findByRole(Role role);
	
}
