package com.spring.repo.Library;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.model.library.Publisher;
@Repository
public interface PublisherRepo extends JpaRepository<Publisher, Long>{

	List<Publisher> findByIsActiveTrue();

}
