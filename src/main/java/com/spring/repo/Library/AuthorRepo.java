package com.spring.repo.Library;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.model.library.Author;

@Repository
public interface AuthorRepo extends JpaRepository<Author, Long>{

	
}
