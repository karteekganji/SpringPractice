package com.spring.security;

import org.omg.CORBA.UnknownUserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.spring.model.library.AppUser;
import com.spring.repo.Library.AppUserRepo;

@CrossOrigin
@Component
public class SecurityAuthenticationProvider implements AuthenticationProvider {
	@Autowired
	private final AppUserRepo appUserRepo;

	@Autowired
	public SecurityAuthenticationProvider(final AppUserRepo appUserRepository) {
		this.appUserRepo = appUserRepository;
	}

	@Override
	public Authentication authenticate(final Authentication authentication) throws AuthenticationException {
		final DemoAuthenticationToken demoAuthentication = (DemoAuthenticationToken) authentication;
		final AppUser user = this.appUserRepo.findOne(demoAuthentication.getUid());

		if (user == null) {
			try {
				throw new UnknownUserException();
			} catch (final UnknownUserException e) {
				e.printStackTrace();
			}
		}

		return user;
	}

	@Override
	public boolean supports(final Class<?> authentication) {
		return DemoAuthenticationToken.class.isAssignableFrom(authentication);
	}
}
