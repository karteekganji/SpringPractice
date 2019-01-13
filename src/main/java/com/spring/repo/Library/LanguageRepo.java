package com.spring.repo.Library;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.model.library.Language;

@Repository
public interface LanguageRepo extends JpaRepository<Language, Long>{

	Language findByNameIgnoreCase(String name);
	
	Language findByNameIgnoreCaseAndIdNot(String name, Long id);
	
	List<Language> findByIsActive(Boolean isDeleted);

	List<Language> findByIsActiveTrue();
	
}
