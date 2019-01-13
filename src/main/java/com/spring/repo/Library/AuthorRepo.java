package com.spring.repo.Library;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.enums.Role;
import com.spring.model.library.Author;

@Repository
public interface AuthorRepo extends JpaRepository<Author, Long>{

	List<Author> findByAppUserRole(Role author);

	List<Author> findByAppUserRoleAndAppUserIsActiveTrue(Role author);
}
