package com.spring.repo.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.model.user.UserRecord;

@Repository
public interface UserRepository extends JpaRepository<UserRecord, Long> {

	List<UserRecord> findEmailByIdIsNotNull();
	
	UserRecord findByEmailIgnoreCase(String email);

	UserRecord findByMobileNumber(String mobileNumber);

	UserRecord findByEmployeeId(String employeeId);

	UserRecord findByEmailIgnoreCaseAndIdNot(String email, Long id);

	UserRecord findByMobileNumberAndIdNot(String mobileNumber, Long id);

	UserRecord findByEmployeeIdAndIdNot(String employeeId, Long id);
	
	List<UserRecord> findByIsActiveTrue();
	
	List<UserRecord> findByIsActiveFalse();

	
}
