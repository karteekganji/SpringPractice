package com.spring.model.library;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

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
public class AppUser extends BaseEntity implements Authentication {

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
	
	@JsonIgnore
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}
	@JsonIgnore
	@Override
	public Object getCredentials() {
		// TODO Auto-generated method stub
		return null;
	}
	@JsonIgnore
	@Override
	public Object getDetails() {
		// TODO Auto-generated method stub
		return null;
	}
	@JsonIgnore
	@Override
	public Object getPrincipal() {
		// TODO Auto-generated method stub
		return null;
	}
	@JsonIgnore
	@Override
	public boolean isAuthenticated() {
		// TODO Auto-generated method stub
		return false;
	}
	@JsonIgnore
	@Override
	public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
	}

}
