package com.spring.repo.Library;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.model.library.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long>{

	List<Category>  findByIsActiveTrue();

}
