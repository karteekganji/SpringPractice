package com.spring.repo.Library;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.model.library.LibraryInfo;
@Repository
public interface LibraryInfoRepo extends JpaRepository<LibraryInfo, Long>{
	
	LibraryInfo findByLibraryIdAndBookId(Long libraryId, Long bookId);
	List<LibraryInfo> findByLibraryId(Long libraryId);
}
