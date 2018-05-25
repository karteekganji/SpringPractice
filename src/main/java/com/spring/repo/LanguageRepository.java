package com.spring.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.model.Language;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Long>{

	Language findByNameIgnoreCase(String name);
	
	Language findByNameIgnoreCaseAndIdNot(String name, Long id);
	
	List<Language> findByIsDeleted(Boolean isDeleted);
	
}
