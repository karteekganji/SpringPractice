package com.spring.model.user;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
@Table(uniqueConstraints = {
		@UniqueConstraint(columnNames = {"email"}),
		@UniqueConstraint(columnNames = {"mobileNumber"}),
		@UniqueConstraint(columnNames = {"employeeId"})
})
@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" })
public class UserRecord extends BaseEntity {

	@NotNull
	public String name;
	public String email;
	public String mobileNumber;
	public String password;
	public String auth;
	public String gender;
	public Boolean isActive = Boolean.FALSE;

}
