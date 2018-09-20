package com.spring.model.user;

import java.sql.Timestamp;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
@Data
@MappedSuperclass
//@JsonIgnoreProperties(value = { "createdAt", "updatedAt" })
public class BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	
	@CreationTimestamp
	@JsonIgnore
	public Timestamp createdAt;
	
	@Version
	@JsonIgnore
	public Timestamp updatedAt;

}
