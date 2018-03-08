package com.spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.model.UserRecord;

public interface UserRepository extends JpaRepository<UserRecord, Long> {

}
