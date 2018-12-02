package com.spring.repo.Library;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.model.library.City;

@Repository
public interface CityRepo extends JpaRepository<City, Long>{

	City findByCityCode(String code);
	City findByCityName(String name);
	
}
