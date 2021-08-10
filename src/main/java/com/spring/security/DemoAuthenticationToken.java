package com.spring.security;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import com.spring.model.library.AppUser;

public class DemoAuthenticationToken extends AbstractAuthenticationToken {

	private static final long serialVersionUID = -1949976839306453197L;
	private AppUser authenticatedUser;
	private final Long uid;

	public DemoAuthenticationToken(final Long uid) {
		super(Arrays.asList());
		this.uid = uid;
	}

	public DemoAuthenticationToken(final Collection<? extends GrantedAuthority> authorities, final AppUser authenticatedUser,
			final Long uid) {
		super(authorities);
		this.uid = uid;
		this.authenticatedUser = authenticatedUser;
	}

	@Override
	public Object getCredentials() {
		return this.authenticatedUser.getPassword();
	}

	@Override
	public Object getPrincipal() {
		return this.authenticatedUser;
	}

	public Long getUid() {
		return this.uid;
	}

}
