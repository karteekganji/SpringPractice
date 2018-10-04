package com.spring.repo.Library;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.model.library.LibraryInfo;

public interface LibraryInfoRepo extends JpaRepository<LibraryInfo, Long>{
	
	LibraryInfo findByLibraryIdAndBookId(Long libraryId, Long bookId);

}
