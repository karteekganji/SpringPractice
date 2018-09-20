package com.spring.repo.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.model.user.UserLanguageInfo;

@Repository
public interface userLanguageInfoRepository extends JpaRepository<UserLanguageInfo, Long>{

	List<UserLanguageInfo> findByAppUserId(Long id);
	
	List<UserLanguageInfo> findByAppUserIdAndLanguageId(Long userId, Long languageId );
	
}
