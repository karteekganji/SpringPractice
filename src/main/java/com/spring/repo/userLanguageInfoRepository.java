package com.spring.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.model.UserLanguageInfo;

@Repository
public interface userLanguageInfoRepository extends JpaRepository<UserLanguageInfo, Long>{

	List<UserLanguageInfo> findByAppUserId(Long id);
	
	List<UserLanguageInfo> findByAppUserIdAndLanguageId(Long userId, Long languageId );
	
}
