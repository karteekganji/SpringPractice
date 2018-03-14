package com.spring.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" })
public class UserRecord {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	public String name;
	public String email;
	public String mobileNumber;
	public String employeeId;
	@CreationTimestamp
	public Timestamp createdAt;
	@Version
	public Timestamp updatedAt;

	// public Long getId() {
	// return id;
	// }
	// public void setId(Long id) {
	// this.id = id;
	// }
	// public String getName() {
	// return name;
	// }
	// public void setName(String name) {
	// this.name = name;
	// }
	// public String getEmail() {
	// return email;
	// }
	// public void setEmail(String email) {
	// this.email = email;
	// }

}
