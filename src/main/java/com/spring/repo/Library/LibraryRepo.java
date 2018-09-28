package com.spring.repo.Library;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.model.library.Library;

@Repository
public interface LibraryRepo extends JpaRepository<Library, Long>{

	List<Library> findByCityCityName(String cityName);
	List<Library> findByCityCityCode(String cityCode);
}
