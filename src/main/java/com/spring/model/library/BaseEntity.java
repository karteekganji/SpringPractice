package com.spring.model.library;

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
	private Long id;
	
	@CreationTimestamp
	@JsonIgnore
	private Timestamp createdAt;
	
	@Version
	@JsonIgnore
	private Timestamp updatedAt;

}
