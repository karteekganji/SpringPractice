package com.spring.model.library;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
import org.springframework.security.core.authority.SimpleGrantedAuthority;

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
public class AppUser extends BaseEntity implements Authentication{

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
		final List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
		list.add(new SimpleGrantedAuthority(this.role.toString()));
		return list;
	}
	@JsonIgnore
	@Override
	public Object getCredentials() {
		return this.password;
	}
	@JsonIgnore
	@Override
	public Object getDetails() {
		return this.email;
	}
	@JsonIgnore
	@Override
	public Object getPrincipal() {
		return this.email;
	}
	@JsonIgnore
	@Override
	public boolean isAuthenticated() {
		return false;
	}
	@JsonIgnore
	@Override
	public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
		
	}

}
