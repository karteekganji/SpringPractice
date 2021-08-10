package com.spring.repo.Library;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.model.library.Library;

@Repository
public interface LibraryRepo extends JpaRepository<Library, Long>{

	List<Library> findByCityCityCode(String cityCode);
	List<Library> findByCityCityNameAndIsActiveTrue(String cityName);
	List<Library> findByCityIdAndIsActiveTrue(Long cityId);
	List<Library> findByCityId(Long cityId);
}
