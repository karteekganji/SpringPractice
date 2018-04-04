package com.spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.model.Language;
import com.spring.model.UserRecord;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Long>{

	Language findByNameIgnoreCase(String name);
	
	Language findByNameIgnoreCaseAndIdNot(String name, Long id);
	
}
