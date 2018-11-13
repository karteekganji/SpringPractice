package com.spring.repo.Library;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.model.library.UserActivity;

@Repository
public interface UserActivityRepo extends JpaRepository<UserActivity, Long>{
	
	UserActivity findByAppUserIdAndBookId(Long appuserId, Long bookId);
	@Query ("select sum(copies) from UserActivity  where app_user_id = :id")
	Integer sumOfBooks(@Param("id") Long id);


}
