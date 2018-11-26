package com.spring.model.library;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.spring.enums.Role;

import lombok.Data;
@Table(uniqueConstraints = {
		@UniqueConstraint(columnNames = {"email"}),
		@UniqueConstraint(columnNames = {"mobileNumber"}),
})
@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" })
public class AppUser extends BaseEntity {

	@NotNull
	private String name;
	private String email;
	private String mobileNumber;
	@JsonIgnore
	private String password;
	private String auth;
	private String gender;
	private String city;
	private Boolean isActive = Boolean.TRUE;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private Role role;

}
