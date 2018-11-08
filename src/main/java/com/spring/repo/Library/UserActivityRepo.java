package com.spring.repo.Library;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.model.library.UserActivity;

@Repository
public interface UserActivityRepo extends JpaRepository<UserActivity, Long>{
	
	UserActivity findByAppUserIdAndBookId(Long appuserId, Long bookId);

}
