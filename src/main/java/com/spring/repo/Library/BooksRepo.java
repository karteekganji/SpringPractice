package com.spring.repo.Library;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.model.library.Books;

@Repository
public interface BooksRepo extends JpaRepository<Books, Long>{

}
