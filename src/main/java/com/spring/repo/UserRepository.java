package com.spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.model.UserRecord;

@Repository
public interface UserRepository extends JpaRepository<UserRecord, Long> {

}
