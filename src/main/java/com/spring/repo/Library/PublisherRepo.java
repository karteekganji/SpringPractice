package com.spring.repo.Library;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.model.library.Publisher;

public interface PublisherRepo extends JpaRepository<Publisher, Long>{

}
