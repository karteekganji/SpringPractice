package com.spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.model.UserLanguageInfo;

@Repository
public interface userLanguageInfoRepository extends JpaRepository<UserLanguageInfo, Long>{

}
