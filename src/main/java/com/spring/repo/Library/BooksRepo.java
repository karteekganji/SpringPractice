package com.spring.repo.Library;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.model.library.Books;

@Repository
public interface BooksRepo extends JpaRepository<Books, Long>{
	
	List<Books> findByLanguageId(Long Id);
	List<Books> findByCategoryId(Long Id);
	List<Books> findByLanguageIdAndCategoryId(Long LId, Long CId );
}
